import oop.project.Implementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonsterTest extends Implementation {

    public Monster cthulhu;
    public Monster phoenix;
    public Monster worm;

    @BeforeEach
    void setUp() {
        cthulhu = new Implementation.Cthulhu(new Point(4, 4), "cthulhu.png");
        phoenix = new Implementation.Phoenix(new Point(4, 4), "phoenix.png");
        worm = new Implementation.Worm(new Point(4, 4), "worm.png");
    }

    @Test
    void testCthulhuLegalMoves() {
        ArrayList<Point> moves = cthulhu.legal_move(new Point(4, 4));
        assertEquals(8, moves.size());
        assertTrue(moves.contains(new Point(3, 3)));
        assertTrue(moves.contains(new Point(3, 4)));
        assertTrue(moves.contains(new Point(3, 5)));
        assertTrue(moves.contains(new Point(4, 3)));
        assertTrue(moves.contains(new Point(4, 5)));
        assertTrue(moves.contains(new Point(5, 3)));
        assertTrue(moves.contains(new Point(5, 4)));
        assertTrue(moves.contains(new Point(5, 5)));
    }

    @Test
    void testPhoenixLegalMoves() {
        ArrayList<Point> moves = phoenix.legal_move(new Point(4, 4));
        assertEquals(8, moves.size());
        assertTrue(moves.contains(new Point(2, 3)));
        assertTrue(moves.contains(new Point(2, 5)));
        assertTrue(moves.contains(new Point(3, 2)));
        assertTrue(moves.contains(new Point(3, 6)));
        assertTrue(moves.contains(new Point(5, 2)));
        assertTrue(moves.contains(new Point(5, 6)));
        assertTrue(moves.contains(new Point(6, 3)));
        assertTrue(moves.contains(new Point(6, 5)));
    }

    @Test
    void testWormLegalMoves() {
        ArrayList<Point> moves = worm.legal_move(new Point(4, 4));
        assertEquals(13, moves.size());
        assertTrue(moves.contains(new Point(0, 0)));
        assertTrue(moves.contains(new Point(1, 1)));
        assertTrue(moves.contains(new Point(1, 7)));
        assertTrue(moves.contains(new Point(2, 2)));
        assertTrue(moves.contains(new Point(2, 6)));
        assertTrue(moves.contains(new Point(3, 3)));
        assertTrue(moves.contains(new Point(3, 5)));
        assertTrue(moves.contains(new Point(5, 3)));
        assertTrue(moves.contains(new Point(5, 5)));
        assertTrue(moves.contains(new Point(6, 2)));
        assertTrue(moves.contains(new Point(6, 6)));
        assertTrue(moves.contains(new Point(7, 1)));
        assertTrue(moves.contains(new Point(7, 7)));
    }
}
