package org.example.egebot.services.impl;


import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.example.egebot.bot.EgeRusBot;
import org.example.egebot.data.AccountDTO;
import org.example.egebot.models.Account;
import org.example.egebot.repositories.AccountRepository;
import org.example.egebot.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;

    @Override
    public void signUp(Message message) {
        String userName = message.getFrom().getUserName();
        Long chatId = message.getChatId();

        if (accountRepository.getAccountByChatId(chatId).isEmpty()) {
            Account newAccount = Account.builder()
                    .userName(userName)
                    .chatId(chatId)
                    .startDate(LocalDate.now())
                    .tries(10)
                    .subscribed(false)
                    .build();

            try {
                accountRepository.save(newAccount);
            } catch (PersistenceException e) {
                LOGGER.error("error to save account with id: " + chatId + "; " + e.getMessage());
            }

        }
    }


    // разобраться с null
    @Override
    public AccountDTO getAccount(Long chatId) {
        Optional<Account> account = accountRepository.getAccountByChatId(chatId);

        return account.map(AccountDTO::from).orElse(null);
    }

    @Override
    public boolean canSendTask(Long chatId) {
        Optional<Account> account = accountRepository.getAccountByChatId(chatId);

        if (account.isPresent()) {
            Account accountReal = account.get();

            if (accountReal.isSubscribed()) {
                LocalDate now = LocalDate.now();
                LocalDate end = accountReal.getEndSubscribe();
                if (end != null) {
                    return now.isBefore(end);
                }
            } else {
                int tries = accountReal.getTries();
                if (tries > 0) {
                    accountReal.setTries(tries - 1);
                    accountRepository.save(accountReal);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean isSubscribed(Long chatId) {
        Optional<Account> account = accountRepository.getAccountByChatId(chatId);

        if (account.isPresent()) {
            Account accountReal = account.get();

            if (accountReal.isSubscribed()) {
                LocalDate now = LocalDate.now();
                LocalDate end = accountReal.getEndSubscribe();
                if (end != null) {
                    return now.isBefore(end);
                }
            }
        }
        return false;
    }
}
