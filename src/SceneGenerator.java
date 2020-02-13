import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.w3c.dom.Document;

public class SceneGenerator {
    private ArrayList<Scene> scenes; //NOTE: Scene array will be generated from XML

    public SceneGenerator(){
        Document doc = null;
        Parser parsing = new Parser();
        try{
            doc = parsing.getDocFromFile("cards.xml");
            scenes = parsing.readCardData(doc);
        }catch (Exception e){
            System.out.println("Error = " + e);
        }
    }

    private int roll(){
        Random rand = new Random();
        int n = rand.nextInt(scenes.size());
        return n;
    }

    public Scene getScene(){
        int randNum = roll();
        Scene scene = scenes.get(randNum);
        return scene;
    }

    public void removeScene(int sceneNum){
        Iterator<Scene> scan = this.scenes.iterator();
        boolean flag = true;
        while (flag){
            Scene scene = scan.next();
            if(scene.getSceneNum() == sceneNum){
                scan.remove();
                flag = false;
            }
        }
    }
}
