import java.util.*;

public class Deadwood {
    private static Queue<Player> players = new LinkedList<Player>();
    private static Board board;

    public static void main(String[] args){
        int playerNum = 0;

        if (args.length != 1){
            System.out.println ("Incorrect number of arguments! Please input number of players");
            System.exit(1);
        }
        try{
            playerNum = Integer.parseInt((args[0]));
            if(playerNum < 2 || playerNum > 8){
                System.out.println("Incorrect number of players, Deadwood must be played with 2 to 8 players");
                System.exit(1);
            }
        }
        catch(NumberFormatException e){
            System.out.println("Incorrect input type! Please input number of players");
            System.exit(1);
        }

        System.out.println("Welcome to DEADWOOD!");

        //Set up players and game
        if(playerNum == 2 || playerNum == 3){
            board = new Board(3);
        }
        else{
            board = new Board(4);
        }

        int credit = 0;
        int rank = 1;

        switch(playerNum){
            case 5:
                credit = 2;
                break;
            case 6:
                credit = 4;
                break;
            case 7:
            case 8:
                rank = 2;
                break;
        }

        String name = "";
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < playerNum; i++){
            System.out.print("Enter the name for Player " + (i+1) +"\n");
            name = input.next();
            players.add(new Player(name, credit, rank, board.getTrailer()));
        }
        startGame();
    }

    //main game loop
    private static void startGame(){

        while(board.getDays() > 0){
            System.out.println(board.getDays() + " DAY(S) LEFT!");
            while (board.getActiveScenes() > 1){
                Player currentPlayer = players.poll();
                System.out.println("It is now " + currentPlayer.getName() +"'s turn");
                players.add(currentPlayer);
                IO.takeTurn(currentPlayer, players);
            }
            board.updateDays();
            if(board.getDays() > 0){
                board.resetBoard();
                System.out.println("Day is over, all players are returning to Trailers");
                for(Player player : players){
                    player.setRoom(board.getTrailer());
                }
            }
        }
        System.out.println("Last day is now over\nGAME OVER!");
        endGame();
    }

    //calculates the scores, announces winners, and ends game
    private static void endGame(){
        HashMap<Player,Integer> scores = new HashMap<Player,Integer>();
        ArrayList<Player> winner = new ArrayList<Player>();
        int highScore = 0;

        //calculate scores and find highest score
        for(Player player : players){
            Player current = player;
            int score = (current.getCredit()) + (current.getMoney()) + (5 * current.getRank());
            scores.put(current, score);
            if(score > highScore){
                highScore = score;
            }
        }

        //finds players with the highest score
        for(Player player : scores.keySet()){
            System.out.println(player.getName() + ": " + scores.get(player));
            if(scores.get(player) == highScore){
                winner.add(player);
            }
        }

        //prints results to terminal
        if(winner.size() > 1){
            System.out.println("Its a Tie!");
            for(Player player : winner){
                System.out.print(player.getName() + " ");
            }
            System.out.print("won!");
        }else{
            System.out.println(winner.get(0).getName() + " won!");
        }
    }
}
