package FlappyBird;

public class Bird implements BirdInterface {

    private int x;
    private int y;
    public Bird(int startX, int startY){
        this.x = startX;
        this.y = startY;
    }
    @Override
    public void jump(int deltaY){
        y -= deltaY;
    };
    @Override
    public void fall(int deltaY){
        y += deltaY;
    }
    @Override
    public int getY(){
        return y;
    };
    @Override
    public int getX(){
        return x;
    };
}
