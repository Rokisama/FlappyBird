package FlappyBird;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    int SCORE = 0;
    private BirdInterface bird;
    private List<PipeInterface> pipes;
    private PipeInterface pipe;
    private PipeInterface pipe2;
    private PipeInterface pipe3;
    private Map map;
    private Renderer renderer;
    private GameRules gameRules;

    public Game() {
        bird = new Bird(1, 1);
        pipes = new ArrayList<>();
        map = new Map();
        pipe = new Pipe(20, 3, 5, 3);
        pipe2 = new Pipe(35, 6, 5, 3);
        pipe3 = new Pipe(50, 4, 5, 3);
        pipes.add(pipe);
        pipes.add(pipe2);
        pipes.add(pipe3);

        renderer = new Renderer(bird, pipes, map);
        gameRules = new GameRules(bird, pipes, map);
    }
    
    public void play() throws IOException {
        SCORE = 0;
        while (true) {

            SCORE = gameRules.processScore(bird, pipes, SCORE);
            gameRules.processPipes(pipes);
            renderer.render(bird, pipes, map, SCORE);
            int input = System.in.read();
            gameRules.processUserInput(input);
            gameRules.progressFrame();

        }
    }

}
