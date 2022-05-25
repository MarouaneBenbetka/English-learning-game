package mvn.cento;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Scene scene = new Scene(new Button());
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