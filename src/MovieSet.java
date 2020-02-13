import java.util.ArrayList;

public class MovieSet {
    private MovieSet[] adjRooms;
    private ArrayList<Role> roles;
    private String name;
    private Scene scene;
    private int shotCount = 0;
    private int shotMax;


    public MovieSet(String name, int shotMax, ArrayList<Role> roles) {
        this.name = name;
        this.shotMax = shotMax;
        this.roles = roles;
    }

    public MovieSet[] getAdjRooms() {
        return adjRooms;
    }

    public void setAdjRooms(MovieSet[] rooms){
        this.adjRooms = rooms;
    }

    public String getName() {
        return name;
    }

    public Scene getScene() {
        return scene;
    }

    public int getShotCount() {
        return shotCount;
    }

    public void updateShotCount() {
        //TODO
    }

    public void endMovieSet(){
        //TODO
    }

    public int getShotMax() {
        return shotMax;
    }

    public void resetRoom(Scene scene){
        this.shotCount = 0;
        this.scene = scene;
        for(Role role : this.roles){
            role.leaveRole();
        }
    }
}
