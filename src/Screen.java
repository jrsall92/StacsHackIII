import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by irs6 on 04/03/17.
 */
public class Screen extends JPanel implements Runnable, KeyListener {

    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 700;

    private boolean isRunning,isPressed=false;

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
        Rectangle bg = new Rectangle(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, true, Color.BLACK);
        Rectangle r2 = new Rectangle(300,350,5,5, true, Color.RED);
        add(bg);
        add(r2);

        for(int i = 0; i<100; i++){
            int x = ThreadLocalRandom.current().nextInt(2, SCREEN_WIDTH + 1);
            int y = ThreadLocalRandom.current().nextInt(2, SCREEN_HEIGHT + 1);
            add(new Star(x, y, 3,3, true, Color.YELLOW));
        }

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
            revalidate();
            repaint();

            timeUrd = (System.nanoTime() - timeStart) / 1000000;
            timeWait = targetTime - timeUrd;
            try {

                Thread.sleep(timeWait);
            } catch (Exception e) {
                e.printStackTrace();
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
    public void paintComponent(Graphics g){
        if(true) {
            Component[] components = getComponents();
            for(int i = 0; i< components.length; i++){
                if(components[i] instanceof Star)
                    ((Star) components[i]).move();

                components[i].paint(g);
            }
        }
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
