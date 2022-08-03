/**
 * TTT game with MVC model
 * TTTGame class represents Controller of game
 * <p>
 * Xinyi Feng
 * Aug 2nd 2022
 */
public class TTTGame {
    private final Board board;
    private final Display display;

    // Initialize instance variables
    public TTTGame(Board board, Display display) {
        this.board = board;
        this.display = display;
    }

    // Play the game! if valid play return true, otherwise false
    public boolean play(int row, int column) {
        try {
            board.move(row, column);
            display.displayBoard();

        } catch (Exception e) {
            System.out.println("Something wrong: " + e.getMessage());
            return false;
        }
        return true;
    }
}
