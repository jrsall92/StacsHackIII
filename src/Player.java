import processing.core.PApplet;

import static processing.core.PApplet.map;
import static processing.core.PConstants.RIGHT;

/**
 * Created by va29 on 04/03/17.
 */

public class Player {

    PApplet parent;
    float x=290;
    float y=840;
    float z;
    float len;
    float yspeed;

    public Player(PApplet p){
        parent = p;
        x  = 290;
        y  = 840;
        //z  = parent.random(0, 1);
       // len = map


     //   len = map(z, 0, 20, 10, 20);
     //   yspeed  = map(z, 0, 20, 1, 20);
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

   /* void keyPressed(){
        if(parent.keyCode =parent.RIGHT){



        }
    }*/


}
