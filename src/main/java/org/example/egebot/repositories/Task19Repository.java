package org.example.egebot.repositories;

import org.example.egebot.models.Task1;
import org.example.egebot.models.Task19;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Task19Repository extends JpaRepository<Task19, Long> {

    @Query(value = "SELECT t FROM Task19 t ORDER BY RAND()")
    Optional<Task19> getRandomTask();
}
