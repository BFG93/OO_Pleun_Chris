package oo_assignment5pleunchris;

import java.util.HashMap;

/**
 *
 * @author Pleun
 */
public class Constant extends NoArgExpr {
    private double val;
    
    public Constant(double val) {
        this.val = val;
    }
    
    @Override
    public String toString() {
        return Double.toString(val);
    }

    @Override
    public double eval(HashMap<String, Double> env) {
        return val;
    }

    @Override
    public BaseExpr partialEval() {
        return this;
    }
}
