import java.awt.*;
import java.awt.image.BufferedImage;

public class BigEnemy extends GameObject{
    private Handler handler;
    private BufferedImage enemy_image;
    public BigEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = 5;
        velY = 5;
        this.handler = handler;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        enemy_image = ss.getSprite(2, 1, 32, 32);
    }
    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y,32,32);
    }
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 64) velX *= -1;

//        handler.addObject(new Trail((int) x, (int) y , ID.Trail, Color.red, 32, 32,0.05f, handler));
    }

    public void render(Graphics g) {
//        g.setColor(Color.red);
//        g.fillRect((int) x,(int) y,32,32);
        g.drawImage(enemy_image, (int)x, (int)y, null);
    }
}
