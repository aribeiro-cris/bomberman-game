package project.bomberman;

public class Players {

    protected Position pos;
    protected String direction;

    public Players(Background background, int[] coordinates, double CellSize, String picture) {
        this.pos = new Position(background, coordinates, CellSize, picture);
        direction = "stop";
    }

    public void move(Background background) {

    }

    public Position getPos() {
        return pos;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Bomb dropBomb(Boolean requestBomb, Background background) {
        if(requestBomb) {
            Bomb bomb = new Bomb(pos, background);
            return bomb;
        } else {
            return null;
        }
    }
}
