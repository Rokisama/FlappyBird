package FlappyBird;

import java.util.List;

public class Renderer {
    BirdInterface bird;
    List<PipeInterface> pipes;
    Map map;
    public Renderer(BirdInterface bird, List<PipeInterface> pipes, Map map) {
        this.bird = bird;
        this.pipes = pipes;
        this.map = map;
    }

    public void render(BirdInterface bird, List<PipeInterface> pipes, Map map, int score) {
        int mapHeight = map.getROWS();
        int mapWidth = map.getCOLS();

        String frame = "";
        System.out.println("SCORE~~~" + score);
        for (int row = 0; row < mapHeight; row++) {
            for (int col = 0; col < mapWidth; col++) {

                char cell = getCellContents(map, bird, pipes, row, col);
                frame += cell;
            }

            frame += "\n";
        }
        System.out.println(frame);
        System.out.println();
        System.out.flush();
    }
    private char getCellContents(Map map, BirdInterface bird, List<PipeInterface> pipes, int row, int col) {
        for (PipeInterface pipe : pipes){

           if (col >= pipe.getX() && col < pipe.getX() + pipe.getWidth()){
               if (row >= 0 && row < pipe.getTopPipeY()){
                   return '#';
               }
               else if (row >= pipe.getBottomPipeY() && row < map.getROWS()){
                   return '#';
               }
           }
        }
        if (col == bird.getX() && row == bird.getY()) {
            return '>';
        }
        else if (row >= map.getROWS()-2){
            return '-';
        }
        else {
            return ' ';
        }
    }
}
