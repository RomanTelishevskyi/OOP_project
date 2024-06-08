package oop.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ChoosingSceneController extends Implementation {

    public void switchScene(ActionEvent event, int n) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Chessboard.fxml"));
        Parent root = loader.load();
        ChessboardController controller = loader.getController();
        controller.createMonster(n);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void on_cthulhu(ActionEvent event) throws IOException {
        switchScene(event, 2);
    }

    @FXML
    void on_phoenix(ActionEvent event) throws IOException {
        switchScene(event, 1);
    }

    @FXML
    void on_worm(ActionEvent event) throws IOException {
        switchScene(event, 3);
    }
}