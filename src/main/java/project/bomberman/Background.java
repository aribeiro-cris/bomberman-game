package project.bomberman;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture picture;
    private int cols;
    private int rows;

    public Background() {
        picture = new Picture(0,0, "src/main/resources/background.png");
        picture.draw();
    }

    //800 / 31 cols x = 25.81
    // 363 / 14 rows y = 25.93
}
