import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by va29 on 04/03/17.
 */

public class Player {

    private final int LEFT_TURN = 1;
    private final int STRAIGHT = 2;
    private final int RIGHT_TURN = 3;

    PApplet parent;
    private float x=290;
    private float y=840;
    private PImage image;
    private int width, height;

    public Player(PApplet p){
        parent = p;
        setImage(STRAIGHT);
        x  = parent.width/2 - width/2;
        y  = parent.height - height;
    }

    void show() {
        parent.image(image, x, y);
    }

    private void setImage(int n){
        if(n<1 || n>3){
            n = 2;
        }
        image = parent.loadImage("aircraft"+ n +".png");
        width = image.width;
        height = image.height;
    }

    public void resetImage(){
        setImage(STRAIGHT);
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

    void move(int m){
        x=x+m;

        if(m>=0)
            setImage(RIGHT_TURN);
        else
            setImage(LEFT_TURN);

        if(x>parent.width-(width/2))
            x = -(width/2) + 1;

        if(x <= -(width/2))
            x = parent.width- (width/2) -1;
    }

}
