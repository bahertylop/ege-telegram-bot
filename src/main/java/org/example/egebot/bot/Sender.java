package org.example.egebot.bot;

import lombok.RequiredArgsConstructor;
import org.example.egebot.data.AccountDTO;
import org.example.egebot.data.BotStateDTO;
import org.example.egebot.data.TaskDTO;
import org.example.egebot.services.AccountService;
import org.example.egebot.services.BotStateService;
import org.example.egebot.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



@Component
@RequiredArgsConstructor
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    private final AccountService accountService;
    private final BotStateService botStateService;
    private final TaskService taskService;

    public void sendMessage(Long chatId, String messageText, ReplyKeyboard keyboard, EgeRusBot bot) {
        SendMessage message = Sender.sendMessage(chatId, messageText);
        message.setReplyMarkup(keyboard);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            LOGGER.error("Ошибка, при отправке сообщения: " + e.getMessage());
        }
    }

    public void sendTask(Long chatId, EgeRusBot bot) {
        if (accountService.canSendTask(chatId)) {
            Integer taskType = botStateService.getTaskType(chatId);
            TaskDTO taskDTO = taskService.getRandomTask(taskType);
            botStateService.setBotStateAnswer(chatId, taskDTO.getTaskType(), taskDTO.getId());
            sendMessage(chatId, taskDTO.toString(), Keyboards.taskCommands(), bot);
        } else {
            sendMessage(chatId, "Для продолжения пользования ботом, купите подписку", Keyboards.profileCommands(), bot);
        }
    }

    public void startBot(Long chatId, EgeRusBot bot) {
        String startMessage = "Привет, " +
                "данный бот создан для нарешивания тестовых заданий егэ по русскому языку, " +
                "разработчик - @neofnik";
        sendMessage(chatId, startMessage, Keyboards.mainCommands(), bot);
    }

    public void sendAnswer(Long chatId, EgeRusBot bot) {
        BotStateDTO stateDTO = botStateService.getBotState(chatId);

        TaskDTO taskDTO = taskService.getTaskByIdAndType(stateDTO.getTaskId(), stateDTO.getTaskType());
        sendMessage(chatId, taskDTO.showAnswer(), Keyboards.taskCommands(), bot);
        sendTask(chatId, bot);
    }

    public void checkTaskAnswer(Long chatId, String answer, EgeRusBot bot) {
        BotStateDTO stateDTO = botStateService.getBotState(chatId);

        boolean result = taskService.checkAnswer(answer, stateDTO.getTaskId(), stateDTO.getTaskType());

        if (result) {
            sendMessage(chatId,"Правильно ✅", Keyboards.taskCommands(), bot);
            sendTask(chatId, bot);
        } else {
            sendMessage(chatId, "Неправильно ❌", Keyboards.taskCommands(), bot);
        }
    }

    public static SendMessage sendMessage(Long chatId, String messageText) {
        String chatIdStr = String.valueOf(chatId);
        return new SendMessage(chatIdStr, messageText);
    }

    public void profileMessage(Long chatId, EgeRusBot bot) {
        AccountDTO accountDTO = accountService.getAccount(chatId);

        if (accountDTO != null) {
            sendMessage(chatId, accountDTO.toString(), Keyboards.profileCommands(), bot);
        }
    }
}
