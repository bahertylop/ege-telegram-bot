package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task15;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task15Repository extends TaskRepository<Task15> {

    @Override
    default Class<Task15> getEntityClass() {
        return Task15.class;
    }

    @Query(value = "SELECT t FROM Task15 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task15> getRandomTask();
}
