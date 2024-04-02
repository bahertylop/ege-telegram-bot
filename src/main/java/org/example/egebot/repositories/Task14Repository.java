package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task14;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task14Repository extends TaskRepository<Task14> {

    @Override
    default Class<Task14> getEntityClass() {
        return Task14.class;
    }

    @Query(value = "SELECT t FROM Task14 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task14> getRandomTask();
}
