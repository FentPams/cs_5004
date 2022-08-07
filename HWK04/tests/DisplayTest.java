/**
 * TTT game with MVC model
 * Display class represents View of game
 *
 * This class tests the display method in the class
 *
 * Xinyi Feng
 * Aug 2nd 2022
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {
    Board modelTester;  // model
    Display viewTester; // view


    @Before
    public void setUp() throws Exception {
        modelTester = new Board();
        viewTester = new Display(modelTester);
    }

    /**
     * Tests display board method with only X move
     */
    @Test
    public void testDisplayBoardWithXOneMove() {
        modelTester.move(0,0);
        assertEquals("X _ _ \n" +
                "_ _ _ \n" +
                "_ _ _ \n", viewTester.displayBoard());
    }

    /**
     * Tests display board method with only one O move
     */
    @Test
    public void testDisplayBoardWithOOneMove() {
        modelTester.move(0,0);
        modelTester.move(0,1);
        assertEquals("X O _ \n" +
                "_ _ _ \n" +
                "_ _ _ \n", viewTester.displayBoard());
    }

    /**
     * Tests display board method with multiple moves
     */
    @Test
    public void testDisplayBoardWithMultipleMoves() {
        modelTester.move(0,0);
        modelTester.move(0,1);
        modelTester.move(0,2);
        modelTester.move(1,1);
        modelTester.move(2,1);
        modelTester.move(2,2);
        assertEquals("X O X \n" +
                "_ O _ \n" +
                "_ X O \n", viewTester.displayBoard());
    }

    /**
     * Tests display board method When X wins
     */
    @Test
    public void testDisplayBoardWhenXWins() {
        modelTester.move(0,0);
        modelTester.move(1,1);
        modelTester.move(0,1);
        modelTester.move(1,2);
        modelTester.move(0,2);
        assertEquals("X X X \n" +
                "_ O O \n" +
                "_ _ _ \n" +
                "Player X wins!", viewTester.displayBoard());
    }

    /**
     * Tests display board method When O wins
     */
    @Test
    public void testDisplayBoardWhenOWins() {
        modelTester.move(0,0);
        modelTester.move(1,1);
        modelTester.move(0,1);
        modelTester.move(1,2);
        modelTester.move(2,1);
        modelTester.move(1,0);
        assertEquals("X X _ \n" +
                "O O O \n" +
                "_ X _ \n" +
                "Player O wins!", viewTester.displayBoard());
    }

    /**
     * Tests display board method When Ties
     */
    @Test
    public void testDisplayBoardWhenTies() {
        modelTester.move(0, 0); // Player X
        modelTester.move(1, 0); // Player O
        modelTester.move(0, 1); // Player X
        modelTester.move(1, 1); // Player O
        modelTester.move(1, 2); // Player X
        modelTester.move(0, 2); // Player O
        modelTester.move(2, 2); // Player X
        modelTester.move(2, 1); // Player O
        modelTester.move(2, 0); // Player X
        assertEquals("X X O \n" +
                "O O X \n" +
                "X O X \n" +
                "It is a Tie.", viewTester.displayBoard());
    }

    /**
     * Tests display board method When grid occupied
     */
    @Test
    public void testDisplayBoardWhenOccupied() {
        try {
            modelTester.move(0, 0); // Player X
            modelTester.move(0, 0); // Player O
        } catch(Exception e) {
            // do nothing
        }

        assertEquals(
                "X _ _ \n" +
                        "_ _ _ \n" +
                        "_ _ _ \n", viewTester.displayBoard());
    }

}