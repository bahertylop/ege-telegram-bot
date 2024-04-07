package org.example.egebot.bot;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.example.egebot.constants.MessagesConstants;
import org.example.egebot.data.AccountDTO;
import org.example.egebot.data.BotStateDTO;
import org.example.egebot.data.TaskDTO;
import org.example.egebot.services.AccountService;
import org.example.egebot.services.BotStateService;
import org.example.egebot.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;


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
            sendMessage(chatId, MessagesConstants.buySub, Keyboards.profileCommands(), bot);
        }
    }

    public void startBot(Long chatId, EgeRusBot bot) {
        sendMessage(chatId, MessagesConstants.startMessage, Keyboards.mainCommands(), bot);
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
            sendMessage(chatId,MessagesConstants.rightAnswer, Keyboards.taskCommands(), bot);
            sendTask(chatId, bot);
        } else {
            sendMessage(chatId, MessagesConstants.wrongAnswer, Keyboards.taskCommands(), bot);
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

//    boolean checkBotStateBuying(Long chatId) {
//        return botStateService.checkBotStateBuying(chatId);
//    }

    public void sendConfirmMessageToAdmin(Message message, EgeRusBot bot) {
        String chatId = String.valueOf(6380769033L);

        SendMessage messageToAdmin = new SendMessage();
        messageToAdmin.setText(message.getChatId().toString());
        messageToAdmin.setChatId(chatId);
        sendMessage(messageToAdmin, bot);

        ForwardMessage forwardMessage = new ForwardMessage();
        forwardMessage.setChatId(chatId);
        forwardMessage.setFromChatId(message.getChatId().toString());
        forwardMessage.setMessageId(message.getMessageId());
        forwardMessage(forwardMessage, bot);
    }

    public void sendMessage(SendMessage message, EgeRusBot bot) {

        try {
            bot.execute(message);
        } catch(TelegramApiException e) {
            LOGGER.error("Ошибка, при отправке сообщения: " + e.getMessage());
        }
    }

    public void forwardMessage(ForwardMessage message, EgeRusBot bot) {

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            LOGGER.error("Ошибка, при отправке фото чека админу: " + e.getMessage());
        }
    }
}
