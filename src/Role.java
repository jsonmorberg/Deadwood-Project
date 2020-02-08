public class Role {
    private String name;
    private boolean extra;
    private String actor;
    private int rank;
    private boolean taken;

    public Role(String name, boolean extra, int rank) {
        //TODO
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return extra;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getRank() {
        return rank;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
