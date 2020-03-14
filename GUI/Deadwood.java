package GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
        stage.initStyle(StageStyle.UTILITY);
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

    public static Board getBoard(){
        return board;
    }

    public static Player getPlayer(){
        Player player = players.poll();
        players.add(player);
        return player;
    }

    public static Queue<Player> getPlayers(){
        return players;
    }


}
