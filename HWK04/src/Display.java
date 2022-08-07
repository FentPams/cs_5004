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
     * @return Sting, represents the board status
     */
    public String displayBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Player curr = board.getMarkAt(i, j);
                sb.append(curr == null ? "_" : curr.toString()).append("\s");
            }
            sb.append("\n");
        }
        if (board.isGameOver()) {
            Player winner = board.getWinner();
            if (winner == null) {
                sb.append("It is a Tie.");
            } else {
                sb.append("Player ").append(winner.toString()).append(" wins!");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

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

    private int validateNumber(String input) {
        String[] pos = input.split(",");
        if (pos.length != 2) return -1;
        try {
            int row = Integer.parseInt(pos[0].trim());
            int col = Integer.parseInt(pos[1].trim());
            if (row < 0 || row > 2 || col < 0 || col > 2) return -1;
            return row * 10 + col;
        } catch(Exception e) {
            return -1;
        }
    }
}
