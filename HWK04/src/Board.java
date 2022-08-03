/**
 * TTT game with MVC model
 * Board class represents Model of game
 *
 * Xinyi Feng
 * Aug 2nd 2022
 */

public class Board {
    // 2D array representing the board grid
    private final Player[][] board;
    int movesCount;

    //Create a board and Initialize the count as 0
    public Board() {
        board = new Player[3][3];
        movesCount = 0;
    }

    /**
     * Check if is one player's turn
     * When count is 0, 2, 4, 6, 8 is X's turn , otherwise, is 0's turn
     * @return enum X or O
     */
    public Player whoseTurn() {
        return movesCount % 2 == 0 ? Player.X : Player.O;
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
    public Player getMarkAt(int row, int column) {
        if (column > 2 || row > 2 || column < 0 || row < 0) {
            throw new IndexOutOfBoundsException("Invalid cell input!");
        } else {
            return board[row][column];
        }
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
    public void move(int row, int column) {
        if (isGameOver()) {
            throw new IllegalStateException("Game is over!");
        } else if (column > 2 || row > 2 || column < 0 || row < 0) {
            throw new IndexOutOfBoundsException("Invalid cell input!");
        } else {
            if (board[row][column] != null) {
                throw new IllegalStateException("Occupied!");
            }
            board[row][column] = whoseTurn();
            movesCount++;
        }
    }

    /**
     * Determines whether the game is over.
     *
     * @return boolean, true iff the game is over, either because of a win or
     * because no squares are left empty
     */
    public boolean isGameOver() {
        if (movesCount == 9) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            // Checks columns
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == Player.X) || (
                    board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == Player.O)) {
                return true;
            }
            // Checks rows
            if ((board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == Player.X) || (
                    board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == Player.O)) {
                return true;
            }
        }
        // Checks diagonals
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == Player.X) || (
                board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == Player.O)) {
            return true;
        } else {
            return (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == Player.X) || (
                    board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == Player.O);
        }
    }

    /**
     * Returns the winner of the game, or null if the game is a
     * tie.
     *
     * @return the winner or  null (for a tie)
     * @throws IllegalStateException if the game isn't over
     */
    public Player getWinner() {
        if (!isGameOver()) {
            throw new IllegalStateException("No winner yet!");
        }
        for (int i = 0; i < 3; i++) {
            // Checks columns
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == Player.X) {
                return Player.X;
            } else if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == Player.O) {
                return Player.O;
            }

            // Checks rows
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == Player.X) {
                return Player.X;
            } else if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == Player.O) {
                return Player.O;
            }
        }

        // Checks diagonals
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == Player.X) {
            return Player.X;
        } else if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == Player.O) {
            return Player.O;
        }

        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == Player.X) {
            return Player.X;
        } else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == Player.O) {
            return Player.O;
        }

        // Tie
        return null;
    }

}
