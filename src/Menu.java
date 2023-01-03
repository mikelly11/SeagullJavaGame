import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
    }
    public void mouseReleased(MouseEvent e){

    }
//    private boolean mouseOver(int mx, int my, int width, int height){
//
//    }
    public void tick(){

    }
    public void render(Graphics g){
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);

        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", 240, 70);

        g.setFont(fnt2);
        g.drawRect(210,150,200,64);
        g.drawString("Play", 280, 190);

        g.setColor(Color.white);
        g.drawRect(210,250,200,64);
        g.drawString("Help", 280, 290);

        g.setColor(Color.white);
        g.drawRect(210,350,200,64);
        g.drawString("Quit", 280, 390);
    }
}
