package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task1Repository extends TaskRepository<Task1> {

    @Override
    default Class<Task1> getEntityClass() {
        return Task1.class;
    }

//    @Query(value = "SELECT t FROM Task1 t ORDER BY RAND()")
//    Optional<Task1> getRandomTask();
}
