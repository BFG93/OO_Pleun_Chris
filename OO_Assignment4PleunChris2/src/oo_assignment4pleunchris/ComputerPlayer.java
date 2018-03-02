package oo_assignment4pleunchris;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Pleun Scholten s4822250
 */
public class ComputerPlayer implements Player {

    private Field team;
    private String name;

    public ComputerPlayer(Field team, String name) {
        this.team = team;
        this.name = name;
    }

    @Override
    public Move play(Board board) {
        Board copy = board.deepCopyBoard(); //Checked copy, is correct

        /* Doesn't work!!!!!!!!!!! */
        //First check for winning conditions
        for (int i = 0; i < Board.DIM; i++)
            for (int j = 0; j < Board.DIM; j++) {
                System.out.printf("W: %s,%b\n",new Move(i, j, team),copy.isWinningState(new Move(i, j, team)));
                if (copy.isWinningState(new Move(i, j, team)))
                    return new Move(i, j, team);
            }

        //Then check for losing conditions
        for (int i = 0; i < Board.DIM; i++)
            for (int j = 0; j < Board.DIM; j++) {
                System.out.printf("L: %s,%b\n",new Move(i, j, team),copy.isWinningState(new Move(i, j, team.other())));
                if (copy.isWinningState(new Move(i, j, team.other())))
                    return new Move(i, j, team);
            }
        //If all else fails
        int randX = ThreadLocalRandom.current().nextInt(0, Board.DIM);
        int randY = ThreadLocalRandom.current().nextInt(0, Board.DIM);
        return new Move(1,1,team);//new Move(randX, randY, team);

        /*
        Sorta fake pseudocode:
        ----------------------------------------------
        Board copy = board.deepCopyBoard();
        for int i : DIM:
            for int j : DIM:
                if(copy.isWinningState(new Move(i,j,team))
                    return new Move(i,j,team)
        for int i : DIM:
                for int j : DIM:
                    if(copy.isWinningState(new Move(i,j,team.other()))
                        return new Move(i,j,team)        */
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
