package project.bomberman;

import java.util.ArrayList;

public class Game {

    public static final String RESOURCES_PREFIX = "src/main/resources/";
    private Background background;
    private Players[] players;
    private int numberOfPlayers = 4;
    //delay for the animation
    private int delay;
    static KeyboardLogic keyboard;
    private ArrayList<Bomb> bombs = new ArrayList<>();

    public Game(int delay) {
        this.background = new Background();
        this.delay = delay;
    }

    public void init() {
        Background background = new Background();

        players = new Players[numberOfPlayers];
        keyboard = new KeyboardLogic();
        //human goes to index zero
        players[0] = PlayersFactory.getNewBomberman(background, initialPosition(0), 25.80,Game.RESOURCES_PREFIX + "NeoBattleIcon.png");
        System.out.println("test to see if the bomberman was created.");
        //PCPlayers start on index 1
        for (int i = 1; i < players.length; i++) {
            players[i] = PlayersFactory.getNewPcPlayers(background, initialPosition(i), 25.80, Game.RESOURCES_PREFIX + "PcPlayers" + i + ".png");
            System.out.println("test to see if the PC Player was created.");
        }
    }

    public void start() throws InterruptedException {
        int t = 0;
        while (t < 1000) {

            // Pause for a while
            Thread.sleep(delay);

            movePlayers();
            bombManagement();
            collisionPlayerBomb();
            t++;
        }
        keyboard.keyboardStopped();
    }

    public void movePlayers() {
        if(players[0].getNumberLives() > 0) {
            players[0].setDirection(keyboard.getDirection());
            Bomb bomb = players[0].dropBomb(keyboard.getRequestBomb(), background);
            if (bomb != null) {
                bombs.add(bomb);
            }
        }

        for (int i = 0; i < players.length; i++) {
            if(players[i].getNumberLives() > 0) {
                players[i].move(background);
            }
        }
    }

    public void bombManagement() {
        for(int i = 0; i < bombs.size(); i++) {
            if(bombs.get(i).decrementTimer() == 0) {
                bombs.get(i).deleteBomb();
                bombs.remove(i);
            }
        }
    }

    public void collisionPlayerBomb() {
        for(int i = 0; i < players.length; i++) {
            if(!players[i].isImune()) {
                for(int j = 0; j < bombs.size(); j++) {
                    if(bombs.get(j).isExplosion()) {
                        if (bombs.get(j).checkPicturesExplosionOverlapPlayer(players[i].getPos().getCol(), players[i].getPos().getRow())) {
                            players[i].decrementLives();
                            if (players[i].getNumberLives() == 0) {
                                players[i].deletePicture();
                            }
                        }
                    }
                }
            }
        }
    }


    //defines initial position for all Players
    public int[] initialPosition(int indexPlayer) {
        int[] coordinates = new int[2]; //takes y and x positions

        //800 / 31 cols x = 25.81
        // 363 / 14 rows y = 25.93

        switch (indexPlayer) {
            case 0:
                coordinates[0] = 1;
                coordinates[1] = 1;
                break;
            case 1:
                coordinates[0] = 29;
                coordinates[1] = 1;
                break;
            case 2:
                coordinates[0] = 1;
                coordinates[1] = 11;
                break;
            case 3:
                coordinates[0] = 29;
                coordinates[1] = 11;
                break;
        }
        return coordinates;
    }
}
