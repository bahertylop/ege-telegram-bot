package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task21;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task21Repository extends JpaRepository<Task21, Long> {

    @Query(value = "SELECT t FROM Task21 t ORDER BY RAND()")
    Optional<Task21> getRandomTask();
}
