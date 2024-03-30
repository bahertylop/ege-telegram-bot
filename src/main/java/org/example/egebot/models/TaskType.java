package org.example.egebot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class TaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String task;
    private String answer;
    private String clarification;
    private Integer taskNumber;
}
