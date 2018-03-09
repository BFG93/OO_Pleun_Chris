package oo_assignment5pleunchris;

import java.util.HashMap;

/**
 *
 * @author Pleun
 */
public class Negate extends OneArgExpr {

    public Negate(BaseExpr arg) {
        super(arg);
    }

    @Override
    public String toString() {
        return String.format("-%s", arg.toString());
    }

    /**
     * @param map of all variable values.
     * @return -argument.
     */
    @Override
    protected double eval(HashMap<String, Double> map) {
        return -arg.eval(map);
    }

    /**
     * @return either a new negated constant or this.
     */
    @Override
    protected BaseExpr partialEval() {
        if (arg instanceof Constant)
            return new Constant(-arg.eval(null)); //Give null as map because it's not needed.
        else
            return new Negate(arg.partialEval());
    }
}
