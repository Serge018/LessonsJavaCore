package Lesson_01;


public class Player implements ISportsman {
    private String name;
    private int speed;
    private float totalTime;


    public Player(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }


    public float run(int distance) {
        float time = Float.valueOf(distance) / Float.valueOf(speed);
        totalTime += time;

        return time;
    }


    public String getResult() {
        String result = name + " - " + String.format("%.2f", totalTime);

        return result;
    }
}
