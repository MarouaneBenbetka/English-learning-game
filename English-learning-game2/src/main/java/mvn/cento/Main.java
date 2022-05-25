package mvn.cento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mvn.cento.ui.Plateau;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Scene scene = Plateau.getPlateauScene();












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