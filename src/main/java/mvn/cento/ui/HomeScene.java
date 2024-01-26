package mvn.cento.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mvn.cento.Main;
import mvn.cento.Noyeau.Exceptions.motDePasseIncorrectException;
import mvn.cento.Noyeau.Exceptions.utilisateurDejaExistantException;
import mvn.cento.Noyeau.Exceptions.utilisateurNonExistantException;
import mvn.cento.Noyeau.Jeu;
import mvn.cento.Noyeau.Joueur;
import mvn.cento.Noyeau.Partie;

import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

public class HomeScene {

   public static Jeu jeu = new Jeu() ; 

    private static VBox container ;
    private static Text welcomeTxt;
    private static Text record;

    public static Scene getHomeScence(){






        container= new VBox();
        container.setId("homeContainer");
        container.setAlignment(Pos.TOP_CENTER);

        HBox header  = new HBox();


        HBox.setHgrow(header, Priority.ALWAYS);
        ImageView logo = new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("images/logo2.png")).toExternalForm()));
        logo.setFitHeight(38);
        logo.setPreserveRatio(true);
        header.getChildren().add(logo);
        HBox separator = new HBox();
            separator.setPrefWidth(1500);
        header.getChildren().add(separator);

        ImageView fullScreenIcon = new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("images/fullScreenIcon.png")).toExternalForm()));
        fullScreenIcon.setFitWidth(38);
        fullScreenIcon.setFitHeight(38);
        fullScreenIcon.setCursor(Cursor.HAND);
        fullScreenIcon.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setFullScreen(true);

        });
        header.getChildren().add(fullScreenIcon);

        HBox.setMargin(logo,new Insets(0,16,0,16));
        HBox.setMargin(fullScreenIcon,new Insets(0,16,0,16));


        welcomeTxt = new Text("Hi, "+jeu.getPartie().getJoueur().getNom());
        welcomeTxt.setId("welcomeTxt");




        container.getChildren().add(header);
        VBox.setMargin(header,new Insets(12,0,10,0));


        container.getChildren().add(welcomeTxt);
        VBox.setMargin(welcomeTxt, new Insets(100,360,10,10));

        VBox buttonsChoices = new VBox();
        buttonsChoices.setAlignment(Pos.CENTER);
        buttonsChoices.setPrefWidth(2000);




        Button newGame = new Button("New game");
        newGame.getStyleClass().add("choiceButton");

        newGame.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {


            


            jeu.getPartie().creerPartie();
            Scene scene;
            try {
                PlateauScene.reset();
                scene = PlateauScene.getPlateauScene( jeu.getPartie());
                Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Cento Game ");
                stage.centerOnScreen();

            } catch (IOException ex) {
                ex.printStackTrace();
            }



        });

        Button continueGame = new Button("Past game");
        continueGame.getStyleClass().add("choiceButton");

        continueGame.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            try {

                PlateauScene.reset();
                jeu.getPartie().chargerAncienPartie();
                Scene scene;
                scene = PlateauScene.getPlateauScene( jeu.getPartie());
                Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Cento Game");
                stage.centerOnScreen();

            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("aucune partie trouve");
            }

        });


        Button ranking = new Button("Ranking");
        ranking.getStyleClass().add("choiceButton");

        ranking.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            Scene scene2 = new Scene(RankingScene.getRankingScene(),1300 , 750);

            scene2.getStylesheets().addAll(Objects.requireNonNull(Main.class.getResource("css/style.css")).toExternalForm());

            stage.setScene(scene2);
            stage.centerOnScreen();
        });

        Button exit = new Button("Log out");
        exit.getStyleClass().add("choiceButton");

        exit.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setScene(SignInScene.getSignInScene());
            stage.centerOnScreen();
        });

        VBox.setMargin(newGame , new Insets(8,0,10,0));
        buttonsChoices.getChildren().add(newGame);

        VBox.setMargin(continueGame , new Insets(8,0,10,0));
        buttonsChoices.getChildren().add(continueGame);

        VBox.setMargin(ranking , new Insets(8,0,10,0));
        buttonsChoices.getChildren().add(ranking);

        VBox.setMargin(exit , new Insets(8,0,10,0));
        buttonsChoices.getChildren().add(exit);

        VBox.setMargin(buttonsChoices,new Insets(26,0,10,0));
        container.getChildren().add(buttonsChoices);
        Scene scene= new Scene(container, 1300,750);

        VBox sizedBoxSeparator = new VBox();
        sizedBoxSeparator.setPrefHeight(500);

        container.getChildren().add(sizedBoxSeparator);

        HBox footer = new HBox();

            HBox highScoreContainer = new HBox();
            highScoreContainer.setAlignment(Pos.CENTER);
            ImageView cup = new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("images/cupIcon.png")).toExternalForm()));
            cup.setPreserveRatio(true);
            cup.setFitHeight(46);
            HBox.setMargin(cup,new Insets(0,6,0,0));
            record = new Text( String.valueOf(jeu.getPartie().getJoueur().getMeilleurScore()));
            record.getStyleClass().add("homeTxt");
            highScoreContainer.getChildren().add(cup);
            highScoreContainer.getChildren().add(record);

        footer.getChildren().add(highScoreContainer);

            HBox sizedBoxSep = new HBox();
            sizedBoxSep.setPrefWidth(2000);

        footer.getChildren().add(sizedBoxSep);

        ImageView soundIcon  = new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("images/soundIcon.png")).toExternalForm()));
        soundIcon.setFitHeight(38);
        soundIcon.setPreserveRatio(true);
        footer.getChildren().add(soundIcon);

        HBox.setMargin(soundIcon,new Insets(0,20,0,4));



        VBox.setMargin(footer,new Insets(4,0,16,26));
        container.getChildren().add(footer);

        scene.getStylesheets().addAll(Objects.requireNonNull(Main.class.getResource("css/style.css")).toExternalForm());





        return scene ;




    }

}
