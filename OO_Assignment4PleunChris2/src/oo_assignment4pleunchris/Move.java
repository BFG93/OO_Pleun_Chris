package oo_assignment4pleunchris;

/**
 * A move is a move on the board, at position x,y with Field state.
 * @author Pleun
 */
public class Move {
    private int x;
    private int y;
    private Field state;
    
    public Move(int x, int y, Field state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }
    
    public Field getState() {
        return this.state;
    }
    
    /**
     * @return the x,y coordinates as an integer array {x,y}
     */
    public int[] getCoords() {
        return new int[] {x,y};
    }
    
    @Override
    public String toString() {
        return String.format("%d,%d -> %s",x,y,state);
    }
}
