package GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.util.*;

public class Deadwood extends Application {
    private static Queue<Player> players = new LinkedList<Player>();
    private static Board board;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        Stage window = new Stage();
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        Parent root = FXMLLoader.load(getClass().getResource("startup.fxml"));
        Scene deadwood = new Scene(root);
        stage.setScene(deadwood);
        stage.show();

        AnchorPane board = FXMLLoader.load(getClass().getResource("board.fxml"));
        BoardView.setRoot(board);
    }

    public static void setUp(ArrayList<String> player){
        int playerNum = player.size();

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


        for (String name : player){
            players.add(new Player(name, credit, rank, board.getTrailer()));
        }

        try {
            BoardView.initialize(players, board);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
    public static Board getBoard(){
        return board;
    }

    public static Player getPlayer(){
        Player player = players.poll();
        players.add(player);
        return player;
    }


}
