import oop.project.Implementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TestWorm extends Implementation {
    Monster worm = new Worm();

    @Test
    void cthulhu_wrong_url() {
        Assertions.assertEquals("file:src/main/resources/oop/project/Worm.png", worm.getUrl());
    }

    @Test
    void cthulhu_starting_position_in_range() {
        Point point = new Point(worm.getStarting_position());
        Assertions.assertTrue(((point.getX() <= 7 && point.getX() >= 0) && (point.getY() <= 7 && point.getY() >= 0)));
    }
}
