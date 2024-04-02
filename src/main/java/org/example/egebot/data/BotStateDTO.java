package org.example.egebot.data;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.enums.Enums;
import org.example.egebot.models.BotState;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BotStateDTO {

    private Long id;
    private Long chatId;
    private Enums.State state;
    private Integer taskType;
    private Long taskId;

    public static BotStateDTO from(BotState state) {
        return BotStateDTO.builder()
                .id(state.getId())
                .chatId(state.getChatId())
                .state(state.getState())
                .taskType(state.getTaskType())
                .taskId(state.getTaskId())
                .build();
    }

    public static List<BotStateDTO> from(List<BotState> botStates) {
        return botStates.stream().map(BotStateDTO::from).toList();
    }
}
