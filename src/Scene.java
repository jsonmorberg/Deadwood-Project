import java.util.ArrayList;

/** Stores information regarding the various scenes */

public class Scene {
    private int sceneNum;
    private String sceneName;
    private String description;
    private int budget;
    private ArrayList<Role> roles;

    //constructor
    public Scene(int sceneNum, String sceneName, String description, int budget, ArrayList<Role> roles) {
        this.sceneNum = sceneNum;
        this.sceneName = sceneName;
        this.description = description;
        this.budget = budget;
        this.roles = roles;
    }

    public int getSceneNum() {
        return this.sceneNum;
    }

    public String getSceneName() {
        return this.sceneName;
    }

    public String getDescription() {
        return this.description;
    }

    public int getBudget() {
        return this.budget;
    }

    public ArrayList<Role> getRoles() {
        return this.roles;
    }
}
