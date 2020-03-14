package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/* View window for upgrade choices */

public class UpgradeView {

    public static void display(Player player){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //locks user to the alert box
        window.setTitle("Upgrade");
        window.setMinWidth(200);
        window.setMinHeight(200);

        Button rank2Money = new Button("$4");
        Button rank3Money = new Button("$10");
        Button rank4Money = new Button("$18");
        Button rank5Money = new Button("$28");
        Button rank6Money = new Button("$40");

        Button rank2Credit = new Button("5");
        Button rank3Credit = new Button("10");
        Button rank4Credit = new Button("15");
        Button rank5Credit = new Button("20");
        Button rank6Credit = new Button("25");

        rank2Money.setOnAction(e->{
            CastingOffice.upgrade(new int[]{1, 2, 4}, player);
            window.close();
        });

        rank3Money.setOnAction(e->{
            CastingOffice.upgrade(new int[]{1, 3, 10}, player);
            window.close();
        });

        rank4Money.setOnAction(e->{
            CastingOffice.upgrade(new int[]{1, 4, 18}, player);
            window.close();
        });

        rank5Money.setOnAction(e->{
            CastingOffice.upgrade(new int[]{1, 5, 28}, player);
            window.close();
        });

        rank6Money.setOnAction(e->{
            CastingOffice.upgrade(new int[]{1, 6, 40}, player);
            window.close();
        });

        rank2Credit.setOnAction(e->{
            CastingOffice.upgrade(new int[]{0, 2, 5}, player);
            window.close();
        });

        rank3Credit.setOnAction(e->{
            CastingOffice.upgrade(new int[]{0, 3, 10}, player);
            window.close();
        });

        rank4Credit.setOnAction(e->{
            CastingOffice.upgrade(new int[]{0, 4, 15}, player);
            window.close();
        });

        rank5Credit.setOnAction(e->{
            CastingOffice.upgrade(new int[]{0, 5, 20}, player);
            window.close();
        });

        rank6Credit.setOnAction(e->{
            CastingOffice.upgrade(new int[]{0, 6, 25}, player);
            window.close();
        });

        if(player.getMoney() < 4){
            rank2Money.setDisable(true);
        }

        if(player.getMoney() < 10){
            rank3Money.setDisable(true);
        }

        if(player.getMoney() < 18){
            rank4Money.setDisable(true);
        }

        if(player.getMoney() < 28){
            rank5Money.setDisable(true);
        }

        if(player.getMoney() < 40){
            rank6Money.setDisable(true);
        }

        if(player.getCredit() < 5){
            rank2Credit.setDisable(true);
        }

        if(player.getCredit() < 10){
            rank3Credit.setDisable(true);
        }

        if(player.getCredit() < 15){
            rank4Credit.setDisable(true);
        }

        if(player.getCredit() < 20){
            rank5Credit.setDisable(true);
        }

        if(player.getCredit() < 25){
            rank6Credit.setDisable(true);
        }

        if(player.getRank() >= 5) {
            rank2Credit.setDisable(true);
            rank2Money.setDisable(true);
            rank3Credit.setDisable(true);
            rank3Money.setDisable(true);
            rank4Credit.setDisable(true);
            rank4Money.setDisable(true);
            rank5Credit.setDisable(true);
            rank5Money.setDisable(true);
        }else if(player.getRank() >= 4) {
            rank2Credit.setDisable(true);
            rank2Money.setDisable(true);
            rank3Credit.setDisable(true);
            rank3Money.setDisable(true);
            rank4Credit.setDisable(true);
            rank4Money.setDisable(true);
        }else if(player.getRank() >= 3){
            rank2Credit.setDisable(true);
            rank2Money.setDisable(true);
            rank3Credit.setDisable(true);
            rank3Money.setDisable(true);
        }else if(player.getRank() >= 2){
            rank2Credit.setDisable(true);
            rank2Money.setDisable(true);
        }


        Button one = new Button("2");
        Button two = new Button("3");
        Button three = new Button("4");
        Button four = new Button("5");
        Button five = new Button("6");

        one.setDisable(true);
        two.setDisable(true);
        three.setDisable(true);
        four.setDisable(true);
        five.setDisable(true);

        Label labelMoney = new Label();
        labelMoney.setText("Money");

        Label labelCredit = new Label();
        labelCredit.setText("Credit");

        Label labelRanks = new Label();
        labelCredit.setText("Credit");

        VBox ranks = new VBox(10);
        ranks.getChildren().addAll(labelRanks);
        ranks.getChildren().addAll(one, two, three, four, five);

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(labelMoney);
        layout1.setAlignment(Pos.CENTER_RIGHT);
        layout1.getChildren().addAll(rank2Money, rank3Money, rank4Money, rank5Money, rank6Money);


        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(labelCredit);
        layout2.setAlignment(Pos.CENTER_LEFT);
        layout2.getChildren().addAll(rank2Credit, rank3Credit, rank4Credit, rank5Credit, rank6Credit);

        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(ranks, layout1, layout2);
        Scene sceneWindow = new Scene(pane);
        window.setScene(sceneWindow);
        window.showAndWait(); //needs to be closed before returning
    }
}
