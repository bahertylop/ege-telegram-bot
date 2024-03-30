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

//    public static <T extends TaskType> TaskDTO from(T taskEntity, Class<T> entityType) {
//        TaskDTO dto = new TaskDTO();
//        dto.setId(taskEntity.getId());
//        dto.setText(taskEntity.getText());
//        dto.setTask(taskEntity.getTask());
//        dto.setAnswer(taskEntity.getAnswer());
//        dto.setClarification(taskEntity.getClarification());
//        dto.setTaskNumber(taskEntity.getTaskNumber());
//        // здесь можно обработать другие поля в зависимости от типа задачи
//
//        return dto;
//    }

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

    public static TaskDTO from(TaskType taskType, Class<? extends TaskType> entityType) {
        TaskDTO dto = new TaskDTO();
        dto.setId(taskType.getId());
        dto.setTask(taskType.getTask());
        dto.setTaskNumber(taskType.getTaskNumber());
        dto.setClarification(taskType.getClarification());
        dto.setAnswer(taskType.getAnswer());
        dto.setTaskType(findTaskType(taskType));

        if (taskType.getText() == null) {
            dto.setText(null);
            dto.setNeedText(false);
        } else {
            dto.setText(taskType.getText());
            dto.setNeedText(true);
        }

        return dto;
    }

    public static int findTaskType(TaskType taskType) {
        if (taskType instanceof Task1)
            return 1;
        else if (taskType instanceof Task2)
            return 2;
        else if (taskType instanceof Task3)
            return 3;
        else if (taskType instanceof Task4)
            return 4;
        else if (taskType instanceof Task5)
            return 5;
        else if (taskType instanceof Task6)
            return 6;
        else if (taskType instanceof Task7)
            return 7;
        else if (taskType instanceof Task8)
            return 8;
        else if (taskType instanceof Task9)
            return 9;
        else if (taskType instanceof Task10)
            return 10;
        else if (taskType instanceof Task11)
            return 11;
        else if (taskType instanceof Task12)
            return 12;
        else if (taskType instanceof Task13)
            return 13;
        else if (taskType instanceof Task14)
            return 14;
        else if (taskType instanceof Task15)
            return 15;
        else if (taskType instanceof Task16)
            return 16;
        else if (taskType instanceof Task17)
            return 17;
        else if (taskType instanceof Task18)
            return 18;
        else if (taskType instanceof Task19)
            return 19;
        else if (taskType instanceof Task20)
            return 20;
        else if (taskType instanceof Task21)
            return 21;
        else return 0;
    }
}
