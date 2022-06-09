package mvn.cento.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mvn.cento.Main;
import mvn.cento.Noyeau.CaseDefinition;
import mvn.cento.Noyeau.EnonceDefinition;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.Stack;

public class DefinitionPopUp {

    public static EnonceDefinition enonceDefinition ;
    private static int lastPos ;
    private static Button continueButton;

    public static GridPane getDefinitionPopUp(){

        VBox container = new VBox();
        int width = 500 ;
        int height = 450 ;
        container.setPrefWidth(width);
        container.setPrefHeight(height);
        container.setMaxWidth(width+200);
        container.setMaxHeight(height);

        Text popUpTitle = new Text("Guess the right word :");
        popUpTitle.getStyleClass().add("popUpTitle");
        Text definition = new Text(enonceDefinition.getQuestion());
        definition.getStyleClass().add("popUpTxt");
        definition.setWrappingWidth(width-60);


        container.getChildren().add(popUpTitle);
        container.getChildren().add(definition);




        TextField answer = new TextField();
        answer.getStyleClass().add("word-input");
        answer.setAlignment(Pos.CENTER);
        answer.setMaxWidth(enonceDefinition.getReponse().length()*30);
        answer.setPromptText("here");

        int maxLength = enonceDefinition.getReponse().length();

        answer.textProperty().addListener(new ChangeListener<String>() {
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (answer.getText().length() > maxLength) {
                    String s = answer.getText().substring(0, maxLength);
                    answer.setText(s);
                }
            }
        });

        container.getChildren().add(answer);

        Text hint = new Text("HINT : The word contain "+maxLength+" characters");
        hint.setId("hint");
        hint.setTextAlignment(TextAlignment.CENTER);
        container.getChildren().add(hint);

        Button submitButton = new Button("submit");
        submitButton.getStyleClass().add("purpuleButton");
        submitButton.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            answer.setEditable(false);
            String textFiledAnswer = answer.getText();
            lastPos = PlateauScene.getPartie().getPlateau().getPositionCourante()+1 ;
            boolean res =  ((CaseDefinition)PlateauScene.getPartie().getPlateau().getCaseCourante()).verifyerReponse(textFiledAnswer);
            PlateauScene.getPartie().getPlateau().getCaseCourante().traiter(PlateauScene.getPartie());

            generateAudio(res);
            Text feedback = new Text();
            feedback.getStyleClass().add("feedBackTxt");
            if(res){
                answer.getStyleClass().add("bonneReponse");
                feedback.setText("Good job");
            }else {
                answer.getStyleClass().add("movaiseReponse");
                feedback.setText("The right answer was \""+ enonceDefinition.getReponse()+"\"");
            }

            container.getChildren().remove(submitButton);
            container.getChildren().add(feedback);
            container.getChildren().add(continueButton);
            VBox.setMargin(continueButton,new Insets(20,0,10,0));

        });

        continueButton = new Button("continue");
        continueButton.getStyleClass().add("purpuleButton");
        continueButton.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {


            PlateauScene.removePopUp();
            PlateauScene.movePion(lastPos ,PlateauScene.getPartie().getPlateau().getPositionCourante()+1  );
            PlateauScene.setScore(PlateauScene.getPartie().getScore());
        });


        container.getChildren().add(submitButton);

        VBox.setMargin(popUpTitle,new Insets(30,0,10,0));
        VBox.setMargin(definition,new Insets(10,8,10,16));
        VBox.setMargin(answer,new Insets(40,0,0,0));
        VBox.setMargin(hint,new Insets(4,0,30,0));
        VBox.setMargin(submitButton,new Insets(20,0,10,0));


        container.setAlignment(Pos.TOP_CENTER);
        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(container);
        gridPane.setId("defPopUp");
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
        gridPane.setMaxWidth(width);
        gridPane.setMaxHeight(height);
        return gridPane;
    }


    public static void setEnonceDefinition(EnonceDefinition enonceDefinition){
        DefinitionPopUp.enonceDefinition = enonceDefinition;
    }


    private static void generateAudio(boolean res){
        try{
            URL resourceUrl;
            if(res) {
                resourceUrl = Main.class.getResource("audio/correct.wav");
            }
            else{
                resourceUrl = Main.class.getResource("audio/error.wav");
            }

            assert resourceUrl != null;
            File file = new File(resourceUrl.toURI());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip  = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
