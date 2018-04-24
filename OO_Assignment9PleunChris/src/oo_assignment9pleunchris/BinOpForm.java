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
public class BinOpForm implements Form{
    private BinOp operator;
    private Form leftOperand;
    private Form rightOperand;
    private final int precedence;
    
    public BinOpForm(BinOp operator, Form left, Form right) {
        this.operator = operator;
        this.leftOperand = left;
        this.rightOperand = right;
        this.precedence = operator.getPrecedence();
    }
    
    @Override
    public <R> R accept(FormVisitor<R> v) {
        return v.visit(this);
    }

    /**
     * @return the op
     */
    public BinOp getOperator() {
        return operator;
    }

    /**
     * @return the leftOperand
     */
    public Form getLeftOperand() {
        return leftOperand;
    }

    /**
     * @return the rightOperand
     */
    public Form getRightOperand() {
        return rightOperand;
    }

    /**
     * @param rightOperand the rightOperand to set
     */
    public void setRightOperand(Form rightOperand) {
        this.rightOperand = rightOperand;
    }

    @Override
    public int getPrecedence() {
        return precedence;
    }
}    
    
    
