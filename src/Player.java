import processing.core.PApplet;

/**
 * Created by va29 on 04/03/17.
 */

public class Player {

    PApplet parent;
    float x=290;
    float y=840;

    public Player(PApplet p){
        parent = p;
        x  = 290;
        y  = 840;
    }

    void show() {
        parent.stroke(300, 300, 600);
        parent.rect(x, y, 60, 60);
    }

    void move(int m){
        x=x+m;

        if(x>parent.width)
            x = 1;

        if(x <=0 )
            x = parent.width -1;
        System.out.println("aaaaaaaaaaaaa");
    }

}
