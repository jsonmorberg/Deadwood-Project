package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        });

        rank3Money.setOnAction(e->{
            CastingOffice.upgrade(new int[]{1, 3, 10}, player);
        });

        rank4Money.setOnAction(e->{
            CastingOffice.upgrade(new int[]{1, 4, 4}, player);
        });

        rank5Money.setOnAction(e->{
            CastingOffice.upgrade(new int[]{1, 5, 4}, player);
        });

        rank6Money.setOnAction(e->{
            CastingOffice.upgrade(new int[]{1, 6, 4}, player);
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

        Label labelMoney = new Label();
        labelMoney.setText("Main Roles");

        Label labelCredit = new Label();
        labelCredit.setText("Extra Roles");

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(labelMoney);
        layout1.setAlignment(Pos.CENTER_RIGHT);


        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(labelCredit);
        layout2.setAlignment(Pos.CENTER_LEFT);

        HBox pane = new HBox();





    }
}
