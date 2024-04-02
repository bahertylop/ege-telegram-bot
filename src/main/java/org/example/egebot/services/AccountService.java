package org.example.egebot.services;


import org.telegram.telegrambots.meta.api.objects.Message;

public interface AccountService {

    void signUp(Message message);

    interface BotStateService {
    }
}
