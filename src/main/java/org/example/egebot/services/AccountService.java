package org.example.egebot.services;


import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface AccountService {

    void signUp(Message message);
}
