package project.bomberman;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bomb {

    final static double length = 25.80; //CellSize
    private Position pos;
    private Picture bomb;
    private Picture explosioncenter;
    private Picture explosionleftmid;
    private Picture explosionleftend;
    private Picture explosionrightmid;
    private Picture explosionrightend;
    private Picture explosiontopmid;
    private Picture explosiontopend;
    private Picture explosionbotmid;
    private Picture explosionbotend;
    private static int bombX;
    private static int bombY;
    private int timer;
    private boolean explosion = false;
    private Background background;

    public Bomb(Position pos, Background background) {
        bombX = pos.getCol();
        bombY = pos.getRow();
        bomb = new Picture(bombX *length, bombY *length, Game.RESOURCES_PREFIX + "bomb.png");
        timer = 30;
        this.background = background;
        bomb.draw();

    }
    public void drawExplosion() {
        bomb.delete();
        explosioncenter = new Picture(bombX * length, bombY * length, Game.RESOURCES_PREFIX + "explosion_first.png");
        explosioncenter.draw();

        if (!background.getObstaculesPosition(bombX - 1, bombY)) {
            explosionleftmid = new Picture(((bombX - 1) * length), bombY * length, Game.RESOURCES_PREFIX + "explosion_second.png");
            explosionleftmid.draw();

            if(!background.getObstaculesPosition(bombX - 2, bombY)) {
                explosionleftend = new Picture(((bombX - 2) * length), bombY * length, Game.RESOURCES_PREFIX + "explosionleftend.png");
                explosionleftend.draw();
            }

        }
        if (!background.getObstaculesPosition(bombX + 1, bombY)) {
            explosionrightmid = new Picture(((bombX + 1) * length), bombY * length, Game.RESOURCES_PREFIX + "explosion_second.png");
            explosionrightmid.draw();
            if (!background.getObstaculesPosition(bombX + 2, bombY)){
                explosionrightend = new Picture(((bombX + 2) * length), bombY * length, Game.RESOURCES_PREFIX + "explosionrigthend.png");
                explosionrightend.draw();
            }
        }
        if (!background.getObstaculesPosition(bombX, bombY - 1)) {
            explosiontopmid = new Picture(bombX * length, ((bombY - 1) * length), Game.RESOURCES_PREFIX + "explosion_second_top.png");
            explosiontopmid.draw();

            if (!background.getObstaculesPosition(bombX, bombY - 2)) {
                explosiontopend = new Picture(bombX * length, ((bombY - 2) * length), Game.RESOURCES_PREFIX + "explosiontopend.png");
                explosiontopend.draw();
            }
        }

        if (!background.getObstaculesPosition(bombX, bombY + 1)) {
            explosionbotmid = new Picture(bombX * length, ((bombY + 1) * length), Game.RESOURCES_PREFIX + "explosion_second_top.png");
            explosionbotmid.draw();

            if (!background.getObstaculesPosition(bombX, bombY + 2)) {
                explosionbotend = new Picture(bombX * length, ((bombY + 2) * length), Game.RESOURCES_PREFIX + "explosionbotend.png");
                explosionbotend.draw();
            }
        }
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
        explosioncenter.delete();
        if(explosionbotmid != null) {
            explosionbotmid.delete();
        }
        if(explosiontopmid != null) {
            explosiontopmid.delete();
        }
        if(explosionleftend != null) {
            explosionleftend.delete();
        }
        if(explosiontopend != null) {
            explosiontopend.delete();
        }
        if(explosionrightend != null) {
            explosionrightend.delete();
        }
        if(explosionrightmid != null) {
            explosionrightmid.delete();
        }
        if (explosionbotend != null) {
            explosionbotend.delete();
        }
        if(explosionleftmid != null) {
            explosionleftmid.delete();
        }
        explosion = false;
    }
}
