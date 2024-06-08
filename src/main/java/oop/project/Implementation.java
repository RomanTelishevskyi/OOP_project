package oop.project;

import java.awt.*;
import java.util.ArrayList;

public class Implementation {

    public abstract static class Monster {

        private String url;

        private Point starting_position;

        public Monster(Point starting_position, String url) {
            this.starting_position = starting_position;
            this.url = url;
        }

        public Point getStarting_position() {
            return starting_position;
        }

        public void setStarting_position(Point starting_position) {
            this.starting_position = starting_position;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public abstract ArrayList<Point> legal_move(Point staring_position);

        public boolean isInRange(int x, int y, int i, int j) {
            return (x + i <= 7 && x + i >= 0) && (y + j <= 7 && y + j >= 0);
        }

    }

    public static class Cthulhu extends Monster {

        public Cthulhu(Point starting_position, String url) {
            super(starting_position, url);
        }

        public Cthulhu() {
            super(new Point(4, 7), "file:src/main/resources/oop/project/Cthulhu.png");
        }

        @Override
        public ArrayList<Point> legal_move(Point start) {
            ArrayList<Point> res = new ArrayList<>();
            int x = (int) start.getX();
            int y = (int) start.getY();
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    if (isInRange(x, y, i, j)) {
                        Point point = new Point();
                        point.x = x + i;
                        point.y = y + j;
                        res.add(point);
                    }
                }
            }
            return res;
        }
    }

    public static class Phoenix extends Monster {

        public Phoenix(Point starting_position, String url) {
            super(starting_position, url);
        }

        public Phoenix() {
            super(new Point(1, 7), "file:src/main/resources/oop/project/Phoenix.png");
        }

        @Override
        public ArrayList<Point> legal_move(Point start) {
            ArrayList<Point> res = new ArrayList<>();
            int x = (int) start.getX();
            int y = (int) start.getY();
            for (int i = -2; i < 3; i++) {
                for (int j = -2; j < 3; j++) {
                    if (i == 0 || j == 0 || ((i == 1 || i == -1) && (j == 1 || j == -1)) || ((i == 2 || i == -2) && (j == 2 || j == -2)))
                        continue;
                    if (isInRange(x, y, i, j)) {
                        Point point = new Point();
                        point.x = x + i;
                        point.y = y + j;
                        res.add(point);
                    }
                }
            }
            return res;
        }
    }

    public static class Worm extends Monster {

        public Worm(Point starting_position, String url) {
            super(starting_position, url);
        }

        public Worm() {
            super(new Point(2, 7), "file:src/main/resources/oop/project/Worm.png");
        }

        @Override
        public ArrayList<Point> legal_move(Point start) {
            ArrayList<Point> res = new ArrayList<>();
            int x = (int) start.getX();
            int y = (int) start.getY();
            for (int i = -7; i < 8; i++) {
                for (int j = -7; j < 8; j++) {
                    if (Math.abs(i) != Math.abs(j) || i == 0 && j == 0) continue;
                    if (isInRange(x, y, i, j)) {
                        Point point = new Point();
                        point.x = x + i;
                        point.y = y + j;
                        res.add(point);
                    }
                }
            }
            return res;
        }
    }
}
