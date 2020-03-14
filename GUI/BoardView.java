package GUI;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Queue;

/* View that manipulates and controls the Image Objects in the board game */

public class BoardView {

    private static ArrayList<Player> actors;
    private static AnchorPane root;
    private static Board board;
    private static Stage window;

    private static ImageView trainCard;
    private static ImageView secretCard;
    private static ImageView churchCard;
    private static ImageView hotelCard;
    private static ImageView mainStCard;
    private static ImageView jailCard;
    private static ImageView generalCard;
    private static ImageView ranchCard;
    private static ImageView bankCard;
    private static ImageView saloonCard;

    private static ImageView trainCardCover;
    private static ImageView secretCardCover;
    private static ImageView churchCardCover;
    private static ImageView hotelCardCover;
    private static ImageView mainStCardCover;
    private static ImageView jailCardCover;
    private static ImageView generalCardCover;
    private static ImageView ranchCardCover;
    private static ImageView bankCardCover;
    private static ImageView saloonCardCover;

    private static ImageView trainShot1;
    private static ImageView trainShot2;
    private static ImageView trainShot3;
    private static ImageView secretShot1;
    private static ImageView secretShot2;
    private static ImageView secretShot3;
    private static ImageView churchShot1;
    private static ImageView churchShot2;
    private static ImageView hotelShot1;
    private static ImageView hotelShot2;
    private static ImageView hotelShot3;
    private static ImageView mainStShot1;
    private static ImageView mainStShot2;
    private static ImageView mainStShot3;
    private static ImageView jailShot1;
    private static ImageView generalShot1;
    private static ImageView generalShot2;
    private static ImageView ranchShot1;
    private static ImageView ranchShot2;
    private static ImageView bankShot1;
    private static ImageView saloonShot1;
    private static ImageView saloonShot2;


    private static ImageView player1;
    private static ImageView player2;
    private static ImageView player3;
    private static ImageView player4;
    private static ImageView player5;
    private static ImageView player6;
    private static ImageView player7;
    private static ImageView player8;



