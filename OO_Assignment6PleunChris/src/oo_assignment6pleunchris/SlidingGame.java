package oo_assignment6pleunchris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.3
 * @date 07-03-2016 A template implementation of a sliding game implementing the
 * Graph interface
 */
public class SlidingGame implements Configuration {

    public static final int N = 3, SIZE = N * N, HOLE = SIZE;
    /**
     * The board is represented by a 2-dimensional array; the position of the
     * hole is kept in 2 variables holeX and holeY
     */
    private int[][] board;
    private int holeX, holeY;
    private Configuration parent;
    private int[][] boardSolution;

    /**
     * A constructor that initializes the board with the specified array
     *
     * @param start: a one dimensional array containing the initial board. The
     * elements of start are stored row-wise.
     */
    public SlidingGame(int[] start) {
        board = new int[N][N];

        assert start.length == N * N : "Length of specified board incorrect";

        for (int p = 0; p < start.length; p++) {
            board[p % N][p / N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }

        parent = null;
        setSolution();
    }

    public SlidingGame(int[][] state) {
        board = new int[N][N];

        for (int i = 0; i < state.length; i++)
            for (int j = 0; j < state.length; j++) {
                board[i][j] = state[i][j];
                if (state[i][j] == HOLE) {
                    holeX = i;
                    holeY = j;
                }

            }
        setSolution();
    }

    /**
     * Creates the solution of the board.
     */
    public final void setSolution() {
        boardSolution = new int[N][N];
        int counter = 1;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                boardSolution[j][i] = counter;
                counter++;
            }
    }

    /**
     * Converts a board into a printable representation. The hole is displayed
     * as a space
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int puzzel = board[col][row];
                //buf.append(puzzel + " ");
                buf.append(puzzel == HOLE ? "  " : puzzel + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    @Override
    public boolean equals(Object o) {
        //Improve the speed by checking the hashCode first.
        if (o.getClass().equals(this.getClass()) && this.hashCode() == o.hashCode()) {
            for (int i = 0; i < board.length; i++)
                if (!Arrays.equals(board[i], SlidingGame.class.cast(o).getBoard()[i]))
                    return false;
            return true;
        }
        return false;
    }

    @Override
    public boolean isSolution() {
        SlidingGame winner = new SlidingGame(boardSolution);
        return winner.equals(this);
    }

    @Override
    public Collection<Configuration> successors() {
        ArrayList<Configuration> successors = new ArrayList<>();
        //Loop over all directions
        for (Direction dir : Direction.values()) {
            int newX = holeX + dir.GetDX();
            int newY = holeY + dir.GetDY();
            //Check if legal position on the board
            if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
                //Copy board
                int[][] newBoard = getDeepBoardCopy();
                //Switch the hole and tile at the new hole's position.
                int temp = newBoard[newX][newY];
                newBoard[newX][newY] = HOLE;
                newBoard[holeX][holeY] = temp; //<-----
                //System.out.printf("oldX: %d, oldY: %d, newX: %d, newY: %d,Temp:%d\n",holeX, holeY, newX, newY, temp);
                //Make new configuration and set the parent.
                SlidingGame succ = new SlidingGame(newBoard);
                succ.setParent(this);
                successors.add(succ);
            }
        }
        return successors;
    }

    @Override
    public int compareTo(Configuration g) {
        throw new UnsupportedOperationException("compareTo : not supported yet.");
    }

    @Override
    public Configuration parent() {
        return parent;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setParent(Configuration parent) {
        this.parent = parent;
    }

    public int[][] getSolution() {
        return boardSolution;
    }

    /**
     * @return a deep copy of the board.
     */
    public int[][] getDeepBoardCopy() {
        int[][] copy = new int[N][N];
        for (int i = 0; i < board.length; i++)
            copy[i] = Arrays.copyOf(board[i], N);
        return copy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int x = N - 1; x >= 0; x--)
            for (int y = N - 1; y >= 0; y--)
                hash = 31 * hash + board[x][y];
        return hash;
    }

}
