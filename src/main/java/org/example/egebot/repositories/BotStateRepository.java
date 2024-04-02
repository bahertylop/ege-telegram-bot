package org.example.egebot.repositories;

import org.example.egebot.models.BotState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BotStateRepository extends JpaRepository<BotState, Long> {

    Optional<BotState> getBotStateByChatId(Long chatId);


}
