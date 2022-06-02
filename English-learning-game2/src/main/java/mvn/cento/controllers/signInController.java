package mvn.cento.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mvn.cento.Noyeau.Exceptions.motDePasseIncorrectException;
import mvn.cento.Noyeau.Exceptions.utilisateurNonExistantException;
import mvn.cento.ui.HomeScene;
import mvn.cento.ui.SignUpScene;

import java.io.IOException;

public class signInController {
    private Stage stage;
    @FXML
    TextField userNameTextField;
    @FXML
    PasswordField passwordTextField;
    @FXML
    Text userNameErrorSignIn;
    @FXML
    Text PasswordErrorSignIn;

    public void switchToSignUp(ActionEvent event) throws IOException {
        Scene scene = SignUpScene.getSignUpScene();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cento Game - SignUp");
        stage.show();
    }
    public void SignInHandler(ActionEvent event) {
        String username = userNameTextField.getText();
        String password = passwordTextField.getText();
        System.out.println("username = " + username + " password = "+password);

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        try {
            PasswordErrorSignIn.setVisible(false);
            userNameErrorSignIn.setVisible(false);
            passwordTextField.setStyle("-fx-border-color: #6745F0");
            userNameTextField.setStyle("-fx-border-color: #6745F0");


            HomeScene.jeu.identifier(username,password);
            stage.setScene(HomeScene.getHomeScence());
            stage.setTitle("Cento Game - Home");
            stage.centerOnScreen();


        } catch (motDePasseIncorrectException  ex) {
            PasswordErrorSignIn.setVisible(true);

            passwordTextField.setStyle("-fx-border-color: red");
        } catch (utilisateurNonExistantException e) {
            userNameErrorSignIn.setVisible(true);
            userNameTextField.setStyle("-fx-border-color: red");

        }


    }
}
