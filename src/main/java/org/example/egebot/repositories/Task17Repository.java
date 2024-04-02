package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task17;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task17Repository extends TaskRepository<Task17> {

    @Override
    default Class<Task17> getEntityClass() {
        return Task17.class;
    }

    @Query(value = "SELECT t FROM Task17 t ORDER BY RANDOM() LIMIT 1")
    Optional<Task17> getRandomTask();
}
