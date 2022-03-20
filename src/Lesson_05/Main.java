package Lesson_05;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static final String FILE_NAME = "table.csv";
    static String[] headers = new String[] { "Title 01", "Title 02", "Title 03" };


    public static void main(String[] args) {
        // Задание №1. Сохранение данных в файл table.csv
        AppData appData = newData();
        save(appData);

        // Задание №2. Чтение файла table.csv
        printFileContent();
    }


    public static AppData newData() {
        AppData appData = new AppData();
        appData.init(headers);

        return appData;
    }


    /*
    * Сохраняет данные таблицы в файл table.csv
    */
    public static void save(AppData appData) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
            String text = appData.toString();
            byte[] data = text.getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(data);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    /*
    * Выводит на экран данные файла table.csv
    */
    public static void printFileContent() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME)) {
            byte[] data = new byte[fileInputStream.available()];
            int result = fileInputStream.read(data);

            if (result == -1) {
                System.out.println("Не удалось прочитать данные из потока.");
            } else {
                String table = new String(data);
                System.out.println(table);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
