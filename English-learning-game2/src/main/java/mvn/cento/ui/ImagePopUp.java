package mvn.cento.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import mvn.cento.Main;

import java.util.Objects;

public class ImagePopUp {
    public static String[] options ={"images/image.jpg","images/image.jpg","images/image.jpg","images/image.jpg"};

    public static GridPane getImagePopUp(){

        VBox container = new VBox();
        int width = 500 ;
        int height = 450 ;
        container.setPrefWidth(width);
        container.setPrefHeight(height);
        container.setMaxWidth(width);
        container.setMaxHeight(height);

        Text popUpTitle = new Text("Choose the right image :");
        popUpTitle.getStyleClass().add("popUpTitle");
        Text definition = new Text("This is a tool to play with other  bla bala abdsfljasdlasdhflasdf");
        definition.getStyleClass().add("popUpTxt");
        definition.setWrappingWidth(width-60);


        container.getChildren().add(popUpTitle);
        container.getChildren().add(definition);




        GridPane answers = new GridPane();
        answers.setAlignment(Pos.CENTER);


        Image image1 = new Image(Objects.requireNonNull(Main.class.getResource(options[0])).toExternalForm());
        BackgroundImage bgImage1 = new BackgroundImage(
                image1,                                                 // image
                BackgroundRepeat.NO_REPEAT,                            // repeatX
                BackgroundRepeat.NO_REPEAT,                            // repeatY
                BackgroundPosition.CENTER,                             // position
                new BackgroundSize(-1, -1, false, false, false, true)  // size
        );
        AnchorPane option1 = new AnchorPane();
        option1.getStyleClass().add("ImageContainer");
        option1.setPrefWidth(200);
        option1.setPrefHeight(150);
        option1.setBackground(new Background(bgImage1));

        option1.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            PlateauScene.removePopUp();
        });


        Image image2 = new Image(Objects.requireNonNull(Main.class.getResource(options[0])).toExternalForm());
        BackgroundImage bgImage2 = new BackgroundImage(
                image2,                                                 // image
                BackgroundRepeat.NO_REPEAT,                            // repeatX
                BackgroundRepeat.NO_REPEAT,                            // repeatY
                BackgroundPosition.CENTER,                             // position
                new BackgroundSize(-1, -1, false, false, false, true)  // size
        );
        AnchorPane option2 = new AnchorPane();
        option2.getStyleClass().add("ImageContainer");
        option2.setPrefWidth(200);
        option2.setPrefHeight(150);
        option2.setBackground(new Background(bgImage2));

        option2.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            PlateauScene.removePopUp();
        });


        Image image3 = new Image(Objects.requireNonNull(Main.class.getResource(options[0])).toExternalForm());
        BackgroundImage bgImage3 = new BackgroundImage(
                image3,                                                 // image
                BackgroundRepeat.NO_REPEAT,                            // repeatX
                BackgroundRepeat.NO_REPEAT,                            // repeatY
                BackgroundPosition.CENTER,                             // position
                new BackgroundSize(-1, -1, false, false, false, true)  // size
        );

        AnchorPane option3 = new AnchorPane();
        option3.getStyleClass().add("ImageContainer");
        option3.setPrefWidth(200);
        option3.setPrefHeight(150);
        option3.setBackground(new Background(bgImage3));

        option3.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            PlateauScene.removePopUp();
        });


        Image image4 = new Image(Objects.requireNonNull(Main.class.getResource(options[0])).toExternalForm());
        BackgroundImage bgImage4 = new BackgroundImage(
                image4,                                                 // image
                BackgroundRepeat.NO_REPEAT,                            // repeatX
                BackgroundRepeat.NO_REPEAT,                            // repeatY
                BackgroundPosition.CENTER,                             // position
                new BackgroundSize(-1, -1, false, false, false, true)  // size
        );



        AnchorPane option4 = new AnchorPane();
        option4.getStyleClass().add("ImageContainer");
        option4.setPrefWidth(200);
        option4.setPrefHeight(150);
        option4.setBackground(new Background(bgImage4));

        option4.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            PlateauScene.removePopUp();
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


        VBox.setMargin(popUpTitle,new Insets(30,0,10,0));
        VBox.setMargin(definition,new Insets(10,8,10,16));
        VBox.setMargin(answers,new Insets(20,0,30,0));

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

}
