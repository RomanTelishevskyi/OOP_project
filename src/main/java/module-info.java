module oop.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.project to javafx.fxml;
    exports oop.project;
}