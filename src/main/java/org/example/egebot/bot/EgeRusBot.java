package org.example.egebot.bot;

import lombok.RequiredArgsConstructor;
import org.example.egebot.data.AccountDTO;
import org.example.egebot.data.BotStateDTO;
import org.example.egebot.data.TaskDTO;
import org.example.egebot.enums.Enums;
import org.example.egebot.models.BotState;
import org.example.egebot.services.AccountService;
import org.example.egebot.services.BotStateService;
import org.example.egebot.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Optional;

@Component
//@RequiredArgsConstructor
public class EgeRusBot extends TelegramLongPollingBot {
    private final UpdateHandler updateHandler;

    @Value("${bot.name}")
    private String botName;

    public EgeRusBot(@Value("${bot.token}") String botToken, UpdateHandler updateHandler) {
        super(botToken);
        this.updateHandler = updateHandler;
    }

    // поступление команд обработка
    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null) {
            updateHandler.handleMessage(update.getMessage(), this);
        } else if (update.hasCallbackQuery()) {
            updateHandler.handleCallbackQuery(update.getCallbackQuery(), this);
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
}
