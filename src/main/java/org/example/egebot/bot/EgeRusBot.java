package org.example.egebot.bot;

import lombok.RequiredArgsConstructor;
import org.example.egebot.data.TaskDTO;
import org.example.egebot.services.AccountService;
import org.example.egebot.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
//@RequiredArgsConstructor
public class EgeRusBot extends TelegramLongPollingBot {

    private int taskNumber = 1;

    private final TaskService taskService;
    private final AccountService accountService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EgeRusBot.class);

    @Value("${bot.name}")
    private String botName;



    public EgeRusBot(@Value("${bot.token}") String botToken, TaskService taskService, AccountService accountService) {
        super(botToken);
        this.taskService = taskService;
        this.accountService = accountService;
    }

    // поступление команд обработка
    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();
        System.out.println(chatId);
        String text = update.getMessage().getText();

        if (text.equals("/start")) {
            accountService.signUp(update.getMessage());
            startBot(chatId);
        } else if (text.equals("Решать задания")) {
            sendMessage(chatId, "Введите номер задания, котрое хотите порешать.");
        }
        else {
            chooseTaskNumber(chatId, text);
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
        sendMessage(chatId, startMessage);
    }

    private void sendMessage(Long chatId, String messageText) {
        SendMessage message = Sender.sendMessage(chatId, messageText);
//        message.setReplyMarkup(Keyboards.mainCommands());
        message.setReplyMarkup(ChooseTask.getChooseTaskKeyboard());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            LOGGER.error("Ошибка, при отправке сообщения: " + e.getMessage());
        }
    }

    private void chooseTaskNumber(Long chatId, String text) {
        taskNumber = Integer.parseInt(text);
        sendMessage(chatId, "Номер задачи выбран, " + text + ":");
        sendTask(chatId);
    }

    private void sendTask(Long chatId) {
        TaskDTO taskDTO = taskService.getRandomTask(taskNumber);
        sendMessage(chatId, taskDTO.toString());
    }
}
