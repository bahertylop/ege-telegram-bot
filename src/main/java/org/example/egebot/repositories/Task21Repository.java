package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task21;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task21Repository extends TaskRepository<Task21> {

    @Override
    default Class<Task21> getEntityClass() {
        return Task21.class;
    }

    @Query(value = "SELECT t FROM Task21 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task21> getRandomTask();
}
