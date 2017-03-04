import processing.core.PApplet;

/**
 * Created by va29 on 04/03/17.
 */
public class Enemy {
    PApplet parent;

    private final int ENEMY_SIZE = 60;
    private final float SPEED = 1.4f;
    private float SPEED2 = 1;
    private float x;

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float y;


    public Enemy(PApplet p) {
        parent = p;
        x  = parent.random((int) (Math.random()*581));
        y  = -60;
    }

    void move() {
        y = y + SPEED;

        if (y > parent.height) {
            y = parent.random(-60, parent.height);
        }

        if(parent.random(-1, 1)>=0) {
            SPEED2=1;

        }else{
            SPEED2=-1;
        }
        x = x + SPEED2;

    }

    void show() {
        parent.stroke(255, 255, 0);
        parent.rect(x, y, ENEMY_SIZE, ENEMY_SIZE);

    }





}
