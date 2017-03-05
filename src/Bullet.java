/**
 * Created by jevge on 04/03/2017.
 */

import processing.core.PApplet;
import processing.core.PImage;

public class Bullet {

    private final float SPEED = 1f;

    private PApplet parent;
    private float x, y;
    private PImage bul_image;
    private float random;
    private int imgNum;
    private int width, height;

    public Bullet(PApplet p, float x, float y){
        this.parent = p;
        this.x = x;
        this.y = y;
        setImage();
    }

    private void setImage(){
        bul_image = parent.loadImage("bullet3.png");
        this.width = bul_image.width;
        this.height = bul_image.height;
    }

    private void collision(Comet comet){
       // show();
        if ((comet.getY() + comet.getHeight() == y)||(comet.getX()< x && comet.getX()+comet.getWidth() <= x)){
            comet.hit();
        }
        //else {
         //   show();
        //}
    }

    void move(){
        y--;
    }

    void show(){

        parent.image(bul_image, x + 12, y);

    }

}
