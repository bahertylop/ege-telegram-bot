package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task16;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task16Repository extends TaskRepository<Task16> {

    @Override
    default Class<Task16> getEntityClass() {
        return Task16.class;
    }

    @Query(value = "SELECT t FROM Task16 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task16> getRandomTask();
}
