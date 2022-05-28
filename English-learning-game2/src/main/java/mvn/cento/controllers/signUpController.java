package mvn.cento.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mvn.cento.ui.SignInScene;

import java.io.IOException;

public class signUpController {
    Stage stage;
    @FXML
    TextField sUserNameTextField;
    @FXML
    PasswordField sPassword;
    @FXML
    PasswordField sConfirmPassword;
    public void switchToSignIn(ActionEvent event) throws IOException {
        Scene scene = SignInScene.getSignInScene();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cento Game - Login");
        stage.show();
    }
    public void SignUpHandler(ActionEvent event) throws  IOException{
        String userName = sUserNameTextField.getText();
        String password = sPassword.getText();
        String confirmPassword = sConfirmPassword.getText();
        System.out.println("userName : " + userName + " password :  "+password + " confirmPassword : "+confirmPassword);
    }
}
