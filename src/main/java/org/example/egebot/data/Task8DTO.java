package org.example.egebot.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.Task2;
import org.example.egebot.models.Task8;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task8DTO {

    private Long id;
    private String text;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;

    public static Task8DTO from(Task8 task) {
        return Task8DTO.builder()
                .id(task.getId())
                .text(task.getText())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .build();
    }

    public static List<Task8DTO> from(List<Task8> tasks) {
        return tasks.stream().map(Task8DTO::from).toList();
    }
}