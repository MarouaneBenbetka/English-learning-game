package mvn.cento.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import mvn.cento.Noyeau.CaseDefinition;

import java.io.IOException;

public class GamePausedPopUp {

    public static GridPane getGamePausedPoP() {

        VBox container = new VBox();
        int width = 500 ;
        int height = 450 ;
        container.setPrefWidth(width);
        container.setPrefHeight(height);
        container.setMaxWidth(width+200);
        container.setMaxHeight(height);

        Text popUpTitle = new Text("Game Paused:");
        popUpTitle.getStyleClass().add("popUpTitle");
        Text definition = new Text("the game is paused right now");
        definition.getStyleClass().add("popUpTxt");
        definition.setWrappingWidth(width-60);


        container.getChildren().add(popUpTitle);
        container.getChildren().add(definition);



        Button resume = new Button("Resume");
        resume.getStyleClass().add("purpuleButton");
        resume.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
           PlateauScene.removePopUp();
        });


        Button restart = new Button("Restart");
        restart.getStyleClass().add("purpuleButton");
        restart.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {

            HomeScene.jeu.getPartie().creerPartie();
            Scene scene;
            try {
                PlateauScene.reset();
                scene = PlateauScene.getPlateauScene( HomeScene.jeu.getPartie());
                Stage stage = (Stage) restart.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Cento Game ");
                stage.centerOnScreen();

            } catch (IOException ex) {
                ex.printStackTrace();
            }


        });


        Button submitButton = new Button("Back to Home");
        submitButton.getStyleClass().add("purpuleButton");
        submitButton.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            Stage stage = (Stage) restart.getScene().getWindow();
            stage.setScene(HomeScene.getHomeScence());
            PlateauScene.removePopUp();
            stage.centerOnScreen();
        });




        container.getChildren().add(resume);
        container.getChildren().add(restart);
        container.getChildren().add(submitButton);

        VBox.setMargin(popUpTitle,new Insets(30,0,10,0));
        VBox.setMargin(definition,new Insets(10,8,10,16));


        VBox.setMargin(resume,new Insets(24,0,10,0));
        VBox.setMargin(restart,new Insets(10,0,10,0));
        VBox.setMargin(submitButton,new Insets(10,0,10,0));


        container.setAlignment(Pos.TOP_CENTER);
        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(container);
        gridPane.setId("defPopUp");
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
        gridPane.setMaxWidth(width);
        gridPane.setMaxHeight(height);
        return gridPane;


    }
    }
