module oop.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens oop.project to javafx.fxml;
    exports oop.project;
}