package project.bomberman;

import java.util.Random;

public class BoxMatrix {

    private Box[][] boxes;

    public BoxMatrix(int cols, int rows) {
        this.boxes = new Box[cols][rows];

    }

    public Box randomDeployBox(int x, int y){
        Random rand = new Random();
        int boxDeploy = rand.nextInt(10);
        if(boxDeploy < 7){   //random from 0-9 and less than 7 drops box (70% to drop a box)
            return new Box(x, y);
        }
        return null;
    }

    public void matrixAreaToBuild(Background background, int xi, int xf, int yi, int yf){
        Box box;
        for(int i = xi; i < xf; i++) {
            for(int j = yi; j < yf; j++) {
                if(!background.getObstaculesPosition(i,j)) {
                    box = randomDeployBox(i,j);
                    if(box != null) {
                        boxes[i][j] = box;
                    }
                }
            }
        }
    }
    public void buildMapLayout(Background background) {

        matrixAreaToBuild(background, 3, background.getCols() - 3, 1, 3);
        matrixAreaToBuild(background, 1, background.getCols() - 1, 3, background.getRows() - 3);
        matrixAreaToBuild(background, 3, background.getCols() - 3, 11, 12);

//        Box box;
//        for(int i = 3; i < background.getCols() - 3; i++) {
//            for(int j = 1; j < 3; j++) {
//                if(!background.getObstaculesPosition(i,j)) {
//                    box = randomDeployBox(i,j);
//                    if(box != null) {
//                        boxes[i][j] = box;
//                    }
//                }
//            }
//        }

//        for(int i = 1; i < background.getCols() - 1; i++) {
//            for(int j = 3; j < background.getRows() - 3; j++) {
//                if(!background.getObstaculesPosition(i,j)) {
//                    box = randomDeployBox(i,j);
//                    if(box != null) {
//                        boxes[i][j] = box;
//                    }
//                }
//            }
//        }

//        for(int i = 3; i < background.getCols() - 3; i++) {
//            for(int j = 11; j < 12; j++) {
//                if(!background.getObstaculesPosition(i,j)) {
//                    box = randomDeployBox(i,j);
//                    if(box != null) {
//                        boxes[i][j] = box;
//                    }
//                }
//            }
//        }
    }

    public Box getBoxes(int x, int y) {
        return boxes[x][y];
    }
    public void deleteBoxes(int x, int y) {
        if(boxes[x][y] != null) {
            boxes[x][y].deleteBox();
            boxes[x][y] = null;
        }
    }
}
