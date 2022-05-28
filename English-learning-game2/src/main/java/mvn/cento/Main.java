package mvn.cento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mvn.cento.Noyeau.Exceptions.*;
import mvn.cento.Noyeau.*;
import mvn.cento.ui.SignInScene;
import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, motDePasseIncorrectException, utilisateurNonExistantException, utilisateurDejaExistantException {
        Jeu jeu = new Jeu();

        Scene scene = SignInScene.getSignInScene();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Cento Game - Login");
        stage.getIcons().add(new Image(Main.class.getResource("images/logo.png").toExternalForm()));
        stage.show();
        stage.centerOnScreen();


    }

    public static void main(String[] args) {
        launch();
    }
}