package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task18;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task18Repository extends JpaRepository<Task18, Long> {

    @Query(value = "SELECT t FROM Task18 t ORDER BY RAND()")
    Optional<Task18> getRandomTask();
}
