package Lesson_05;

import java.util.Random;


public class AppData {
    private String[] headers;
    private int[][] table;
    private Random random = new Random();

    public void init(String[] headers) {
        this.headers = headers;
        table = new int[headers.length][headers.length];

        for (int row = 0; row < headers.length; row++) {
            for (int column = 0; column < headers.length; column++) {
                table[row][column]  = random.nextInt(10);
            }
        }
    }
}
