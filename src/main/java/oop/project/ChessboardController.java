package oop.project;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.util.ArrayList;

public class ChessboardController extends Implementation {

    @FXML
    private GridPane board;

    @FXML
    private ImageView piece;

    public ImageView point;

    private int mouseX;

    private int mouseY;

    private Monster monster;

    public void createMonster(int n) {
        switch (n) {
            case 1:
                monster = new Phoenix();
                break;
            case 2:
                monster = new Cthulhu();
                break;
            case 3:
                monster = new Worm();
                break;
        }
        createImage();
    }

    public void setDots(ArrayList<Point> legal_moves) {
        for (Point legalMove : legal_moves) {

            javafx.scene.image.Image image = new Image("file:src/main/resources/oop/project/P1.png");
            point = new ImageView(image);
            point.setFitWidth(100);
            point.setFitHeight(100);
            point.setOnMousePressed(e -> {
                for (Point legal_Move : legal_moves) {
                    deleteDots(legal_Move);
                }
                mouseX = (int) (e.getSceneX() / 100);
                mouseY = (int) (e.getSceneY() / 100);
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

    public void createImage() {
        Image image = new Image(monster.getUrl());
        piece = new ImageView(image);
        piece.setFitWidth(100);
        piece.setFitHeight(100);
        board.add(piece, (int) monster.getStarting_position().getX(), (int) monster.getStarting_position().getY());
    }

    @FXML
    void test() {
        piece.setOnMousePressed(e -> {
            Point piece_position = new Point(GridPane.getColumnIndex(piece), GridPane.getRowIndex(piece));
            setDots(monster.legal_move(piece_position));
        });
    }

}
