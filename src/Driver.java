import processing.core.PApplet;

/**
 * Created by irs6 on 04/03/17.
 */
public class Driver extends PApplet {

    private boolean moveLeft, moveRight, moveUp, moveDown;
    private final int NUMBER_OF_STARS = 500;

    public static void main(String[] args){
        PApplet.main("Driver");
    }

    StarP[] stars = new StarP[NUMBER_OF_STARS];

    public void settings(){
        size(640, 900);
        for(int i = 0; i< NUMBER_OF_STARS; i++){
            stars[i] = new StarP(this);
        }
    }

    public void setup(){
        moveLeft = false;
        moveRight = false;
        moveUp = false;
        moveDown = false;
    }

    public void draw(){
        background(0, 0, 0);
        for (int i = 0; i < NUMBER_OF_STARS; i++) {
            stars[i].move();
            stars[i].show();
        }
    }

    public void keyPressed(){
        if(key == CODED){
            if(key == UP){
                moveUp = true;
                //TODO move player up
            }
            else {
                moveUp = false;
            }

            if(key == DOWN){
                moveDown = true;
                //TODO move player down
            }
            else{
                moveDown = false;
            }

            if(key == RIGHT){
                moveRight = true;
                //TODO move right
            }
            else{
                moveRight = false;
            }

            if(key == LEFT){
                moveLeft = true;
                //TODO move right
            }
            else{
                moveLeft = false;
            }
        }
    }
}
