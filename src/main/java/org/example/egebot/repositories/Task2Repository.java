package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task2Repository extends TaskRepository<Task2> {

    @Override
    default Class<Task2> getEntityClass() {
        return Task2.class;
    }

    @Query(value = "SELECT t FROM Task2 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task2> getRandomTask();
}