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
                sb.append(winner.toString()).append(" wins!");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
