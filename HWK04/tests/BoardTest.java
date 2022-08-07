/**
 * TTT game with MVC model
 * Board class represents Model of game
 *
 * Test Board class its all methods
 *
 * Xinyi Feng
 * Aug 2nd 2022
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    TTTGame controllerTester; //controller
    Board modelTester;  // model
    Display viewTester; // view

    @Before
    public void setUp() throws Exception {
        modelTester = new Board();
        viewTester = new Display(modelTester);
        controllerTester = new TTTGame(modelTester,viewTester);
    }

    /**
     * Tests whose Turn method
     * if it is 0, 2, 4, 6, 8 round, is X's turn
     * otherwise is O's turn
     */

    @Test
    public void testWhoseTurnX() {
        assertEquals(Player.X, modelTester.whoseTurn());
    }

    /**
     * Tests whose Turn method
     * if it is 0, 2, 4, 6, 8 round, is X's turn
     * otherwise is O's turn
     */

    @Test
    public void testWhoseTurnX2() {
        modelTester.move(0,0);
        modelTester.move(1,1);
        assertEquals(Player.X, modelTester.whoseTurn());
    }

    /**
     * Tests whose Turn method
     * if it is 0, 2, 4, 6, 8 round, is X's turn
     * otherwise is O's turn
     */

    @Test
    public void testWhoseTurnY() {
        modelTester.move(0,0);
        assertEquals(Player.O, modelTester.whoseTurn());
    }

    /**
     * Tests whose Turn method
     * if it is 0, 2, 4, 6, 8 round, is X's turn
     * otherwise is O's turn
     */

    @Test
    public void testWhoseTurnY2() {
        modelTester.move(0,0);
        modelTester.move(1,1);
        modelTester.move(1,2);
        assertEquals(Player.O, modelTester.whoseTurn());
    }

    /**
     * Tests get mark at method test x move and its index test o move and its index
     */
    @Test
    public void testGetMarkAt() {
        modelTester.move(0, 0); // X move
        assertEquals(Player.X, modelTester.getMarkAt(0, 0));

        modelTester.move(1, 1); // O move
        assertEquals(Player.O, modelTester.getMarkAt(1, 1));
    }

    /**
     * Tests get mark at method return null when the cell is empty
     */
    @Test
    public void testNullGetMarkAt() {
        assertNull(modelTester.getMarkAt(2, 2)); //empty cell: return null
    }

    /**
     * Tests get mark at method
     *
     * @throws IndexOutOfBoundsException when index out of bound
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetMarkAtWithIndexOutOfBound() {
        try {
            modelTester.getMarkAt(3, 3); // gird is index from 0 to 2
        } catch (IndexOutOfBoundsException Ioob) {
            String message = "Invalid cell input!";
            assertEquals(message, Ioob.getMessage());
            throw Ioob;
        }
        fail("Exception did not throw");
    }


    /**
     * Tests move method, move within index 0-2 no mark occupied, not game over yet
     */
    @Test
    public void testMoveSucceed() {
        modelTester.move(0, 0); // X move 0,0
        assertEquals(Player.X, modelTester.getMarkAt(0, 0));

        modelTester.move(1, 1); // O move 1, 1
        assertEquals(Player.O, modelTester.getMarkAt(1, 1));
    }

    /**
     * Tests move method, move within index 0-2 has mark occupied, not game over yet
     *
     * @throws IllegalStateException
     */
    @Test(expected = IllegalStateException.class)
    public void testMoveHasMarkOccupied() {
        try {
            modelTester.move(0, 0); // X move 0,0

            modelTester.move(0, 0); // move at spot that has occupied
        } catch (IllegalStateException Ise) {
            String message = "Occupied!";
            assertEquals(message, Ise.getMessage());
            throw Ise;
        }
        fail("Exception did not throw");
    }

    /**
     * Tests move method, move within index 0-2 no mark occupied, but is game over
     *
     * @throws IllegalStateException
     */
    @Test(expected = IllegalStateException.class)
    public void testMoveWhenGameOver() {
        try {
            modelTester.move(0, 0); // Player X
            modelTester.move(1, 0); // Player O
            modelTester.move(0, 1); // Player X
            modelTester.move(1, 1); // Player O
            modelTester.move(0, 2); // Player X, win and game over

            // unoccupied spot but game over, throw exception
            modelTester.move(2, 2);
        } catch (IllegalStateException Ise) {
            String message = "Game is over!";
            assertEquals(message, Ise.getMessage());
            throw Ise;
        }
        fail("Exception did not throw");
    }

    /**
     * Tests move method, move out of index 0-2 no mark occupied,  game not over yet
     *
     * @throws IndexOutOfBoundsException
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveWithIndexOutOfBounds() {

        try {
            modelTester.move(3, 0); // out of bounds
        } catch (IndexOutOfBoundsException Ioob) {
            String message = "Invalid cell input!";
            assertEquals(message, Ioob.getMessage());
            throw Ioob;
        }
        fail("Exception did not throw");
    }

    /**
     * Tests isGameOver method When one player wins, returns boolean
     */
    @Test
    public void isGameOverWhenOneWinColumn() {
        modelTester.move(0, 0); // Player X
        modelTester.move(1, 0); // Player O
        modelTester.move(0, 1); // Player X
        modelTester.move(1, 1); // Player O, no winner yet
        // no winner and not finish
        assertFalse(modelTester.isGameOver());

        modelTester.move(0, 2); // Player X, win
        //has winner
        assertTrue(modelTester.isGameOver());

    }

    /**
     * Tests isGameOver method When one player wins, returns boolean
     */
    @Test
    public void isGameOverWhenOneWinRow() {
        modelTester.move(0, 0); // Player X
        modelTester.move(0, 1); // Player O
        modelTester.move(1, 0); // Player X
        modelTester.move(0, 2); // Player O, no winner yet
        modelTester.move(2, 0); // Player X, win
        //has winner
        assertTrue(modelTester.isGameOver());

    }

    /**
     * Tests isGameOver method When one player wins, returns boolean
     */
    @Test
    public void isGameOverWhenOneWinDiagonal() {
        modelTester.move(0, 0); // Player X
        modelTester.move(0, 1); // Player O
        modelTester.move(1, 1); // Player X
        modelTester.move(0, 2); // Player O, no winner yet
        modelTester.move(2, 2); // Player X, win
        //has winner
        assertTrue(modelTester.isGameOver());

    }

    /**
     * Tests isGameOver method When no empty spot, returns boolean
     */
    @Test
    public void isGameOverWhenNoEmptySpot() {
        modelTester.move(0, 0); // Player X
        modelTester.move(1, 0); // Player O
        modelTester.move(0, 1); // Player X
        modelTester.move(1, 1); // Player O
        modelTester.move(1, 2); // Player X
        modelTester.move(0, 2); // Player O
        modelTester.move(2, 2); // Player X
        modelTester.move(2, 1); // Player O
        modelTester.move(2, 0); // Player X, no winner and no empty spot

        assertTrue(modelTester.isGameOver());
    }

    /**
     * Tests getWinner method return the winner X when X win in a Column
     */
    @Test
    public void testGetWinnerXCol() {
        modelTester.move(0, 0); // Player X
        modelTester.move(0, 1); // Player O
        modelTester.move(1, 0); // Player X
        modelTester.move(1, 1); // Player O
        modelTester.move(2, 0); // Player X, win
        assertEquals(Player.X, modelTester.getWinner());
        //
        //      | X | O |   |
        //      | X | O |   |
        //      | X |   |   |
        //
    }

    /**
     * Tests getWinner method return the winner X when X win in a Row
     */
    @Test
    public void testGetWinnerXRow() {
        modelTester.move(0, 0); // Player X
        modelTester.move(1, 0); // Player O
        modelTester.move(0, 1); // Player X
        modelTester.move(1, 1); // Player O
        modelTester.move(0, 2); // Player X, win
        assertEquals(Player.X, modelTester.getWinner());
        //
        //      | X | X | X |
        //      | O | O |   |
        //      |   |   |   |
        //
    }

    /**
     * Tests getWinner method return the winner X when X win in a diagonal
     */
    @Test
    public void testGetWinnerXDia() {
        modelTester.move(0, 0); // Player X
        modelTester.move(0, 1); // Player O
        modelTester.move(1, 1); // Player X
        modelTester.move(1, 0); // Player O
        modelTester.move(2, 2); // Player X, win
        assertEquals(Player.X, modelTester.getWinner());
        //
        //      | X | O |   |
        //      | O | X |   |
        //      |   |   | X |
        //
    }
    /**
     * Tests getWinner method return the winner X when X win in a diagonal
     */
    @Test
    public void testGetWinnerXDia2() {
        modelTester.move(0, 2); // Player X
        modelTester.move(0, 1); // Player O
        modelTester.move(1, 1); // Player X
        modelTester.move(1, 0); // Player O
        modelTester.move(2, 0); // Player X, win
        assertEquals(Player.X, modelTester.getWinner());
        //
        //      |   | O | X |
        //      | O | X |   |
        //      | X |   |   |
        //
    }
    /**
     * Tests getWinner method return the winner O when o in the diagonal
     */
    @Test
    public void testGetWinnerO() {
        modelTester.move(0, 0); // Player X
        modelTester.move(1, 0); // Player O
        modelTester.move(0, 1); // Player X
        modelTester.move(1, 1); // Player O
        modelTester.move(1, 2); // Player X
        modelTester.move(0, 2); // Player O
        modelTester.move(2, 2); // Player X
        modelTester.move(2, 0); // Player O, WIN

        assertEquals(Player.O, modelTester.getWinner());
        //
        //     | X | O | O |
        //     | X | O |   |
        //     | O | X | X |
        //
    }
    /**
     * Tests getWinner method return the winner O when o in the diagonal
     */
    @Test
    public void testGetWinnerO2() {
        modelTester.move(1, 2); // Player X
        modelTester.move(0, 0); // Player O
        modelTester.move(0, 1); // Player X
        modelTester.move(1, 1); // Player O
        modelTester.move(1, 0); // Player X
        modelTester.move(2, 2); // Player O, WIN

        assertEquals(Player.O, modelTester.getWinner());
        //
        //     | O | X |   |
        //     | X | O | X |
        //     |   |   | O |
        //
    }
    /**
     * Tests getWinner method return the winner O when o in the Row
     */
    @Test
    public void testGetWinnerORow() {
        modelTester.move(1, 2); // Player X
        modelTester.move(0, 0); // Player O
        modelTester.move(1, 0); // Player X
        modelTester.move(0, 1); // Player O
        modelTester.move(2, 1); // Player X
        modelTester.move(0, 2); // Player O,WIN

        assertEquals(Player.O, modelTester.getWinner());
        //
        //     | O | O | O |
        //     | X |   | X |
        //     |   | X |   |
        //
    }
    /**
     * Tests getWinner method return the winner O when o in the Col
     */
    @Test
    public void testGetWinnerOCol() {
        modelTester.move(1, 2); // Player X
        modelTester.move(0, 0); // Player O
        modelTester.move(1, 1); // Player X
        modelTester.move(1, 0); // Player O
        modelTester.move(2, 1); // Player X
        modelTester.move(2, 0); // Player O,WIN

        assertEquals(Player.O, modelTester.getWinner());
        //
        //     | O |   |   |
        //     | O | X | X |
        //     | O | X |   |
        //
    }
    /**
     * Tests getWinner method return the winner null when it is tie
     */
    @Test
    public void testGetWinnerTie() {
        modelTester.move(0, 0); // Player X
        modelTester.move(1, 0); // Player O
        modelTester.move(0, 1); // Player X
        modelTester.move(1, 1); // Player O
        modelTester.move(1, 2); // Player X
        modelTester.move(0, 2); // Player O
        modelTester.move(2, 2); // Player X
        modelTester.move(2, 1); // Player O
        modelTester.move(2, 0); // Player X

        assertNull(modelTester.getWinner());
        //
        //     | X | O | X |
        //     | X | O | O |
        //     | O | X | X |
        //
    }

    /**
     * Tests getWinner method
     *
     * @throws IllegalStateException when has winner but game is not over
     */
    @Test(expected = IllegalStateException.class)
    public void testGetWinnerWhenGameNotOver() {
        modelTester.getWinner();
    }
}