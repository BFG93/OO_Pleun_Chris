package oo_assignment5pleunchris;

import java.util.Map;

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
    protected double eval(Map<String, Double> map) {
        return -arg.eval(map);
    }

    /**
     * @return either a new negated constant or this.
     */
    @Override
    protected BaseExpr partialEval() {
        arg = arg.partialEval();
        //Neg(n) -> -n
        if (arg instanceof Constant)
            return new Constant(-arg.eval(null));
        else
            return this;
    }
}
