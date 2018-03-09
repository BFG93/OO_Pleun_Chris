package oo_assignment5pleunchris;

/**
 * Class to make expressions easier to create.
 *
 * @author Pleun
 */
public class ExprFactory {

    public static Add add(BaseExpr arg1, BaseExpr arg2) {
        return new Add(arg1, arg2);
    }

    public static Multiply mul(BaseExpr arg1, BaseExpr arg2) {
        return new Multiply(arg1, arg2);
    }

    public static Negate neg(BaseExpr arg1) {
        return new Negate(arg1);
    }
    
    public static Constant c(double value) {
        return new Constant(value);
    }
    
    public static Variable v(String name) {
        return new Variable(name);
    }
}
