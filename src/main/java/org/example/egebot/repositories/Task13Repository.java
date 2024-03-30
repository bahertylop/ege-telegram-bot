package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task13;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task13Repository extends TaskRepository<Task13> {

    @Override
    default Class<Task13> getEntityClass() {
        return Task13.class;
    }

//    @Query(value = "SELECT t FROM Task13 t ORDER BY RAND()")
//    Optional<Task13> getRandomTask();
}
