package oop.project;

import java.awt.*;
import java.util.ArrayList;

public class Implementation {

    public abstract static class Monster{

        public abstract ArrayList<Point> legal_move(Point staring_position);

        public Monster(Point starting_position, String url){
        }
    }

    public static class Cthulhu extends Monster{

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
        public Cthulhu(Point starting_position, String url){
            super(starting_position,url);
        }
        public Cthulhu(){
            super(new Point(7,4),"file:src/main/resources/oop/project/Cthulhu.png");
        }
    }
}
