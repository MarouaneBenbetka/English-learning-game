package mvn.cento.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import mvn.cento.Main;
import mvn.cento.Noyeau.CaseDefinition;
import mvn.cento.Noyeau.EnonceDefinition;
import mvn.cento.Noyeau.Jeu;
import mvn.cento.Noyeau.Joueur;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.TreeSet;

public class RankingScene {




    public static GridPane getRankingScene(){

        VBox container = new VBox();
        int width = 500 ;
        int height = 450 ;
        container.setPrefWidth(width);
        container.setPrefHeight(height);
        container.setMaxWidth(width+200);
        container.setMaxHeight(height);
        container.setAlignment(Pos.CENTER_LEFT);




        TreeSet<Joueur> sortedJoueurs  = new TreeSet<>() ;
        for (Map.Entry<String, Joueur> set : Jeu.getJoueurs().entrySet()) {
            sortedJoueurs.add(set.getValue());
        }

        int cpt = 0 ;
        Text popUpTitle;
        for (Joueur joueur : sortedJoueurs){
             popUpTitle = new Text((cpt+1)+".  "+ String.format("%-20s | Score : %-3d",joueur.getNom(),joueur.getMeilleurScore()));
             popUpTitle.getStyleClass().add("popUpTitle");
             popUpTitle.setTextAlignment(TextAlignment.LEFT);
             container.getChildren().add(popUpTitle);
             VBox.setMargin(popUpTitle,new Insets(10,0,6,0));

            cpt++;
            if(cpt > 5)
                break;
        }







        Button submitButton = new Button("Back to home");
        submitButton.getStyleClass().add("purpuleButton");
        submitButton.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {

            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.setScene(HomeScene.getHomeScence());

            stage.centerOnScreen();



        });




        container.getChildren().add(submitButton);

        VBox.setMargin(submitButton,new Insets(30,0,10,100));


        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(container);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setId("rankingScene");
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
        gridPane.setMaxWidth(width);
        gridPane.setMaxHeight(height);
        return gridPane;
    }








}
