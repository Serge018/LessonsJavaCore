package Lesson_05;

import java.io.IOException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static final String FILE_NAME = "table.csv";
    static String[] headers = new String[] { "Title 01", "Title 02", "Title 03" };

    public static void main(String[] args) {
        // Задание №1. Сохранение данных в файл table.csv
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
            // Генерируем таблицу с данными
            String appData = newData().toString();
            byte[] csvData = appData.getBytes(StandardCharsets.UTF_8);

            // Записываем данные таблицы в файл table.csv
            fileOutputStream.write(csvData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static AppData newData() {
        AppData appData = new AppData();
        appData.init(headers);

        return appData;
    }
}
