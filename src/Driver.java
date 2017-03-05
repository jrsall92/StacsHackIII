import processing.core.PApplet;

import java.util.ArrayList;

/**
 * Created by irs6 on 04/03/17.
 */
public class Driver extends PApplet {

    Player pl;
    Enemy enemy;
    //PApplet p;
    int k = 0;

    private final int NUMBER_OF_STARS = 500;
    private final int NUMBER_OF_COMETS = 5;
    private final int SCREEN_WIDTH = 640;
    private final int SCREEN_HEIGHT = 900;

    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Bullet> newBullets = new ArrayList<>();
    private ArrayList<BulletEnemy> bulletsEnemy = new ArrayList<>();
    private ArrayList<BulletEnemy> newBulletsEnemy = new ArrayList<>();

    private boolean moveLeft, moveRight, moveUp, moveDown;

    public static void main(String[] args) {
        PApplet.main("Driver");
    }

    private StarP[] stars = new StarP[NUMBER_OF_STARS];
    private Comet[] comets = new Comet[NUMBER_OF_COMETS];

    public void settings() {
        size(SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    public void setup() {
        for (int i = 0; i < NUMBER_OF_STARS; i++) {
            stars[i] = new StarP(this);
        }

        for (int i = 0; i < NUMBER_OF_COMETS; i++) {
            comets[i] = new Comet(this);
        }
        moveLeft = false;
        moveRight = false;
        moveUp = false;
        moveDown = false;

        pl = new Player(this);
        enemy = new Enemy(this);
    }

    public void draw() {
        background(0, 0, 0);
        for (int i = 0; i < NUMBER_OF_STARS; i++) {
            stars[i].move();
            stars[i].show();
        }
        for (int i = 0; i < NUMBER_OF_COMETS; i++) {
            comets[i].move();
            comets[i].show();
            if ((comets[i].getY() + comets[i].getHeight() >= pl.getY() && comets[i].getY() < pl.getY()) && (comets[i].getX() <= pl.getX() + 80
                    && comets[i].getX() + comets[i].getWidth() - 50 > pl.getX())) {
                //comets[i].hit();
               // PApplet.image(loadImage("gameover2.png"),200,200);
                //theEnd = PApplet.loadImage("gameover2.png");
                //image(theEnd,250,450);
                stop();
            }
        }

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).move();
            bullets.get(i).show(pl.getWidth() / 2);
            for (int j = 0; j < NUMBER_OF_COMETS; j++) {
                if (bullets.get(i).collision(comets[j])) {
                    break;
                }
            }
            if(!bullets.get(i).isTransparent() && !bullets.get(i).isOutOfBounds()){
                newBullets.add(bullets.get(i));
            }
        }

        bullets = newBullets;
        newBullets = new ArrayList<>();

        if (k % 120 == 0) {
            bulletsEnemy.add(new BulletEnemy(this, enemy.getX(), enemy.getY()));
        }
        k++;

        for (int i = 0; i < bulletsEnemy.size(); i++) {
            bulletsEnemy.get(i).move();
            bulletsEnemy.get(i).show(enemy.getWidth() / 2);
            if(bulletsEnemy.get(i).collision2(pl)){
                System.out.println("shoot");
                //stop();
            }
            if(!bulletsEnemy.get(i).isTransparent() && !bulletsEnemy.get(i).isOutOfBounds()){
                newBulletsEnemy.add(bulletsEnemy.get(i));
            }
        }

        bulletsEnemy = newBulletsEnemy;
        newBullets = new ArrayList<>();

        pl.show();
        enemy.show();
        enemy.move();
    }

    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == UP) {
                moveUp = true;
                //TODO move player up
            }
            else {
                moveUp = false;
            }

            if (keyCode == DOWN) {
                moveDown = true;
                //TODO move player down
            }
            else {
                moveDown = false;
            }

            if (keyCode == RIGHT) {
                moveRight = true;
                pl.move(20);
                //TODO move right
            }
            else {
                moveRight = false;
            }

            if (keyCode == LEFT) {
                moveLeft = true;
                pl.move(-20);
                //TODO move right
            }
            else {
                moveLeft = false;
            }
        }
        else {
            if (key == ' ') {
                System.out.println("Space");
                //comets[3].hit();
                bullets.add(new Bullet(this, pl.getX(), pl.getY()));
                //   bulletsEnemy.add(new BulletEnemy(this, enemy.getX(), enemy.getY()));
            }
        }
    }

    public void keyReleased() {
        pl.resetImage();
    }
}

