package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task3;
import org.example.egebot.models.Task6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task6Repository extends TaskRepository<Task6> {

    @Override
    default Class<Task6> getEntityClass() {
        return Task6.class;
    }

    @Query(value = "SELECT t FROM Task6 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task6> getRandomTask();
}