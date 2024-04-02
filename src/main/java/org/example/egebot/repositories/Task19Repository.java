package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task19;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task19Repository extends TaskRepository<Task19> {
    @Override
    default Class<Task19> getEntityClass() {
        return Task19.class;
    }


    @Query(value = "SELECT t FROM Task19 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task19> getRandomTask();
}
