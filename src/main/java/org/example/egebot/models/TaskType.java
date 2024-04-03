package org.example.egebot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class TaskType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(length = 4000)
    private String text;

    @Column(length = 2000)
    private String task;

    private String answer;

    @Column(length = 2000)
    private String clarification;

    private Integer taskNumber;
}
