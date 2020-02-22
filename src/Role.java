/** Stores information regarding the various roles */

public class Role {
    private String name;
    private String quote;
    private boolean extra;
    private int rank;
    private boolean taken = false;

    //constructor
    public Role(String name, String quote, boolean extra, int rank) {
        this.name = name;
        this.quote = quote;
        this.extra = extra;
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    public String getName() {
        return this.name;
    }

    public String getQuote() {
        return this.quote;
    }

    public boolean isExtra() {
        return this.extra;
    }

    public boolean isTaken() {
        return this.taken;
    }

    public void takeRole() {
        this.taken = true;
    }

    public void leaveRole(){
        this.taken = false;
    }
}





