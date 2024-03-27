package org.example.egebot.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Sender {

    public static SendMessage sendMessage(Long chatId, String messageText) {
        String chatIdStr = String.valueOf(chatId);
        return new SendMessage(chatIdStr, messageText);
    }
}
