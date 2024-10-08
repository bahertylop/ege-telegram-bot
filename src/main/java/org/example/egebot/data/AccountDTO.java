package org.example.egebot.data;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.egebot.models.Account;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {

    private Long id;
    private String userName;
    private LocalDate firstStartDate;
    private Integer tries;
    private Boolean subscribed;
    private LocalDate endSubscribe;
    private Integer rightAnswers;
    private Integer badAnswers;
    private Integer skippedTasks;

    public static AccountDTO from(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .userName(account.getUserName())
                .subscribed(account.isSubscribed())
                .firstStartDate(account.getStartDate())
                .endSubscribe(account.getEndSubscribe())
                .tries(account.getTries())
                .rightAnswers(account.getRightAnswers())
                .badAnswers(account.getBadAnswers())
                .skippedTasks(account.getSkippedTasks())
                .build();
    }

    public static List<AccountDTO> from(List<Account> accounts) {
        return accounts.stream().map(AccountDTO::from).toList();
    }

    public String toString() {
        String id = "Id профиля: " + this.id + "\n";
        String userName = "Имя пользователя: " + this.userName + "\n";

        String subscribe = "";
        if (subscribed) {
            subscribe = "Оформлена подписка до: " + endSubscribe + "\n";
        } else {
            subscribe = "Подписка не оформлена, для покупки подписки нажми \"Купить подписку\"\n" +
            "Бесплатных попыток осталось " + tries + "\n";
        }

        String start = "Впервые активировали бота: " + firstStartDate + " \uD83E\uDD1D\n";

        String rightAnswers = "✅ Правильных ответов: " + getRightAnswers() + "\n";
        String badAnswers = "❌ Неправильных ответов: " + getBadAnswers() + "\n";
        String skipped = "Пропущено заданий: " + getSkippedTasks();

        return id + userName + subscribe + start + rightAnswers + badAnswers + skipped;
    }
}
