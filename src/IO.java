import java.util.*;

/** Class that handles User Input and Output **/

public class IO {
    private static CastingOffice office = new CastingOffice();

    public static void takeTurn(Player currentPlayer, Queue<Player> players){

        //flags and scanner object
        Scanner input = new Scanner(System.in);
        boolean working = currentPlayer.isOnRole();
        boolean worked = false;
        boolean moved = false;

        boolean loop = true;
        while (loop) {
            String choice = input.nextLine();

            //move
            if(choice.toLowerCase().equals("move")){
                if(working == true){
                    System.out.println("You are currently working the role " + currentPlayer.getRole().getName() + ", you cannot leave your job!");
                }else {
                    if (moved == false) {
                        //list adjacent rooms
                        MovieSet[] choices = currentPlayer.getRoom().getAdjRooms();
                        System.out.println("Here are the rooms you can move to:");
                        for (int i = 0; i < choices.length; i++) {
                            String status = "";
                            if (choices[i].isActive()) {
                                status = "(Active)";
                            } else {
                                status = "(Unactive)";
                            }
                            System.out.println("\t" + (i + 1) + ". " + choices[i].getName() + " " + status);
                        }
                        System.out.println("\t" + (choices.length + 1) + ". Go Back");

                        //loop for user input to pick
                        boolean choiceLoop = true;
                        while (choiceLoop) {
                            try {
                                int roomChoice = input.nextInt();
                                if (roomChoice < 1 || roomChoice > (choices.length + 1)) {
                                } else if (roomChoice == choices.length + 1) {
                                    System.out.println("You've decided not to move");
                                    choiceLoop = false;
                                    input.nextLine();
                                } else {
                                    System.out.println("You've moved from " + currentPlayer.getRoom().getName() + " to " + choices[roomChoice - 1].getName());
                                    currentPlayer.move(choices[roomChoice - 1]);
                                    choiceLoop = false;
                                    moved = true;
                                    input.nextLine();

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input type! Try again!");
                                input.nextLine();
                            }
                        }
                    } else {
                        System.out.println("You've already moved this turn!");
                    }
                }

            //act
            }else if(choice.toLowerCase().equals("act")){
                if(working == true){
                    if(moved == false){
                        if(worked == false){
                            currentPlayer.act();
                            working = currentPlayer.isOnRole();
                            worked = true;
                        }else{
                            System.out.println("You've already worked this turn!");
                        }
                    }else{
                        System.out.println("You just got here! You can work next turn!");
                    }
                }else{
                    System.out.println("You don't have a role to act!");
                }

            //rehearse
            }else if(choice.toLowerCase().equals("rehearse")){
                if(working == true){
                    if(moved == false){
                        if(worked == false){
                            if(currentPlayer.getRehearsal() < 5){
                                currentPlayer.rehearsal();
                                System.out.println("You rehearse your lines and receive a rehearsal token! You currently have " + currentPlayer.getRehearsal() + " token(s)!");
                                worked = true;
                            }else{
                                System.out.println("You've rehearsed 5 times for this part! You must act!");
                            }
                        }else{
                            System.out.println("You've already worked this turn!");
                        }
                    }else{
                        System.out.println("You just got here! You can work next turn!");
                    }
                }else{
                    System.out.println("You're not currently working! You can't rehearse!");
                }


            //upgrade
            }else if(choice.toLowerCase().equals("upgrade")){
                if(currentPlayer.getRoom().getName().equals("Casting Office")) {
                    int[][] prices = office.getCosts();
                    int[][] options = new int[5][3];

                    //displays upgrade options
                    System.out.println("Here are the Ranks you can purchase! ");
                    int moneyCount = 0;
                    int creditCount = 0;
                    int upgrade = 0;
                    HashMap<Integer, int[]> choices = new HashMap<>();
                    for (int i = 0; i < prices.length; i++) {
                        if (currentPlayer.getRank() < prices[i][0]) {
                            if (currentPlayer.getCredit() >= prices[i][2]) {
                                upgrade++;
                                System.out.println("\t" + upgrade + ". Rank " + prices[i][0] + " with " + prices[i][2] + " credits.");
                                options[creditCount][0] = prices[i][0];
                                options[creditCount][1] = 0;
                                options[creditCount][2] = prices[i][2];
                                creditCount++;
                                choices.put(upgrade, new int[]{0, prices[i][0], prices[i][2]});
                            }
                            if (currentPlayer.getMoney() >= prices[i][1]) {
                                upgrade++;
                                System.out.println("\t" + upgrade + ". Rank " + prices[i][0] + " with " + prices[i][1] + " dollars.");
                                options[moneyCount][0] = prices[i][0];
                                options[moneyCount][1] = prices[i][1];
                                options[moneyCount][2] = 0;
                                moneyCount++;
                                choices.put(upgrade, new int[]{1, prices[i][0], prices[i][1]});
                            }
                        }
                    }
                    upgrade++;
                    System.out.println("\t" + upgrade + ". Go Back");

                    //loop for user input
                    boolean choiceLoop = true;
                    while (choiceLoop) {
                        try {
                            int upgradeChoice = input.nextInt();
                            if (upgradeChoice < 1 || upgradeChoice > upgrade) {
                                //bad
                            } else if (upgradeChoice == upgrade) {
                                System.out.println("You have decided to not upgrade.");
                                input.nextLine();
                                choiceLoop = false;
                            } else {
                                office.upgrade(choices.get(upgradeChoice), currentPlayer);
                                System.out.println("You have now upgraded to rank " + currentPlayer.getRank() + ", you have " + currentPlayer.getMoney() + " money and " + currentPlayer.getCredit() + " credits");
                                input.nextLine();
                                choiceLoop = false;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect input type! Try again!");
                            input.nextLine();
                        }
                    }
                } else
                    System.out.println("You are not currently at the Casting Office, you are at " + currentPlayer.getRoom().getName());

            //take a roll
            }else if(choice.toLowerCase().equals("take role") || choice.toLowerCase().equals("take a role")){
                if(working == true){
                    System.out.println("You are currently working the role " + currentPlayer.getRole().getName() + ", you cannot leave your job!");
                }else if(currentPlayer.getRoom().getName().equals("Casting Office") || currentPlayer.getRoom().getName().equals("Trailer")){
                    System.out.println("You can't act in the Casting Office or Trailers!");
                }else if(currentPlayer.getRoom().isActive() == false){
                    System.out.println("The room you are currently in has already shot all their scenes!");
                }else{

                    //filter roles
                    ArrayList<Role> roomRoles = currentPlayer.getRoom().getRoles();
                    ArrayList<Role> sceneRoles = currentPlayer.getRoom().getScene().getRoles();
                    ArrayList<Role> availableRoomRoles = new ArrayList<Role>();
                    ArrayList<Role> availableSceneRoles = new ArrayList<Role>();

                    for(Role role : roomRoles){
                        if(currentPlayer.getRank() >= role.getRank() && !role.isTaken()){
                            availableRoomRoles.add(role);
                        }
                    }

                    for(Role role : sceneRoles){
                        if(currentPlayer.getRank() >= role.getRank() && !role.isTaken()){
                            availableSceneRoles.add(role);
                        }
                    }

                    //displays appropriate options
                    if(availableRoomRoles.size() + availableSceneRoles.size() > 0){
                        int roleChoice = 0;
                        HashMap<Integer, Role> roleOptions = new HashMap<Integer, Role>();
                        System.out.println("Here are the roles you can choose from! \n");
                        if(availableRoomRoles.size() > 0){
                            for(Role role : availableRoomRoles){
                                roleChoice++;
                                System.out.println(roleChoice + ".  " + role.getName() + "(Extra)" + "\n\tQuote: " + role.getQuote() + "\n\tRank: " + role.getRank() + "\n");
                                roleOptions.put(roleChoice, role);
                            }
                        }
                        if(availableSceneRoles.size() > 0){
                            for(Role role : availableSceneRoles){
                                roleChoice++;
                                System.out.println(roleChoice + ".  " + role.getName() + "(Main)" + "\n\tQuote: " + role.getQuote() + "\n\tRank: " + role.getRank() + "\n");
                                roleOptions.put(roleChoice, role);
                            }
                        }
                        roleChoice++;
                        System.out.println(roleChoice+ ". Go Back");

                        //loop for user input
                        boolean choiceLoop = true;
                        while (choiceLoop) {
                            try {
                                int roleInput = input.nextInt();
                                if (roleInput < 1 || roleInput > roleChoice) {
                                    //bad
                                } else if (roleInput == roleChoice) {
                                    System.out.println("You have decided to not take a role.");
                                    input.nextLine();
                                    choiceLoop = false;
                                } else {
                                    currentPlayer.takeRole(roleOptions.get(roleInput));
                                    currentPlayer.getRole().takeRole();
                                    currentPlayer.getRoom().addActor(currentPlayer);
                                    System.out.println("You are now working the part of " + currentPlayer.getRole().getName());
                                    working = currentPlayer.isOnRole();
                                    input.nextLine();
                                    choiceLoop = false;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input type! Try again!");
                                input.nextLine();
                            }
                        }
                    }else{
                        System.out.println("There are no roles available for you to act!");
                    }
                }

            //end turn
            }else if(choice.toLowerCase().equals(("end turn")) || choice.toLowerCase().equals("end")){
                loop = false;

            //help
            }else if(choice.toLowerCase().equals(("help"))) {
                System.out.println(
                        "move - Displays a list of Rooms you can move into if you are not working, chose room by entering corresponding number\ntake role - " +
                                "Displays available roles in the room you are currently in if you are not already working\nact - Rolls a dice to see if you can" +
                                " take a shot counter off a room, you can only work once per turn\nrehearse - Gives a +1 to dice rolls on that role, you can only " +
                                "work once per turn\nupgrade - Upgrades the player rank at the cost of credit/money, can only upgrade in the Casting Office" +
                                "\nwhere - Displays all current players and their positions\nwho - Displays current active player and their stats\nend - Ends turn ");

            //where
            }else if(choice.toLowerCase().equals("where")) {
                System.out.println("You are currently at " + currentPlayer.getRoom().getName());
                for (Player player : players) {
                    if (!player.getName().equals(currentPlayer.getName())) {
                        System.out.println(player.getName() + " is at " + player.getRoom().getName());
                    }
                }

            //who
            }else if(choice.toLowerCase().equals("who")) {
                System.out.println("Active player is " + currentPlayer.getName() + "\nMoney: " + currentPlayer.getMoney() + "\nCredits: "
                        + currentPlayer.getCredit() + "\nRank: " + currentPlayer.getRank() + "\nRehearsal Tokens: " + currentPlayer.getRehearsal());

            //handles incorrect input
            }else{
                System.out.println("Invalid Input! Please try again (type in HELP for options)");
            }
        }
    }
}
