package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Queue;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class BoardController {

    private static Queue<Player> players;
    private static Board board;
    private static Player current;

    @FXML private Button trailer;

    @FXML private Button train;

    @FXML private Button casting;

    @FXML private Button general;

    @FXML private Button secret;

    @FXML private Button hotel;

    @FXML private Button saloon;

    @FXML private Button jail;

    @FXML private Button ranch;

    @FXML private Button church;

    @FXML private Button main;

    @FXML private Button bank;

    @FXML private TextArea name;

    @FXML private TextArea rank;

    @FXML private TextArea money;

    @FXML private TextArea credit;

    @FXML private TextArea rehearsal;

    @FXML private Button start;

    @FXML private Button move;

    @FXML private Button upgrade;

    @FXML private Button act;

    @FXML private Button rehearse;

    @FXML private Button takeRole;

    @FXML private Button endTurn1;

    @FXML private Button endTurn2;

    @FXML private Button quit;

    @FXML private TextArea output;



    @FXML
    private void startGame(ActionEvent event){
        buttonViewOne();
        start.setVisible(false);
        start.setDisable(true);

        board = Deadwood.getBoard();
        current = Deadwood.getPlayer();
        name.setText(current.getName());
        rank.setText(String.valueOf(current.getRank()));
        money.setText(String.valueOf(current.getMoney()));
        credit.setText(String.valueOf(current.getCredit()));
        rehearsal.setText(String.valueOf(current.getRehearsal()));

        output.appendText("\nIt is " + current.getName() + "'s turn!");
    }


    @FXML
    private void moveButton(ActionEvent event) {

        move.setDisable(true);
        upgrade.setDisable(true);
        endTurn1.setDisable(true);
        takeRole.setDisable(true);

        MovieSet currentRoom = current.getRoom();
        if(currentRoom.getName().equals("Train Station")){
            casting.setVisible(true);
            casting.setDisable(false);
            casting.toFront();

            jail.setVisible(true);
            jail.setDisable(false);
            jail.toFront();

        }else if(currentRoom.getName().equals("Secret Hideout")){{
            casting.setVisible(true);
            casting.setDisable(false);
            casting.toFront();

            ranch.setVisible(true);
            ranch.setDisable(false);
            ranch.toFront();

            church.setVisible(true);
            church.setDisable(false);
            church.toFront();
        }

        }else if(currentRoom.getName().equals("Church")){
            secret.setVisible(true);
            secret.setDisable(false);
            secret.toFront();

            bank.setVisible(true);
            bank.setDisable(false);
            bank.toFront();

            hotel.setVisible(true);
            hotel.setDisable(false);
            hotel.toFront();

        }else if(currentRoom.getName().equals("Hotel")){
            church.setVisible(true);
            church.setDisable(false);
            church.toFront();

            bank.setVisible(true);
            bank.setDisable(false);
            bank.toFront();

            trailer.setVisible(true);
            trailer.setDisable(false);
            trailer.toFront();


        }else if(currentRoom.getName().equals("General Store")){
            jail.setVisible(true);
            jail.setDisable(false);
            jail.toFront();

            ranch.setVisible(true);
            ranch.setDisable(false);
            ranch.toFront();

            saloon.setVisible(true);
            saloon.setDisable(false);
            saloon.toFront();

            train.setVisible(true);
            train.setDisable(false);
            train.toFront();

        }else if(currentRoom.getName().equals("Ranch")){
            casting.setVisible(true);
            casting.setDisable(false);
            casting.toFront();

            general.setVisible(true);
            general.setDisable(false);
            general.toFront();

            secret.setVisible(true);
            secret.setDisable(false);
            secret.toFront();

            bank.setVisible(true);
            bank.setDisable(false);
            bank.toFront();



        }else if(currentRoom.getName().equals("Bank")){

            ranch.setVisible(true);
            ranch.setDisable(false);
            ranch.toFront();

            saloon.setVisible(true);
            saloon.setDisable(false);
            saloon.toFront();

            church.setVisible(true);
            church.setDisable(false);
            church.toFront();

            hotel.setVisible(true);
            hotel.setDisable(false);
            hotel.toFront();


        }else if(currentRoom.getName().equals("Saloon")){
            general.setVisible(true);
            general.setDisable(false);
            general.toFront();

            bank.setVisible(true);
            bank.setDisable(false);
            bank.toFront();

            trailer.setVisible(true);
            trailer.setDisable(false);
            trailer.toFront();

            main.setVisible(true);
            main.setDisable(false);
            main.toFront();

        }else if(currentRoom.getName().equals("Main Street")){
            saloon.setVisible(true);
            saloon.setDisable(false);
            saloon.toFront();

            trailer.setVisible(true);
            trailer.setDisable(false);
            trailer.toFront();

            jail.setVisible(true);
            jail.setDisable(false);
            jail.toFront();


        }else if(currentRoom.getName().equals("Trailer")){
            saloon.setVisible(true);
            saloon.setDisable(false);
            saloon.toFront();

            main.setVisible(true);
            main.setDisable(false);
            main.toFront();

            hotel.setVisible(true);
            hotel.setDisable(false);
            hotel.toFront();

        }else if(currentRoom.getName().equals("Casting Office")){
            secret.setVisible(true);
            secret.setDisable(false);
            secret.toFront();

            train.setVisible(true);
            train.setDisable(false);
            train.toFront();

            ranch.setVisible(true);
            ranch.setDisable(false);
            ranch.toFront();
        }else if(currentRoom.getName().equals("Jail")){

            train.setVisible(true);
            train.setDisable(false);
            train.toFront();

            general.setVisible(true);
            general.setDisable(false);
            general.toFront();

            main.setVisible(true);
            main.setDisable(false);
            main.toFront();
        }


    }

    @FXML
    private void moveTrain(ActionEvent event){
        BoardView.moveTrain(current);
        current.move(board.getSets().get(0));

        if(current.getRoom().isVisited() == false){
            BoardView.flipTrain();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();


    }
    @FXML
    private void moveJail(ActionEvent event){
        BoardView.moveJail(current);
        current.move(board.getSets().get(5));

        if(current.getRoom().isVisited() == false){
            BoardView.flipJail();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }
    @FXML
    private void moveGeneral(ActionEvent event){
        BoardView.moveGeneral(current);
        current.move(board.getSets().get(6));

        if(current.getRoom().isVisited() == false){
            BoardView.flipGeneral();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }
    @FXML
    private void moveSecret(ActionEvent event){
        BoardView.moveSecret(current);
        current.move(board.getSets().get(1));

        if(current.getRoom().isVisited() == false){
            BoardView.flipSecret();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }
    @FXML
    private void moveHotel(ActionEvent event){
        BoardView.moveHotel(current);
        current.move(board.getSets().get(3));

        if(current.getRoom().isVisited() == false){
            BoardView.flipHotel();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }
    @FXML
    private void moveSaloon(ActionEvent event){
        BoardView.moveSaloon(current);
        current.move(board.getSets().get(9));

        if(current.getRoom().isVisited() == false){
            BoardView.flipSaloon();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }
    @FXML
    private void moveChurch(ActionEvent event){
        BoardView.moveChurch(current);
        current.move(board.getSets().get(2));

        if(current.getRoom().isVisited() == false){
            BoardView.flipChurch();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }
    @FXML
    private void moveRanch(ActionEvent event){
        BoardView.moveRanch(current);
        current.move(board.getSets().get(7));

        if(current.getRoom().isVisited() == false){
            BoardView.flipRanch();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }
    @FXML
    private void moveMain(ActionEvent event){
        BoardView.moveMain(current);
        current.move(board.getSets().get(4));

        if(current.getRoom().isVisited() == false){
            BoardView.flipMain();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();

    }

    @FXML
    private void moveTrailer(ActionEvent event){
        BoardView.moveTrailer(current);
        current.move(board.getSets().get(10));

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }

    @FXML
    private void moveCasting(ActionEvent event){
        BoardView.moveCasting(current);
        current.move(board.getSets().get(11));

        upgrade.setDisable(false);
        endTurn1.setDisable(false);
        buttonViewThree();
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }

    @FXML
    private void moveBank(ActionEvent event){
        BoardView.moveBank(current);
        current.move(board.getSets().get(8));

        if(current.getRoom().isVisited() == false){
            BoardView.flipBank();
        }

        takeRole.setDisable(false);
        endTurn1.setDisable(false);
        secret.setVisible(false);
        secret.setDisable(true);
        secret.toBack();

        train.setVisible(false);
        train.setDisable(true);
        train.toBack();

        ranch.setVisible(false);
        ranch.setDisable(true);
        ranch.toBack();

        saloon.setVisible(false);
        saloon.setDisable(true);
        saloon.toBack();

        main.setVisible(false);
        main.setDisable(true);
        main.toBack();

        hotel.setVisible(false);
        hotel.setDisable(true);
        hotel.toBack();

        trailer.setVisible(false);
        trailer.setDisable(true);
        trailer.toBack();

        jail.setVisible(false);
        jail.setDisable(true);
        jail.toBack();

        general.setVisible(false);
        general.setDisable(true);
        general.toBack();

        bank.setVisible(false);
        bank.setDisable(true);
        bank.toBack();

        church.setVisible(false);
        church.setDisable(true);
        church.toBack();

        casting.setVisible(false);
        casting.setDisable(true);
        casting.toBack();
    }








    @FXML
    private void upgradeButton(ActionEvent event) {
        System.out.println("Upgrade");

    }

    @FXML
    private void actButton(ActionEvent event) {
        System.out.println("Act");
    }

    @FXML
    private void rehearseButton(ActionEvent event) {
        System.out.println("rehearse");
    }

    @FXML
    private void takeRoleButton(ActionEvent event) {
        ArrayList<Role> roomRoles = current.getRoom().getRoles();
        SceneCard scene = current.getRoom().getScene();

        Role role = RoleView.display(roomRoles, scene, current.getRank());
        current.takeRole(role);
        takeRole.setDisable(true);
    }

    @FXML
    private void endButton(ActionEvent event) {
        current = Deadwood.getPlayer();

        if(current.getRoom().getName().equals("Casting Office")){
            buttonViewThree();
        }

        name.setText(current.getName());
        rank.setText(String.valueOf(current.getRank()));
        money.setText(String.valueOf(current.getMoney()));
        credit.setText(String.valueOf(current.getCredit()));
        rehearsal.setText(String.valueOf(current.getRehearsal()));

        output.appendText("\nIt is " + current.getName() + "'s turn!");

        if(current.getRoom().getName().equals("Casting Office")){
            buttonViewThree();
        }else if(current.isOnRole()){
            buttonViewTwo();
        }else{
            buttonViewOne();
        }
    }

    @FXML
    private void quitButton(ActionEvent event) {
        System.out.println("quit");
    }

    public void buttonViewOne(){
        move.setVisible(true);
        move.setDisable(false);
        takeRole.setVisible(true);
        takeRole.setDisable(false);
        endTurn1.setVisible(true);
        endTurn1.setDisable(false);

        upgrade.setVisible(false);
        upgrade.setDisable(true);
        act.setVisible(false);
        act.setDisable(true);
        rehearse.setVisible(false);
        rehearse.setDisable(true);
        quit.setVisible(false);
        quit.setDisable(true);
        endTurn2.setVisible(false);
        endTurn2.setDisable(true);
    }

    public void buttonViewTwo(){
        act.setVisible(true);
        act.setDisable(false);
        rehearse.setVisible(true);
        rehearse.setDisable(false);
        quit.setVisible(true);
        quit.setDisable(false);
        endTurn2.setVisible(true);
        endTurn2.setDisable(false);

        move.setVisible(false);
        move.setDisable(true);
        takeRole.setVisible(false);
        takeRole.setDisable(true);
        endTurn1.setVisible(false);
        endTurn1.setDisable(true);
        upgrade.setVisible(false);
        upgrade.setDisable(true);
    }

    public void buttonViewThree(){
        move.setVisible(true);
        move.setDisable(false);
        upgrade.setVisible(true);
        upgrade.setDisable(false);
        endTurn1.setVisible(true);
        endTurn1.setDisable(false);

        takeRole.setVisible(false);
        takeRole.setDisable(true);
        act.setVisible(false);
        act.setDisable(true);
        rehearse.setVisible(false);
        rehearse.setDisable(true);
        quit.setVisible(false);
        quit.setDisable(true);
        endTurn2.setVisible(false);
        endTurn2.setDisable(true);
    }
}
