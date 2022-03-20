package Lesson_05;

public class Main {
    public static final String FILE_NAME = "table.csv";
    static String[] headers = new String[] { "Заговок №1", "Заговок №3", "Заговок №3" };

    public static void main(String[] args) {
        // Сохранение данных в файл table.csv

    }

    public static AppData newData() {
        AppData appData = new AppData();
        appData.init(headers);
        return appData;
    }
}
