/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment9pleunchris;

/**
 *
 * @author christianlammers
 */
public enum BinOp {

    AndOp("/\\",1),
    OrOp("\\/",2),
    ImplyOp("->",3);
    
    private String symbol;
    private final int precedence;
    
    private BinOp(String symbol, int precedence) {
        this.symbol = symbol;
        this.precedence = precedence;
    }

    @Override
    public String toString() {
        return symbol;
    }

    /**
     * @return the precedence
     */
    public int getPrecedence() {
        return precedence;
    }
}
