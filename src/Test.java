import processing.core.PApplet;

/**
 * Created by irs6 on 04/03/17.
 */
public class Test extends PApplet {

    public static void main(String[] args){
        PApplet.main("Test");
    }

    Drop[] drops = new Drop[500];

    public void settings(){
        size(640, 360);
    }

    public void setup(){
        for(int i = 0; i< 500; i++){
            drops[i] = new Drop(this);
        }
    }

    public void draw(){
        background(230, 230, 250);
        for (int i = 0; i < drops.length; i++) {
            drops[i].fall();
            drops[i].show();
        }
    }

}
