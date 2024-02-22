package project.bomberman;

import java.util.Random;

public class PcPlayers extends Players {

    public PcPlayers(Background background, int[] coordinates, double CellSize, String picture) {
        super(background, coordinates, CellSize, picture);
    }

    @Override
    public void move(Background background) {
        Random rand = new Random();
        int randomValue = rand.nextInt(4);

        switch (randomValue) {
            case 0:
                if (!background.getObstaculesPosition(pos.getCol() - 1, pos.getRow())) {
                    pos.moveLeft(1, 26);
                }
                break;
            case 1:
                if (!background.getObstaculesPosition(pos.getCol() + 1, pos.getRow())) {
                    pos.moveRight(1, 26);
                }
                break;
            case 2:
                if (!background.getObstaculesPosition(pos.getCol(), pos.getRow() + 1)) {
                    pos.moveDown(1, 26);
                }
                break;
            case 3:
            default:
                if (!background.getObstaculesPosition(pos.getCol(), pos.getRow() - 1)) {
                    pos.moveUp(1, 26);
                }
                break;
        }
    }
}
