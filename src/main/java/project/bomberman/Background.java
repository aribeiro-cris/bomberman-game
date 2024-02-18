package project.bomberman;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;
    private int cols;
    private int rows;
    private boolean[][] obstaculeTable;

    public Background() {
        picture = new Picture(0,0, "src/main/resources/background.png");
        picture.draw();
        cols = 31;
        rows = 13;

        //table to help
        obstaculeTable = new boolean[this.cols][this.rows];

        for(int i= 0; i < cols; i++) {
            obstaculeTable[i][0] = true;
//            Rectangle rectangle = new Rectangle(i * 26, 0 * 26, 26,26);
//            rectangle.setColor(Color.BLUE);
//            rectangle.fill();
        }

        for(int i= 2; i < rows-1; i+=2) {
            obstaculeTable[0][i] = true;
//            Rectangle rectangle = new Rectangle(0 * 26, i * 26, 26,26);
//            rectangle.setColor(Color.YELLOW);
//            rectangle.fill();
            for(int j = 1; j < cols; j++) {
                if(j %2 == 0) {
                obstaculeTable[j][i] = true;
//                Rectangle rectangle1 = new Rectangle(j * 26, i * 26, 26,26);
//                rectangle1.setColor(Color.GREEN);
//                rectangle1.fill();
//                }
//                else {
//                obstaculeTable[j][i] = false;
////                    Rectangle rectangle1 = new Rectangle(j * 26, i * 26, 26,26);
////                    rectangle1.setColor(Color.RED);
////                    rectangle1.fill();
               }
            }
        }

        for(int i = 1; i < rows; i+=2) {
            obstaculeTable[0][i] = true;
//            Rectangle rectangle1 = new Rectangle(0 * 26, i * 26, 26,26);
//            rectangle1.setColor(Color.BLACK);
//            rectangle1.fill();
//            for(int j = 1; j < cols -1; j+=1) {
//                obstaculeTable[j][0] = false;
//////                Rectangle rectangle = new Rectangle(j * 26, i * 26, 26,26);
//////                rectangle.setColor(Color.WHITE);
//////                rectangle.fill();
//            }
            obstaculeTable[cols-1][i] = true;
//            Rectangle rectangle = new Rectangle(30 * 26, i * 26, 26,26);
//            rectangle.setColor(Color.ORANGE);
//            rectangle.fill();
        }

        for(int i= 0; i < cols; i++) {
            obstaculeTable[i][rows-1] = true;
//            Rectangle rectangle = new Rectangle(i * 26, (rows-1) * 26, 26,26);
//            rectangle.setColor(Color.BLUE);
//            rectangle.fill();
        }
    }

    public boolean getObstaculesPosition(int col, int row) {
        return obstaculeTable[col][row];
    }
}
