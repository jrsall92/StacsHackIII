import javax.swing.*;

/**
 * Created by irs6 on 04/03/17.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("hi");
        JFrame window = new JFrame("Hunt The Wumpus");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Screen());
        window.pack();
        window.setVisible(true);
    }
}
