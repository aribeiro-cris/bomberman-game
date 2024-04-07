package project.bomberman;

import java.util.ArrayList;
import java.util.Random;

public class PcPlayers extends Players {

    private Random rand;
    private int timerRandom;
    private static int left = 0;
    private static int right = 1;
    private static int down = 2;
    private static int up = 3;
    private static int iddle = 4;

    public PcPlayers(Background background, int[] coordinates, double CellSize, String picture) {
        super(background, coordinates, CellSize, picture);

        rand = new Random();
        timerRandom = rand.nextInt(300) + 60;
    }

    // 0 -> left move score
    // 1 -> right move score
    // 2 -> down move score
    // 3 -> up move score
    // 4 -> stand still

    //move possible?
    //bomb nearby? -> bomb direction score -1
    //safe position? no bomb close -> score 1

    private int calculateBombScore(ArrayList<Bomb> bombs, int x, int y, int score){
        for(int i = 0; i < bombs.size() ;i++) {
            if(bombs.get(i).checkPicturesExplosionOverlapPlayer(x, y)){
                score -= 15;
                if(score < 0){
                    score = 0;
                    i = bombs.size();
                }
            }
        }
        return score;
    }

    public int aiActionDefinition(Background background, BoxMatrix boxMatrix, ArrayList<Bomb> bombs) {
        int[] valueMatrix = new int[5];
        valueMatrix[left] = 20; //initial score
        valueMatrix[right] = 20;
        valueMatrix[down] = 20;
        valueMatrix[up] = 20;
        valueMatrix[iddle] = 20;
        int action;


        if (!background.getObstaculesPosition(pos.getCol() - 1, pos.getRow()) && (boxMatrix.getBoxes(pos.getCol() - 1, pos.getRow()) == null)) {
            valueMatrix[left] = calculateBombScore(bombs, pos.getCol() - 1, pos.getRow(), valueMatrix[left]);
        }
        else{
            valueMatrix[left] = 0;
        }

        if (!background.getObstaculesPosition(pos.getCol() + 1, pos.getRow()) && (boxMatrix.getBoxes(pos.getCol() + 1, pos.getRow()) == null)) {
            valueMatrix[right] = calculateBombScore(bombs, pos.getCol() + 1, pos.getRow(), valueMatrix[right]);

        }
        else{
            valueMatrix[right] = 0;
        }

        if (!background.getObstaculesPosition(pos.getCol(), pos.getRow() + 1) && (boxMatrix.getBoxes(pos.getCol(), pos.getRow() + 1) == null)) {
            valueMatrix[down] = calculateBombScore(bombs, pos.getCol(), pos.getRow() + 1, valueMatrix[down]);
        }
        else{
            valueMatrix[down] = 0;
        }

        if (!background.getObstaculesPosition(pos.getCol(), pos.getRow() - 1) && (boxMatrix.getBoxes(pos.getCol(), pos.getRow() - 1) == null)) {
            valueMatrix[up] = calculateBombScore(bombs, pos.getCol(), pos.getRow() - 1, valueMatrix[up]);
        }
        else{
            valueMatrix[up] = 0;
        }

        if (!background.getObstaculesPosition(pos.getCol(), pos.getRow()) && (boxMatrix.getBoxes(pos.getCol(), pos.getRow()) == null)) {
            valueMatrix[iddle] = calculateBombScore(bombs, pos.getCol(), pos.getRow(), valueMatrix[iddle]);
        }
        else{
            valueMatrix[iddle] = 0;
        }

        System.out.println("testing here: " + valueMatrix[left] + " right: " + valueMatrix[right] + " down " + valueMatrix[down] + " up " + valueMatrix[up] + "iddle " + valueMatrix[iddle]);

        int sum = valueMatrix[left] +  valueMatrix[right] + valueMatrix[down] + valueMatrix[up] + valueMatrix[iddle];

        if(sum != 0) {
            action = rand.nextInt(sum);
        }
        else{
            return iddle;
        }

        if(action < valueMatrix[left]){    //example: left |0 - 5| right 6 - 10| down 11 - 20 | up 21 - 30| iddle 31 - 40
            return left;
        }
        if(action < valueMatrix[left] + valueMatrix[right]){
            return right;
        }
        if(action < valueMatrix[left] + valueMatrix[right] + valueMatrix[down]){
            return down;
        }
        if(action < valueMatrix[left] + valueMatrix[right] + valueMatrix[down] + valueMatrix[up]){
            return up;
        }
        else{
            return iddle;
        }
    }

    @Override
    public void move(Background background, BoxMatrix boxMatrix, ArrayList<Bomb> bombs) {

        int action = aiActionDefinition(background, boxMatrix, bombs);

        if(action == left) {
            pos.moveLeft(1, 26);
        }
        else if(action == right) {
            pos.moveRight(1, 26);
        }
        else if(action == down) {
            pos.moveDown(1, 26);
        }
        else if(action == up) {
            pos.moveUp(1, 26);
        }
    }

    @Override
    public boolean getTimeToDropBomb() {
        timerRandom--;
        if(timerRandom == 0) {
            timerRandom = rand.nextInt(30) + 10;
            return true;
        }
        return false;
    }
}
