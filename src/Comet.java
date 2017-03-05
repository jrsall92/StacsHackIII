import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by irs6 on 04/03/17.
 */
public class Comet {

    private final float SPEED = 2f;

    private PApplet parent;
    private float x;

    public void setX(float x) {
        this.x=x;
    }
    public void setY(float y) {
        this.y=y;
    }

    private float y;
    private PImage image1, image2, image3, maul, curr;
    private float random;
    private int imgNum;
    private int width1, height1, width2, height2, width3, height3, maulWidth, maulHeight, currWidth, currHeight;
    private int maulCounter;

    public Comet(PApplet p){
        this.parent = p;
        image1 = parent.loadImage("boulder"+ 1 +".png");
        width1 = image1.width;
        height1 = image1.height;
        image2 = parent.loadImage("boulder"+ 2 +".png");
        width2 = image2.width;
        height2 = image2.height;
        image3 = parent.loadImage("boulder"+ 3 +".png");
        width3 = image3.width;
        height3 = image3.height;
        maul = parent.loadImage("maul.png");
        maulWidth=maul.width;
        maulHeight=maul.height;
        init();
        setImage(imgNum);
    }

    private void setImage(int n){
        if(n<1 || n>3 || n == 1){
            curr = image1;
            currWidth = width1;
            currHeight = height1;

        }
        else if(n==2){
            curr = image2;
            currWidth = width2;
            currHeight = height2;
           // x=x+100;
            //curr.setX(x+100);

            //y=y+100;
        }
        else if(n == 3){
            curr = image3;
            currWidth = width3;
            currHeight = height3;
        }
    }

    void hit(){
        imgNum++;
        if(imgNum > 4){
            init();
        }
        if(imgNum == 4){
            curr = maul;
            currHeight = maulHeight;
            currWidth = maulWidth;
            x-=42;
            y-=69;
        }
        else {

           // x=x+100;
            //y=y+100;
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
        return currWidth;
    }

    public int getHeight() {
        return currHeight;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    void show(){
        parent.image(curr, x, y);
    }
}
