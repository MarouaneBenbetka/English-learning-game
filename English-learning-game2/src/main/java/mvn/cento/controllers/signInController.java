package mvn.cento.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mvn.cento.ui.SignUpScene;

import java.io.IOException;

public class signInController {
    private Stage stage;
    @FXML
    TextField userNameTextField;
    @FXML
    PasswordField passwordTextField;
    public void switchToSignUp(ActionEvent event) throws IOException {
        Scene scene = SignUpScene.getSignUpScene();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cento Game - SignUp");
        stage.show();
    }
    public void SignInHandler(ActionEvent event) throws  IOException{
        String username = userNameTextField.getText();
        String password = passwordTextField.getText();
        System.out.println("username = " + username + " password = "+password);
    }
}
