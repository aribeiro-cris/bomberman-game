package project.bomberman;

public class Players {

    protected Position pos;
    protected String direction;

    public Players(Background background, int[] coordinates, String picture) {
        this.pos = new Position(background, coordinates, picture);
        this.direction = "stop";
    }

    public void move(Background background) {
        if(direction != "stop") {
            if(direction == "left") {
                if (!background.getObstaculesPosition(pos.getCol()-1, pos.getRow())) {
                    pos.moveLeft(-1,26);
                }
            }
            if (direction == "right") {
                if (!background.getObstaculesPosition(pos.getCol()+1, pos.getRow())) {
                    pos.moveLeft(+1,26);
                }
            }
            if (direction == "down") {
                if (!background.getObstaculesPosition(pos.getCol(), pos.getRow()+1)) {
                    pos.moveLeft(+1,26);
                }
            }
            if (direction == "up") {
                if (!background.getObstaculesPosition(pos.getCol(), pos.getRow()-1)) {
                    pos.moveLeft(-1,26);
                }
            }
        }
    }


//    public Position getPos() {
//        return pos;
//    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
