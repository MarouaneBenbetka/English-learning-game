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

import java.util.Objects;
import java.util.Stack;

public class DefinitionPopUp {

    public static String rightAnswer="holaad" ;

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
        Text definition = new Text("This is a tool to play with other  bla bala abdsfljasdlasdhflasdf");
        definition.getStyleClass().add("popUpTxt");
        definition.setWrappingWidth(width-60);


        container.getChildren().add(popUpTitle);
        container.getChildren().add(definition);




        TextField answer = new TextField();
        answer.setId("word-input");
        answer.setAlignment(Pos.CENTER);
        answer.setMaxWidth(rightAnswer.length()*30);
        answer.setPromptText("here");

        int maxLength = rightAnswer.length();

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
            PlateauScene.removePopUp();
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
}
