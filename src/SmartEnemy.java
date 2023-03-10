import java.awt.*;
import java.awt.image.BufferedImage;

public class SmartEnemy extends GameObject{
    private Handler handler;
    private GameObject player;
    private BufferedImage enemy_image;
    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);

        }
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        enemy_image = ss.getSprite(2, 4, 16, 16);
    }
    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y,16,16);
    }
    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 16;
        float diffY = y - player.getY() - 16;
        float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y - player.getY())*(y - player.getY()));

        velX = ((-1/distance) * diffX)*2;
        velY = ((-1/distance) * diffY)*2;

        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

//        handler.addObject(new Trail(x, y , ID.Trail, Color.green, 16, 16,0.05f, handler));

    }

    public void render(Graphics g) {
//        g.setColor(Color.green);
//        g.fillRect((int) x,(int) y,16,16);
        g.drawImage(enemy_image, (int)x, (int)y, null);
    }
}
