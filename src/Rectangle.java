import java.awt.*;

/**
 * Created by irs6 on 04/03/17.
 */
public class Rectangle extends Component {

    int x,y,w,h;
    boolean filled;
    Color color;

    public Rectangle(int x, int y, int w, int h, boolean filled, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.filled = filled;
        this.color = color;
    }

    @Override public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(color);

        if(filled){
            g2d.fillRect(x, y, w, h);
        }
        else{
            g2d.drawRect(x, y, w, h);
        }
    }
}
