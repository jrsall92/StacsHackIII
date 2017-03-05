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
        private float random;
        private int imgNum;
        private int width, height;

        public BulletEnemy(PApplet p, float x, float y){
            this.parent = p;
            this.x = x;
            this.y = y;
            setImage();
        }

        private void setImage(){
            bul_image = parent.loadImage("bullet3.png");
            this.width = bul_image.width;
            this.height = bul_image.height;
        }

      /*  public boolean collision(Comet comet){



            if ((comet.getY() + comet.getHeight() >= y *//*&& comet.getY() < y*//*)&&
                    (comet.getX() <= x && comet.getX()+comet.getWidth() > x)){
                comet.hit();

                //  comet.setX(comet.getX()+50);
                //  comet.setY(comet.getY()+50);

                // comet.hit();
                return true;
            }
            return false;
        }*/

        //public void collision(Enemy enemy){
        //    if ((enemy.getY() + enemy.getHeight() == y)||(enemy.getX()< x && enemy.getX()+enemy.getWidth() <= x)){
        //        enemy.hit();
        //    }
        //}


    public boolean collision2(Player player){

        if ((player.getY() + player.getHeight() >= y /*&& comet.getY() < y*/)&&
                (player.getX() <= x && player.getX()+player.getWidth() > x)){
            //  comet.setX(comet.getX()+50);
            //  comet.setY(comet.getY()+50);

            // comet.hit();
            return true;
        }
        return false;
    }

    void move(){
            y+=SPEED;
        }

/*
    void move2(){
        y+=SPEED;
    }
*/


        void show(int offset){

            parent.image(bul_image, x + offset - 6, y);

        }



}
