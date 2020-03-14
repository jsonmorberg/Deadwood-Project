package GUI;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

/* View that calculates and displays winner(s) */


public class EndView {

    public static void display(Queue<Player> players){
        Stage window = new Stage();
        window.initStyle(StageStyle.UTILITY);
        window.initModality(Modality.APPLICATION_MODAL); //locks user to the alert box
        window.setTitle("Upgrade");
        window.setMinWidth(200);
        window.setMinHeight(200);

        TextArea textArea = new TextArea();
        textArea.setEditable(false);

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
            textArea.appendText("\n"+player.getName() + ": " + scores.get(player));
            if(scores.get(player) == highScore){
                winner.add(player);
            }
        }

        //prints results to terminal
        if(winner.size() > 1){
            System.out.println("\n\nIts a Tie!");
            for(Player player : winner){
                textArea.appendText(player.getName() + " ");
            }
            textArea.appendText("all won!");
        }else{
            textArea.appendText("\n\n" + winner.get(0).getName() + " won!");
        }



        VBox vbox = new VBox(textArea);

        Scene scene = new Scene(vbox, 200, 100);
        window.setScene(scene);
        window.showAndWait();



    }
}
