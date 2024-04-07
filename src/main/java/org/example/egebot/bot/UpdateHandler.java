package org.example.egebot.bot;

import lombok.RequiredArgsConstructor;
import org.example.egebot.data.BotStateDTO;
import org.example.egebot.enums.Enums;
import org.example.egebot.services.AccountService;
import org.example.egebot.services.BotStateService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class UpdateHandler {

    private final BotStateService botStateService;

    private final AccountService accountService;

    private final ChooseTask chooseTask;

    private final Sender sender;
    public void handleMessage(Message message, EgeRusBot bot) {
        Long chatId = message.getChatId();
        System.out.println(chatId);
        String text = message.getText();
        BotStateDTO botState = botStateService.getBotState(chatId);

        if (text.equals("/start")) {
            accountService.signUp(message);
            sender.startBot(chatId, bot);
        } else if (text.equals("Решать задания")) {
            sender.sendMessage(chatId, "Выберите номер задания, которое хотите порешать.\uD83D\uDC47", ChooseTask.getChooseTaskKeyboard(), bot);
        } else if (text.equals("Пропустить задание")) {
            sender.sendTask(chatId, bot);
        } else if (text.equals("\uD83D\uDD19")) {
            botStateService.setBotStateCommand(chatId);
            sender.sendMessage(chatId, "Выберите нужный пункт меню", Keyboards.mainCommands(), bot);
        } else if (text.equals("Купить подписку")) {
            sender.sendMessage(chatId, "Купить подписку переведите сотку по номеру 89083006654 и пришлите чек", Keyboards.profileCommands(), bot);
        } else if (botState.getState().equals(Enums.State.ANSWER)) {
            if (text.equals("Узнать ответ")) {
                sender.sendAnswer(chatId, bot);
            } else {
                sender.checkTaskAnswer(chatId, text, bot);
            }
        } else if (text.equals("Профиль")) {
            sender.profileMessage(chatId, bot);
        }
        else {
            sender.sendMessage(chatId, "Неизвестная команда, воспользуйтесь меню)", Keyboards.mainCommands(), bot);
        }
    }

    public void handleCallbackQuery(CallbackQuery callbackQuery, EgeRusBot bot) {
        Long chatId = callbackQuery.getFrom().getId();
        System.out.println(chatId);
        String data = callbackQuery.getData();
        System.out.println(data);
        chooseTask.chooseTaskNumber(chatId, data, bot);
    }
}