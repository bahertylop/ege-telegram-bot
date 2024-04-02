package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task3;
import org.example.egebot.models.Task4;
import org.example.egebot.models.Task5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task4Repository extends TaskRepository<Task4> {

    @Override
    default Class<Task4> getEntityClass() {
        return Task4.class;
    }

    @Query(value = "SELECT t FROM Task4 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task4> getRandomTask();
}
