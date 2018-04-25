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
public enum  ConstantForm implements Form {

    True(true),
    False(false);
    
    private boolean value;
    private final int precedence;
    
    private ConstantForm(boolean string) {
        this.value = string;
        this.precedence = 0;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
      
    @Override
    public <R> R accept(FormVisitor<R> v) {
        return v.visit(this);
    }

    @Override
    public int getPrecedence() {
        return precedence;
    }
    
    /**
     * @return the value
     */
    public boolean getValue() {
        return value;
    }
    
}
