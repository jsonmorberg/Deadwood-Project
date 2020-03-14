package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class StartUp {

    private static int playerNum;

    public static boolean display(String title, StackPane root){
        Stage window = new Stage();
        //window.initModality(Modality.APPLICATION_MODAL); //locks user to the alert box
        window.setTitle(title);

        /**

        //Create two buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });
        */

        Button button = new Button("START");
        ChoiceBox<Integer> choice = new ChoiceBox<>();
        choice.getItems().addAll( 2, 3, 4, 5, 6, 7, 8);
        choice.getSelectionModel().select(0);

        button.setOnAction(event -> {
            playerNum = choice.getValue();
        });

        root.getChildren().add(choice);
        root.getChildren().add(button);

        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait(); //needs to be closed before returning
        System.out.println(playerNum);
        return true;
    }
}