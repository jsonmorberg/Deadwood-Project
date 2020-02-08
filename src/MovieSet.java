public class MovieSet {
    private int setNum;
    private int[] adjRooms;
    private String name;
    private Scene scene;
    private boolean faceUp;
    private int shotCount;
    private int shotMax;

    public MovieSet(int setNum, int[] adjRooms, String name, int shotCount, int shotMax) {
        //TODO
    }

    public int getSetNum() {
        return setNum;
    }

    public int[] getAdjRooms() {
        return adjRooms;
    }

    public String getName() {
        return name;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        //TODO
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public int getShotCount() {
        return shotCount;
    }

    public void updateShotCount(int shotCount) {
        //TODO
    }

    public int getShotMax() {
        return shotMax;
    }
}
