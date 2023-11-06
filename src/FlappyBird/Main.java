package FlappyBird;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Press Enter to begin, input w to jump");
        Game game = new Game();
        game.play();
    }
}