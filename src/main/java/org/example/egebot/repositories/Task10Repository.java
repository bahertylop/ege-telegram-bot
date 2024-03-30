package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task10;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task10Repository extends TaskRepository<Task10> {

    @Override
    default Class<Task10> getEntityClass() {
        return Task10.class;
    }

//    @Query(value = "SELECT t FROM Task10 t ORDER BY RAND()")
//    Optional<Task10> getRandomTask();
}
