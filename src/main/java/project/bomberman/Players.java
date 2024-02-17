package project.bomberman;

public class Players {

    protected Position pos;

    public Players(Background background, int[] coordinates, String picture) {
        this.pos = new Position(background, coordinates, picture);
    }

    void move(Background background) {
    }


    public Position getPos() {
        return pos;
    }
}
