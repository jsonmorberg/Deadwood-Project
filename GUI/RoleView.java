package GUI;

import GUI.Role;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class RoleView {


    private static Button main1;
    private static Button main2;
    private static Button main3;
    private static Button extra1;
    private static Button extra2;
    private static Button extra3;
    private static Button extra4;

    private static Role role;

    public static Role display(ArrayList<Role> offCard, SceneCard scene, int rank) {

        ArrayList<Role> main = scene.getRoles();
        role = null;
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //locks user to the alert box
        window.setTitle("Take Role");
        window.setMinWidth(200);
        window.setMinHeight(200);


        Label labelMain = new Label();
        labelMain.setText("Main Roles");

        Label labelExtra = new Label();
        labelExtra.setText("Extra Roles");

        HBox pane = new HBox();

        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(labelMain);
        layout1.setAlignment(Pos.CENTER_RIGHT);


        VBox layout2 = new VBox(10);
        layout2.getChildren().addAll(labelExtra);
        layout2.setAlignment(Pos.CENTER_LEFT);


        if (main.size() == 3) {
            main1 = new Button(main.get(0).getName() + " (" + main.get(0).getRank() + ")");
            main2 = new Button(main.get(1).getName() + " (" + main.get(1).getRank() + ")");
            main3 = new Button(main.get(2).getName() + " (" + main.get(2).getRank() + ")");

            main1.setOnAction(e -> {
                role = main.get(0);
                window.close();
            });

            main2.setOnAction(e -> {
                role = main.get(1);
                window.close();
            });

            main3.setOnAction(e -> {
                role = main.get(2);
                window.close();
            });

            if (rank < main.get(0).getRank()) {
                main1.setDisable(true);
            }

            if (rank < main.get(1).getRank()) {
                main2.setDisable(true);
            }

            if (rank < main.get(2).getRank()) {
                main3.setDisable(true);
            }

            if (main.get(0).isTaken()) {
                main1.setDisable(true);
            }

            if (main.get(1).isTaken()) {
                main2.setDisable(true);
            }

            if (main.get(2).isTaken()) {
                main3.setDisable(true);
            }

            layout1.getChildren().addAll(main1, main2, main3);


        } else if (main.size() == 2) {
            main1 = new Button(main.get(0).getName() + " (" + main.get(0).getRank() + ")");
            main2 = new Button(main.get(1).getName() + " (" + main.get(1).getRank() + ")");

            main1.setOnAction(e -> {
                role = main.get(0);
                window.close();
            });

            main2.setOnAction(e -> {
                role = main.get(1);
                window.close();
            });

            if (rank < main.get(0).getRank()) {
                main1.setDisable(true);
            }

            if (rank < main.get(1).getRank()) {
                main2.setDisable(true);
            }

            if (main.get(0).isTaken()) {
                main1.setDisable(true);
            }

            if (main.get(1).isTaken()) {
                main2.setDisable(true);
            }

            layout1.getChildren().addAll(main1, main2);

        } else if (main.size() == 1) {
            main1 = new Button(main.get(0).getName() + " (" + main.get(0).getRank() + ")");

            main1.setOnAction(e -> {
                role = main.get(0);
                window.close();
            });


            if (rank < main.get(0).getRank()) {
                main1.setDisable(true);
            }

            if (main.get(0).isTaken()) {
                main1.setDisable(true);
            }

            layout1.getChildren().addAll(main1);
        }
            if (offCard.size() == 4) {

                extra1 = new Button(offCard.get(0).getName() + " (" + offCard.get(0).getRank() + ")");
                extra2 = new Button(offCard.get(1).getName() + " (" + offCard.get(1).getRank() + ")");
                extra3 = new Button(offCard.get(2).getName() + " (" + offCard.get(2).getRank() + ")");
                extra4 = new Button(offCard.get(3).getName() + " (" + offCard.get(3).getRank() + ")");

                extra1.setOnAction(e -> {
                    role = offCard.get(0);
                    window.close();
                });

                extra2.setOnAction(e -> {
                    role = offCard.get(1);
                    window.close();
                });

                extra3.setOnAction(e -> {
                    role = offCard.get(2);
                    window.close();
                });

                extra4.setOnAction(e -> {
                    role = offCard.get(3);
                    window.close();
                });

                if (rank < offCard.get(0).getRank()) {
                    extra1.setDisable(true);
                }
                if (rank < offCard.get(1).getRank()) {
                    extra2.setDisable(true);
                }
                if (rank < offCard.get(2).getRank()) {
                    extra3.setDisable(true);
                }
                if (rank < offCard.get(3).getRank()) {
                    extra4.setDisable(true);
                }
                if (offCard.get(0).isTaken()) {
                    extra1.setDisable(true);
                }
                if (offCard.get(1).isTaken()) {
                    extra2.setDisable(true);
                }
                if (offCard.get(2).isTaken()) {
                    extra3.setDisable(true);
                }
                if (offCard.get(3).isTaken()) {
                    extra4.setDisable(true);
                }
                layout2.getChildren().addAll(extra1, extra2, extra3, extra4);

            } else if (offCard.size() == 3) {
                extra1 = new Button(offCard.get(0).getName() + " (" + offCard.get(0).getRank() + ")");
                extra2 = new Button(offCard.get(1).getName() + " (" + offCard.get(1).getRank() + ")");
                extra3 = new Button(offCard.get(2).getName() + " (" + offCard.get(2).getRank() + ")");

                extra1.setOnAction(e -> {
                    role = offCard.get(0);
                    window.close();
                });

                extra2.setOnAction(e -> {
                    role = offCard.get(1);
                    window.close();
                });

                extra3.setOnAction(e -> {
                    role = offCard.get(2);
                    window.close();
                });

                if (rank < offCard.get(0).getRank()) {
                    extra1.setDisable(true);
                }
                if (rank < offCard.get(1).getRank()) {
                    extra2.setDisable(true);
                }
                if (rank < offCard.get(2).getRank()) {
                    extra3.setDisable(true);
                }
                if (offCard.get(0).isTaken()) {
                    extra1.setDisable(true);
                }
                if (offCard.get(1).isTaken()) {
                    extra2.setDisable(true);
                }
                if (offCard.get(2).isTaken()) {
                    extra3.setDisable(true);
                }
                layout2.getChildren().addAll(extra1, extra2, extra3);

            } else if (offCard.size() == 2) {
                extra1 = new Button(offCard.get(0).getName() + " (" + offCard.get(0).getRank() + ")");
                extra2 = new Button(offCard.get(1).getName() + " (" + offCard.get(1).getRank() + ")");

                extra1.setOnAction(e -> {
                    role = offCard.get(0);
                    window.close();
                });
                extra2.setOnAction(e -> {
                    role = offCard.get(1);
                    window.close();
                });

                if (rank < offCard.get(0).getRank()) {
                    extra1.setDisable(true);
                }
                if (rank < offCard.get(1).getRank()) {
                    extra2.setDisable(true);
                }
                if (offCard.get(0).isTaken()) {
                    extra1.setDisable(true);
                }
                if (offCard.get(1).isTaken()) {
                    extra2.setDisable(true);
                }
                layout2.getChildren().addAll(extra1, extra2);
            }

            pane.getChildren().addAll(layout2, layout1);

            Scene sceneWindow = new Scene(pane);
            window.setScene(sceneWindow);
            window.showAndWait(); //needs to be closed before returning
            return role;

        }
    }

