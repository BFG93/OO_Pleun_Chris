package oo_assignment5pleunchris;

import java.util.HashMap;

/**
 *
 * @author Pleun
 */
public class Variable extends NoArgExpr{
    private String name;
    
    public Variable(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public double eval(HashMap<String, Double> dictionary) {
        return dictionary.get(name);
    }
    
    @Override
    public BaseExpr partialEval() {
        return this;
    }
}
