import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        // Play Button
        if(mouseOver(mx, my, 210, 150, 200, 64)){
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(game.WIDTH / 2 - 32, game.HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH) - 48, r.nextInt(game.HEIGHT) - 48, ID.BasicEnemy, handler));
        }
        if(mouseOver(mx, my, 210, 250, 200, 64)){
            game.gameState = Game.STATE.Help;
        }
        // Back button
        if(game.gameState == Game.STATE.Help){
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Men;
                return;
            }
        }

        // Quit button
        if(game.gameState == Game.STATE.Men) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }

        // Play Again button
        if(game.gameState == Game.STATE.End){
            if(mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Men;
                return;
            }
        }
    }
    public void mouseReleased(MouseEvent e){

    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            } else return false;
        }else return false;
    }
    public void tick(){

    }
    public void render(Graphics g){
        if(game.gameState == Game.STATE.Men) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 280, 190);

            g.setColor(Color.white);
            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 280, 290);

            g.setColor(Color.white);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 280, 390);
        }else if(game.gameState == Game.STATE.Help) {
            Font fnt3 = new Font("arial", 1, 15);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt = new Font("arial", 1, 50);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);

            g.setFont(fnt3);
            g.drawString("Use the 'WASD' keys to move around in this fast phased game.", 100, 90);
            g.drawString("W = Up, A = Left, S = Down, D = Right.", 100, 110);
            g.drawString("In this game your goal is to dodge enemies and get as many", 100, 130);
            g.drawString("points as possible. Every 10 levels there is a boss enemy.", 100, 150);
            g.setFont(fnt2);
            g.setColor(Color.blue);
            g.drawString("ENJOY!", 250, 190);

            g.setColor(Color.white);
            g.setFont(fnt2);
            g.drawString("Back", 270, 390);
            g.drawRect(210, 350, 200, 64);
        }else if(game.gameState == Game.STATE.End) {
            Font fnt3 = new Font("arial", 1, 15);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt = new Font("arial", 1, 50);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("End Game", 200, 70);

            g.setFont(fnt3);
            g.drawString("You lost with a score of  " + hud.getScore(), 100, 90);

            g.setColor(Color.white);
            g.setFont(fnt2);
            g.drawString("Play Again", 230, 390);
            g.drawRect(210, 350, 200, 64);
        }
    }
}
