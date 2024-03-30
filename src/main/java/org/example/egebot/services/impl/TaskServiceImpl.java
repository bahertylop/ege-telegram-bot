package org.example.egebot.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.egebot.constants.ExceptionConstants;
import org.example.egebot.data.TaskDTO;
import org.example.egebot.models.*;
import org.example.egebot.repositories.*;
import org.example.egebot.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public TaskDTO getRandomTask(Integer taskType) {
        return switch (taskType) {
            case 1 ->
                    TaskDTO.from(task1Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 2 ->
                    TaskDTO.from(task2Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 3 ->
                    TaskDTO.from(task3Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 4 ->
                    TaskDTO.from(task4Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 5 ->
                    TaskDTO.from(task5Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 6 ->
                    TaskDTO.from(task6Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 7 ->
                    TaskDTO.from(task7Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 8 ->
                    TaskDTO.from(task8Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 9 ->
                    TaskDTO.from(task9Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 10 ->
                    TaskDTO.from(task10Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 11 ->
                    TaskDTO.from(task11Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 12 ->
                    TaskDTO.from(task12Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 13 ->
                    TaskDTO.from(task13Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 14 ->
                    TaskDTO.from(task14Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 15 ->
                    TaskDTO.from(task15Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 16 ->
                    TaskDTO.from(task16Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 17 ->
                    TaskDTO.from(task17Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 18 ->
                    TaskDTO.from(task18Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 19 ->
                    TaskDTO.from(task19Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 20 ->
                    TaskDTO.from(task20Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            case 21 ->
                    TaskDTO.from(task21Repository.getRandomTask().orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)));
            default -> throw new RuntimeException(ExceptionConstants.TASK_NOT_FOUND);
        };

    }

    @Override
    public boolean checkAnswer(String userAnswer, Long taskId, Integer taskType) {
        boolean result = false;
        switch (taskType) {
            case 1:  // слово
                Optional<Task1> task1 = task1Repository.findById(taskId);
                String realAnswer = task1.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer.contains(userAnswer);
                break;
            case 2: // число
                Optional<Task2> task2 = task2Repository.findById(taskId);
                String realAnswer2 = task2.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer2.equals(userAnswer);
                break;
            case 3: // число
                Optional<Task3> task3 = task3Repository.findById(taskId);
                String realAnswer3 = task3.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer3.equals(userAnswer);
                break;
            case 4: // число
                Optional<Task4> task4 = task4Repository.findById(taskId);
                String realAnswer4 = task4.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer4.equals(userAnswer);
                break;
            case 5:  // слово
                Optional<Task5> task5 = task5Repository.findById(taskId);
                String realAnswer5 = task5.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer5.contains(userAnswer);
                break;
            case 6:  // слово
                Optional<Task6> task6 = task6Repository.findById(taskId);
                String realAnswer6 = task6.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer6.contains(userAnswer);
                break;
            case 7: // слово
                Optional<Task7> task7 = task7Repository.findById(taskId);
                String realAnswer7 = task7.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer7.contains(userAnswer);
                break;
            case 8: // число
                Optional<Task8> task8 = task8Repository.findById(taskId);
                String realAnswer8 = task8.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer8.equals(userAnswer);
                break;
            case 9: // число
                Optional<Task9> task9 = task9Repository.findById(taskId);
                String realAnswer9 = task9.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer9.equals(userAnswer);
                break;
            case 10: // число
                Optional<Task10> task10 = task10Repository.findById(taskId);
                String realAnswer10 = task10.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer10.equals(userAnswer);
                break;
            case 11: // число
                Optional<Task11> task11 = task11Repository.findById(taskId);
                String realAnswer11 = task11.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer11.equals(userAnswer);
                break;
            case 12:  // число
                Optional<Task12> task12 = task12Repository.findById(taskId);
                String realAnswer12 = task12.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer12.equals(userAnswer);
                break;
            case 13: // число
                Optional<Task13> task13 = task13Repository.findById(taskId);
                String realAnswer13 = task13.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer13.equals(userAnswer);
                break;
            case 14: // число
                Optional<Task14> task14 = task14Repository.findById(taskId);
                String realAnswer14 = task14.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer14.equals(userAnswer);
                break;
            case 15: // число
                Optional<Task15> task15 = task15Repository.findById(taskId);
                String realAnswer15 = task15.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer15.equals(userAnswer);
                break;
            case 16: // число
                Optional<Task16> task16 = task16Repository.findById(taskId);
                String realAnswer16 = task16.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer16.equals(userAnswer);
                break;
            case 17: // число
                Optional<Task17> task17 = task17Repository.findById(taskId);
                String realAnswer17 = task17.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer17.equals(userAnswer);
                break;
            case 18: // число
                Optional<Task18> task18 = task18Repository.findById(taskId);
                String realAnswer18 = task18.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer18.equals(userAnswer);
                break;
            case 19: // число
                Optional<Task19> task19 = task19Repository.findById(taskId);
                String realAnswer19 = task19.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer19.equals(userAnswer);
                break;
            case 20: // число
                Optional<Task20> task20 = task20Repository.findById(taskId);
                String realAnswer20 = task20.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer20.equals(userAnswer);
                break;
            case 21: // число
                Optional<Task21> task21 = task21Repository.findById(taskId);
                String realAnswer21 = task21.orElseThrow(() -> new RuntimeException(ExceptionConstants.TASK_NOT_FOUND)).getAnswer();
                result = realAnswer21.equals(userAnswer);
                break;
            default:
                result = false;
        }
        return false;
    }
}
