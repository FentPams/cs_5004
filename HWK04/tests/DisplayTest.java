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
     * Tests display board method with only X move
     */
    @Test
    public void testDisplayBoardWithXOneMove() {
        controllerTester.play(0,0);
        assertEquals("X _ _ \n" +
                "_ _ _ \n" +
                "_ _ _ \n", viewTester.displayBoard());
    }

    /**
     * Tests display board method with only one O move
     */
    @Test
    public void testDisplayBoardWithOOneMove() {
        controllerTester.play(0,0);
        controllerTester.play(0,1);
        assertEquals("X O _ \n" +
                "_ _ _ \n" +
                "_ _ _ \n", viewTester.displayBoard());
    }

    /**
     * Tests display board method with multiple moves
     */
    @Test
    public void testDisplayBoardWithMultipleMoves() {
        controllerTester.play(0,0);
        controllerTester.play(0,1);
        controllerTester.play(0,2);
        controllerTester.play(1,1);
        controllerTester.play(2,1);
        controllerTester.play(2,2);
        assertEquals("X O X \n" +
                "_ O _ \n" +
                "_ X O \n", viewTester.displayBoard());
    }

    /**
     * Tests display board method When X wins
     */
    @Test
    public void testDisplayBoardWhenXWins() {
        controllerTester.play(0,0);
        controllerTester.play(1,1);
        controllerTester.play(0,1);
        controllerTester.play(1,2);
        controllerTester.play(0,2);
        assertEquals("X X X \n" +
                "_ O O \n" +
                "_ _ _ \n" +
                "X wins!", viewTester.displayBoard());
    }

    /**
     * Tests display board method When O wins
     */
    @Test
    public void testDisplayBoardWhenOWins() {
        controllerTester.play(0,0);
        controllerTester.play(1,1);
        controllerTester.play(0,1);
        controllerTester.play(1,2);
        controllerTester.play(2,1);
        controllerTester.play(1,0);
        assertEquals("X X _ \n" +
                "O O O \n" +
                "_ X _ \n" +
                "O wins!", viewTester.displayBoard());
    }

    /**
     * Tests display board method When Ties
     */
    @Test
    public void testDisplayBoardWhenTies() {
        controllerTester.play(0, 0); // Player X
        controllerTester.play(1, 0); // Player O
        controllerTester.play(0, 1); // Player X
        controllerTester.play(1, 1); // Player O
        controllerTester.play(1, 2); // Player X
        controllerTester.play(0, 2); // Player O
        controllerTester.play(2, 2); // Player X
        controllerTester.play(2, 1); // Player O
        controllerTester.play(2, 0); // Player X
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
        controllerTester.play(0, 0); // Player X
        controllerTester.play(0, 0); // Player O

        assertEquals(
                "X _ _ \n" +
                        "_ _ _ \n" +
                        "_ _ _ \n", viewTester.displayBoard());
    }

}