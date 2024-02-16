package project.bomberman;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Bomberman {

    protected Position pos;

    public Bomberman(Background background, int[] coordinates, String picture) {
        this.pos = new Position(background, coordinates, picture);
    }

    void move(Background background) {
    }


    public Position getPos() {
        return pos;
    }
}
