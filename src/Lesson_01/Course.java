package Lesson_01;

public class Course {
    int[] distanses = { 122, 75, 32, 45, 20 };


    public void doIt(Team team) {
        for (int distanse : distanses) {
            team.run(distanse);
        }
    }
}
