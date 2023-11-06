package FlappyBird;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {

    @Test
    void testProcessUserInputCorrectKey() {
        // Arrange
        Bird bird = new Bird(1, 1);
        List<PipeInterface> pipes = new ArrayList<>();
        Map map = new Map();
        PipeInterface pipe1 = new Pipe(20, 3, 5, 3);
        PipeInterface pipe2 = new Pipe(35, 6, 5, 3);
        PipeInterface pipe3 = new Pipe(50, 4, 5, 3);
        pipes.add(pipe1);
        pipes.add(pipe2);
        pipes.add(pipe3);

        GameRules gameRules = new GameRules(bird, pipes, map);

        // Act
        double initialVelocity = bird.getY();

        int userInput = 'w';
        gameRules.processUserInput(userInput);

        double updatedVelocity = bird.getY();

        // Assert
        assertTrue(updatedVelocity < initialVelocity);
    }

    @Test
    void testProcessPipesMovingToStart() {
        // Arrange
        final int START_LOCATION = 50;
        List<PipeInterface> pipes = new ArrayList<>();
        Map map = new Map();
        PipeInterface pipe1 = new Pipe(-1, 3, 5, 3);
        PipeInterface pipe2 = new Pipe(14, 6, 5, 3);
        PipeInterface pipe3 = new Pipe(29, 4, 5, 3);
        pipes.add(pipe1);
        pipes.add(pipe2);
        pipes.add(pipe3);
        Bird bird = new Bird(1, 1);

        GameRules gameRules = new GameRules(bird, pipes, map);

        // Act
        List<PipeInterface> updatedPipes = gameRules.processPipes(pipes);

        // Assert
        for (PipeInterface updatedPipe : updatedPipes) {
            if (updatedPipe.isOffScreen()) {

                assertEquals(START_LOCATION, updatedPipe.getX());

            }
        }
    }
}
