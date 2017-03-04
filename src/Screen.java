import javax.swing.*;
import java.awt.event.*;

/**
 * Created by irs6 on 04/03/17.
 */
public class Screen extends JPanel implements KeyListener {



    @Override public void keyTyped(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("yo");
        }

    }

    @Override public void keyPressed(KeyEvent e) {

    }

    @Override public void keyReleased(KeyEvent e) {

    }
}
