package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task3;
import org.example.egebot.models.Task5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task5Repository extends TaskRepository<Task5> {

    @Override
    default Class<Task5> getEntityClass() {
        return Task5.class;
    }

    @Query(value = "SELECT t FROM Task5 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task5> getRandomTask();
}
