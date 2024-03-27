package org.example.egebot.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.Task20;
import org.example.egebot.models.Task21;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task21DTO {

    private Long id;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;

    public static Task21DTO from(Task21 task) {
        return Task21DTO.builder()
                .id(task.getId())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .build();
    }

    public static List<Task21DTO> from(List<Task21> tasks) {
        return tasks.stream().map(Task21DTO::from).toList();
    }
}