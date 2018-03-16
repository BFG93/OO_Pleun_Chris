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
    private SlidingGame parent;
    
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
                buf.append(puzzel == HOLE ? "  " : puzzel + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass().equals(this.getClass())) {
            for (int i = 0; i < board.length; i++)
                if (!Arrays.equals(board[i], SlidingGame.class.cast(o).getBoard()[i]))
                    return false;
        return true;    

        }
        return false;
    }

    @Override
    public boolean isSolution() {
        for (int i = 0; i < board.length; i++) {
            //Check if the hole is in the corect place.
            if(holeX != N-1 || holeX != N-1) 
                return false;
            //For not the first row, check if the first el of this row is 1 more than the last el of the previous row.
            if(i != 0 && board[i][0] != board[i-1][N]-1) 
                    return false;
            //Check if every element is one more than the previous. < length-1 for IndexOutOfBounds
            for (int j = 0; j < board[i].length-1; j++) 
                if (board[i][j+1] != board[i][j]-1)
                    return false;
        }
        return true;
    }

    @Override
    public Collection<Configuration> successors() {
        ArrayList<Configuration> successors = new ArrayList<>();
        for(Direction dir : Direction.values()) {
            
        }
        throw new UnsupportedOperationException("successors : not supported yet.");
    }

    @Override
    public int compareTo(Configuration g) {
        throw new UnsupportedOperationException("compareTo : not supported yet.");
    }

    @Override
    public Configuration parent() {
        throw new UnsupportedOperationException("parent: Not supported yet.");
    }

    public int[][] getBoard() {
        return board;
    }
}
