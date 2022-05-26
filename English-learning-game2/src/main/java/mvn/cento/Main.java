package mvn.cento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mvn.cento.Noyeau.Exceptions.*;
import mvn.cento.Noyeau.*;
import mvn.cento.ui.PlateauScene;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, motDePasseIncorrectException, utilisateurNonExistantException {

        Jeu jeu = new Jeu();




        jeu.identifier("Marouane"  , "111");
        jeu.getPartie().creerPartie();
        //jeu.getPartie().lancerPartie();



        Scene scene = PlateauScene.getPlateauScene( jeu.getPartie().getPlateau());












        //window settings
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setTitle("Cento Game");
        stage.getIcons().add(new Image(Main.class.getResource("images/logo.png").toExternalForm()));
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}