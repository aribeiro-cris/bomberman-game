package project.bomberman;

public class Main {
    public static void main(String[] args) {

        Background background = new Background();
        int coordinatesArray[] = new int[2];
        coordinatesArray[0] = 26;
        coordinatesArray[1] = 26;

        Bomberman bomberman = new Bomberman(background, coordinatesArray, "src/main/resources/bomberman.png");
    }
}