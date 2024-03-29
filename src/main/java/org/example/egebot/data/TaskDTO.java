package org.example.egebot.data;

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
public class TaskDTO {

    private Long id;
    private Boolean needText;
    private String text;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;

    public static TaskDTO from(Task1 task) {
        return TaskDTO.builder()
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
