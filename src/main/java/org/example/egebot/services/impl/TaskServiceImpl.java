package org.example.egebot.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.egebot.models.*;
import org.example.egebot.repositories.*;
import org.example.egebot.services.TaskService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final Task1Repository task1Repository;
    private final Task2Repository task2Repository;
    private final Task3Repository task3Repository;
    private final Task4Repository task4Repository;
    private final Task5Repository task5Repository;
    private final Task6Repository task6Repository;
    private final Task7Repository task7Repository;
    private final Task8Repository task8Repository;
    private final Task9Repository task9Repository;
    private final Task10Repository task10Repository;
    private final Task11Repository task11Repository;
    private final Task12Repository task12Repository;
    private final Task13Repository task13Repository;
    private final Task14Repository task14Repository;
    private final Task15Repository task15Repository;
    private final Task16Repository task16Repository;
    private final Task17Repository task17Repository;
    private final Task18Repository task18Repository;
    private final Task19Repository task19Repository;
    private final Task20Repository task20Repository;
    private final Task21Repository task21Repository;







    @Override
    public void getRandomTask(Integer taskType) {

    }

    @Override
    public boolean checkAnswer(String answer, Long taskId, Integer taskType) {
        return false;
    }
}
