
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
    private Dice dice = new Dice();


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

    //rolls dice to calculate if a player can take off a shot counter
    public void act() {
        Scene scene = this.room.getScene();
        System.out.println("Current Room: " + this.room.getName() + "\nShots left: " + this.room.getShotCount());
        int roll = Dice.roll();
        System.out.println("You rolled a " + roll);

        //Does not meet budget
        if(roll + this.rehearsal < this.room.getScene().getBudget()){
            System.out.println("Scenes budget was " + this.room.getScene().getBudget() + ", your score was " + (roll + this.rehearsal) + " (rehearsal tokens + rolls)\n");
            System.out.println("You did not meet budget, no shots are taken");
            if(this.role.isExtra()){
                this.money++;
                System.out.println("Since you had an Extra role, you receive one dollar, you now have " + this.money);
            }

        //Meets budget
        }else{
            System.out.println("Scenes budget was " + this.room.getScene().getBudget() + ", your score was " + (roll + this.rehearsal) + " (rehearsal tokens + rolls)\n");
            System.out.println("You met budget, so a shot has been taken! " + this.room.getShotCount() + " shots left");
            if(this.role.isExtra()){
                this.credit++;
                this.money++;
                System.out.println("Since you had an Extra role, you receive one dollar and one credit, you now have " + this.money + " dollars and " + this.credit + " credits");

            }else{
                this.credit += 2;
                System.out.println("Since you had a Main role, you receive two credits, you now have " + this.credit + " credits");
            }
            this.room.takeShot();
        }
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
