import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    private int scoreKeep = 0;
    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    public void tick(){
        scoreKeep++;
        if(scoreKeep >= 100){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if(hud.getLevel() == 2){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
//            }else if(hud.getLevel() == 3){
//                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
            }else if(hud.getLevel() == 4){
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
//            }else if(hud.getLevel() == 5){
//                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
            }else if(hud.getLevel() == 6){
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
            }else if(hud.getLevel() == 7){
                handler.addObject(new Cherry(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.Cherry, handler));
            }else if(hud.getLevel() == 8){
                handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }else if(hud.getLevel() == 10){
                handler.clearEnemys();
                handler.addObject(new Boss1(r.nextInt(Game.WIDTH/2),-120, ID.Boss1, handler));
            }else if(hud.getLevel() == 20){
                handler.clearEnemys();
                handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }else if(hud.getLevel() == 22){
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }else if(hud.getLevel() == 24){
                handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }else if(hud.getLevel() == 26){
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }else if(hud.getLevel() == 28){
                handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }
        }
    }
}
