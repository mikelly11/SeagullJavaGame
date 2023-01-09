import java.awt.*;
import java.awt.image.BufferedImage;

public class Cherry extends GameObject{
    private Handler handler;
    private BufferedImage enemy_image;
    public Cherry(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        velX = 2;
        velY = 2;
        this.handler = handler;

        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        enemy_image = ss.getSprite(5, 1, 16, 16);
    }
    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y,16,16);
    }
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

//        handler.addObject(new Trail((int) x, (int) y , ID.Trail, Color.red, 16, 16,0.05f, handler));
    }

    public void render(Graphics g) {
//        g.setColor(Color.red);
//        g.fillRect((int) x,(int) y,16,16);
        g.drawImage(enemy_image, (int)x, (int)y, null);
    }
}
