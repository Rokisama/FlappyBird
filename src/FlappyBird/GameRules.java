package FlappyBird;

import java.io.IOException;
import java.util.List;

public class GameRules {
    BirdInterface bird;
    List<PipeInterface> pipes;
    Map map;
    final int START_LOCATION = 50;
    
    public GameRules(BirdInterface bird, List<PipeInterface> pipes, Map map){
        this.bird = bird;
        this.pipes = pipes;
        this.map = map;
    }

    public void processUserInput(int userInput) {
        if(userInput == 'w'){
            bird.jump(3);
        }
    }
    public List<PipeInterface> processPipes(List<PipeInterface> pipes){

        for (PipeInterface pipe : pipes){
            if (pipe.isOffScreen()){
                pipe.moveTo(START_LOCATION);
                pipe.randomiseGapY();
            }
        }

        return pipes;
    }
    public void progressFrame() throws IOException {
        bird.fall(1);

        for (PipeInterface pipe : pipes){
            if (pipe.overlapsBird(bird)){
                System.out.println("You died!");
                Game game = new Game();
                game.play();
            }
            else {
                pipe.moveLeft(1);
            }
        }

    }

    public int processScore(BirdInterface bird, List<PipeInterface> pipes, int SCORE) {
        for (PipeInterface pipe : pipes){
            if (pipe.isOffScreen()){
                SCORE++;
            }
        }
        return SCORE;
    }
}
