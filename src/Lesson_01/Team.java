package Lesson_01;


public class Team implements ISportsman {
    String name;
    private Player[] players;


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
        for (Player player : players) {
            float time = player.run(distance);
            if (time > maxTimeOfPlayers)
            {
                maxTimeOfPlayers = time;
            }
        }

        return maxTimeOfPlayers;
    }


    public String getResult() {
        String total = "";
        for (Player player : players) {
            String result = player.getResult();
            total += (result + "\n");
        }

        return total;
    }
}
