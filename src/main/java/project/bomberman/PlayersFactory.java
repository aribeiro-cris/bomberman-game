package project.bomberman;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class PlayersFactory {

    public static Players getNewBomberman(Background background, int[] coordinates, String picture) {
        Players bomberman;
        bomberman = new Players(background, coordinates, picture);
        return bomberman;
    }

    public static Players getNewPcPlayers(Background background, int[] coordinates, String picture) {
        Players pcPlayers;
        pcPlayers = new Players(background, coordinates, picture);
        return pcPlayers;
    }
}
