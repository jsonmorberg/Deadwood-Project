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
        if(shotCount < 1){
            this.deactivateRoom();
        }
    }

    //room has cleared all shots, deal out appropriate bonuses
    public void deactivateRoom() {
        boolean flag = false;

        ArrayList<Player> current = this.actors;
        ArrayList<Player> main = new ArrayList<Player>();
        ArrayList<Role> roles = this.scene.getRoles();

        System.out.println("All shots are done in " + this.name);

        //Filter through all main roles in Set for a main character
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).isTaken()) {
                flag = true;
            }
        }

        //main role found
        if (flag) {
            System.out.println("There was at least one Player who had a main role, bonus will be distributed!");
            for (Player player : current) {
                //Bonuses for Extras
                if (player.getRole().isExtra()) {
                    System.out.println(player.getName() + " had an extra role with rank " + player.getRole().getRank() + ", so they get " + player.getRole().getRank() + " dollar(s)");
                    player.setMoney(player.getMoney() + player.getRole().getRank());
                }else{
                    main.add(player);
                }
            }

            Queue<Role> sortedRoles = new LinkedList<Role>();
            while(roles.size() > 0) {
                Role largestRank = roles.get(0);
                for (Role role : roles){
                    if(role.getRank() > largestRank.getRank()){
                        largestRank = role;
                    }
                }
                sortedRoles.add(largestRank);
                roles.remove(largestRank);
            }


            //roll dice for bonuses
            int diceNum = this.scene.getBudget();
            Random rand = new Random();
            ArrayList<Integer> diceRolls = new ArrayList<Integer>();
            for (int i = 0; i < diceNum; i++) {
                diceRolls.add(rand.nextInt(6) + 1);
            }
            Collections.sort(diceRolls, Collections.reverseOrder());
            System.out.println();
            System.out.println("This scene had a budget of " + diceNum + ", Bonuses rolled were " + Arrays.toString(diceRolls.toArray()));


            //deal out bonuses for each main player
            HashMap<Role, Integer> bonuses = new HashMap<Role, Integer>();
            for(Role role : sortedRoles){
                bonuses.put(role, 0);
            }

            for(int bonus : diceRolls){
                Role role = sortedRoles.poll();
                bonuses.put(role, bonuses.get(role) + bonus);
                sortedRoles.add(role);
            }

            for(Role role : bonuses.keySet()){
                for(Player player : main){
                    if(player.getRole().equals(role)){
                        System.out.println(player.getName() + " just got " + bonuses.get(role));
                        player.setMoney(player.getMoney() + bonuses.get(role));
                    }
                }
            }



        }else{
            System.out.println("There were no Players with main roles, so there are no bonuses");
        }

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
}
