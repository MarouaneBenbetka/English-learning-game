package mvn.cento.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import mvn.cento.Main;

import java.io.IOException;
import java.util.Objects;

public class SignUpScene {

    public static Scene getSignUpScene() throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("view/sign-up.fxml")));

        Scene scene = new Scene(root, 900, 580);

        Text text = (Text) scene.lookup("#getStarted");
        VBox.setMargin(text , new Insets(0,0,20,0));



        Text error1 = (Text) scene.lookup("#ConfirmPasswordErrorSignUp");
        error1.setVisible(false);
        error1 =  (Text) scene.lookup("#PasswordErrorSignUp");
        error1.setVisible(false);
        error1 =  (Text) scene.lookup("#UsernameErrorSignUp");
        error1.setVisible(false);

        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("css/style.css")).toExternalForm());
        return scene;


    }
}
