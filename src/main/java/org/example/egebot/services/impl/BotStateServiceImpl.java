package org.example.egebot.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.egebot.data.BotStateDTO;
import org.example.egebot.data.TaskDTO;
import org.example.egebot.enums.Enums;
import org.example.egebot.models.BotState;
import org.example.egebot.repositories.BotStateRepository;
import org.example.egebot.services.BotStateService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BotStateServiceImpl implements BotStateService {

    private final BotStateRepository botStateRepository;

    @Override
    public BotStateDTO getBotState(Long chatId) {
        Optional<BotState> botState = botStateRepository.getBotStateByChatId(chatId);

        if (botState.isPresent()) {
            return BotStateDTO.from(botState.get());
        } else {
            BotState newBotState = BotState.builder()
                    .chatId(chatId)
                    .state(Enums.State.COMMAND)
                    .build();
            botStateRepository.save(newBotState);
            return BotStateDTO.from(newBotState);
        }
    }

    @Override
    public void setTaskType(Integer taskType, Long chatId) {
        Optional<BotState> botState = botStateRepository.getBotStateByChatId(chatId);

        if (botState.isPresent()) {
            BotState state = botState.get();
            if (taskType != null) {
                state.setTaskType(taskType);
            }
            botStateRepository.save(state);
        } else {
            BotState newBotState = BotState.builder()
                    .chatId(chatId)
                    .taskType(taskType)
                    .build();
            botStateRepository.save(newBotState);
        }
    }

    @Override
    public Integer getTaskType(Long chatId) {
        Optional<BotState> botState = botStateRepository.getBotStateByChatId(chatId);

        int taskType = 1;
        if (botState.isPresent()) {
            BotState state = botState.get();
            if (state.getTaskType() != null) {
                taskType = state.getTaskType();
            }
        }
        return taskType;
    }

    @Override
    public void setBotStateCommand(Long chatId) {
        botStateRepository.setStateCommand(chatId);
    }

    @Override
    public void setBotStateAnswer(Long chatId, Integer taskType, Long taskId) {
        botStateRepository.setStateAnswer(chatId, taskId, taskType);
    }
}
