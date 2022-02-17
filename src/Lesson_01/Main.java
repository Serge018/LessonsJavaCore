package Lesson_01;

public class Main {

    public static void main(String[] args) {
        // Создаем полосу препятствий
        Course course = new Course();

        // Создаем команду
        Player[] players = {
            new Player("Raphael", 7),
            new Player("Leonardo", 6),
            new Player("Donatello", 8),
            new Player("Michelangelo", 9)
        };
        Team team = new Team("TMNT", players);

        // Просим команду пройти полосу
        course.doIt(team);

        // Показываем результаты
         team.showResults();
    }
}
