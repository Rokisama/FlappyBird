package FlappyBird;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirdTest {

    @Test
    void testJumpIncreasesVerticalPosition() {
        // Arrange
        Bird bird = new Bird(3, 10); // Assuming you have a Bird class
        // Act
        int initialVerticalPosition = bird.getY();
        bird.jump(2);
        int updatedVerticalPosition = bird.getY();
        // Assert
        assertTrue(updatedVerticalPosition < initialVerticalPosition);
    }
}