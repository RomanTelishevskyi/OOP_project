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
import javafx.scene.input.MouseEvent;
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

    public void createBoard(){
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Tile tile = new Tile((x+y)%2==0);
                board.add(tile,x,y);
            }
        }
    }

    public void setDots(ArrayList<Point> legal_moves){
        for (Point legalMove : legal_moves) {
            //TODO change absolute path
            Image image = new Image("file:/C:/Users/rvtbd/IdeaProjects/OOP_project/src/main/resources/oop/project/P1.png");
            ImageView view = new ImageView(image);
            view.setFitWidth(100);
            view.setFitHeight(100);
            view.setOnMousePressed(e ->{
                int mouseX = (int)(e.getSceneX()/100);
                int mouseY = (int)(e.getSceneY()/100);
                piece.relocate(mouseX,mouseY);
                System.out.println(1234); //TODO find out how to move the piece
            });
            board.add(view, (int) legalMove.getX(), (int) legalMove.getY());
        }

    }

    public void createImage(){
        //TODO
        Image image = new Image("file:/C:/Users/rvtbd/IdeaProjects/OOP_project/src/main/resources/oop/project/Cthulhu.png");
        piece = new ImageView(image);
        piece.setFitWidth(100);
        piece.setFitHeight(100);
        board.add(piece,4,4);
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
    void test(MouseEvent event) {
        createBoard();
        createImage();
        piece.setOnMousePressed(e->{
            System.out.println(1);
            Monster ct = new cthulhu();
            Point point = new Point(4,4);
            setDots(ct.legal_move(point));

        });
    }

}