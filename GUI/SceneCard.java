package GUI;

import java.util.ArrayList;

/** Stores information regarding the various scenes */

public class SceneCard {
    private int sceneNum;
    private String sceneName;
    private String description;
    private int budget;
    private ArrayList<Role> roles;
    private String jpg;

    //constructor
    public SceneCard(int sceneNum, String sceneName, String description, int budget, ArrayList<Role> roles, String jpg) {
        this.sceneNum = sceneNum;
        this.sceneName = sceneName;
        this.description = description;
        this.budget = budget;
        this.roles = roles;
        this.jpg = jpg;
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

    public String getJpg(){
        return this.jpg;
    }
}
