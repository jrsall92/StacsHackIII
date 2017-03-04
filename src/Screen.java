import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Font;
import java.awt.image.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by irs6 on 04/03/17.
 */
public class Screen extends JPanel implements Runnable, KeyListener {

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 700;

    private boolean isRunning;

    private boolean gameStart = false;
    private boolean computer = false;
    private boolean startSetUp = false;

    private boolean menuPick = true;

    private boolean hintUsed = false;

    private Graphics2D graphics1;
    private int FPS = 60;
    private int targetTime = 1000 / FPS;

    private GridTiles gridTiles;
    //private Player player;

    public Screen() {

        super();

        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setFocusable(true);
        requestFocus();
    }

   /* public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
        addKeyListener(this);
    }

    public void setGridTiles(GridTiles gridTiles) {
        this.gridTiles = gridTiles;
    }


    public void setGameStart() {
        gameStart = true;
    }

    public boolean getGameStart() {
        return gameStart;
    }
*/
    public void run() {

        initialise();
        long timeStart;
        long timeUrd;
        long timeWait;

        while (isRunning) {
            timeStart = System.nanoTime();

          //  render();
          //  draw();
            /*update();
            render();
            draw();*/

            timeUrd = (System.nanoTime() - timeStart) / 1000000;
            timeWait = targetTime - timeUrd;
            try {
                Thread.sleep(timeWait);
            } catch (Exception e) {

            }

        }
    }

    public void initialise() {
        isRunning = true;

       // graphics1 = (Graphics2D) image.getGraphics();

        //grid tiles testMap is no longer used, make sure to delete this
       // gridTiles = new GridTiles(30);


        //player = new Player(gridTiles);

        //  player.startPositionPlayer();

        //player.loadPlayerTile("player.png");

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }


    /*public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 700;

    @Override public void keyTyped(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("yo");
        }

    }

    @Override public void keyPressed(KeyEvent e) {

    }

    @Override public void keyReleased(KeyEvent e) {

    }*/
}
