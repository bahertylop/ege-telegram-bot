package org.example.egebot.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.egebot.constants.ExceptionConstants;
import org.example.egebot.data.TaskDTO;
import org.example.egebot.models.*;
import org.example.egebot.repositories.*;
import org.example.egebot.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TaskServiceImpl implements TaskService {
    private final Map<Integer, TaskRepository<? extends TaskType>> taskRepositories = new HashMap<>();

    @Autowired
    public TaskServiceImpl(
            Task1Repository task1Repository,
            Task2Repository task2Repository,
            Task3Repository task3Repository,
            Task5Repository task5Repository,
            Task6Repository task6Repository,
            Task7Repository task7Repository,
            Task8Repository task8Repository,
            Task4Repository task4Repository,
            Task9Repository task9Repository,
            Task10Repository task10Repository,
            Task11Repository task11Repository,
            Task12Repository task12Repository,
            Task13Repository task13Repository,
            Task14Repository task14Repository,
            Task15Repository task15Repository,
            Task16Repository task16Repository,
            Task17Repository task17Repository,
            Task18Repository task18Repository,
            Task19Repository task19Repository,
            Task20Repository task20Repository,
            Task21Repository task21Repository
    ) {
        taskRepositories.put(1, task1Repository);
        taskRepositories.put(2, task2Repository);
        taskRepositories.put(3, task3Repository);
        taskRepositories.put(4, task4Repository);
        taskRepositories.put(5, task5Repository);
        taskRepositories.put(6, task6Repository);
        taskRepositories.put(7, task7Repository);
        taskRepositories.put(8, task8Repository);
        taskRepositories.put(9, task9Repository);
        taskRepositories.put(10, task10Repository);
        taskRepositories.put(11, task11Repository);
        taskRepositories.put(12, task12Repository);
        taskRepositories.put(13, task13Repository);
        taskRepositories.put(14, task14Repository);
        taskRepositories.put(15, task15Repository);
        taskRepositories.put(16, task16Repository);
        taskRepositories.put(17, task17Repository);
        taskRepositories.put(18, task18Repository);
        taskRepositories.put(19, task19Repository);
        taskRepositories.put(20, task20Repository);
        taskRepositories.put(21, task21Repository);
    }

    @Override
    public TaskDTO getRandomTask(Integer taskType) {
        TaskRepository<? extends TaskType> repository = taskRepositories.get(taskType);
        if (repository == null) {
            throw new RuntimeException(ExceptionConstants.TASK_NOT_FOUND);
        }
        Class<? extends TaskType> entityType = repository.getEntityClass();
        return TaskDTO.from(repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
    }

    @Override
    public boolean checkAnswer(String userAnswer, Long taskId, Integer taskType) {
        TaskRepository<? extends TaskType> repository = taskRepositories.get(taskType);
        if (repository == null) {
            throw new RuntimeException(ExceptionConstants.TASK_NOT_FOUND);
        }

        Optional<? extends TaskType> task = repository.findById(taskId);
        if (task.isPresent()) {
            if (List.of(1, 5, 6, 7).contains(taskType)) {
                return task.get().getAnswer().contains(userAnswer);
            } else {
                return task.get().getAnswer().equals(userAnswer);
            }
        } else {
            return false;
        }
    }

    @Override
    public TaskDTO getTaskByIdAndType(Long taskId, Integer taskType) {
        TaskRepository<? extends TaskType> repository = taskRepositories.get(taskType);
        if (repository == null) {
            throw new RuntimeException(ExceptionConstants.TASK_NOT_FOUND);
        }

        Optional<? extends TaskType> task = repository.findById(taskId);
        if (task.isPresent()) {
            return TaskDTO.from(task.get());
        } else {
            throw new RuntimeException(ExceptionConstants.TASK_NOT_FOUND);
        }
    }
}
