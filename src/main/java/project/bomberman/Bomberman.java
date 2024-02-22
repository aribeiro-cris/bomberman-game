package project.bomberman;

public class Bomberman extends Players {

    public Bomberman(Background background, int[] coordinates, double CellSize, String picture) {
        super(background, coordinates, CellSize, picture);
    }

    @Override
    public void move(Background background) {
        if (direction != "stop") {
            if (direction == "left") {
                if (!background.getObstaculesPosition(pos.getCol() - 1, pos.getRow())) {
                    pos.moveLeft(1, 26);
                }
            }
            if (direction == "right") {
                if (!background.getObstaculesPosition(pos.getCol() + 1, pos.getRow())) {
                    pos.moveRight(1, 26);
                }
            }
            if (direction == "down") {
                if (!background.getObstaculesPosition(pos.getCol(), pos.getRow() + 1)) {
                    pos.moveDown(1, 26);
                }
            }
            if (direction == "up") {
                if (!background.getObstaculesPosition(pos.getCol(), pos.getRow() - 1)) {
                    pos.moveUp(1, 26);
                }
            }
        }
    }
}
