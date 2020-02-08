public class Scene {
    private int cardNum;
    private int budget;
    private Role[] roles;
    private boolean used;

    public Scene(int cardNum, int budget, Role[] roles) {
        //TODO
    }

    public int getBudget() {
        return budget;
    }

    public Role[] getRoles() {
        return roles;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
