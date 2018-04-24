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

    True("True"),
    False("False");
    
    private String name;
    private final int precedence;
    
    private ConstantForm(String string) {
        this.name = string;
        this.precedence = 0;
    }

    @Override
    public String toString() {
        return name;
    }
      
    @Override
    public <R> R accept(FormVisitor<R> v) {
        return v.visit(this);
    }

    @Override
    public int getPrecedence() {
        return precedence;
    }
    
}
