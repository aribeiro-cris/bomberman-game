package project.bomberman;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private int col;
    private int row;
    private Picture picture1;

    public Position(Background background, int[] coordinates, double CellSize, String picture) {
        this.col = coordinates[0];
        this.row = coordinates[1];
        picture1 = new Picture(col*CellSize,row*CellSize, picture);
        picture1.draw();
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
        picture1.translate((distance*cellSize),0);
    }

    public void moveLeft(int distance, int cellSize){
        col-= distance;
        picture1.translate((-distance*cellSize),0);
    }

    public void moveUp(int distance, int cellSize) {
        row-= distance;
        picture1.translate(0, (-distance*cellSize));
    }

    public void moveDown(int distance, int cellSize) {
        row+=distance;
        picture1.translate(0, (distance*cellSize));
    }
}
