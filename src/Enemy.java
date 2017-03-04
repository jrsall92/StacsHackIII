import processing.core.PApplet;

/**
 * Created by va29 on 04/03/17.
 */
public class Enemy {
    PApplet parent;

    private final int ENEMY_SIZE = 60;
    private final float SPEED = 0.75f;
    private float x;
    private float y;


    public Enemy(PApplet p) {
        parent = p;
        x  = parent.random((int) (Math.random()*581));
        y  = 0;
    }

    void move() {
        y = y + SPEED;

        if (y > parent.height) {
            y = parent.random(-60, parent.height);
        }
    }

    void show() {
        parent.stroke(255, 255, 0);
        parent.rect(x, y, ENEMY_SIZE, ENEMY_SIZE);

    }





}
