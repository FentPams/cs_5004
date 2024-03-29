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

    // Method to play the game until someone has won
    public void playGame() {
        display.printWelcomeMessage();
        display.displayBoard();
        while (!board.isGameOver()) {
            int posCode = display.promptPlayer();
            int row = posCode / 10, col = posCode % 10;
            try {
                board.move(row, col);
                display.displayBoard();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        display.printEndMessage();
    }
}
