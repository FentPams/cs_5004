import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class tttModelTest {

  tttModel tester;

  @Before
  public void setUp() throws Exception {
    //tester = new tttModelImpl();
  }

  /**
   * Tests move method, move within index 0-2 no mark occupied, not game over yet
   */
  @Test
  public void testMoveSucceed() {
    tester.move(0, 0); // X move 0,0
    assertEquals(Player.X, tester.getMarkAt(0, 0));

    tester.move(1, 1); // O move 1, 1
    assertEquals(Player.O, tester.getMarkAt(1, 1));

  }

  /**
   * Tests move method, move within index 0-2 has mark occupied, not game over yet
   *
   * @throws IllegalStateException
   */
  @Test(expected = IllegalStateException.class)
  public void testMoveHasMarkOccupied() {
    tester.move(0, 0); // X move 0,0

    tester.move(0, 0); // move at spot that has occupied
  }

  /**
   * Tests move method, move within index 0-2 no mark occupied, but is game over
   *
   * @throws IllegalStateException
   */
  @Test(expected = IllegalStateException.class)
  public void testMoveWhenGameOver() {
    tester.move(0, 0); // Player X
    tester.move(1, 0); // Player O
    tester.move(0, 1); // Player X
    tester.move(1, 1); // Player O
    tester.move(0, 2); // Player X, win and game over

    // unoccupied spot but game over, throw exception
    tester.move(2, 2);
  }

  /**
   * Tests move method, move out of index 0-2 no mark occupied,  game not over yet
   *
   * @throws IndexOutOfBoundsException
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testMoveWithIndexOutOfBounds() {
    tester.move(3, 0); // out of bounds
  }

  /**
   * Tests isXsTurn method, return boolean
   */
  @Test
  public void testIsXsTurn(){
    assertTrue(tester.isXsTurn()); // X goes first
  }

  /**
   * Tests isOsTurn method, return boolean
   */
  @Test
  public void testIsOsTurn(){
    tester.move(0,0); //X goes first
    assertTrue(tester.isOsTurn()); // O's Turn
  }

  /**
   * Tests nextPlayer method Next player is X
   */
  @Test
  public void testNextPlayerX() {
    assertEquals(Player.X, tester.nextPlayer()); // X is the first player
  }

  /**
   * Test nextPlayer method Next player is O
   */
  @Test
  public void testNextPlayerO() {
    tester.move(0, 0); // X plays
    assertEquals(Player.O, tester.nextPlayer()); // Y is the next player
  }

  /**
   * Test nextPlayer method
   *
   * @throws IllegalStateException when game is over or has winner
   */
  @Test(expected = IllegalStateException.class)
  public void testNextPlayerWhenGameOver() {
    tester.move(0, 0); // Player X
    tester.move(1, 0); // Player O
    tester.move(0, 1); // Player X
    tester.move(1, 1); // Player O
    tester.move(0, 2); // Player X, Game over

    tester.move(2, 2); // Throws exception
  }

  /**
   * Tests get mark at method test x move and its index test o move and its index
   */
  @Test
  public void testGetMarkAt() {
    tester.move(0, 0); // X move
    assertEquals(Player.X, tester.getMarkAt(0, 0));

    tester.move(1, 1); // O move
    assertEquals(Player.O, tester.getMarkAt(1, 1));
  }

  /**
   * Tests get mark at method return null when the cell is empty
   */
  @Test
  public void testNullGetMarkAt() {
    assertNull(tester.getMarkAt(2, 2)); //empty cell: return null
  }

  /**
   * Tests get mark at method
   *
   * @throws IndexOutOfBoundsException when index out of bound
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetMarkAtWithIndexOutOfBound() {
    tester.move(3, 3); // gird is index from 0 to 2
  }

  /**
   * Tests isGameOver method When one player wins, returns boolean
   */
  @Test
  public void isGameOverWhenOneWin() {
    tester.move(0, 0); // Player X
    tester.move(1, 0); // Player O
    tester.move(0, 1); // Player X
    tester.move(1, 1); // Player O, no winner yet
    // no winner and not finish
    assertFalse(tester.isGameOver());

    tester.move(0, 2); // Player X, win
    //has winner
    assertTrue(tester.isGameOver());

  }

  /**
   * Tests isGameOver method When no empty spot, returns boolean
   */
  @Test
  public void isGameOverWhenNoEmptySpot() {
    tester.move(0, 0); // Player X
    tester.move(1, 0); // Player O
    tester.move(0, 1); // Player X
    tester.move(1, 1); // Player O
    tester.move(1, 2); // Player X
    tester.move(0, 2); // Player O
    tester.move(2, 2); // Player X
    tester.move(2, 1); // Player O
    tester.move(2, 0); // Player X, no winner and no empty spot

    assertTrue(tester.isGameOver());
  }

  /**
   * Tests getWinner method return the winner X when X win in a row
   */
  @Test
  public void testGetWinnerX() {
    tester.move(0, 0); // Player X
    tester.move(1, 0); // Player O
    tester.move(0, 1); // Player X
    tester.move(1, 1); // Player O
    tester.move(0, 2); // Player X, win
    assertEquals(Player.X, tester.getWinner());
    //
    //      | X | O |   |
    //      | X | O |   |
    //      | X |   |   |
    //
  }

  /**
   * Tests getWinner method return the winner O when o in the diagonal
   */
  @Test
  public void testGetWinnerO() {
    tester.move(0, 0); // Player X
    tester.move(1, 0); // Player O
    tester.move(0, 1); // Player X
    tester.move(1, 1); // Player O
    tester.move(1, 2); // Player X
    tester.move(0, 2); // Player O
    tester.move(2, 2); // Player X
    tester.move(2, 0); // Player O, WIN

    assertEquals(Player.O, tester.getWinner());
    //
    //     | X | O | O |
    //     | X | O |   |
    //     | O | X | X |
    //
  }

  /**
   * Tests getWinner method return the winner null when it is tie
   */
  @Test
  public void testGetWinnerTie() {
    tester.move(0, 0); // Player X
    tester.move(1, 0); // Player O
    tester.move(0, 1); // Player X
    tester.move(1, 1); // Player O
    tester.move(1, 2); // Player X
    tester.move(0, 2); // Player O
    tester.move(2, 2); // Player X
    tester.move(2, 1); // Player O
    tester.move(2, 0); // Player X

    assertNull(tester.getWinner());
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
    tester.getWinner();
  }
}