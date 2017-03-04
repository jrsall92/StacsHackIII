import java.awt.*;

/**
 * Created by irs6 on 04/03/17.
 */
public class Star extends Rectangle {

    public Star(int x, int y, int w, int h, boolean filled, Color color) {
        super(x, y, w, h, filled, color);
    }

    public void move(){
        y += 10;
    }
}
