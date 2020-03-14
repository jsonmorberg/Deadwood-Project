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

import java.util.*;

import java.awt.*;
import java.net.URL;


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
        UpgradeView.display(current);
        money.setText(String.valueOf(current.getMoney()));
        credit.setText(String.valueOf(current.getCredit()));
        rank.setText(String.valueOf(current.getRank()));
    }

    @FXML
    private void actButton(ActionEvent event) {

        output.appendText("\n\nCurrent Room: " + current.getRoom().getName() + "\nShots left: " + current.getRoom().getShotCount());
        Random random = new Random();
        int roll = random.nextInt(6) + 1;
        output.appendText("\n\nYou rolled a \" + roll");

        //Does not meet budget
        if(roll + current.getRehearsal() < current.getRoom().getScene().getBudget()){
            output.appendText("\n\nScenes budget was " + current.getRoom().getScene().getBudget() + ", your score was " + (roll + current.getRehearsal()) + " (rehearsal tokens + rolls)\n");
            output.appendText("You did not meet budget, no shots are taken");
            if(current.getRole().isExtra()){
                current.setMoney(current.getMoney() + 1);
                output.appendText("\n\nSince you had an Extra role, you receive one dollar, you now have " + current.getMoney());
            }

            //Meets budget
        }else{
            output.appendText("\n\nScenes budget was " + current.getRoom().getScene().getBudget() + ", your score was " + (roll + current.getRehearsal()) + " (rehearsal tokens + rolls)\n");
            output.appendText("You met budget, so a shot has been taken! " + (current.getRoom().getShotCount()-1) + " shots left");

            if(current.getRole().isExtra()){
                current.setCredit(current.getCredit() + 1);
                current.setMoney(current.getMoney() + 1);
                output.appendText("\nSince you had an Extra role, you receive one dollar and one credit, you now have " + current.getMoney()+ " dollars and " + current.getCredit() + " credits");

            }else{
                current.setCredit(current.getCredit() + 2);
                output.appendText("\nSince you had a Main role, you receive two credits, you now have " + current.getCredit()+ " credits");
            }

            current.getRoom().takeShot();

            if(current.getRoom().getShots() == 0){
                boolean flag = false;

                ArrayList<Player> actors = current.getRoom().getActors();
                ArrayList<Player> main = new ArrayList<Player>();
                ArrayList<Role> roles = current.getRoom().getScene().getRoles();

                output.appendText("\nAll shots are done in " + current.getRoom().getScene().getSceneName());

                //Filter through all main roles in Set for a main character
                for (int i = 0; i < roles.size(); i++) {
                    if (roles.get(i).isTaken()) {
                        flag = true;
                    }
                }

                //main role found
                if (flag) {
                    output.appendText("\nThere was at least one Player who had a main role, bonus will be distributed!");
                    for (Player player : actors) {
                        //Bonuses for Extras
                        if (player.getRole().isExtra()) {
                            output.appendText("\n\n" + player.getName() + " had an extra role with rank " + player.getRole().getRank() + ", so they get " + player.getRole().getRank() + " dollar(s)");
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
                    int diceNum = current.getRoom().getScene().getBudget();
                    Random rand = new Random();
                    ArrayList<Integer> diceRolls = new ArrayList<Integer>();
                    for (int i = 0; i < diceNum; i++) {
                        diceRolls.add(rand.nextInt(6) + 1);
                    }
                    Collections.sort(diceRolls, Collections.reverseOrder());
                    output.appendText("\n\nThis scene had a budget of " + diceNum + ", Bonuses rolled were " + Arrays.toString(diceRolls.toArray()));


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
                                output.appendText("\n\n" + player.getName() + " just got " + bonuses.get(role));
                                player.setMoney(player.getMoney() + bonuses.get(role));
                            }
                        }
                    }

                }else{
                    output.appendText("\n\nThere were no Players with main roles, so there are no bonuses");
                }
                current.getRoom().deactivateRoom();
            }

        }
        rehearse.setDisable(true);
        act.setDisable(true);
        money.setText(String.valueOf(current.getMoney()));
        credit.setText(String.valueOf(current.getCredit()));
    }

    @FXML
    private void rehearseButton(ActionEvent event) {
        current.rehearsal();
        rehearsal.setText(String.valueOf(current.getRehearsal()));
        rehearse.setDisable(true);
        act.setDisable(true);
    }

    @FXML
    private void takeRoleButton(ActionEvent event) {
        ArrayList<Role> roomRoles = current.getRoom().getRoles();
        SceneCard scene = current.getRoom().getScene();

        Role role = RoleView.display(roomRoles, scene, current.getRank());
        if(role != null){
            current.takeRole(role);
            role.takeRole();
            current.getRoom().addActor(current);
            takeRole.setDisable(true);
            move.setDisable(true);
            System.out.println(role.getName());
        }

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
