package GUI;

import java.util.ArrayList;
import java.util.Random;

/** Generates scenes using the Parser.class and keeps an array that can randomly generate all 40 scenes for the board */

import org.w3c.dom.Document;

public class SceneGenerator {
    private ArrayList<SceneCard> scenes; //NOTE: Scene array will be generated from XML

    //constructor uses Parser.class to look through XML
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

    //Returns a brand new scene and removes it from the generation array
    public SceneCard getScene(){
        int randNum = roll();
        SceneCard scene = scenes.remove(randNum);
        return scene;
    }

    private int roll(){
        Random rand = new Random();
        int n = rand.nextInt(scenes.size());
        return n;
    }
}
