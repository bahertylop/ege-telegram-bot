package org.example.egebot.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.data.TaskDTO;
import org.example.egebot.enums.Enums;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BotState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long chatId;

    @Enumerated(value = EnumType.STRING)
    private Enums.State state;

    private Integer taskType;

    private Long taskId;
}
