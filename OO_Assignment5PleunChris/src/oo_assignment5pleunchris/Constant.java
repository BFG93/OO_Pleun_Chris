package oo_assignment5pleunchris;

import java.util.Map;

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
    public double eval(Map<String, Double> env) {
        return val;
    }

    @Override
    public BaseExpr partialEval() {
        return this;
    }
}
