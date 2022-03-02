package Lesson_01;


public class Team {
    String name;
    private final ISportsman[] players;


    public Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
    }


    public void showResults () {
        String total = getResult();
        System.out.print(total);
    }


    public float run(int distance) {
        float maxTimeOfPlayers = 0.0F;
        for (ISportsman player : players) {
            float time = player.run(distance);
            if (time > maxTimeOfPlayers)
            {
                maxTimeOfPlayers = time;
            }
        }

        return maxTimeOfPlayers;
    }


    public String getResult() {
        StringBuilder total = new StringBuilder();
        for (ISportsman player : players) {
            String result = player.getResult();
            total.append(result).append("\n");
        }

        return total.toString();
    }
}
