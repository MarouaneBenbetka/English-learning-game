package mvn.cento;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mvn.cento.ui.PlateauScene;
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


        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            if(PlateauScene.plateau != null){
                if( (double)newVal < 1182){
                    PlateauScene.plateau.setScaleX(1);

                }
                else if((double)newVal < 1300){
                    PlateauScene.plateau.setScaleX(1.2);
                }else {
                    PlateauScene.plateau.setScaleX(1.3);

                }
            }

        });
        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            if(PlateauScene.plateau != null){
                if((double)newVal < 680){
                    PlateauScene.plateau.setScaleY(0.8);
                }
                else if((double)newVal < 770){
                    PlateauScene.plateau.setScaleY(0.85);
                }else {
                    PlateauScene.plateau.setScaleY(0.99);
                }
            }
        });



    }

    public static void main(String[] args) {

        launch();
    }
}