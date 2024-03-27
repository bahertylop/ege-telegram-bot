package org.example.egebot.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.Task3;
import org.example.egebot.models.Task4;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task4DTO {

    private Long id;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;

    public static Task4DTO from(Task4 task) {
        return Task4DTO.builder()
                .id(task.getId())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .build();
    }

    public static List<Task4DTO> from(List<Task4> tasks) {
        return tasks.stream().map(Task4DTO::from).toList();
    }
}