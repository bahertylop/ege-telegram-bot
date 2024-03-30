package org.example.egebot.repositories;

import org.example.egebot.models.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface TaskRepository<T extends TaskType> extends JpaRepository<T , Long> {


    default Class<T> getEntityClass() {
        return null;
    }

    @Query(value = "SELECT t FROM #{#entityName} t ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<T> getRandomTask();
}
