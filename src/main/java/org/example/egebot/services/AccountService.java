package org.example.egebot.services;


import org.example.egebot.data.AccountDTO;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface AccountService {

    void signUp(Message message);

    AccountDTO getAccount(Long chatId);
}
