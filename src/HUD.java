import java.awt.*;

public class HUD {
    public static int HEALTH = 100;
    private int greenValue = 255;

    public int score = 0;
    public int level = 1;

    public void tick(){
        // HEALTH --;
        HEALTH = (int) Game.clamp(HEALTH, 0, 100);
        greenValue = (int) Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        score++;
    }
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15,15,200,32);
//        g.setColor(Color.green);
        g.setColor(new Color(100, greenValue, 0));
        g.fillRect(15,15,HEALTH*2,32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);

        g.drawString("Score: " +  score, 15, 64);
        g.drawString("Level:  " +  level, 15, 86);
    }
    public void score(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
}
