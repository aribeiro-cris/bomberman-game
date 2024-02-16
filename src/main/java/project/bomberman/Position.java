package project.bomberman;
;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private int col;
    private int row;
    private Picture bomberman;

    public Position(Background background, int[] coordinates, String picture) {
        this.col = coordinates[0];
        this.row = coordinates[1];
        bomberman = new Picture(col,row, picture);
        bomberman.draw();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }


    //random movement to the bomberman
    public void moveRight(int distance, int cellSize) {
        col+= distance;
        bomberman.translate((distance*cellSize),0);
    }

    public void moveLeft(int distance, int cellSize){
        col-= distance;
        bomberman.translate((-distance*cellSize),0);
    }

    public void moveUp(int distance, int cellSize) {
        row-= distance;
        bomberman.translate(0, (-distance*cellSize));
    }

    public void moveDown(int distance, int cellSize) {
        row+=distance;
        bomberman.translate(0, (distance*cellSize));
    }
}
