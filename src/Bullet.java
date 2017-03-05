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
    private boolean transparent, outOfBounds;
    private float random;
    private int imgNum;
    private int width, height;

    public Bullet(PApplet p, float x, float y){
        this.parent = p;
        this.x = x;
        this.y = y;
        transparent = false;
        outOfBounds = false;
        setImage();
    }

    private void setImage(){
        bul_image = parent.loadImage("bullet3.png");
        this.width = bul_image.width;
        this.height = bul_image.height;
    }

    public boolean collision(Comet comet){
        if ((comet.getY() + comet.getHeight() >= y && comet.getY() < y)&&(comet.getX() <= x+50
                && comet.getX()+comet.getWidth()-30 > x)){
            comet.hit();
            transparent = true;
            return true;
        }
        return false;
    }

    public boolean collision(Enemy enemy){
        if ((enemy.getY() + enemy.getHeight() >= y && enemy.getY() < y)&&(enemy.getX() <= x+50
                && enemy.getX()+enemy.getWidth()-30 > x)){
            enemy.reset();
            transparent = true;
            return true;
        }
        return false;
    }

    void move(){
        y-=SPEED;
        outOfBounds = y < -10;
    }

    public boolean isTransparent() {
        return transparent;
    }

    public boolean isOutOfBounds() {
        return outOfBounds;
    }

    void show(int offset){

        parent.image(bul_image, x + offset - 6, y);

    }

}
