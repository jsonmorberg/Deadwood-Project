import org.w3c.dom.Document;

import java.util.ArrayList;

public class Board {
    private SceneGenerator sceneGenerator = new SceneGenerator();
    private ArrayList<MovieSet> sets;
    private static int activeRooms = 10;
    private int rooms = 12;
    private int days;

    public Board(int days){
        this.days = days;
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

        this.AdjRooms();
    }

    public void AdjRooms(){
        MovieSet[] train = new MovieSet[3];
        train[0] = sets.get(5);
        train[1] = sets.get(6);
        train[2] = sets.get(11);
        sets.get(0).setAdjRooms(train);
        sets.get(0).setScene(sceneGenerator.getScene());

        MovieSet[] secret = new MovieSet[3];
        secret[0] = sets.get(2);
        secret[1] = sets.get(7);
        secret[2] = sets.get(11);
        sets.get(1).setAdjRooms(secret);
        sets.get(1).setScene(sceneGenerator.getScene());

        MovieSet[] church = new MovieSet[3];
        church[0] = sets.get(1);
        church[1] = sets.get(8);
        church[2] = sets.get(3);
        sets.get(2).setAdjRooms(church);
        sets.get(2).setScene(sceneGenerator.getScene());


        MovieSet[] hotel = new MovieSet[3];
        hotel[0] = sets.get(10);
        hotel[1] = sets.get(8);
        hotel[2] = sets.get(2);
        sets.get(3).setAdjRooms(hotel);
        sets.get(3).setScene(sceneGenerator.getScene());

        MovieSet[] mainSt = new MovieSet[3];
        mainSt[0] = sets.get(10);
        mainSt[1] = sets.get(5);
        mainSt[2] = sets.get(9);
        sets.get(4).setAdjRooms(mainSt);
        sets.get(4).setScene(sceneGenerator.getScene());

        MovieSet[] jail = new MovieSet[3];
        jail[0] = sets.get(4);
        jail[1] = sets.get(6);
        jail[2] = sets.get(0);
        sets.get(5).setAdjRooms(jail);
        sets.get(5).setScene(sceneGenerator.getScene());

        MovieSet[] general = new MovieSet[4];
        general[0] = sets.get(7);
        general[1] = sets.get(0);
        general[2] = sets.get(5);
        general[3] = sets.get(9);
        sets.get(6).setAdjRooms(general);
        sets.get(6).setScene(sceneGenerator.getScene());

        MovieSet[] ranch = new MovieSet[4];
        ranch[0] = sets.get(11);
        ranch[1] = sets.get(6);
        ranch[2] = sets.get(1);
        ranch[3] = sets.get(8);
        sets.get(7).setAdjRooms(ranch);
        sets.get(7).setScene(sceneGenerator.getScene());

        MovieSet[] bank = new MovieSet[4];
        bank[0] = sets.get(9);
        bank[1] = sets.get(2);
        bank[2] = sets.get(7);
        bank[3] = sets.get(3);
        sets.get(8).setAdjRooms(bank);
        sets.get(8).setScene(sceneGenerator.getScene());

        MovieSet[] saloon = new MovieSet[4];
        saloon[0] = sets.get(4);
        saloon[1] = sets.get(6);
        saloon[2] = sets.get(8);
        saloon[3] = sets.get(10);
        sets.get(9).setAdjRooms(saloon);
        sets.get(9).setScene(sceneGenerator.getScene());

        MovieSet[] trailer = new MovieSet[3];
        trailer[0] = sets.get(4);
        trailer[1] = sets.get(9);
        trailer[2] = sets.get(3);
        sets.get(10).setAdjRooms(trailer);

        MovieSet[] office = new MovieSet[3];
        office[0] = sets.get(0);
        office[1] = sets.get(7);
        office[2] = sets.get(1);
        sets.get(11).setAdjRooms(office);
    }

    public void resetBoard(){
        activeRooms = 10;
        for (MovieSet set : sets){
            if(!(set.getName().equals("Casting Office") || set.getName().equals("Trailer"))){
                set.resetRoom(sceneGenerator.getScene());
            }

        }
    }

    public int getActiveScenes() {
        return activeRooms;
    }

    public static void updateActiveScenes() {
        activeRooms--;
    }

    public static void endDay(){
        activeRooms = 1;
    }

    public int getDays() {
        return days;
    }

    public void updateDays(){
        days--;
    }

    public MovieSet getTrailer(){
        return sets.get(10);
    } //CHANGE
}
