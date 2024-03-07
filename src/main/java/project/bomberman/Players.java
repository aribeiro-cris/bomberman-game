package project.bomberman;

import java.util.ArrayList;

public abstract class Players {

    protected Position pos;
    protected String direction;
    private int numberLives;
    private boolean imune;
    private int timerImunity = 60;

    public Players(Background background, int[] coordinates, double CellSize, String picture) {
        this.pos = new Position(background, coordinates, CellSize, picture);
        direction = "stop";
        numberLives = 3;
        imune = false;
    }

    public Position getPos() {
        return pos;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Bomb dropBomb(Boolean requestBomb, Background background) {
        if(requestBomb) {
            Bomb bomb = new Bomb(pos.getCol(), pos.getRow(), background);
            return bomb;
        } else {
            return null;
        }
    }

    public void decrementLives() {
        numberLives--;
        imune = true;
    }

    public int getNumberLives() {
        return numberLives;
    }

    public void deletePicture() {
        pos.deletePicture();
    }

    public boolean isImune() {
        if(imune){
            timerImunity--;
        }
        if(timerImunity == 0){
            imune = false;
            timerImunity = 60;
        }
        return imune;
    }

    public abstract void move(Background background, BoxMatrix boxMatrix, ArrayList<Bomb> bombs);

    public boolean getTimeToDropBomb(){
        return false;
    }
}
