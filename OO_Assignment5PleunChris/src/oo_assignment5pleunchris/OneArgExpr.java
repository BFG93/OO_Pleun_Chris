package oo_assignment5pleunchris;

/**
 *
 * @author Pleun
 */
public abstract class OneArgExpr extends BaseExpr {
    BaseExpr arg;
    
    public OneArgExpr(BaseExpr arg) {
        this.arg = arg;
    }
}
