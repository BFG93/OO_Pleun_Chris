package oo_assignment5pleunchris;

import java.util.Map;

/**
 *
 * @author Pleun
 */
public abstract class BaseExpr {
    @Override
    public abstract String toString();
    
    protected abstract double eval(Map<String, Double> map);
    
    protected abstract BaseExpr partialEval();
}
