package oo_assignment4pleunchris;

/**
 *
 * @author Pleun
 */
public class HumanPlayer implements Player {

    private Field team;
    private String name;
    private View user;

    public HumanPlayer(Field team, String name, View user) {
        this.team = team;
        this.name = name;
        this.user = user;
    }

    @Override
    public Move play(Board board) {
        Move move = null;
        while (move == null)
            try {
                String[] input = user.getNextLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                move = new Move(x, y, team);
            } catch (Exception e) { //Catches all errors, NumberFormatException won't.
                user.println("Invalid input. Please input in format 'row col' to play your move there.");
            }
        return move;
    }

    @Override
    public void setTeam(Field team) {
        this.team = team;
    }

    @Override
    public Field getTeam() {
        return this.team;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("player %s playing with %s", this.name, this.team);
    }

}
