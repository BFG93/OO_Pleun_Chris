package oo_assignment4pleunchris;

/**
 * Board of the tic tac toe game.
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class Board {

    public final static int DIM = 3;
    private Field[][] board;

    /**
     * Constructor function for the board.
     */
    public Board() {
        board = new Field[DIM][DIM];
        //Initialize board as empty.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Field.EMPTY;
            }
        }
    }

    /**
     * Constructor function for the board with a given 2D Field array.
     *
     * @param field
     */
    public Board(Field[][] field) {
        board = new Field[DIM][DIM];
        //Initialize board as empty.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = field[i][j];
            }
        }
    }

    /**
     * @param x
     * @param y
     * @return the state of the board at position x,y.
     */
    public Field getState(int x, int y) {
        return board[x][y];
    }

    /**
     * @param move
     * @return true if the move is not a null move, is in bounds and whether the
     * move will be to an empty field.
     */
    public boolean legalMove(Move move) {
        return move != null && move.getCoords()[0] >= 0 && move.getCoords()[0] < DIM && move.getCoords()[1] >= 0 && move.getCoords()[1] < DIM && board[move.getCoords()[0]][move.getCoords()[1]] == Field.EMPTY;
    }

    /**
     * Sets the state of the board at x,y of move.
     *
     * @param move
     */
    public void setState(Move move) {
        board[move.getCoords()[0]][move.getCoords()[1]] = move.getState();
    }

    /**
     * @return a true copy of the board.
     */
    public Board deepCopyBoard() {
        Field[][] field = new Field[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                field[i][j] = board[i][j];
            }
        }
        return new Board(field);
    }

    /**
     * @param move
     * @return whether the given move will result in a winning state.
     */
    public boolean isWinningState() {
        /*
        Algorithm based on https://stackoverflow.com/questions/1056316/algorithm-for-determining-tic-tac-toe-game-over
        Gotta give credit ;)
         */

        return checkCols() || checkRows() || checkDiags();

    }

    /**
     * Checks for winning condition in the column of the played move. Null move
     * caught in higher function.
     *
     * @param move
     * @return true if winning condition on columns.
     */
    public boolean checkCols() {
        for (int i = 0; i < DIM; i++) {
            if (    board[DIM - DIM][i] != Field.EMPTY &&
                    board[DIM - 1][i] != Field.EMPTY &&
                    board[DIM - 2][i] != Field.EMPTY )
                
            if (board[DIM - DIM][i] == board[DIM - 2][i] && board[DIM - DIM][i] == board[DIM - 1][i]) {
                return true;
            }

        }
        return false;
    }

    /**
     * Checks for winning condition in the row of the played move. Null move
     * caught in higher function.
     *
     * @param move
     * @return true if winning condition on row.
     */
    public boolean checkRows() {
        for (int i = 0; i < DIM; i++) {
            if (    board[i][DIM - DIM] != Field.EMPTY &&
                    board[i][DIM - 2] != Field.EMPTY &&
                    board[i][DIM - 1] != Field.EMPTY )
                
            if (board[i][DIM - DIM] == board[i][DIM - 2] && board[i][DIM - DIM] == board[i][DIM -1]) {
                return true;
            }

        }
        return false;
    }

    /**
     * Checks for winning condition in the diagonal of the played move if legal.
     * Null move caught in higher function.
     *
     * @param move
     * @return true if winning condition on diagonal.
     */
    public boolean checkDiags() {
        
        if (    board[DIM - DIM][DIM - DIM] != Field.EMPTY &&
                    board[DIM-2][DIM - 2] != Field.EMPTY &&
                    board[DIM-1][DIM - 1] != Field.EMPTY )
        
        if (board[DIM - DIM][DIM - DIM] == board[DIM - 2][DIM - 2] && board[DIM - DIM][DIM - DIM] == board[DIM - 1][DIM - 1]) {
            return true;
        }
        
        
        if (    board[DIM - DIM][DIM - 1] != Field.EMPTY &&
                    board[DIM-2][DIM - 2] != Field.EMPTY &&
                    board[DIM-1][DIM - DIM] != Field.EMPTY )
            
        if (board[DIM - DIM][DIM - 1] == board[DIM - 2][DIM - 2] && board[DIM - 1][DIM - DIM] == board[DIM - 2][DIM - 2]) {
            return true;
        }
        return false;

    }

    /**
     * @return true if there is an empty state in the board.
     */
    public boolean hasEmpty() {
        for (Field[] states : board) {
            for (Field state : states) {
                if (state == Field.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(
                "         |     |     \n"
                + "      %s  |  %s  |  %s  \n"
                + "         |     |     \n"
                + "    -----------------\n"
                + "         |     |     \n"
                + "      %s  |  %s  |  %s  \n"
                + "         |     |     \n"
                + "    -----------------\n"
                + "         |     |     \n"
                + "      %s  |  %s  |  %s  \n"
                + "         |     |     \n", board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
        //Don't punish me for the String concatenation plz, otherwise it's soooo unreadable.
    }
}
