package oo_assignment4pleunchris;

/**
 * Connects game logic and view.
 *
 * @author Pleun
 */
public class Controller {

    private Board board;
    private View user;
    private Player player1;
    private Player player2;

    public Controller() {
        this.board = new Board();
        this.user = new View();
        player1 = createHumanPlayer(user);
        player2 = createComputerPlayer(player1);
    }

    /**
     * Main loop of the game.
     */
    public void run() {
        user.println(board);
        //System.out.println(this.toString());
        boolean finished = false;
        //The cross player can always start, independent of whether that is the human or computer player.
        Player currentPlayer = getPlayerFromTeam(Field.CROSS);
        while (!finished) {
            System.out.println(currentPlayer);
            Move move = null;
            //For human move, display promt.
            if (currentPlayer instanceof HumanPlayer) {
                user.println("Please input in format 'row col' to play your move there.");
                move = currentPlayer.play(board);
            }
            //Get move from the player.
            while (!board.legalMove(move)) {
                user.println("Not a legal move.");
                move = currentPlayer.play(board);
            }
            //Do the move and show.
            board.setState(move);
            user.println(board);

            /* End conditions */
            //Check winner.
            if (board.isWinningState(move)) {
                user.println(String.format("Congratulations %s for winning the game!", currentPlayer));
                finished = true;
            }
            //Check draw. Also check for empty otherwise a full board with a winner would also be considered a draw.
            if (!board.hasEmpty()) {
                user.println("It's a draw!");
                finished = true;
            }
            //New current player is the opposite team.
            currentPlayer = getPlayerFromTeam(currentPlayer.getTeam().other());
        }
    }

    /**
     * @param player1
     * @param player2
     * @param team
     * @return the player that uses the given team.
     */
    private Player getPlayerFromTeam(Field team) {
        if (player1.getTeam() == team)
            return player1;
        if (player2.getTeam() == team)
            return player2;
        else
            throw new IllegalArgumentException("Player1 or player2 have the same team.");
    }

    /**
     * @return a new computer player called Computer, playing the opposite team
     * as the human player.
     */
    private Player createComputerPlayer(Player humanPlayer) {
        Field team = humanPlayer.getTeam().other();
        return new ComputerPlayer(team, "Computer");
    }

    /**
     * Asks the player for name and team.
     *
     * @return a new human player.
     */
    private Player createHumanPlayer(View user) {
        //Name input
        user.println("Please enter your name.");
        String name = user.getNextLine();
        //Team input
        user.println("Would you like to be X (enter 1) or O (enter 2)?");
        int teamNr = user.getIntFromInput();
        while (teamNr != 1 && teamNr != 2) {
            user.println("Invalid input, please enter 1 for X or 2 for O.");
            teamNr = user.getIntFromInput();
        }
        Field team = Field.CIRCLE;
        if (teamNr == 1)
            team = Field.CROSS;
        //Make new player
        return new HumanPlayer(team, name, user);
    }

    @Override
    public String toString() {
        return String.format("Game contains %s and %s", player1, player2);
    }
}
