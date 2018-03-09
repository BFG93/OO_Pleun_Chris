package oo_assignment5pleunchris;

import java.util.Map;

/**
 *
 * @author Pleun
 */
public class Multiply extends TwoArgExpr {

    public Multiply(BaseExpr arg1, BaseExpr arg2) {
        super(arg1, arg2);
    }

    @Override
    public String toString() {
        return String.format("(%s * %s)", arg1, arg2);
    }

    @Override
    protected double eval(Map<String, Double> map) {
        return arg1.eval(map) * arg2.eval(map);
    }

    @Override
    protected BaseExpr partialEval() {
        arg1 = arg1.partialEval();
        arg2 = arg2.partialEval();
        
        //Mul(n,m) -> n*m
        if (arg1 instanceof Constant & arg2 instanceof Constant)
            return new Constant(arg1.eval(null) * arg2.eval(null));
        //Mul(x,0) -> 0 & Mul(0,y) -> 0
        else if (arg1 instanceof Constant && arg1.eval(null)==0 || arg2 instanceof Constant && arg2.eval(null)==0) 
            return new Constant(0);
        //Mul(1,y) -> y
        else if (arg1 instanceof Constant && arg1.eval(null)==1)
            return arg2;
        //Mul(x,1) -> x
        else if(arg2 instanceof Constant && arg2.eval(null)==1)
            return arg1;
        else 
            return this;
    }

}
