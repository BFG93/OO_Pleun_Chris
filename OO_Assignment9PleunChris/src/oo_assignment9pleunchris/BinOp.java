/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment9pleunchris;

import java.util.function.BinaryOperator;

/**
 *
 * @author christianlammers
 */
public enum BinOp implements BinaryOperator<Boolean>{

    AndOp("/\\",1) {
        @Override
        public Boolean apply(Boolean a1, Boolean a2) {
            return a1 && a2;
        }
    },
    OrOp("\\/",2) {
        @Override
        public Boolean apply(Boolean a1, Boolean a2) {
            return a1 || a2;
        }
    },
    ImplyOp("->",3) {
        @Override
        public Boolean apply(Boolean a1, Boolean a2) {
            return !a1 || a2;
        }
    };
    
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
