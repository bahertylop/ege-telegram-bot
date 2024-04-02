package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task10;
import org.example.egebot.models.Task3;
import org.example.egebot.models.Task9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task9Repository extends TaskRepository<Task9> {

    @Override
    default Class<Task9> getEntityClass() {
        return Task9.class;
    }

    @Query(value = "SELECT t FROM Task9 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task9> getRandomTask();
}
