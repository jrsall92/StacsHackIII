import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by irs6 on 04/03/17.
 */
public class Comet {

    private final float SPEED = 0.5f;

    private PApplet parent;
    private float x, y;
    private PImage image1, image2, image3, maul, curr;
    private float random;
    private int imgNum;
    private int width, height;
    private int maulCounter;

    public Comet(PApplet p){
        this.parent = p;
        image1 = parent.loadImage("boulder"+ 1 +".png");
        image2 = parent.loadImage("boulder"+ 2 +".png");
        image3 = parent.loadImage("boulder"+ 3 +".png");
        maul = parent.loadImage("maul.png");
        init();
        setImage(imgNum);
    }

    private void setImage(int n){
        if(n<1 || n>3 || n == 1){
            curr = image1;
        }
        else if(n==2){
            curr = image2;
        }
        else if(n == 3){
            curr = image3;
        }

        width = curr.width;
        height = curr.height;
    }

    void hit(){
        imgNum++;
        if(imgNum > 4){
            init();
        }
        if(imgNum == 4){
            curr = maul;
            x-=42;
            y-=69;
        }
        else {
            setImage(imgNum);
        }
    }

    void move() {
        y = y + SPEED + (random * 50 * SPEED /100);
        if (y > parent.height || maulCounter > 3) {
            init();
        }
        else if(imgNum == 4)
            maulCounter++;
    }

    private void init(){
        x  = parent.random(parent.width);
        y  = parent.random(-250, -150);
        random = parent.random(-1f, 1f);
        imgNum = 1;
        maulCounter = 0;
        setImage(imgNum);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    void show(){
        parent.image(curr, x+width, y);
    }
}
