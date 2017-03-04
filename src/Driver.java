import processing.core.PApplet;

/**
 * Created by irs6 on 04/03/17.
 */
public class Driver extends PApplet {


    private final int NUMBER_OF_STARS = 500;
    private final int NUMBER_OF_COMETS = 5;
    private final int SCREEN_WIDTH = 640;
    private final int SCREEN_HEIGHT = 900;

    private boolean moveLeft, moveRight, moveUp, moveDown;

    public static void main(String[] args){
        PApplet.main("Driver");
    }

    private StarP[] stars = new StarP[NUMBER_OF_STARS];
    private Comet[] comets = new Comet[NUMBER_OF_COMETS];

    public void settings(){
        size(SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    public void setup(){
        for(int i = 0; i< NUMBER_OF_STARS; i++){
            stars[i] = new StarP(this);
        }

        for(int i = 0; i < NUMBER_OF_COMETS; i++){
            comets[i] = new Comet(this);
        }
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
        for(int i = 0; i < NUMBER_OF_COMETS; i++){
            comets[i].move();
            comets[i].show();
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
        else{
            if(key == ' '){
                System.out.println("Space");
                comets[3].hit();
            }
        }
    }
}