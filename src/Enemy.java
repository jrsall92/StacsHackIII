import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by va29 on 04/03/17.
 */
public class Enemy {

    private PApplet parent;

    private final int LEFT_TURN = 1;
    private final int STRAIGHT = 2;
    private final int RIGHT_TURN = 3;

    private final int ENEMY_SIZE = 60;
    private final float SPEED = 1.4f;
    private float SPEED2 = 1f;
    private PImage image;
    private int width, height;
    private float x, y;
    private int frames = 0;
    private int direction;


    public Enemy(PApplet p) {
        parent = p;
        setImage(STRAIGHT);
        x  = parent.random((int) (Math.random()*581));
        y  = -60;
    }

    void move() {
        y = y + SPEED;

        if (y > parent.height) {
            init();
        }

        if(frames <= 0){
            frames = (int) (parent.random(10,45));
            direction = (int) parent.random(-1.1f, 1.1f);
        }

        if(direction < 0){
            setImage(LEFT_TURN);
        }
        else if (direction > 0){
            setImage(RIGHT_TURN);
        }
        else {
            setImage(STRAIGHT);
        }

        x = x + direction * SPEED2;

        frames--;

        if(x>parent.width-(ENEMY_SIZE/2))
            x = -(ENEMY_SIZE/2) + 1;

        if(x <= -(ENEMY_SIZE/2))
            x = parent.width- (ENEMY_SIZE/2) -1;
    }

    private void init(){
        x  = parent.random(parent.width);
        y  = parent.random(-250, -150);
        setImage(STRAIGHT);
    }

    private void setImage(int n){
        if(n<1 || n>3){
            n = 2;
        }
        image = parent.loadImage("fighter"+ n +".png");
        width = image.width;
        height = image.height;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    void show() {
        parent.image(image, x, y);
    }

}
