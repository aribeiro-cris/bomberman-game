package project.bomberman;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;
    private int cols;
    private int rows;
    private boolean[][] obstaculeTable;

    public Background() {
        picture = new Picture(0,0, Game.RESOURCES_PREFIX + "background.png");
        picture.draw();
        cols = 31;
        rows = 13;

        //table to help
        obstaculeTable = new boolean[this.cols][this.rows];

        for(int i= 0; i < cols; i++) {
            obstaculeTable[i][0] = true;
        }

        for(int i= 2; i < rows-1; i+=2) {
            obstaculeTable[0][i] = true;
            for(int j = 1; j < cols; j++) {
                if(j %2 == 0) {
                obstaculeTable[j][i] = true;
               }
            }
        }

        for(int i = 1; i < rows; i+=2) {
            obstaculeTable[0][i] = true;
            obstaculeTable[cols-1][i] = true;
        }

        for(int i= 0; i < cols; i++) {
            obstaculeTable[i][rows-1] = true;
        }
    }

    public boolean getObstaculesPosition(int col, int row) {
        if(col < 0 || row < 0){
            return true;
        }
        return obstaculeTable[col][row];
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
