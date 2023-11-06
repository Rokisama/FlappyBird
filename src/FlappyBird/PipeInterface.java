package FlappyBird;

public interface PipeInterface {
    void moveLeft(int deltaX);
    boolean overlapsBird(BirdInterface bird);

    void randomiseGapY();

    void moveTo(int location);

    int getX();

    int getTopPipeY();

    int getBottomPipeY();

    int getWidth();

    boolean isOffScreen();
}
