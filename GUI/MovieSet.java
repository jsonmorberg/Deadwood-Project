package GUI;

import java.util.*;

/** Stores information regarding the various rooms on the Board */

public class MovieSet {
    private MovieSet[] adjRooms;
    private ArrayList<Role> cardRoles;
    private ArrayList<Player> actors = new ArrayList<Player>();
    private String name;
    private SceneCard scene;
    private int shotCount;
    private int shots;
    private boolean active = true;
    private boolean visited = false;

    //constructor
    public MovieSet(String name, int shotMax, ArrayList<Role> roles) {
        this.name = name;
        this.shots = shotMax;
        this.cardRoles = roles;
        this.shotCount = shotMax;
    }

    public MovieSet[] getAdjRooms() {
        return adjRooms;
    }

    public void addActor(Player player){
        this.actors.add(player);
    }

    public void setAdjRooms(MovieSet[] rooms){
        this.adjRooms = rooms;
    }

    public String getName() {
        return name;
    }

    public SceneCard getScene() {
        return scene;
    }

    public void setScene(SceneCard scene) {
        this.scene = scene;
    }

    public int getShotCount() {
        return shotCount;
    }

    public boolean isActive() {
        return active;
    }

    public ArrayList<Role> getRoles() {
        return cardRoles;
    }

    public void takeShot(){
        this.shotCount--;
    }

    //room has cleared all shots, deal out appropriate bonuses
    public void deactivateRoom() {

        //remove player from all roles
        for(Player player : actors){
            player.getRole().leaveRole();
            player.discardRole();
            player.resetRehearsal();
        }

        //remove player from working on the board
        this.actors.clear();
        this.active = false;
        Board.updateActiveScenes();
    }

    //reset room with new Scene and discard all current working players
    public void resetRoom(SceneCard scene){
        this.shotCount = shots;
        this.scene = scene;
        this.active = true;
        for(Player player: actors){
            player.getRole().leaveRole();
            player.discardRole();
            player.resetRehearsal();
        }
        actors.clear();
    }

    public boolean isVisited(){
        return visited;
    }

    public int getShots(){
        return this.shotCount;
    }

    public ArrayList<Player> getActors(){
        return this.actors;
    }

    public void removeActor(Player player){
        actors.remove(player);
    }
}
