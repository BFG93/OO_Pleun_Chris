package oo_assignment5pleunchris;

import java.util.Map;

/**
 *
 * @author Pleun
 */
public class Add extends TwoArgExpr{

    public Add(BaseExpr arg1, BaseExpr arg2) {
        super(arg1, arg2);
    }

    @Override
    public String toString() {
        return String.format("(%s + %s)",arg1,arg2);
    }

    @Override
    protected double eval(Map<String, Double> map) {
        return arg1.eval(map) + arg2.eval(map);
    }

    /**
     * @return either a new Constant with value arg1+arg2 or this.
     */
    @Override
    protected BaseExpr partialEval() {
        arg1 = arg1.partialEval();
        arg2 = arg2.partialEval();
        
        //Add(n,m) -> n+m
        if(arg1 instanceof Constant & arg2 instanceof Constant)
            return new Constant(arg1.eval(null)+arg2.eval(null));
        //Add(x,0) -> x
        if(arg2 instanceof Constant && arg2.eval(null)==0)
            return arg1;
        //Add(0,y) -> y
        if(arg1 instanceof Constant && arg1.eval(null)==0)
            return arg2;
        else
            return this;
    }

}
