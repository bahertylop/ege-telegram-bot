package org.example.egebot.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.Task15;
import org.example.egebot.models.Task7;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task15DTO {

    private Long id;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;

    public static Task15DTO from(Task15 task) {
        return Task15DTO.builder()
                .id(task.getId())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .build();
    }

    public static List<Task15DTO> from(List<Task15> tasks) {
        return tasks.stream().map(Task15DTO::from).toList();
    }
}
