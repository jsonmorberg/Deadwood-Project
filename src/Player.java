
/** Stores information regarding Player information and performs acting and rehearsal tasks */

public class Player {
    private String name;
    private int money = 0;
    private int credit;
    private int rank;
    private Role role;
    private MovieSet room;
    private int rehearsal;
    private boolean onRole = false;


    public Player(String name, int credit, int rank, MovieSet room) {
        this.name = name;
        this.credit = credit;
        this.rank = rank;
        this.room = room;
    }

    //move player to a new destination
    public void move(MovieSet choice) {
        this.room = choice;
    }

    public void rehearsal() {
        this.rehearsal++;
    }

    //take role
    public void takeRole(Role role){
        this.role = role;
        this.onRole = true;
    }

    //remove from working
    public void discardRole(){
        this.role = null;
        this.onRole = false;
    }

    public void setRoom(MovieSet room) {
        this.room = room;
    }

    public int getMoney() {
        return money;
    }

    public Role getRole() {
        return role;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public MovieSet getRoom() {
        return room;
    }

    public int getRehearsal() {
        return rehearsal;
    }

    public void resetRehearsal() {
        rehearsal = 0;
    }

    public boolean isOnRole() {
        return onRole;
    }

    public String getName() {
        return name;
    }
}
