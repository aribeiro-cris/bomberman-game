package project.bomberman;

public class PlayersFactory {

    public static Players getNewBomberman(Background background, int[] coordinates, double CellSize, String picture) {
        Players bomberman;
        bomberman = new Bomberman(background, coordinates, CellSize, picture);
        return bomberman;
    }

    public static Players getNewPcPlayers(Background background, int[] coordinates, double CellSize, String picture) {
        Players pcPlayers;
        pcPlayers = new PcPlayers(background, coordinates, CellSize, picture);
        return pcPlayers;
    }
}
