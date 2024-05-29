package oop.project;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public Tile(boolean color){
        setWidth(100);
        setHeight(100);
        setFill(color ?  Color.valueOf("#feb") : Color.valueOf("#582"));
    }

}

