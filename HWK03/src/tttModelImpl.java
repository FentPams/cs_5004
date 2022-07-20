import java.lang.reflect.Array;

public class tttModelImpl implements tttModel {

  private char[][] board;
  private int turns;

  public tttModelImpl() {
    this.board = new char[3][3];
    // Initialized as empty cell
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.board[i][j] = ' ';
      }
    }
    this.turns = 0;
  }


  /**
   * Places an X or O mark in the specified cell. Whether it places an X or O depends on which
   * player's turn it is.
   *
   * @param column the column of the cell
   * @param row    the row of the cell
   * @throws IllegalStateException     if the game is over, or if there is already a mark in the
   *                                   cell.
   * @throws IndexOutOfBoundsException if the cell is out of bounds. Legal values for column and row
   *                                   are 0, 1, 2
   */
  @Override
  public void move(int column, int row) {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over!");
    } else if (column > 2 || row > 2 || column < 0 || row < 0) {
      throw new IndexOutOfBoundsException("Invalid cell input!");
    } else {
      if (board[column][row] != ' ') {
        throw new IllegalStateException("Occupied!");
      }
      board[column][row] = isXsTurn() ? 'X' : 'O';
      turns++;
    }
  }

  /**
   * Check if is one player's turn
   *
   * @return boolean if is X's turn
   */
  @Override
  public boolean isXsTurn() {
    // X goes first, X takes turns at 0, 2, 4, 6, 8
    return this.turns % 2 == 0;
  }

  /**
   * Check if is one player's turn
   *
   * @return boolean if is O's turn
   */
  @Override
  public boolean isOsTurn() {
    // O goes after, O takes turns at 1, 3, 5, 7
    return this.turns % 2 == 1;
  }

  /**
   * Returns the player whose turn is next.
   *
   * @return the next player
   * @throws IllegalStateException if the game is over
   */
  @Override
  public Player nextPlayer() throws IllegalStateException {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over!");
    }
    // turns is 0,2,4,6,8 X is next player, 1, 3, 5, 7  turns O is next player
    return this.turns % 2 == 0 ? Player.X : Player.O;
  }

  /**
   * Returns the Player whose mark is in the cell at the given coordinates, or {@code null} if that
   * cell is empty.
   *
   * @param column the column of the cell
   * @param row    the row of the cell
   * @return a {@code Player} or {@code null}
   * @throws IndexOutOfBoundsException if the cell is out of bounds.
   */
  @Override
  public Player getMarkAt(int column, int row) {
    if (column > 2 || row > 2 || column < 0 || row < 0) {
      throw new IndexOutOfBoundsException("Invalid cell input!");
    } else {
      if (board[column][row] == 'X') {
        return Player.X;
      } else if (board[column][row] == 'O') {
        return Player.O;
      } else {
        return null;
      }
    }
  }


  /**
   * Determines whether the game is over.
   *
   * @return boolean, true iff the game is over, either because of a win or because no squares are
   * left empty
   */
  public boolean isGameOver() {
    if (turns == 9) {
      return true;
    }
    for (int i = 0; i < 3; i++) {
      // Checks columns
      if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'X') || (
          board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'O')) {
        return true;
      }
      // Checks rows
      if ((board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'X') || (
          board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'O')) {
        return true;
      }
    }
    // Checks diagonals
    if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'X') || (
        board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'O')) {
      return true;
    } else {
      return (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'X') || (
          board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'O');
    }
  }

  /**
   * Returns the winner of the game, or null if the game is a tie.
   *
   * @return the winner or  null (for a tie)
   * @throws IllegalStateException if the game isn't over
   */
  @Override
  public Player getWinner() {
    if (!isGameOver()) {
      throw new IllegalStateException("No winner yet!");
    }
    for (int i = 0; i < 3; i++) {
      // Checks columns
      if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'X') {
        return Player.X;
      } else if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'O') {
        return Player.O;
      }

      // Checks rows
      if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'X') {
        return Player.X;
      } else if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'O') {
        return Player.O;
      }
    }

    // Checks diagonals
    if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'X') {
      return Player.X;
    } else if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'O') {
      return Player.O;
    }

    if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'X') {
      return Player.X;
    } else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'O') {
      return Player.O;
    }

    // Tie
    return null;
  }

  @Override
  public String toString() {
    String output = "";
    for (char[] y : board) {
      output += "+---+---+---+\n";
      for (char x : y) {
        output += "| " + x + " ";
      }
      output += "|\n";
    }
    return output += "+---+---+---+";
  }
}




