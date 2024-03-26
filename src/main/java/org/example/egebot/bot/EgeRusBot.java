package org.example.egebot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class EgeRusBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;

    public EgeRusBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    // поступление команд обработка
    @Override
    public void onUpdateReceived(Update update) {

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
}
