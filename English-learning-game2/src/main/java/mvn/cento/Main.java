package mvn.cento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mvn.cento.Noyeau.Exceptions.*;
import mvn.cento.Noyeau.*;
import mvn.cento.ui.PlateauScene;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, motDePasseIncorrectException, utilisateurNonExistantException, utilisateurDejaExistantException {



        Jeu jeu = new Jeu();




        jeu.creerCompte("Marouane"  , "111");
        jeu.getPartie().creerPartie();
        //jeu.getPartie().lancerPartie();



        Scene scene = PlateauScene.getPlateauScene( jeu.getPartie());







        //scene = new Scene(new Button());
        //window settings
        stage.setScene(scene);

        //stage.setFullScreen(true);
        stage.setTitle("Cento Game");
        stage.getIcons().add(new Image(Main.class.getResource("images/logo.png").toExternalForm()));
        stage.show();
        stage.centerOnScreen();



    }

    public static void main(String[] args) {
        launch();
    }
}