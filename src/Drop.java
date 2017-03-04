import processing.core.PApplet;

import static processing.core.PApplet.*;

/**
 * Created by irs6 on 04/03/17.
 */

public class Drop{

    PApplet parent;

    float x;
    float y;
    float z;
    float len;
    float yspeed;

    public Drop(PApplet p) {
        parent = p;
        x  = parent.random(parent.width);
        y  = parent.random(-500, -50);
        z  = parent.random(0, 20);
        len = map(z, 0, 20, 10, 20);
        yspeed  = map(z, 0, 20, 1, 20);

    }

    void fall() {
        y = y + yspeed;
        float grav = map(z, 0, 20, 0, 0.2f);
        yspeed = yspeed + grav;

        if (y > parent.height) {
            y = parent.random(-200, -100);
            yspeed = map(z, 0, 20, 4, 10);
        }
    }

    void show() {
        float thick = map(z, 0, 20, 1, 3);
        parent.strokeWeight(thick);
        parent.stroke(138, 43, 226);
        parent.line(x, y, x, y+len);
    }

}
