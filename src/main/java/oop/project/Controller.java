package oop.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button Cthulhu;

    @FXML
    private Button Jörmungandr;

    @FXML
    private Button Worm;

    @FXML
    public GridPane board;

    @FXML
    public ImageView piece;

    private Stage stage;

    private Scene scene;

    private Parent root;

    public void switchScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Chessboard.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void on_cthulhu(ActionEvent event) throws IOException {
        switchScene(event);
    }

    @FXML
    void on_jörmungandr(ActionEvent event) throws IOException {
        switchScene(event);
    }

    @FXML
    void on_worm(ActionEvent event) throws IOException {
        switchScene(event);
    }
    @FXML
    void test(MouseEvent event) {

    }
}