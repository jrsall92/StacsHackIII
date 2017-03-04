import processing.core.PApplet;

/**
 * Created by va29 on 04/03/17.
 */
public class Enemy {
    PApplet parent;

    private final int ENEMY_SIZE = 60;
    private final float SPEED = 1.4f;
    private float SPEED2 = 1f;
    private float x;
    private int frames = 0;
    private int direction;

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

        if(frames <= 0){
            frames = (int) (parent.random(120));
            direction = (int) parent.random(-1.1f, 1.1f);
            while (direction == 0){
                direction = (int) parent.random(-1.1f, 1.1f);
            }
        }

        x = x + direction * SPEED2;
        frames--;

        if(x>parent.width-(ENEMY_SIZE/2))
            x = -(ENEMY_SIZE/2) + 1;

        if(x <= -(ENEMY_SIZE/2))
            x = parent.width- (ENEMY_SIZE/2) -1;
    }

    void show() {
        parent.stroke(255, 255, 0);
        parent.rect(x, y, ENEMY_SIZE, ENEMY_SIZE);

    }





}
