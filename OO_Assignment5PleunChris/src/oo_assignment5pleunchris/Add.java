package oo_assignment5pleunchris;

import java.util.HashMap;

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
    protected double eval(HashMap<String, Double> map) {
        return arg1.eval(map) + arg2.eval(map);
    }

    /**
     * @return either a new Constant with value arg1+arg2 or this.
     */
    @Override
    protected BaseExpr partialEval() {
        if(arg1 instanceof Constant && arg2 instanceof Constant)
            return new Constant(arg1.eval(null)+arg2.eval(null));
        else
            return this;
    }

}
