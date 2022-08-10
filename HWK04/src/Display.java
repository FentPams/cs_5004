import java.util.Scanner;

/**
 * TTT game with MVC model
 * Display class represents View of game
 * <p>
 * Xinyi Feng
 * Aug 2nd 2022
 */
public class Display {
    private final Board board;

    public Display(Board board) {
        this.board = board;
    }

    /**
     * This displayBoard will display the current board status, X of Player X, O for Player O
     * And _ for empty spot.
     * If game is over, will print fourth line with remainder info.
     *
     * @return Sting, represents the board status. This return type is not necessary but just for unit tests.
     */
    public String displayBoard() {
        String boardStr = board.toString();
        System.out.println(boardStr);
        return boardStr;
    }

    /**
     * Prompt player to enter the position he/she wants to play and re-enter information
     *
     * @return int
     */
    public int promptPlayer() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Player currentPlayer = board.whoseTurn();
            System.out.printf("Player %s, please enter the row and column (split with a comma like 0,2) you want to move and press ENTER to end:\n", currentPlayer);
            String input = sc.nextLine();
            int posCode = validateNumber(input);
            if (posCode != -1) {
                return posCode;
            } else {
                System.out.println("Please re-enter!");
            }
        }
    }

    /**
     * Private method to validate the user' input in a right format, and called by prompt player.
     *
     * @param input user input to tell which position they want to move
     * @return an integer (e.g. for row 1, column 2, return 1 * 10 + 2 = 12)
     */
    private int validateNumber(String input) {
        String[] pos = input.split(",");
        if (pos.length != 2) return -1;
        try {
            int row = Integer.parseInt(pos[0].trim());
            int col = Integer.parseInt(pos[1].trim());
            if (row < 0 || row > 2 || col < 0 || col > 2) return -1;
            return row * 10 + col;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Displays a welcome message to the console.  Used when the game begins.
     */
    public void printWelcomeMessage() {
        System.out.println("Welcome to Tic Tac Toe!\n");
    }

    /**
     * Displays an ending message to the console.  Used when the game ends.
     */
    public void printEndMessage() {
        System.out.println("Game Over!\n");
    }

}
