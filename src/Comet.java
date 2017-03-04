import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by irs6 on 04/03/17.
 */
public class Comet {

    private final float SPEED = 0.5f;

    private PApplet parent;
    private float x, y;
    private PImage image;
    private float random;
    private int imgNum;

    public Comet(PApplet p){
        this.parent = p;
        init();
        image = parent.loadImage("boulder"+ imgNum +".png");
    }

    void hit(){
        imgNum++;
        if(imgNum > 3){
            init();
        }
        image = parent.loadImage("boulder"+ imgNum +".png");
    }

    void move() {
        y = y + SPEED + (random * 50 * SPEED /100);

        if (y > parent.height) {
            init();
        }
    }

    private void init(){
        x  = parent.random(parent.width);
        y  = parent.random(-250, -150);
        random = parent.random(-1f, 1f);
        imgNum = 1;
    }

    void show(){
        parent.image(image, x, y);
    }
}
