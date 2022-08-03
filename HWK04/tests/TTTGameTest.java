import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TTTGameTest {
    TTTGame controllerTester; //controller
    Board modelTester;  // model
    Display viewTester; // view


    @Before
    public void setUp() throws Exception {
        modelTester = new Board();
        viewTester = new Display(modelTester);
        controllerTester = new TTTGame(modelTester, viewTester);
    }


    /**
     * Test one play
     * If move succeed, return true
     */
    @Test
    public void testPlaySucceed() {
        assertTrue(controllerTester.play(0, 0));
    }

    /**
     * Test one play out of bounds
     * Move failed, return false
     */
    @Test
    public void testPlayOutOfBounds() {
        assertFalse(controllerTester.play(1, 3));
    }

    /**
     * Test one play of X
     * Use displayboard method to test
     */
    @Test
    public void testPlayWithXOneMove() {
        controllerTester.play(0, 0);
        assertEquals("X _ _ \n" +
                "_ _ _ \n" +
                "_ _ _ \n", viewTester.displayBoard());
    }

    /**
     * Test one play of O
     * Use displayboard method to test
     */
    @Test
    public void testPlayWithOOneMove() {
        controllerTester.play(0, 0);
        controllerTester.play(0, 1);
        assertEquals("X O _ \n" +
                "_ _ _ \n" +
                "_ _ _ \n", viewTester.displayBoard());
    }

    /**
     * Tests multiple play with multiple moves
     * Use displayboard method to test
     */
    @Test
    public void testPlayWithMultipleMoves() {
        controllerTester.play(0, 0);
        controllerTester.play(0, 1);
        controllerTester.play(0, 2);
        controllerTester.play(1, 1);
        controllerTester.play(2, 1);
        controllerTester.play(2, 2);
        assertEquals("X O X \n" +
                "_ O _ \n" +
                "_ X O \n", viewTester.displayBoard());
    }

    /**
     * Test continue playing when one already wins
     * the method return false
     */
    @Test
    public void testPlayWhenOneWins() {
        controllerTester.play(0, 0);
        controllerTester.play(1, 1);
        controllerTester.play(0, 1);
        controllerTester.play(1, 2);
        controllerTester.play(0, 2);
        assertFalse(controllerTester.play(2, 0));// game already over
    }

    /**
     * Test continue playing when one already wins
     * the method return false
     */
    @Test
    public void testPlayWhenGameOver() {
        controllerTester.play(0, 0); // Player X
        controllerTester.play(1, 0); // Player O
        controllerTester.play(0, 1); // Player X
        controllerTester.play(1, 1); // Player O
        controllerTester.play(1, 2); // Player X
        controllerTester.play(0, 2); // Player O
        controllerTester.play(2, 2); // Player X
        controllerTester.play(2, 1); // Player O
        controllerTester.play(2, 0); // Player X
        assertFalse(controllerTester.play(2, 0));// game already over
    }

    /**
     * Tests every legal move return True
     */
    @Test
    public void testPlayEveryLegalStepReturnTrue() {
        List<Move> steps = List.of(
                new Move(0, 0),
                new Move(1, 0),
                new Move(0, 1),
                new Move(1, 1),
                new Move(1, 2),
                new Move(0, 2),
                new Move(2, 2),
                new Move(2, 1),
                new Move(2, 0));

        steps.forEach(move -> assertTrue(controllerTester.play(move.row, move.col)));
    }

    /**
     * Helper method to test legal move
     */
    class Move {
        int row, col;

        public Move(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


}