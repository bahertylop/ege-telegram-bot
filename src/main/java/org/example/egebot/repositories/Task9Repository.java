package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task10;
import org.example.egebot.models.Task3;
import org.example.egebot.models.Task9;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task9Repository extends JpaRepository<Task9, Long> {

    @Query(value = "SELECT t FROM Task9 t ORDER BY RAND()")
    Optional<Task9> getRandomTask();
}
