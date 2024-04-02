package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task12;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task12Repository extends TaskRepository<Task12> {


    @Override
    default Class<Task12> getEntityClass() {
        return Task12.class;
    }
    @Query(value = "SELECT t FROM Task12 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task12> getRandomTask();
}
