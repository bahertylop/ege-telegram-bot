package org.example.egebot.services;


import org.example.egebot.data.BotStateDTO;

public interface BotStateService {

    BotStateDTO getBotState(Long chatId);

    void setBotStateCommand(Long chatId);

    void setBotStateAnswer(Long chatId, Integer taskType, Long taskId);

    void setTaskType(Integer taskType, Long chatId);

    Integer getTaskType(Long chatId);

    void setBotStateBuying(Long chatId);

    boolean checkBotStateBuying(Long chatId);
}
