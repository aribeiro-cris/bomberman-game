package project.bomberman;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Box {

    final static double length = 25.80;
    private Picture box;
    private int boxX;
    private int boxY;

    public Box(int x, int y) {
        boxX = x;
        boxY = y;
        box = new Picture(boxX *length, boxY *length, Game.RESOURCES_PREFIX + "box.png");
        box.draw();
    }

}
