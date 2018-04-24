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
public class ExprFactory {
    
    public static BinOpForm and(Form left, Form right) {
        return new BinOpForm(BinOp.AndOp, left, right);
    }
    
    public static BinOpForm or(Form left, Form right) {
        return new BinOpForm(BinOp.OrOp, left, right);
    }
    
    public static BinOpForm imply(Form left, Form right) {
        return new BinOpForm(BinOp.ImplyOp, left, right);
    }
    
    public static NotForm not(Form op) {
        return new NotForm(op);
    }
    
    public static AtomForm atom(String str) {
        return new AtomForm(str);
    }
    
    public static ConstantForm T() {
        return ConstantForm.True;
    }
    
    public static ConstantForm F() {
        return ConstantForm.False;
    }
}
