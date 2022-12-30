import java.awt.*;
import java.util.Random;

public class Player extends GameObject{
    Random r = new Random();
    public Player(int x, int y, ID id) {
        super(x, y, id);

//        velX = r.nextInt(5) + 1;
//        velY = r.nextInt(5);
        //setX(100);
    }

    public void tick() {
        x += velX;
        y += velY;
        x = Game.clamp(x, 0, Game.WIDTH-50);
        y = Game.clamp(y, 0, Game.HEIGHT-80);
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y,32,32);
    }


}
