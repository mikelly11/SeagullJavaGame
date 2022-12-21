import javax.swing.*;
import java.awt.*;

public class Window extends Canvas{
    private static final long serialVersionUID = 7559246019720071796L;
    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));
        // X button working. If you don't have and exit it wont stop game operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Can't resize window
        frame.setResizable(false);
        // Not needed but window would be in top left. This makes it be center
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        //Running that start method.
        game.start();
    }
}
