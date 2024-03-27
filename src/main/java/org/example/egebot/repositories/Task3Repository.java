package org.example.egebot.repositories;

import org.example.egebot.models.Task2;
import org.example.egebot.models.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Task3Repository extends JpaRepository<Task3, Long> {


}