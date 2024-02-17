package project.bomberman;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Game {

    public static final String RESOURCES_PREFIX = "src/main/resources/";
    private Background background;
    private Players[] players;
    private int numberOfPlayers = 4;
    //delay for the animation
    private int delay;

    public Game(int delay) {
        this.background = new Background();
        this.delay = delay;
    }

    public void init() {
        Background background = new Background();

        players = new Players[numberOfPlayers];
        //human goes to index zero
        players[0] = PlayersFactory.getNewBomberman(background, initialPosition(background, 0), Game.RESOURCES_PREFIX + "bomberman.png");
        System.out.println("test to see if the bomberman was created.");
        //AIPlayers start in index 1
        for (int i = 1; i < players.length; i++) {
            players[i] = PlayersFactory.getNewPcPlayers(background, initialPosition(background, i), Game.RESOURCES_PREFIX + "PcPlayers" + i + ".png");
            System.out.println("test to see if the AI player was created.");
        }
    }

    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            movePlayers();
        }

    }

    public void movePlayers() {
        for (int i = 1; i < players.length; i++) {
            players[i].move(background);
        }
    }

    //defines initial position for all Players
    public int[] initialPosition(Background background, int indexPlayer) {
        //to find the center position so all players have the same distance from center
        int[] coordinates = new int[2]; //takes y and x positions

        //800 / 31 cols x = 25.81
        // 363 / 14 rows y = 25.93

        switch (indexPlayer) {
            case 0:
                coordinates[0] = 26;
                coordinates[1] = 26;
                break;
            case 1:
                coordinates[0] = 748;
                coordinates[1] = 26;
                break;
            case 2:
                coordinates[0] = 26;
                coordinates[1] = 285;
                break;
            case 3:
                coordinates[0] = 748;
                coordinates[1] = 285;
                break;
        }
        return coordinates;
    }
}
