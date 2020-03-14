package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StartUpController implements Initializable {
    ObservableList list = FXCollections.observableArrayList();

    @FXML private Button next;

    @FXML
    private ChoiceBox<String> choices;

    @FXML private Text etc;

    @FXML private TextField player1;
    @FXML private TextField player2;
    @FXML private TextField player3;
    @FXML private TextField player4;
    @FXML private TextField player5;
    @FXML private TextField player6;
    @FXML private TextField player7;
    @FXML private TextField player8;

    @FXML private Button start1;
    @FXML private Button start2;
    @FXML private Button start3;
    @FXML private Button start4;
    @FXML private Button start5;
    @FXML private Button start6;
    @FXML private Button start7;

    private void loadData(){
        list.removeAll(list);
        String a = "2";
        String b = "3";
        String c = "4";
        String d = "5";
        String e = "6";
        String f = "7";
        String g = "8";
        list.addAll(a,b,c,d,e,f,g);
        choices.getItems().addAll(list);
        choices.setValue("2");
    }
    @FXML
    private void nextButton(ActionEvent event){
        etc.setVisible(false);
        choices.setVisible(false);
        choices.setDisable(true);
        next.setVisible(false);
        next.setDisable(true);


        if(choices.getValue().equals("2")){
            player1.setVisible(true);
            player2.setVisible(true);
            start1.setVisible(true);

        }else if(choices.getValue().equals("3")){
            player1.setVisible(true);
            player2.setVisible(true);
            player3.setVisible(true);
            start2.setVisible(true);


        }else if(choices.getValue().equals("4")){
            player1.setVisible(true);
            player2.setVisible(true);
            player3.setVisible(true);
            player4.setVisible(true);
            start3.setVisible(true);

        }else if(choices.getValue().equals("5")){
            player1.setVisible(true);
            player2.setVisible(true);
            player3.setVisible(true);
            player4.setVisible(true);
            player5.setVisible(true);
            start4.setVisible(true);

        }else if(choices.getValue().equals("6")){
            player1.setVisible(true);
            player2.setVisible(true);
            player3.setVisible(true);
            player4.setVisible(true);
            player5.setVisible(true);
            player6.setVisible(true);
            start5.setVisible(true);

        }else if(choices.getValue().equals("7")){
            player1.setVisible(true);
            player2.setVisible(true);
            player3.setVisible(true);
            player4.setVisible(true);
            player5.setVisible(true);
            player6.setVisible(true);
            player7.setVisible(true);
            start6.setVisible(true);

        }else if(choices.getValue().equals("8")){
            player1.setVisible(true);
            player2.setVisible(true);
            player3.setVisible(true);
            player4.setVisible(true);
            player5.setVisible(true);
            player6.setVisible(true);
            player7.setVisible(true);
            player8.setVisible(true);
            start7.setVisible(true);

        }
    }

    @FXML
    private void startOne(){
        ArrayList<String> players = new ArrayList<String>();
        players.add(player1.getText());
        players.add(player2.getText());
        Stage stage = (Stage) start1.getScene().getWindow();
        stage.close();
        Deadwood.setUp(players);
    }

    @FXML
    private void startTwo(){
        ArrayList<String> players = new ArrayList<String>();
        players.add(player1.getText());
        players.add(player2.getText());
        players.add(player3.getText());
        Stage stage = (Stage) start2.getScene().getWindow();
        stage.close();
        Deadwood.setUp(players);
    }

    @FXML
    private void startThree(){
        ArrayList<String> players = new ArrayList<String>();
        players.add(player1.getText());
        players.add(player2.getText());
        players.add(player3.getText());
        players.add(player4.getText());
        Stage stage = (Stage) start3.getScene().getWindow();
        stage.close();
        Deadwood.setUp(players);
    }

    @FXML
    private void starFour(){
        ArrayList<String> players = new ArrayList<String>();
        players.add(player1.getText());
        players.add(player2.getText());
        players.add(player3.getText());
        players.add(player4.getText());
        players.add(player5.getText());
        Stage stage = (Stage) start4.getScene().getWindow();
        stage.close();
        Deadwood.setUp(players);

    }

    @FXML
    private void startFive(){
        ArrayList<String> players = new ArrayList<String>();
        players.add(player1.getText());
        players.add(player2.getText());
        players.add(player3.getText());
        players.add(player4.getText());
        players.add(player5.getText());
        players.add(player6.getText());
        Stage stage = (Stage) start5.getScene().getWindow();
        stage.close();
        Deadwood.setUp(players);

    }

    @FXML
    private void startSix(){
        ArrayList<String> players = new ArrayList<String>();
        players.add(player1.getText());
        players.add(player2.getText());
        players.add(player3.getText());
        players.add(player4.getText());
        players.add(player5.getText());
        players.add(player6.getText());
        players.add(player7.getText());
        Stage stage = (Stage) start6.getScene().getWindow();
        stage.close();
        Deadwood.setUp(players);
    }

    @FXML
    private void startSeven(){
        ArrayList<String> players = new ArrayList<String>();
        players.add(player1.getText());
        players.add(player2.getText());
        players.add(player3.getText());
        players.add(player4.getText());
        players.add(player5.getText());
        players.add(player6.getText());
        players.add(player7.getText());
        players.add(player8.getText());
        Stage stage = (Stage) start7.getScene().getWindow();
        stage.close();
        Deadwood.setUp(players);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }
}
