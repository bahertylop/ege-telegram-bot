package org.example.egebot.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.*;

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
    private Integer taskType;

    public static TaskDTO from(Task1 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(true)
                .text(task.getText())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(1)
                .build();
    }

    public static TaskDTO from(Task2 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(true)
                .text(task.getText())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(2)
                .build();
    }

    public static TaskDTO from(Task3 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(true)
                .text(task.getText())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(3)
                .build();
    }

    public static TaskDTO from(Task4 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(4)
                .build();
    }

    public static TaskDTO from(Task5 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(5)
                .build();
    }

    public static TaskDTO from(Task6 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(6)
                .build();
    }

    public static TaskDTO from(Task7 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(7)
                .build();
    }

    public static TaskDTO from(Task8 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(true)
                .text(task.getText())
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(4)
                .build();
    }

    public static TaskDTO from(Task9 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(9)
                .build();
    }

    public static TaskDTO from(Task10 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(10)
                .build();
    }

    public static TaskDTO from(Task11 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(11)
                .build();
    }

    public static TaskDTO from(Task12 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(12)
                .build();
    }

    public static TaskDTO from(Task13 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(13)
                .build();
    }

    public static TaskDTO from(Task14 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(14)
                .build();
    }

    public static TaskDTO from(Task15 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(15)
                .build();
    }

    public static TaskDTO from(Task16 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(16)
                .build();
    }

    public static TaskDTO from(Task17 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(17)
                .build();
    }

    public static TaskDTO from(Task18 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(18)
                .build();
    }

    public static TaskDTO from(Task19 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(19)
                .build();
    }

    public static TaskDTO from(Task20 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(20)
                .build();
    }

    public static TaskDTO from(Task21 task) {
        return TaskDTO.builder()
                .id(task.getId())
                .needText(false)
                .text(null)
                .task(task.getTask())
                .answer(task.getAnswer())
                .clarification(task.getClarification())
                .taskNumber(task.getTaskNumber())
                .taskType(21)
                .build();
    }


    public static List<Task1DTO> from(List<Task1> tasks) {
        return tasks.stream().map(Task1DTO::from).toList();
    }
}
