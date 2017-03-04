import javax.swing.*;

/**
 * Created by irs6 on 04/03/17.
 */
public class Main {

    public static void main(String[] args){
        JFrame window = new JFrame("Return of the Arcades");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Screen());
        window.pack();
        window.setVisible(true);
    }
}
