package mvn.cento;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mvn.cento.ui.SignInScene;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException{

        stage.setScene(SignInScene.getSignInScene());
        stage.setTitle("Cento Game -Sign In");
        stage.getIcons().add(new Image(Main.class.getResource("images/logo.png").toExternalForm()));
        stage.show();
        stage.centerOnScreen();



    }

    public static void main(String[] args) {

        launch();
    }
}