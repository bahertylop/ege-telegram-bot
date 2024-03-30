package org.example.egebot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task15 extends TaskType  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(length = 2000)
    private String task;

    private String answer;

    @Column(length = 1500)
    @Nullable
    private String clarification;

    @Column(name = "task_number")
    private Integer taskNumber;
}
