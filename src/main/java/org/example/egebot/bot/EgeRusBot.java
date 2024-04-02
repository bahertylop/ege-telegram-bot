package org.example.egebot.bot;

import lombok.RequiredArgsConstructor;
import org.example.egebot.data.BotStateDTO;
import org.example.egebot.data.TaskDTO;
import org.example.egebot.models.BotState;
import org.example.egebot.services.AccountService;
import org.example.egebot.services.BotStateService;
import org.example.egebot.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
//@RequiredArgsConstructor
public class EgeRusBot extends TelegramLongPollingBot {

    private int taskNumber = 1;

    private final TaskService taskService;
    private final AccountService accountService;

    private final BotStateService botStateService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EgeRusBot.class);

    @Value("${bot.name}")
    private String botName;



    public EgeRusBot(@Value("${bot.token}") String botToken, TaskService taskService, AccountService accountService, BotStateService botStateService) {
        super(botToken);
        this.taskService = taskService;
        this.accountService = accountService;
        this.botStateService = botStateService;
    }

    // поступление команд обработка
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null) {
            Long chatId = update.getMessage().getChatId();
            System.out.println(chatId);
            String text = update.getMessage().getText();
            BotStateDTO botState = botStateService.getBotState(chatId);

            if (text.equals("/start")) {
                accountService.signUp(update.getMessage());
                startBot(chatId);
            } else if (text.equals("Решать задания")) {
                sendMessage(chatId, "Введите номер задания, котрое хотите порешать.", ChooseTask.getChooseTaskKeyboard());
            }
            else {
                checkTaskAnswer(chatId, text);
            }
        } else if (update.hasCallbackQuery()) {
            Long chatId = update.getCallbackQuery().getFrom().getId();
            System.out.println(chatId);
            String data = update.getCallbackQuery().getData();
            System.out.println(data);
            chooseTaskNumber(chatId, data);
        }


    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    private void startBot(Long chatId) {
        String startMessage = "Привет, " +
                "данный бот создан для нарешивания тестовых заданий егэ по русскому языку, " +
                "разработчик - @neofnik";
        sendMessage(chatId, startMessage, Keyboards.mainCommands());
    }

    private void sendMessage(Long chatId, String messageText, ReplyKeyboard keyboard) {
        SendMessage message = Sender.sendMessage(chatId, messageText);
//        message.setReplyMarkup(Keyboards.mainCommands());
        message.setReplyMarkup(keyboard);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            LOGGER.error("Ошибка, при отправке сообщения: " + e.getMessage());
        }
    }

    private void chooseTaskNumber(Long chatId, String text) {
        taskNumber = Integer.parseInt(text);
        sendMessage(chatId, "Номер задачи выбран, " + text + ":", Keyboards.mainCommands());
        sendTask(chatId);
    }

    private void sendTask(Long chatId) {
        TaskDTO taskDTO = taskService.getRandomTask(taskNumber);
        botStateService.setBotStateAnswer(chatId, taskDTO.getTaskType(), taskDTO.getId());
        sendMessage(chatId, taskDTO.toString(), Keyboards.taskCommands());
    }

    private void checkTaskAnswer(Long chatId, String answer) {
        BotStateDTO stateDTO = botStateService.getBotState(chatId);

        boolean result = taskService.checkAnswer(answer, stateDTO.getTaskId(), stateDTO.getTaskType());

        if (result) {
            sendMessage(chatId,"Правильно", Keyboards.taskCommands());
            sendTask(chatId);
        } else {
            sendMessage(chatId, "Неправильно", Keyboards.taskCommands());
        }
    }
}
