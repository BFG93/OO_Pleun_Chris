package oo_assignment4pleunchris;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Pleun Scholten s4822250
 */
public class ComputerPlayer implements Player {

    private Field team;
    private String name;
    private Board copy;
    private Move validMove;
    private int counter;

    public ComputerPlayer(Field team, String name) {
        this.team = team;
        this.name = name;
    }

    @Override
    public Move play(Board board) {
        copy = board.deepCopyBoard(); //Checked copy, is correct
        Move move;

        //First check for winning conditions
        if (checkForWin())
            return validMove;

        //Then check for losing conditions
        if (checkForLoose())
            return validMove;

        //Check for fork
        if (checkForFork())
            return validMove;

        //If all else fails
        //int randX = ThreadLocalRandom.current().nextInt(0, Board.DIM);
        //int randY = ThreadLocalRandom.current().nextInt(0, Board.DIM);
        //return new Move(1, 1, team);//new Move(randX, randY, team);

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
        return validMove;
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

    private boolean checkForWin() {
        Move move;
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                if (copy.getState(i, j) == Field.EMPTY) {
                move = new Move(i, j, team);
                //System.out.printf("W: %s,%b\n", move, copy.isWinningState());
                copy.setState(move);
                if (copy.isWinningState()) {
                    validMove = move;
                    //System.out.println("Winning move");
                    return true;
                }
                copy.setState(new Move(i,j,Field.EMPTY));
                }
            }
        }
        return false;
    }

    private boolean checkForLoose() {
        Move move;
        counter = 0;
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                if (copy.getState(i, j) == Field.EMPTY) {
                move = new Move(i, j, team.other());
                //System.out.printf("L: %s,%b\n", move, copy.isWinningState());
                copy.setState(move);
                if (copy.isWinningState()) {
                    validMove = new Move(i, j, team);
                    counter++;
                    //System.out.println("Loosing move");
                    return true;
                }
                copy.setState(new Move(i,j,Field.EMPTY));
                }
            }
        }
        return false;
    }

    private boolean checkForFork() {
        Move move;
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                if (copy.getState(i, j) == Field.EMPTY) {
                    move = new Move(i, j, team.other());
                    copy.setState(move);
                    
                    // if opponent has two possibilities to win if he does the move
                    if (twoWinningMoves()) {
                        validMove = new Move(i, j, team);
                        System.out.println("fork " + validMove);
                        return true;
                    }
                    copy.setState(new Move(i, j, Field.EMPTY));

                }
            }

        }
        return false;
    }

    private boolean twoWinningMoves() {
        Move move;
        counter = 0;
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                if (copy.getState(i, j) == Field.EMPTY) {
                move = new Move(i, j, team.other());
                //System.out.printf("L: %s,%b\n", move, copy.isWinningState());
                copy.setState(move);
                if (copy.isWinningState()) {
                    validMove = new Move(i, j, team);
                    counter++;
                }
                copy.setState(new Move(i,j,Field.EMPTY));
                }
            }
        }
        return counter ==2;
    }

}
