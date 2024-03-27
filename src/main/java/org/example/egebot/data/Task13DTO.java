package org.example.egebot.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.Task13;
import org.example.egebot.models.Task7;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task13DTO {

    private Long id;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;

    public static Task13DTO from(Task13 task) {
        return Task13DTO.builder()
                .id(task.getId())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .build();
    }

    public static List<Task13DTO> from(List<Task13> tasks) {
        return tasks.stream().map(Task13DTO::from).toList();
    }
}
