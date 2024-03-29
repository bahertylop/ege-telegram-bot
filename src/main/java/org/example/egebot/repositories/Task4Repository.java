package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task3;
import org.example.egebot.models.Task4;
import org.example.egebot.models.Task5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task4Repository extends JpaRepository<Task4, Long> {

    @Query(value = "SELECT t FROM Task4 t ORDER BY RAND()")
    Optional<Task5> getRandomTask();
}
