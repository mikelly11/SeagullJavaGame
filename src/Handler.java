import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();
    public void tick(){
        // this is for looping through every single one of the Game Objects
        for(int i=0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
        }
    }
//    public void render(Graphics g){
//    }

}
