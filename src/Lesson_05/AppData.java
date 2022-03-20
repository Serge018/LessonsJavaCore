package Lesson_05;

import java.util.Random;


public class AppData {
    private String[] headers;
    private int[][] table;


    /*
    * Создаёт таблицу, наполненную случайныма целочисленными значениями в диапазоне (100, 1000)
    */
    public void init(String[] headers) {
        this.headers = headers;
        table = new int[headers.length][headers.length];
        Random random = new Random();

        for (int row = 0; row < headers.length; row++) {
            for (int column = 0; column < headers.length; column++) {
                table[row][column]  = random.nextInt(900) + 100;
            }
        }
    }


    /*
    * Возвращает данные таблицу в виде строки.
    * Все ячейки раздеоены ";"
    */
    @Override
    public String toString() {
        String result = "";

        // производим конкатенацию зголовков
        for (String word : headers) {
            result += word + ";";
        }
        result += "\n";

        // производим конкателацию ячеек
        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[row].length; column++) {
                result += table[row][column] + ";";
            }
            result += "\n";
        }

        return result;
    }
}