    //set up board
    public static void initialize(Queue<Player> players, Board b) throws FileNotFoundException {

        ArrayList<Player> list = new ArrayList(players);
        actors = list;
        board = b;

        trainShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        trainShot2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        trainShot3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        secretShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        secretShot2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        secretShot3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        churchShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        churchShot2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        hotelShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        hotelShot2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        hotelShot3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        mainStShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        mainStShot2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        mainStShot3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        jailShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        generalShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        generalShot2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        ranchShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        ranchShot2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        bankShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        saloonShot1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));
        saloonShot2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/shot.png"))));


        trainCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));
        secretCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));
        churchCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));
        hotelCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));
        mainStCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));
        jailCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));
        generalCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));
        ranchCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));
        bankCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));
        saloonCardCover = new ImageView(new Image(new FileInputStream(new File("./src/GUI/CardBack-small.jpg"))));

        if(players.size() == 2){
            player1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/b1.png"))));
            player2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/c1.png"))));
            root.getChildren().addAll(player1, player2);

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

        }else if(players.size() == 3){
            player1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/b1.png"))));
            player2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/c1.png"))));
            player3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/o1.png"))));
            root.getChildren().addAll(player1, player2, player3);

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

        }else if(players.size() == 4){
            player1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/b1.png"))));
            player2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/c1.png"))));
            player3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/o1.png"))));
            player4 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/p1.png"))));
            root.getChildren().addAll(player1, player2, player3, player4);

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

        }else if(players.size() == 5){
            player1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/b1.png"))));
            player2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/c1.png"))));
            player3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/o1.png"))));
            player4 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/p1.png"))));
            player5 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/r1.png"))));
            root.getChildren().addAll(player1, player2, player3, player4, player5);

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

            player5.setX(911);
            player5.setY(324);

        }else if(players.size() == 6){

            player1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/b1.png"))));
            player2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/c1.png"))));
            player3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/o1.png"))));
            player4 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/p1.png"))));
            player5 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/r1.png"))));
            player6 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/v1.png"))));
            root.getChildren().addAll(player1, player2, player3, player4, player5, player6);

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

            player5.setX(911);
            player5.setY(324);

            player6.setX(951);
            player6.setY(324);

        }else if(players.size() == 7){

            player1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/b1.png"))));
            player2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/c1.png"))));
            player3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/o1.png"))));
            player4 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/p1.png"))));
            player5 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/r1.png"))));
            player6 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/v1.png"))));
            player7 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/w1.png"))));
            root.getChildren().addAll(player1, player2, player3, player4, player5, player6, player7);

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

            player5.setX(911);
            player5.setY(324);

            player6.setX(951);
            player6.setY(324);

            player7.setX(991);
            player7.setY(324);

        }else if(players.size() == 8){

            player1 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/b1.png"))));
            player2 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/c1.png"))));
            player3 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/o1.png"))));
            player4 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/p1.png"))));
            player5 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/r1.png"))));
            player6 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/v1.png"))));
            player7 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/w1.png"))));
            player8 = new ImageView(new Image(new FileInputStream(new File("./src/GUI/y1.png"))));
            root.getChildren().addAll(player1, player2, player3, player4, player5, player6, player7, player8);

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

            player5.setX(911);
            player5.setY(324);

            player6.setX(951);
            player6.setY(324);

            player7.setX(991);
            player7.setY(324);

            player8.setX(1031);
            player8.setY(324);
        }

        Stage stage = new Stage();
        window = stage;
        stage.setTitle("DEADWOOD");
        Scene deadwood = new Scene(root);

        stage.setScene(deadwood);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        initializeCards();
    }

    public static void setRoot(AnchorPane root) {
        BoardView.root = root;
    }

    //game is over
    public static void close(){
        window.close();
    }

    //set up first set of scene cards
    public static void initializeCards() throws FileNotFoundException {
        ArrayList<MovieSet> sets = board.getSets();

        SceneCard scene1 = sets.get(0).getScene();
        trainCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene1.getJpg()))));

        SceneCard scene2 = sets.get(1).getScene();
        secretCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene2.getJpg()))));

        SceneCard scene3 = sets.get(2).getScene();
        churchCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene3.getJpg()))));

        SceneCard scene4 = sets.get(3).getScene();
        hotelCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene4.getJpg()))));

        SceneCard scene5 = sets.get(4).getScene();
        mainStCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene5.getJpg()))));

        SceneCard scene6 = sets.get(5).getScene();
        jailCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene6.getJpg()))));

        SceneCard scene7 = sets.get(6).getScene();
        generalCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene7.getJpg()))));

        SceneCard scene8 = sets.get(7).getScene();
        ranchCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene8.getJpg()))));

        SceneCard scene9 = sets.get(8).getScene();
        bankCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene9.getJpg()))));

        SceneCard scene10 = sets.get(9).getScene();
        saloonCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene10.getJpg()))));

        root.getChildren().addAll(trainCard, secretCard, churchCard, hotelCard, mainStCard, jailCard, generalCard, ranchCard, bankCard, saloonCard);
        root.getChildren().addAll(trainCardCover, secretCardCover, churchCardCover, hotelCardCover, mainStCardCover, jailCardCover, generalCardCover, ranchCardCover, bankCardCover, saloonCardCover);
        root.getChildren().addAll(trainShot1, trainShot2, trainShot3, jailShot1, generalShot1, generalShot2, ranchShot1, ranchShot2, secretShot1, secretShot2, secretShot3, churchShot1, churchShot2, hotelShot1, hotelShot2, hotelShot3, mainStShot1, mainStShot2, mainStShot3, saloonShot1, saloonShot2, bankShot1);

        trainCard.setX(12);
        trainCard.setY(77);

        secretCard.setX(14);
        secretCard.setY(628);

        churchCard.setX(561);
        churchCard.setY(628);

        hotelCard.setX(876);
        hotelCard.setY(628);

        mainStCard.setX(876);
        mainStCard.setY(21);

        jailCard.setX(252);
        jailCard.setY(25);

        generalCard.setX(332);
        generalCard.setY(240);

        ranchCard.setX(220);
        ranchCard.setY(411);

        bankCard.setX(563);
        bankCard.setY(405);

        saloonCard.setX(570);
        saloonCard.setY(240);
        coverCards();
        shots();
    }

    //set coordinates for card covers
    public static void coverCards(){

        trainCardCover.setX(12);
        trainCardCover.setY(77);

        secretCardCover.setX(14);
        secretCardCover.setY(628);

        churchCardCover.setX(561);
        churchCardCover.setY(628);

        hotelCardCover.setX(876);
        hotelCardCover.setY(628);

        mainStCardCover.setX(876);
        mainStCardCover.setY(21);

        jailCardCover.setX(252);
        jailCardCover.setY(25);

        generalCardCover.setX(332);
        generalCardCover.setY(240);

        ranchCardCover.setX(220);
        ranchCardCover.setY(411);

        bankCardCover.setX(563);
        bankCardCover.setY(405);

        saloonCardCover.setX(570);
        saloonCardCover.setY(240);

    }

    //set coordinates for shots
    public static void shots(){
        trainShot1.setX(139);
        trainShot1.setY(30);
        trainShot2.setX(92);
        trainShot2.setY(30);
        trainShot3.setX(44);
        trainShot3.setY(30);
        secretShot1.setX(323);
        secretShot1.setY(658);
        secretShot2.setX(273);
        secretShot2.setY(658);
        secretShot3.setX(223);
        secretShot3.setY(658);
        churchShot1.setX(566);
        churchShot1.setY(582);
        churchShot2.setX(620);
        churchShot2.setY(582);
        hotelShot1.setX(989);
        hotelShot1.setY(582);
        hotelShot2.setX(942);
        hotelShot2.setY(582);
        hotelShot3.setX(894);
        hotelShot3.setY(582);
        mainStShot1.setX(827);
        mainStShot1.setY(24);
        mainStShot2.setX(780);
        mainStShot2.setY(24);
        mainStShot3.setX(731);
        mainStShot3.setY(24);
        jailShot1.setX(403);
        jailShot1.setY(137);
        generalShot1.setX(286);
        generalShot1.setY(286);
        generalShot2.setX(286);
        generalShot2.setY(242);
        ranchShot1.setX(478);
        ranchShot1.setY(409);
        ranchShot2.setX(429);
        ranchShot2.setY(409);
        bankShot1.setX(764);
        bankShot1.setY(474);
        saloonShot1.setX(617);
        saloonShot1.setY(188);
        saloonShot2.setX(569);
        saloonShot2.setY(188);
    }

    //reset board for new day
    public static void resetView() throws FileNotFoundException {
        if(actors.size() == 2){

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

        }else if(actors.size() == 3){

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

        }else if(actors.size() == 4){

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

        }else if(actors.size() == 5){

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

            player5.setX(911);
            player5.setY(324);

        }else if(actors.size() == 6){

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

            player5.setX(911);
            player5.setY(324);

            player6.setX(951);
            player6.setY(324);

        }else if(actors.size() == 7){

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

            player5.setX(911);
            player5.setY(324);

            player6.setX(951);
            player6.setY(324);

            player7.setX(991);
            player7.setY(324);

        }else if(actors.size() == 8) {

            player1.setX(911);
            player1.setY(275);

            player2.setX(951);
            player2.setY(275);

            player3.setX(991);
            player3.setY(275);

            player4.setX(1031);
            player4.setY(275);

            player5.setX(911);
            player5.setY(324);

            player6.setX(951);
            player6.setY(324);

            player7.setX(991);
            player7.setY(324);

            player8.setX(1031);
            player8.setY(324);

            }

            ArrayList<MovieSet> sets = board.getSets();

            SceneCard scene1 = sets.get(0).getScene();
            trainCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene1.getJpg()))));

            SceneCard scene2 = sets.get(1).getScene();
            secretCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene2.getJpg()))));

            SceneCard scene3 = sets.get(2).getScene();
            churchCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene3.getJpg()))));

            SceneCard scene4 = sets.get(3).getScene();
            hotelCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene4.getJpg()))));

            SceneCard scene5 = sets.get(4).getScene();
            mainStCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene5.getJpg()))));

            SceneCard scene6 = sets.get(5).getScene();
            jailCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene6.getJpg()))));

            SceneCard scene7 = sets.get(6).getScene();
            generalCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene7.getJpg()))));

            SceneCard scene8 = sets.get(7).getScene();
            ranchCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene8.getJpg()))));

            SceneCard scene9 = sets.get(8).getScene();
            bankCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene9.getJpg()))));

            SceneCard scene10 = sets.get(9).getScene();
            saloonCard = new ImageView(new Image(new FileInputStream(new File("./src/GUI/"+scene10.getJpg()))));
            root.getChildren().addAll(trainCard, secretCard, churchCard, hotelCard, mainStCard, jailCard, generalCard, ranchCard, bankCard, saloonCard);

            trainCard.setX(12);
            trainCard.setY(77);
            secretCard.setX(14);
            secretCard.setY(628);

            churchCard.setX(561);
            churchCard.setY(628);

            hotelCard.setX(876);
            hotelCard.setY(628);

            mainStCard.setX(876);
            mainStCard.setY(21);

            jailCard.setX(252);
            jailCard.setY(25);

            generalCard.setX(332);
            generalCard.setY(240);

            ranchCard.setX(220);
            ranchCard.setY(411);

            bankCard.setX(563);
            bankCard.setY(405);

            saloonCard.setX(570);
            saloonCard.setY(240);

            trainCardCover.setVisible(true);
            trainCardCover.toFront();
            secretCardCover.setVisible(true);
            churchCardCover.setVisible(true);
            hotelCardCover.setVisible(true);
            mainStCardCover.setVisible(true);
            jailCardCover.setVisible(true);
            generalCardCover.setVisible(true);
            ranchCardCover.setVisible(true);
            bankCardCover.setVisible(true);
            saloonCardCover.setVisible(true);

            secretCardCover.toFront();
            churchCardCover.toFront();
            hotelCardCover.toFront();
            mainStCardCover.toFront();
            jailCardCover.toFront();
            generalCardCover.toFront();
            ranchCardCover.toFront();
            bankCardCover.toFront();
            saloonCardCover.toFront();

            trainShot1.setVisible(true);
            trainShot1.toFront();
            trainShot2.setVisible(true);
            trainShot2.toFront();
            trainShot3.setVisible(true);
            trainShot3.toFront();
            secretShot1.setVisible(true);
            secretShot1.toFront();
            secretShot2.setVisible(true);
            secretShot2.toFront();
            secretShot3.setVisible(true);
            secretShot3.toFront();
            churchShot1.setVisible(true);
            churchShot1.toFront();
            churchShot2.setVisible(true);
            churchShot2.toFront();
            hotelShot1.setVisible(true);
            hotelShot1.toFront();
            hotelShot2.setVisible(true);
            hotelShot2.toFront();
            hotelShot3.setVisible(true);
            hotelShot3.toFront();
            mainStShot1.setVisible(true);
            mainStShot1.toFront();
            mainStShot2.setVisible(true);
            mainStShot2.toFront();
            mainStShot3.setVisible(true);
            mainStShot3.toFront();
            jailShot1.setVisible(true);
            jailShot1.toFront();
            generalShot1.setVisible(true);
            generalShot1.toFront();
            generalShot2.setVisible(true);
            generalShot2.toFront();
            ranchShot1.setVisible(true);;
            ranchShot1.toFront();
            ranchShot2.setVisible(true);;
            ranchShot2.toFront();
            bankShot1.setVisible(true);
            bankShot1.toFront();
            saloonShot1.setVisible(true);
            saloonShot1.toFront();
            saloonShot2.setVisible(true);
            saloonShot2.toFront();
        }

    //shut down room view
    public static void shutdown(MovieSet room, Player player) {
                    if(room.getName().equals("Train Station")){
                        moveTrain(player);
                        trainCard.setVisible(false);
                    }else if(room.getName().equals("Secret Hideout")){
                        moveSecret(player);
                        secretCard.setVisible(false);
                    }else if(room.getName().equals("Church")){
                        moveChurch(player);
                        churchCard.setVisible(false);
                    }else if(room.getName().equals("Hotel")){
                        moveHotel(player);
                        hotelCard.setVisible(false);
                    }else if(room.getName().equals("Main Street")){
                        moveMain(player);
                        mainStCard.setVisible(false);
                    }else if(room.getName().equals("Jail")){
                        moveJail(player);
                        jailCard.setVisible(false);
                    }else if(room.getName().equals("General Store")){
                        moveGeneral(player);
                        generalCard.setVisible(false);
                    }else if(room.getName().equals("Ranch")){
                        moveRanch(player);
                        ranchCard.setVisible(false);
                    }else if(room.getName().equals("Bank")){
                        moveBank(player);
                        bankCard.setVisible(false);
                    }else if(room.getName().equals("Saloon")){
                        moveSaloon(player);
                        saloonCard.setVisible(false);
                    }
    }

    /* Various classes for individual assignments */

    public static void takeTrainShot(int shots){
        if(shots == 2){
            trainShot1.setVisible(false);
        }else if(shots == 1){
            trainShot2.setVisible(false);
        }else if(shots == 0){
            trainShot3.setVisible(false);
        }
    }

    public static void takeSaloonShot(int shots){
        if(shots == 1){
            saloonShot1.setVisible(false);
        }else if(shots == 0){
            saloonShot2.setVisible(false);
        }
    }

    public static void takeHotelShot(int shots){
        if(shots == 2){
            hotelShot1.setVisible(false);
        }else if(shots == 1){
            hotelShot2.setVisible(false);
        }else if(shots == 0){
            hotelShot3.setVisible(false);
        }
    }

    public static void takeMainShot(int shots){
        if(shots == 2){
            mainStShot1.setVisible(false);
        }else if(shots == 1){
            mainStShot2.setVisible(false);
        }else if(shots == 0){
            mainStShot3.setVisible(false);
        }
    }

    public static void takeJailShot(int shots){
        if(shots == 0){
            jailShot1.setVisible(false);
        }
    }

    public static void takeGeneralShot(int shots){
        if(shots == 1){
            generalShot1.setVisible(false);
        }else if(shots == 0){
            generalShot2.setVisible(false);
        }
    }

    public static void takeRanchShot(int shots){
        if(shots == 1){
            ranchShot1.setVisible(false);
        }else if(shots == 0){
            ranchShot2.setVisible(false);
        }
    }

    public static void takeSecretShot(int shots){
        if(shots == 2){
            secretShot1.setVisible(false);
        }else if(shots == 1){
            secretShot2.setVisible(false);
        }else if(shots == 0){
            secretShot3.setVisible(false);
        }
    }

    public static void takeChurchShot(int shots){
        if(shots == 1){
            churchShot1.setVisible(false);
        }else if(shots == 0){
            churchShot2.setVisible(false);
        }
    }

    public static void takeBankShot(int shots){
      if(shots == 0){
            bankShot1.setVisible(false);
        }
    }



    public static void moveTrain(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(99);
                    player1.setY(342);
                }else if(i == 1){
                    player2.setX(99);
                    player2.setY(342);
                }else if(i == 2){
                    player3.setX(99);
                    player3.setY(342);

                }else if(i == 3){
                    player4.setX(99);
                    player4.setY(342);

                }else if(i == 4){
                    player5.setX(99);
                    player5.setY(342);

                }else if(i == 5){
                    player6.setX(99);
                    player6.setY(342);

                }
            }
        }
    }

    public static void moveGeneral(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(268);
                    player1.setY(335);
                }else if(i == 1){
                    player2.setX(268);
                    player2.setY(335);
                }else if(i == 2){
                    player3.setX(268);
                    player3.setY(335);

                }else if(i == 3){
                    player4.setX(268);
                    player4.setY(335);

                }else if(i == 4){
                    player5.setX(268);
                    player5.setY(335);

                }else if(i == 5){
                    player6.setX(268);
                    player6.setY(335);

                }
            }
        }
    }
    public static void moveSecret(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(278);
                    player1.setY(712);
                }else if(i == 1){
                    player2.setX(278);
                    player2.setY(712);
                }else if(i == 2){
                    player3.setX(278);
                    player3.setY(712);

                }else if(i == 3){
                    player4.setX(278);
                    player4.setY(712);

                }else if(i == 4){
                    player5.setX(278);
                    player5.setY(712);

                }else if(i == 5){
                    player6.setX(278);
                    player6.setY(712);

                }
            }
        }
    }
    public static void moveHotel(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(923);
                    player1.setY(402);
                }else if(i == 1){
                    player2.setX(923);
                    player2.setY(402);
                }else if(i == 2){
                    player3.setX(923);
                    player3.setY(402);

                }else if(i == 3){
                    player4.setX(923);
                    player4.setY(402);

                }else if(i == 4){
                    player5.setX(923);
                    player5.setY(402);

                }else if(i == 5){
                    player6.setX(923);
                    player6.setY(402);

                }
            }
        }
    }
    public static void moveSaloon(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(842);
                    player1.setY(342);
                }else if(i == 1){
                    player2.setX(842);
                    player2.setY(342);
                }else if(i == 2){
                    player3.setX(842);
                    player3.setY(342);

                }else if(i == 3){
                    player4.setX(842);
                    player4.setY(342);

                }else if(i == 4){
                    player5.setX(842);
                    player5.setY(342);

                }else if(i == 5){
                    player6.setX(842);
                    player6.setY(342);

                }
            }
        }
    }
    public static void moveJail(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(461);
                    player1.setY(146);
                }else if(i == 1){
                    player2.setX(461);
                    player2.setY(146);
                }else if(i == 2){
                    player3.setX(461);
                    player3.setY(146);

                }else if(i == 3){
                    player4.setX(461);
                    player4.setY(146);

                }else if(i == 4){
                    player5.setX(461);
                    player5.setY(146);

                }else if(i == 5){
                    player6.setX(461);
                    player6.setY(146);

                }
            }
        }
    }
    public static void moveRanch(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(278);
                    player1.setY(549);
                }else if(i == 1){
                    player2.setX(278);
                    player2.setY(549);
                }else if(i == 2){
                    player3.setX(278);
                    player3.setY(549);

                }else if(i == 3){
                    player4.setX(278);
                    player4.setY(549);

                }else if(i == 4){
                    player5.setX(278);
                    player5.setY(549);

                }else if(i == 5){
                    player6.setX(278);
                    player6.setY(549);

                }
            }
        }
    }
    public static void moveChurch(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(693);
                    player1.setY(580);
                }else if(i == 1){
                    player2.setX(693);
                    player2.setY(580);
                }else if(i == 2){
                    player3.setX(693);
                    player3.setY(580);

                }else if(i == 3){
                    player4.setX(693);
                    player4.setY(580);

                }else if(i == 4){
                    player5.setX(693);
                    player5.setY(580);

                }else if(i == 5){
                    player6.setX(693);
                    player6.setY(580);

                }
            }
        }
    }
    public static void moveMain(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(744);
                    player1.setY(99);
                }else if(i == 1){
                    player2.setX(744);
                    player2.setY(99);
                }else if(i == 2){
                    player3.setX(744);
                    player3.setY(99);

                }else if(i == 3){
                    player4.setX(744);
                    player4.setY(99);

                }else if(i == 4){
                    player5.setX(744);
                    player5.setY(99);

                }else if(i == 5){
                    player6.setX(744);
                    player6.setY(99);

                }
            }
        }
    }
    public static void moveBank(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(775);
                    player1.setY(412);
                }else if(i == 1){
                    player2.setX(775);
                    player2.setY(412);
                }else if(i == 2){
                    player3.setX(775);
                    player3.setY(412);

                }else if(i == 3){
                    player4.setX(775);
                    player4.setY(412);

                }else if(i == 4){
                    player5.setX(775);
                    player5.setY(412);

                }else if(i == 5){
                    player6.setX(775);
                    player6.setY(412);

                }
            }
        }
    }
    public static void moveTrailer(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(967);
                    player1.setY(301);
                }else if(i == 1){
                    player2.setX(967);
                    player2.setY(301);
                }else if(i == 2){
                    player3.setX(967);
                    player3.setY(301);

                }else if(i == 3){
                    player4.setX(967);
                    player4.setY(301);

                }else if(i == 4){
                    player5.setX(967);
                    player5.setY(301);

                }else if(i == 5){
                    player6.setX(967);
                    player6.setY(301);

                }
            }
        }
    }
    public static void moveCasting(Player player){
        for(int i = 0; i < actors.size(); i++){
            if (player.equals(actors.get(i))){
                if(i == 0){
                    player1.setX(85);
                    player1.setY(468);
                }else if(i == 1){
                    player2.setX(85);
                    player2.setY(468);
                }else if(i == 2){
                    player3.setX(85);
                    player3.setY(468);

                }else if(i == 3){
                    player4.setX(85);
                    player4.setY(468);

                }else if(i == 4){
                    player5.setX(85);
                    player5.setY(468);

                }else if(i == 5){
                    player6.setX(85);
                    player6.setY(468);

                }
            }
        }
    }

    public static void flipTrain(){
        trainCardCover.setVisible(false);
    }

    public static void flipMain(){
        mainStCardCover.setVisible(false);
    }

    public static void flipSecret(){
        secretCardCover.setVisible(false);
    }

    public static void flipChurch(){
        churchCardCover.setVisible(false);
    }

    public static void flipHotel(){
        hotelCardCover.setVisible(false);
    }
    public static void flipJail(){
        jailCardCover.setVisible(false);
    }
    public static void flipGeneral(){
        generalCardCover.setVisible(false);
    }
    public static void flipRanch(){
        ranchCardCover.setVisible(false);
    }
    public static void flipBank(){
        bankCardCover.setVisible(false);
    }

    public static void flipSaloon(){
        saloonCardCover.setVisible(false);
    }
}
