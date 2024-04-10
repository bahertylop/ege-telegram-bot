package org.example.egebot.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Keyboards {

    public static ReplyKeyboardMarkup mainCommands() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        keyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("Решать задания");

        KeyboardRow row2 = new KeyboardRow();
        row2.add("Профиль");
        row2.add("Купить подписку");

        keyboardRows.add(row1);
        keyboardRows.add(row2);

        keyboardMarkup.setKeyboard(keyboardRows);

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup taskCommands() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        keyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("⬅\uFE0F");
        row1.add("Пропустить задание");

        KeyboardRow row2 = new KeyboardRow();
        row2.add("Узнать ответ");

        keyboardRows.add(row1);
        keyboardRows.add(row2);

        keyboardMarkup.setKeyboard(keyboardRows);

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup profileCommands() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        keyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("⬅\uFE0F");
        row.add("Купить подписку");

        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);

        return keyboardMarkup;
    }
}
