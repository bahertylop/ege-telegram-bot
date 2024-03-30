package org.example.egebot.services;

import org.example.egebot.data.TaskDTO;
import org.springframework.stereotype.Service;


public interface TaskService {

    TaskDTO getRandomTask(Integer taskType);

    boolean checkAnswer(String answer, Long taskId, Integer taskType);
}
