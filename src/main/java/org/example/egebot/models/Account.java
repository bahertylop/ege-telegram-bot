package org.example.egebot.models;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.ws.rs.DefaultValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.engine.messageinterpolation.util.InterpolationHelper;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "first_start")
    private LocalDate startDate;

    @Column(name = "user_name")
    private String userName;

    private int tries = 10;

    private boolean subscribed;

    @Column(name = "end_subscribe")
    private LocalDate endSubscribe;

    @Column(name = "right_answers", columnDefinition = "integer default 0")
    private Integer rightAnswers;

    @Column(name = "bad_answers", columnDefinition = "integer default 0")
    private Integer badAnswers;

    @Column(name = "skipped_tasks", columnDefinition = "integer default 0")
    private Integer skippedTasks;
}
