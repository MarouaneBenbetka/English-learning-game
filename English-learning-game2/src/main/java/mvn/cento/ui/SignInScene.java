package mvn.cento.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import mvn.cento.Main;

import java.io.IOException;
import java.util.Objects;

public class SignInScene {

    public static Scene getSignInScene() throws IOException {

            Parent root = FXMLLoader.load(Main.class.getResource("view/sign-in.fxml"));
            Scene scene = new Scene(root, 1000, 600);
            return scene;


    }
}
