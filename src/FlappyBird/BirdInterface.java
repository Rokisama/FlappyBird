package FlappyBird;

public interface BirdInterface {
    void jump(int deltaY);

    void fall(int deltaY);

    int getY();
    int getX();
}
