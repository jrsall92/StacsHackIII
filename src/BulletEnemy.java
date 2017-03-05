import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by va29 on 05/03/17.
 */
public class BulletEnemy {
    /**
     * Created by jevge on 04/03/2017.
     */
    private final float SPEED = 5f;

    private PApplet parent;
    private float x, y;
    private PImage bul_image;
    private boolean transparent, outOfBounds;
    private float random;
    private int imgNum;
    private int width, height;

    public BulletEnemy(PApplet p, float x, float y) {
        this.parent = p;
        this.x = x;
        this.y = y;
        transparent = false;
        outOfBounds = false;
        setImage();
    }

    public boolean isTransparent() {
        return transparent;
    }

    public boolean isOutOfBounds() {
        return outOfBounds;
    }

    private void setImage() {
        bul_image = parent.loadImage("bullet3.png");
        this.width = bul_image.width;
        this.height = bul_image.height;
    }

    public boolean collision2(Player player) {

        if ((player.getY() + player.getHeight() >= y /*&& comet.getY() < y*/) && (player.getX() <= x && player.getX() + player.getWidth() > x)) {
            transparent = true;
            return true;
        }
        return false;
    }

    void move() {
        y += SPEED;
        outOfBounds = y > parent.height;
    }

    void show(int offset) {
        parent.image(bul_image, x + offset - 6, y);
    }

}
