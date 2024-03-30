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
public class Task4 extends TaskType  {

    @Column(length = 2000)
    private String task;

    private String answer;

    @Column(length = 500)
    @Nullable
    private String clarification;

    @Column(name = "task_number")
    private Integer taskNumber;
}
