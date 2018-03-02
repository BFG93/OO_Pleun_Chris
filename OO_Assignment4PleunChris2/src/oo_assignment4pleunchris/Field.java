package oo_assignment4pleunchris;

/**
 * Enumeration type for the tic-tac-toe game.
 * Allows states to be EMPTY, CROSS or CIRCLE. 
 * @author Pleun Scolten s4822250
 */
public enum Field {
    EMPTY, CROSS, CIRCLE;
    
    @Override
    public String toString() {
        switch (this) {
            case CROSS:
                return "X";
            case CIRCLE:
                return "O";
            case EMPTY:
                return " ";
            default:
                throw new AssertionError("Not a Field type.");
        }
    }
    
    /**
     * @return the field of the other player.
     */
    public Field other() {
        switch (this) {
            case EMPTY:
                return EMPTY;
            case CROSS:
                return CIRCLE;
            case CIRCLE:
                return CROSS;
            default:
                throw new AssertionError("Not a Field type.");
        }
    }
}