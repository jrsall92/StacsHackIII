import processing.core.PApplet;

/**
 * Created by irs6 on 04/03/17.
 */
public class StarP {

    PApplet parent;

    float x;
    float y;
    float yspeed;

    public StarP(PApplet p) {
        parent = p;
        x  = parent.random(parent.width);
        y  = parent.random(-200, parent.height);
        yspeed  = 0.75f;

    }

    void move() {
        y = y + yspeed;

        if (y > parent.height) {
            y = parent.random(-200, parent.height);
        }
    }

    void show() {
        parent.stroke(255, 255, 0);
        parent.rect(x, y, 3, 3);
    }
}
