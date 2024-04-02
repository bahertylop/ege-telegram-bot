package org.example.egebot.bot;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class ChooseTask {

    public static InlineKeyboardMarkup getChooseTaskKeyboard() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(InlineKeyboardButton.builder().callbackData("task1").text("1").build());
        row1.add(InlineKeyboardButton.builder().callbackData("task2").text("2").build());
        row1.add(InlineKeyboardButton.builder().callbackData("task3").text("3").build());
        rowsInline.add(row1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(InlineKeyboardButton.builder().callbackData("task4").text("4").build());
        row2.add(InlineKeyboardButton.builder().callbackData("task5").text("5").build());
        row2.add(InlineKeyboardButton.builder().callbackData("task6").text("6").build());
        rowsInline.add(row2);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        row3.add(InlineKeyboardButton.builder().callbackData("task7").text("7").build());
        row3.add(InlineKeyboardButton.builder().callbackData("task8").text("8").build());
        row3.add(InlineKeyboardButton.builder().callbackData("task9").text("9").build());
        rowsInline.add(row3);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        row4.add(InlineKeyboardButton.builder().callbackData("task10").text("10").build());
        row4.add(InlineKeyboardButton.builder().callbackData("task11").text("11").build());
        row4.add(InlineKeyboardButton.builder().callbackData("task12").text("12").build());
        rowsInline.add(row4);

        List<InlineKeyboardButton> row5 = new ArrayList<>();
        row5.add(InlineKeyboardButton.builder().callbackData("task13").text("13").build());
        row5.add(InlineKeyboardButton.builder().callbackData("task14").text("14").build());
        row5.add(InlineKeyboardButton.builder().callbackData("task15").text("15").build());
        rowsInline.add(row5);

        List<InlineKeyboardButton> row6 = new ArrayList<>();
        row6.add(InlineKeyboardButton.builder().callbackData("task16").text("16").build());
        row6.add(InlineKeyboardButton.builder().callbackData("task17").text("17").build());
        row6.add(InlineKeyboardButton.builder().callbackData("task18").text("18").build());
        rowsInline.add(row6);

        List<InlineKeyboardButton> row7 = new ArrayList<>();
        row7.add(InlineKeyboardButton.builder().callbackData("task19").text("19").build());
        row7.add(InlineKeyboardButton.builder().callbackData("task20").text("20").build());
        row7.add(InlineKeyboardButton.builder().callbackData("task21").text("21").build());
        rowsInline.add(row7);
        keyboardMarkup.setKeyboard(rowsInline);

        return keyboardMarkup;
    }
}
