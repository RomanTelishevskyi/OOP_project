package oop.project;

import javafx.scene.shape.Circle;

import java.awt.*;
import java.util.ArrayList;

public class Implementation {

    public interface Monster{

        ArrayList<Point> legal_move(Point staring_position);

    }

    public static class cthulhu extends Controller implements Monster{

        @Override
        public ArrayList<Point> legal_move(Point start) {
            ArrayList<Point> res = new ArrayList<>();
            int x = (int) start.getX();
            int y = (int) start.getY();
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if(i == 0 && j == 0) continue;
                    if((x+i<=7&&x+i>=0)&&(y+j<=7&&y+j>=0)){
                        Point point = new Point();
                        point.x = x+i;
                        point.y = y+j;
                        res.add(point);
                    }
                }
            }
            return res;
        }
    }
}
