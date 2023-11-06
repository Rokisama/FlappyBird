package FlappyBird;

public class Pipe implements PipeInterface{

    private int x;
    private int gapY;
    private int gapHeight;
    private int pipeWidth;


    public Pipe(int x, int gapY, int gapHeight, int pipeWidth) {
        this.x = x;
        this.gapY = gapY;
        this.gapHeight = gapHeight;
        this.pipeWidth = pipeWidth;
    }

    @Override
    public void moveLeft(int deltaX){
        x -= deltaX;
    }
    @Override
    public boolean overlapsBird(BirdInterface bird){

        if ((bird.getX() >= getX() -1 && bird.getX() < getX() -1 + getWidth())
                && bird.getY() < getTopPipeY()){

            return true;
        }
        else if ((bird.getX() >= getX() -1 && bird.getX() < getX() -1 + getWidth())
                && bird.getY() >= getBottomPipeY()){

            return true;
        }
        return false;
    }
    @Override
    public void randomiseGapY(){
        gapY = (int) (3 + (Math.random() * 12));
    }

    @Override
    public void moveTo(int location){
        x = location;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getTopPipeY() {
        return gapY;
    }
    @Override
    public int getBottomPipeY(){
        return gapY + gapHeight;
    }
    @Override
    public int getWidth(){
        return pipeWidth;
    }
    @Override
    public boolean isOffScreen(){
        return x < 0;
    }
}
