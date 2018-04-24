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
public class AtomForm implements Form {

    private final String name;
    public final int precedence;

    @Override
    public <R> R accept(FormVisitor<R> v) {
        return v.visit(this);
    }

    public AtomForm(String name) {
        this.name = name;
        this.precedence = 0;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int getPrecedence() {
        return precedence;
    }

}
