package org.example.egebot.data;


import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.Task1;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task1DTO {

    private Long id;
    private String text;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;

    public static Task1DTO from(Task1 task) {
        return Task1DTO.builder()
                .id(task.getId())
                .text(task.getText())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .build();
    }

    public static List<Task1DTO> from(List<Task1> tasks) {
        return tasks.stream().map(Task1DTO::from).toList();
    }
}
