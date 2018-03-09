package oo_assignment5pleunchris;

import java.util.HashMap;

/**
 *
 * @author Pleun
 */
public abstract class BaseExpr {
    @Override
    public abstract String toString();
    
    protected abstract double eval(HashMap<String, Double> map);
    
    protected abstract BaseExpr partialEval();
}
