package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task20;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task20Repository extends TaskRepository<Task20> {

    @Override
    default Class<Task20> getEntityClass() {
        return Task20.class;
    }

//    @Query(value = "SELECT t FROM Task20 t ORDER BY RAND()")
//    Optional<Task20> getRandomTask();
}
