package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task3;
import org.example.egebot.models.Task7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task7Repository extends JpaRepository<Task7, Long> {

    @Query(value = "SELECT t FROM Task7 t ORDER BY RAND()")
    Optional<Task7> getRandomTask();
}
