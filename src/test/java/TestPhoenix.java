import oop.project.Implementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TestPhoenix extends Implementation {
    Monster ph = new Phoenix();

    @Test
    void phoenix_wrong_url() {
        Assertions.assertEquals("file:src/main/resources/oop/project/Phoenix.png", ph.getUrl());
    }

    @Test
    void phoenix_starting_position_in_range() {
        Point point = new Point(ph.getStarting_position());
        Assertions.assertTrue(((point.getX() <= 7 && point.getX() >= 0) && (point.getY() <= 7 && point.getY() >= 0)));
    }
}
