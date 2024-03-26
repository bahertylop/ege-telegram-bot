package org.example.egebot.bot;

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
public class EgeRusBot extends TelegramLongPollingBot {

    private static final Logger LOGGER = LoggerFactory.getLogger(EgeRusBot.class);

    @Value("${bot.name}")
    private String botName;

    public EgeRusBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    // поступление команд обработка
    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();

        String text = update.getMessage().getText();

        if (text.equals("/start")) {
            startBot(chatId);
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
        String chatIdStr = String.valueOf(chatId);
        SendMessage message = new SendMessage(chatIdStr, messageText);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            LOGGER.error("Ошибка, при отправке сообщения: " + e.getMessage());
        }
    }
}
