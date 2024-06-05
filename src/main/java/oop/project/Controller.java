package oop.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller extends Implementation {

    @FXML
    private Button Cthulhu;

    @FXML
    private Button Phoenix;

    @FXML
    private Button Worm;

    @FXML
    public GridPane board;

    @FXML
    public ImageView piece;

    public ImageView point;

    private int mouseX;

    private int mouseY;

    public void switchScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Chessboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setDots(ArrayList<Point> legal_moves){
        for (Point legalMove : legal_moves) {

            Image image = new Image("file:src/main/resources/oop/project/P1.png");
            point = new ImageView(image);
            point.setFitWidth(100);
            point.setFitHeight(100);
            point.setOnMousePressed(e ->{
                for (Point legal_Move : legal_moves){
                    deleteDots(legal_Move);
                }
                mouseX = (int)(e.getSceneX()/100);
                mouseY = (int)(e.getSceneY()/100);
                GridPane.setColumnIndex(piece, mouseX);
                GridPane.setRowIndex(piece, mouseY);
            });
            board.add(point, (int) legalMove.getX(), (int) legalMove.getY());
        }
    }
    private void deleteDots(Point point) {
        board.getChildren().removeIf(node ->
                GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) == point.getX() &&
                        GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == point.getY()
        );
    }

    //TODO from here on out

    public void createImage(){
        Image image = new Image("file:src/main/resources/oop/project/Cthulhu.png");
        piece = new ImageView(image);
        piece.setFitWidth(100);
        piece.setFitHeight(100);
        board.add(piece,0,0);
    }


    @FXML
    void on_cthulhu(ActionEvent event) throws IOException {
        switchScene(event);
    }

    @FXML
    void on_phoenix(ActionEvent event) throws IOException {
        switchScene(event);
    }

    @FXML
    void on_worm(ActionEvent event) throws IOException {
        switchScene(event);
    }
    @FXML
    void test() {
        createImage();
        Monster ct = new Cthulhu();
        piece.setOnMousePressed(e->{
            System.out.println(1);
            Point piece_position = new Point(GridPane.getColumnIndex(piece),GridPane.getRowIndex(piece));
            setDots(ct.legal_move(piece_position));
        });
    }

}