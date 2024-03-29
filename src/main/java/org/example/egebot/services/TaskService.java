package org.example.egebot.services;

import org.springframework.stereotype.Service;


public interface TaskService {

    void getRandomTask(Integer taskType);

    boolean checkAnswer(String answer, Long taskId, Integer taskType);
}
