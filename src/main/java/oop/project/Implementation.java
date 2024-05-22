package oop.project;

import java.awt.*;
import java.util.ArrayList;

public class Implementation {

    public interface Monster{

        Point staring_position = null;

        ArrayList<Point> possible_moves = new ArrayList();

        ArrayList<Point> legal_move(Point staring_position);

    }

    public class cthulhu extends Controller implements Monster{

        @Override
        public ArrayList<Point> legal_move(Point start) {

        }
    }
}
