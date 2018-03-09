package oo_assignment5pleunchris;

/**
 *
 * @author Pleun
 */
public abstract class TwoArgExpr extends BaseExpr {
    protected BaseExpr arg1;
    protected BaseExpr arg2;
    
    public TwoArgExpr(BaseExpr arg1, BaseExpr arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
}
