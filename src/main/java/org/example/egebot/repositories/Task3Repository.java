package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task2;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task3Repository extends TaskRepository<Task3> {

    @Override
    default Class<Task3> getEntityClass() {
        return Task3.class;
    }

    @Query(value = "SELECT t FROM Task3 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task3> getRandomTask();
}