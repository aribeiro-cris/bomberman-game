package project.bomberman;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Background background = new Background();
        Game game = new Game(100);
        game.init();
        game.start();

//        int coordinatesArray[] = new int[2];
//        coordinatesArray[0] = 26;
//        coordinatesArray[1] = 26;
//
//        Bomberman bomberman = new Bomberman(background, coordinatesArray, "src/main/resources/bomberman.png");
    }
}