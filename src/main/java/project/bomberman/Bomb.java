package project.bomberman;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bomb {

    final static double length = 25.80; //CellSize
    private Picture bomb;
    private int bombX;
    private int bombY;
    private int timer;
    private boolean explosion = false;
    private Background background;
    private PictureInfo[] picturesExplosion;

    //pictures corresponding to each index in the array picturesExplosion
    private static final int explosionCenter = 0;
    private static final int explosionLeftMid = 1;
    private static final int explosionLeftEnd = 2;
    private static final int explosionRightMid = 3;
    private static final int explosionRightEnd = 4;
    private static final int explosionTopMid = 5;
    private static final int explosionTopEnd = 6;
    private static final int explosionBotMid = 7;
    private static final int explosionBotEnd = 8;

    public Bomb(Position pos, Background background) {
        bombX = pos.getCol();
        bombY = pos.getRow();
        bomb = new Picture(bombX *length, bombY *length, Game.RESOURCES_PREFIX + "bomb.png");
        timer = 30;
        this.background = background;
        bomb.draw();
        picturesExplosion = new PictureInfo[9];

        picturesExplosion[explosionCenter] = new PictureInfo(bombX, bombY, new Picture(bombX * length, bombY * length, Game.RESOURCES_PREFIX + "explosion_first.png"));
        picturesExplosion[explosionLeftMid] = new PictureInfo(bombX - 1, bombY, new Picture(((bombX - 1) * length), bombY * length, Game.RESOURCES_PREFIX + "explosion_second.png"));
        picturesExplosion[explosionLeftEnd] = new PictureInfo(bombX - 2, bombY, new Picture(((bombX - 2) * length), bombY * length, Game.RESOURCES_PREFIX + "explosionleftend.png"));
        picturesExplosion[explosionRightMid] = new PictureInfo(bombX + 1, bombY, new Picture(((bombX + 1) * length), bombY * length, Game.RESOURCES_PREFIX + "explosion_second.png"));
        picturesExplosion[explosionRightEnd] = new PictureInfo(bombX + 2, bombY, new Picture(((bombX + 2) * length), bombY * length, Game.RESOURCES_PREFIX + "explosionrigthend.png"));
        picturesExplosion[explosionTopMid] = new PictureInfo(bombX, bombY + 1, new Picture(bombX * length, ((bombY - 1) * length), Game.RESOURCES_PREFIX + "explosion_second_top.png"));
        picturesExplosion[explosionTopEnd] = new PictureInfo(bombX, bombY-2, new Picture(bombX * length, ((bombY - 2) * length), Game.RESOURCES_PREFIX + "explosiontopend.png"));
        picturesExplosion[explosionBotMid] = new PictureInfo(bombX, bombY+1,new Picture(bombX * length, ((bombY + 1) * length), Game.RESOURCES_PREFIX + "explosion_second_top.png"));
        picturesExplosion[explosionBotEnd] = new PictureInfo(bombX, bombY + 2, new Picture(bombX * length, ((bombY + 2) * length), Game.RESOURCES_PREFIX + "explosionbotend.png"));

    }
    public void drawExplosion() {
        bomb.delete();
        picturesExplosion[explosionCenter].drawPicture();

        if (!background.getObstaculesPosition(bombX - 1, bombY)) {
            picturesExplosion[explosionLeftMid].drawPicture();

            if(!background.getObstaculesPosition(bombX - 2, bombY)) {
                picturesExplosion[explosionLeftEnd].drawPicture();
            }
            else{
                picturesExplosion[explosionLeftEnd].setPicture(null);
            }
        }
        else{
            picturesExplosion[explosionLeftMid].setPicture(null);
            picturesExplosion[explosionLeftEnd].setPicture(null);
        }

        if (!background.getObstaculesPosition(bombX + 1, bombY)) {
            picturesExplosion[explosionRightMid].drawPicture();
            if (!background.getObstaculesPosition(bombX + 2, bombY)) {
                picturesExplosion[explosionRightEnd].drawPicture();
            }
            else {
                picturesExplosion[explosionRightEnd].setPicture(null);
                }
        }
        else{
            picturesExplosion[explosionRightEnd].setPicture(null);
            picturesExplosion[explosionRightMid].setPicture(null);
        }

        if (!background.getObstaculesPosition(bombX, bombY - 1)) {
            picturesExplosion[explosionTopMid].drawPicture();

            if (!background.getObstaculesPosition(bombX, bombY - 2)) {
                picturesExplosion[explosionTopEnd].drawPicture();
            }
            else {
                picturesExplosion[explosionTopEnd].setPicture(null);
            }
        }
        else{
            picturesExplosion[explosionTopEnd].setPicture(null);
            picturesExplosion[explosionTopMid].setPicture(null);
        }

        if (!background.getObstaculesPosition(bombX, bombY + 1)) {
            picturesExplosion[explosionBotMid].drawPicture();

            if (!background.getObstaculesPosition(bombX, bombY + 2)) {
                picturesExplosion[explosionBotEnd].drawPicture();
            }
            else {
                picturesExplosion[explosionBotEnd].setPicture(null);
            }
        }
        else{
            picturesExplosion[explosionBotEnd].setPicture(null);
            picturesExplosion[explosionBotMid].setPicture(null);
        }
    }

    public boolean checkPicturesExplosionOverlapPlayer(int x, int y) {
        for (int i = 0 ; i < picturesExplosion.length ; i++) {
            if (picturesExplosion[i].getX() == x && picturesExplosion[i].getY() == y && picturesExplosion[i].getPicture() != null) {
                return true;
            }
        }
        return false;
    }


    public int decrementTimer(){

        timer--;
        if (timer == 0 && !explosion) {
            explosion = true;
            timer = 10; //time that the bomb stays on the game
            drawExplosion();
        }

        return timer;
    }

    public void deleteBomb() {
        picturesExplosion[explosionCenter].deletePicture();
        if(picturesExplosion[explosionBotMid] != null) {
            picturesExplosion[explosionBotMid].deletePicture();
        }
        if(picturesExplosion[explosionTopMid] != null) {
            picturesExplosion[explosionTopMid].deletePicture();
        }
        if(picturesExplosion[explosionLeftEnd] != null) {
            picturesExplosion[explosionLeftEnd].deletePicture();
        }
        if(picturesExplosion[explosionTopEnd] != null) {
            picturesExplosion[explosionTopEnd].deletePicture();
        }
        if(picturesExplosion[explosionRightEnd] != null) {
            picturesExplosion[explosionRightEnd].deletePicture();
        }
        if(picturesExplosion[explosionRightMid] != null) {
            picturesExplosion[explosionRightMid].deletePicture();
        }
        if (picturesExplosion[explosionBotEnd] != null) {
            picturesExplosion[explosionBotEnd].deletePicture();
        }
        if(picturesExplosion[explosionLeftMid] != null) {
            picturesExplosion[explosionLeftMid].deletePicture();
        }
        explosion = false;
    }

    public boolean isExplosion() {
        return explosion;
    }
}
