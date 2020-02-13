import org.w3c.dom.Document;

import java.util.ArrayList;

public class Board {
    private SceneGenerator sceneGenerator = new SceneGenerator();
    private ArrayList<MovieSet> sets;
    private int activeRooms = 10;
    private int rooms = 12;
    private boolean dayOver = false;

    public void createBoard(){
        Document doc = null;
        Parser parsing = new Parser();
        try{
            doc = parsing.getDocFromFile("board.xml");
            sets = parsing.readBoardData(doc);
            sets.add(new MovieSet("Trailer", 0, null));
            sets.add(new MovieSet("Casting Office", 0, null));
        }catch (Exception e){
            System.out.println("Error = " + e);
        }
    }

    public void setAdjRooms(){
        MovieSet[] train = new MovieSet[3];
        train[0] = sets.get(5);
        train[1] = sets.get(6);
        train[2] = sets.get(11);

        MovieSet[] secret = new MovieSet[3];
        secret[0] = sets.get(2);
        secret[1] = sets.get(7);
        secret[2] = sets.get(11);

        MovieSet[] church = new MovieSet[3];
        church[0] = sets.get(1);
        church[1] = sets.get(8);
        church[2] = sets.get(3);

        MovieSet[] hotel = new MovieSet[3];
        hotel[0] = sets.get(10);
        hotel[1] = sets.get(8);
        hotel[2] = sets.get(2);

        MovieSet[] mainSt = new MovieSet[3];
        mainSt[0] = sets.get(10);
        mainSt[1] = sets.get(5);
        mainSt[2] = sets.get(9);

        MovieSet[] jail = new MovieSet[3];
        jail[0] = sets.get(4);
        jail[1] = sets.get(6);
        jail[2] = sets.get(0);

        MovieSet[] general = new MovieSet[4];
        general[0] = sets.get(7);
        general[1] = sets.get(0);
        general[2] = sets.get(5);
        general[3] = sets.get(9);

        MovieSet[] ranch = new MovieSet[4];
        ranch[0] = sets.get(11);
        ranch[1] = sets.get(6);
        ranch[2] = sets.get(1);
        ranch[3] = sets.get(8);

        MovieSet[] bank = new MovieSet[4];
        bank[0] = sets.get(9);
        bank[1] = sets.get(2);
        bank[2] = sets.get(7);
        bank[3] = sets.get(3);

        MovieSet[] saloon = new MovieSet[4];
        saloon[0] = sets.get(4);
        saloon[1] = sets.get(6);
        saloon[2] = sets.get(8);
        saloon[3] = sets.get(10);
    }

    public void resetBoard(){
        activeRooms = 10;
        dayOver = false;
        for (MovieSet set : sets){
            set.resetRoom(sceneGenerator.getScene());
        }
    }

    public boolean isDayOver() {
        return dayOver;
    }

    public int getActiveScenes() {
        return activeRooms;
    }

    public void updateActiveScenes() {
        activeRooms--;
        if(activeRooms == 1){
            dayOver = true;
        }
    }
}
