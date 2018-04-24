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
public class NotForm implements Form {

    private Form operand;
    private final int precedence;
    
    public NotForm(Form oper) {
        this.precedence = 0;
        this.operand = oper;
    }

    @Override
    public <R> R accept(FormVisitor<R> v) {
        return v.visit(this);
    }

    /**
     * @return the operand
     */
    public Form getOperand() {
        return operand;
    }

    @Override
    public int getPrecedence() {
        return precedence;
    }
    
    
}
