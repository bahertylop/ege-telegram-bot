package org.example.egebot.repositories;

import jakarta.transaction.Transactional;
import org.example.egebot.enums.Enums;
import org.example.egebot.models.BotState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BotStateRepository extends JpaRepository<BotState, Long> {

    Optional<BotState> getBotStateByChatId(Long chatId);

    @Transactional
    default void setStateCommand(Long chatId) {
        Optional<BotState> botState = getBotStateByChatId(chatId);
        BotState state;
        if (botState.isPresent()) {
            state = botState.get();
            state.setState(Enums.State.COMMAND);
            state.setTaskId(null);
            state.setTaskType(null);
        } else {
            state = BotState.builder()
                    .chatId(chatId)
                    .state(Enums.State.COMMAND)
                    .build();
        }
        save(state);
    }

    @Transactional
    default void setStateAnswer(Long chatId, Long taskId, Integer taskType) {
        Optional<BotState> botState = getBotStateByChatId(chatId);
        BotState state;
        if (botState.isPresent()) {
            state = botState.get();
            state.setState(Enums.State.ANSWER);
            state.setTaskType(taskType);
            state.setTaskId(taskId);
        } else {
            state = BotState.builder()
                    .state(Enums.State.ANSWER)
                    .chatId(chatId)
                    .taskId(taskId)
                    .taskType(taskType)
                    .build();
        }
        save(state);
    }
}
