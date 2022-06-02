package mvn.cento.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mvn.cento.Noyeau.Exceptions.*;
import mvn.cento.ui.HomeScene;
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

    @FXML
    Text ConfirmPasswordErrorSignUp;

    @FXML
    Text PasswordErrorSignUp;

    @FXML
    Text UsernameErrorSignUp;

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

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        try {

            ConfirmPasswordErrorSignUp.setVisible(false);
            PasswordErrorSignUp.setVisible(false);
            UsernameErrorSignUp.setVisible(false);


            sUserNameTextField.setStyle("-fx-border-color: #6745F0");
            sPassword.setStyle("-fx-border-color: #6745F0");
            sConfirmPassword.setStyle("-fx-border-color: #6745F0");


            HomeScene.jeu.creerCompte(userName,password , confirmPassword);
            stage.setScene(HomeScene.getHomeScence());
            stage.setTitle("Cento Game - Home");
            stage.centerOnScreen();

        } catch (utilisateurDejaExistantException  e) {
            UsernameErrorSignUp.setText("User name already exists");
            UsernameErrorSignUp.setVisible(true);

            sUserNameTextField.setStyle("-fx-border-color: red");


        } catch (nomUtilisateurVideException e) {
            UsernameErrorSignUp.setText("User name is required");
            UsernameErrorSignUp.setVisible(true);

            sUserNameTextField.setStyle("-fx-border-color: red");


        } catch (confirmMotDePasseException e) {
            ConfirmPasswordErrorSignUp.setText("Not the same");
            PasswordErrorSignUp.setText("Not the same");
            ConfirmPasswordErrorSignUp.setVisible(true);
            PasswordErrorSignUp.setVisible(true);

            sConfirmPassword.setStyle("-fx-border-color: red");
            sPassword.setStyle("-fx-border-color: red");

        } catch (motDePasseVideException e) {
            PasswordErrorSignUp.setText("Password is required");
            PasswordErrorSignUp.setVisible(true);
            sPassword.setStyle("-fx-border-color: red");

        } catch (confirmMotDePasseVideException e) {
            ConfirmPasswordErrorSignUp.setText("Confirm password is required");
            ConfirmPasswordErrorSignUp.setVisible(true);
            sConfirmPassword.setStyle("-fx-border-color: red");

        }


    }
}
