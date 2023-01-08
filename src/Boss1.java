import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Boss1 extends GameObject{
    private Handler handler;
    Random r = new Random();
    private int timer = 60;
    private int timer2 = 50;
    private BufferedImage enemy_image;
    public Boss1(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = 0;
        velY = 2;
        this.handler = handler;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        enemy_image = ss.getSprite(3, 1, 64, 64);
    }
    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y,16,16);
    }
    public void tick() {
        x += velX;
        y += velY;
        if(timer <= 0) velY = 0;
        else timer--;
        if(timer <= 0) timer2--;
        if(timer2<=0){
            if(velX ==0) velX = 2;

            if(velX > 0) velX += 0.005f;
            else if(velX < 0) velX -= 0.005f;

            int spawn = r.nextInt(30);
            if(spawn == 0) handler.addObject(new Boss1Bullet((int)x + 30, (int)y + 30, ID.BasicEnemy, handler));
        }

//        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

//        handler.addObject(new Trail((int) x, (int) y , ID.Trail, Color.red, 64, 64,0.5f, handler));
    }

    public void render(Graphics g) {
//        g.setColor(Color.red);
//        g.fillRect((int) x,(int) y,64,64);
        g.drawImage(enemy_image, (int)x, (int)y, null);
    }
}
