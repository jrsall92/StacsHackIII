/**
 * Created by jevge on 04/03/2017.
 */

import processing.core.PApplet;
import processing.core.PImage;

public class Bullet {

    private final float SPEED = 3f;

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

    public boolean collision(Comet comet){
        if ((comet.getY() + comet.getHeight() >= y && comet.getY() < y)&&(comet.getX() <= x && comet.getX()+comet.getWidth() > x)){
            comet.hit();
            return true;
        }
        return false;
    }

    //public void collision(Enemy enemy){
    //    if ((enemy.getY() + enemy.getHeight() == y)||(enemy.getX()< x && enemy.getX()+enemy.getWidth() <= x)){
    //        enemy.hit();
    //    }
    //}

    void move(){
        y-=SPEED;
    }

    void show(int offset){

        parent.image(bul_image, x + offset - 6, y);

    }

}
