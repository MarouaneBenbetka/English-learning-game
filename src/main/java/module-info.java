module mvn.englishlearninggame2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens mvn.cento to javafx.fxml;
    exports mvn.cento;
    exports mvn.cento.controllers;
    opens mvn.cento.controllers to javafx.fxml;
}