package org.example.egebot.services;


import org.example.egebot.data.BotStateDTO;

public interface BotStateService {

    BotStateDTO getBotState(Long chatId);

    void setBotStateCommand(Long chatId);

    void setBotStateAnswer(Long chatId, Integer taskType, Long taskId);
}
