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
public class PrintFormVisitor implements FormVisitor<Void>{
    
    @Override
    public Void visit(BinOpForm bin) {
        Form left = bin.getLeftOperand();
        Form right = bin.getRightOperand();
        BinOp operator = bin.getOperator();
        
        if (left.getPrecedence() > operator.getPrecedence()) {
            System.out.print("(");
            left.accept(this);
            System.out.print(")");
        }
        else 
            left.accept(this);
        System.out.print(operator);
        if (right.getPrecedence() > operator.getPrecedence()) {
            System.out.print("(");
            right.accept(this);
            System.out.print(")");
        }
        else
            right.accept(this);
        return null;
    }

    @Override
    public Void visit(NotForm not) {
        Form operand = not.getOperand();
        System.out.print(String.format("~%s", operand));
        return null;
    }

    @Override
    public Void visit(ConstantForm con) {
        System.out.print(con);
        return null;
    }

    @Override
    public Void visit(AtomForm str) {
        System.out.print(str);
        return null;
    }

    
}
