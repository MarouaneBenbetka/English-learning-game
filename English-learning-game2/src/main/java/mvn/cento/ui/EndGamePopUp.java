package mvn.cento.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class EndGamePopUp {

    public static String rightAnswer="holaad" ;

    public static GridPane getEndGamePopUp(){

        VBox container = new VBox();
        int width = 500 ;
        int height = 450 ;
        container.setPrefWidth(width);
        container.setPrefHeight(height);
        container.setMaxWidth(width+200);
        container.setMaxHeight(height);

        Text popUpTitle = new Text("Game Over");
        popUpTitle.getStyleClass().add("popUpTitle");
        Text definition = new Text("Congrats you hvae just completed an adventure of 100 case.");
        definition.getStyleClass().add("popUpTxt");
        definition.setWrappingWidth(width-60);

        Text totalScore = new Text("Total Score : 100");
        totalScore.getStyleClass().add("popUpTxt");
        Text topRecord = new Text("Personal record : 1000");
        topRecord.getStyleClass().add("popUpTxt");
        Text worldRecord = new Text("World record : 6969");
        worldRecord.getStyleClass().add("popUpTxt");


        Text recordTxt = new Text("10 points left to beat your old record");
        recordTxt.getStyleClass().add("small-black-txt");
        Text worldRecordTxt = new Text("20 points left to beat the world record");
        worldRecordTxt.getStyleClass().add("small-black-txt");

        container.getChildren().add(popUpTitle);
        container.getChildren().add(definition);
        container.getChildren().add(totalScore);
        container.getChildren().add(topRecord);
        container.getChildren().add(recordTxt);
        container.getChildren().add(worldRecord);
        container.getChildren().add(worldRecordTxt);


        Button submitButton = new Button("Back to home");
        submitButton.getStyleClass().add("purpuleButton");
        submitButton.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            PlateauScene.removePopUp();
        });

        container.getChildren().add(submitButton);

        VBox.setMargin(popUpTitle,new Insets(30,0,10,0));
        VBox.setMargin(definition,new Insets(10,8,10,16));
        VBox.setMargin(totalScore,new Insets(20,0,10,0));
        VBox.setMargin(topRecord,new Insets(4,0,2,0));
        VBox.setMargin(recordTxt,new Insets(0,0,6,0));

        VBox.setMargin(worldRecord,new Insets(4,0,2,0));

        VBox.setMargin(worldRecordTxt,new Insets(0,0,4,0));
        VBox.setMargin(submitButton,new Insets(30,0,26,0));


        container.setAlignment(Pos.TOP_CENTER);
        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(container);
        gridPane.setId("endPopUp");
        gridPane.setPrefWidth(width);
        gridPane.setPrefHeight(height);
        gridPane.setMaxWidth(width);
        gridPane.setMaxHeight(height);
        return gridPane;
    }


}
