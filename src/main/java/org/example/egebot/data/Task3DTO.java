package org.example.egebot.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.Task2;
import org.example.egebot.models.Task3;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task3DTO {

    private Long id;
    private String text;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;

    public static Task3DTO from(Task3 task) {
        return Task3DTO.builder()
                .id(task.getId())
                .text(task.getText())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .build();
    }

    public static List<Task3DTO> from(List<Task3> tasks) {
        return tasks.stream().map(Task3DTO::from).toList();
    }
}