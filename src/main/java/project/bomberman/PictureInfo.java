package project.bomberman;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PictureInfo {

    private Picture picture;
    private int x; //center pos of X
    private int y; //center pos of Y

    public PictureInfo(int x, int y, Picture picture) {
        this.x = x;
        this.y = y;
        this.picture = picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Picture getPicture() {
        return this.picture;
    }

    public void deletePicture() {
        if(picture != null) {
            picture.delete();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void drawPicture(){
        picture.draw();
    }

}
