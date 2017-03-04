import processing.core.PApplet;

/**
 * Created by irs6 on 04/03/17.
 */
public class StarP {

    PApplet parent;

    private final int STAR_SIZE = 3;
    private final float SPEED = 0.75f;
    float x;
    float y;


    public StarP(PApplet p) {
        parent = p;
        x  = parent.random(parent.width);
        y  = parent.random(-200, parent.height);

    }

    void move() {
        y = y + SPEED;

        if (y > parent.height) {
            y = parent.random(-200, parent.height);
        }
    }

    void show() {
        parent.stroke(255, 255, 0);
        parent.rect(x, y, STAR_SIZE, STAR_SIZE);
    }
}
