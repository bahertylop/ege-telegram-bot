package org.example.egebot.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.egebot.data.TaskDTO;
import org.springframework.stereotype.Service;


public interface TaskService {

    TaskDTO getRandomTask(Integer taskType);

    boolean checkAnswer(String answer, Long taskId, Integer taskType);

    TaskDTO getTaskByIdAndType(Long taskId, Integer taskType);
}
