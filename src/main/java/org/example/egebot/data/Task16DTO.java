package org.example.egebot.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.Task16;
import org.example.egebot.models.Task7;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task16DTO {

    private Long id;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;

    public static Task16DTO from(Task16 task) {
        return Task16DTO.builder()
                .id(task.getId())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .build();
    }

    public static List<Task16DTO> from(List<Task16> tasks) {
        return tasks.stream().map(Task16DTO::from).toList();
    }
}
