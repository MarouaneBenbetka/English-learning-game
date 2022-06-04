package mvn.cento.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import mvn.cento.Main;
import mvn.cento.Noyeau.CaseImage;
import mvn.cento.Noyeau.EnonceImage;
import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;
import java.util.Objects;

public class ImagePopUp {


    public static EnonceImage enonceImage ;
    public static final String prefixPath = "images/questions/";
    private static int reponseIndex  ;

    private static AnchorPane option1;
    private static AnchorPane option2;
    private static AnchorPane option3;
    private static AnchorPane option4;
    private static Button continueButton;

    public static GridPane getImagePopUp(){

        reponseIndex = -1 ;

        VBox container = new VBox();
        int width = 500 ;
        int height = 450 ;
        container.setPrefWidth(width);
        container.setPrefHeight(height);
        container.setMaxWidth(width);
        container.setMaxHeight(height);

        Text popUpTitle = new Text("Choose the right image :");
        popUpTitle.getStyleClass().add("popUpTitle");
        Text definition = new Text(enonceImage.getQuestion());
        definition.getStyleClass().add("popUpTxt");
        definition.setWrappingWidth(width-60);


        container.getChildren().add(popUpTitle);
        container.getChildren().add(definition);




        GridPane answers = new GridPane();
        answers.setAlignment(Pos.CENTER);


        Image image1 = new Image(Objects.requireNonNull(Main.class.getResource(prefixPath+enonceImage.getImagesUrl()[0])).toExternalForm());
        BackgroundImage bgImage1 = new BackgroundImage(
                image1,                                                 // image
                BackgroundRepeat.NO_REPEAT,                            // repeatX
                BackgroundRepeat.NO_REPEAT,                            // repeatY
                BackgroundPosition.CENTER,                             // position
                new BackgroundSize(-1, -1, false, false, false, true)  // size
        );
        option1 = new AnchorPane();
        option1.getStyleClass().add("ImageContainer");
        option1.setPrefWidth(200);
        option1.setPrefHeight(150);
        option1.setBackground(new Background(bgImage1));

        option1.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {


            if(reponseIndex == -1){
                generateAudio(0);

                revealAnswers();
                reponseIndex = 0;
            }


        });


        Image image2 = new Image(Objects.requireNonNull(Main.class.getResource(prefixPath+enonceImage.getImagesUrl()[1])).toExternalForm());
        BackgroundImage bgImage2 = new BackgroundImage(
                image2,                                                 // image
                BackgroundRepeat.NO_REPEAT,                            // repeatX
                BackgroundRepeat.NO_REPEAT,                            // repeatY
                BackgroundPosition.CENTER,                             // position
                new BackgroundSize(-1, -1, false, false, false, true)  // size
        );
        option2 = new AnchorPane();
        option2.getStyleClass().add("ImageContainer");
        option2.setPrefWidth(200);
        option2.setPrefHeight(150);
        option2.setBackground(new Background(bgImage2));

        option2.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {


            if(reponseIndex == -1){
                generateAudio(1);

                revealAnswers();
                reponseIndex = 1;
            }
        });


        Image image3 = new Image(Objects.requireNonNull(Main.class.getResource(prefixPath+enonceImage.getImagesUrl()[2])).toExternalForm());
        BackgroundImage bgImage3 = new BackgroundImage(
                image3,                                                 // image
                BackgroundRepeat.NO_REPEAT,                            // repeatX
                BackgroundRepeat.NO_REPEAT,                            // repeatY
                BackgroundPosition.CENTER,                             // position
                new BackgroundSize(-1, -1, false, false, false, true)  // size
        );

        option3 = new AnchorPane();
        option3.getStyleClass().add("ImageContainer");
        option3.setPrefWidth(200);
        option3.setPrefHeight(150);
        option3.setBackground(new Background(bgImage3));

        option3.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {


            if(reponseIndex == -1){
                generateAudio(2);

                revealAnswers();
                reponseIndex = 2;
            }
        });


        Image image4 = new Image(Objects.requireNonNull(Main.class.getResource(prefixPath+enonceImage.getImagesUrl()[3])).toExternalForm());
        BackgroundImage bgImage4 = new BackgroundImage(
                image4,                                                 // image
                BackgroundRepeat.NO_REPEAT,                            // repeatX
                BackgroundRepeat.NO_REPEAT,                            // repeatY
                BackgroundPosition.CENTER,                             // position
                new BackgroundSize(-1, -1, false, false, false, true)  // size
        );



        option4 = new AnchorPane();
        option4.getStyleClass().add("ImageContainer");
        option4.setPrefWidth(200);
        option4.setPrefHeight(150);
        option4.setBackground(new Background(bgImage4));

        option4.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {



            if(reponseIndex == -1){
                generateAudio(3);
                revealAnswers();
                reponseIndex = 3;
            }
        });


        answers.add(option1,0,0);
        answers.add(option2,0,1);
        answers.add(option3,1,0);
        answers.add(option4,1,1);



        GridPane.setMargin(option1,new Insets(4));
        GridPane.setMargin(option2,new Insets(4));
        GridPane.setMargin(option3,new Insets(4));
        GridPane.setMargin(option4,new Insets(4));


        container.getChildren().add(answers);

        continueButton = new Button("continue");
        continueButton.getStyleClass().add("purpuleButton");
        continueButton.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
           traiterReponse(reponseIndex);
        });

        container.getChildren().add(continueButton);
        continueButton.setVisible(false);


        VBox.setMargin(popUpTitle,new Insets(30,0,10,0));
        VBox.setMargin(definition,new Insets(10,8,10,16));
        VBox.setMargin(answers,new Insets(20,0,0,0));
        VBox.setMargin(continueButton,new Insets(8,0,12,0));


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


    public static void setEnonceImage(EnonceImage enonceImage){
        ImagePopUp.enonceImage = enonceImage;
    }


    public static void traiterReponse(int index){
        int lastPos = PlateauScene.getPartie().getPlateau().getPositionCourante()+1 ;
        boolean res =  ((CaseImage)PlateauScene.getPartie().getPlateau().getCaseCourante()).verifyerReponse(index);
        PlateauScene.getPartie().getPlateau().getCaseCourante().traiter(PlateauScene.getPartie());
        PlateauScene.removePopUp();
        if(res ){
            PlateauScene.movePion(lastPos ,PlateauScene.getPartie().getPlateau().getPositionCourante()+1  );
            PlateauScene.setScore(PlateauScene.getPartie().getScore());
        }
    }


    private static void generateAudio(int indexReponse){
        try{
            URL resourceUrl;
            if(enonceImage.getIndiceBonneReponse() == indexReponse) {
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

    private static void revealAnswers(){

        option1.getStyleClass().add("movaiseReponse");
        option2.getStyleClass().add("movaiseReponse");
        option3.getStyleClass().add("movaiseReponse");
        option4.getStyleClass().add("movaiseReponse");

        switch (enonceImage.getIndiceBonneReponse()){
            case 0 :
                option1.getStyleClass().remove("movaiseReponse");
                option1.getStyleClass().add("bonneReponse");
                break;
            case 1 :
                option2.getStyleClass().remove("movaiseReponse");
                option2.getStyleClass().add("bonneReponse");
                break;
            case 2 :
                option3.getStyleClass().remove("movaiseReponse");
                option3.getStyleClass().add("bonneReponse");
                break;
            case 3 :
                option4.getStyleClass().remove("movaiseReponse");
                option4.getStyleClass().add("bonneReponse");
                break;
        }

        continueButton.setVisible(true);



    }

}
