package oo_assignment9pleunchris;

import java.util.Map;

/**
 *
 * @author Pleun
 */
public class EvalFormVisitor implements FormVisitor<Boolean>{

    private Map<String, Boolean> env;
    
    public EvalFormVisitor(Map<String, Boolean> env) {
        this.env = env;
    }
    
    @Override
    public Boolean visit(BinOpForm bin) {
        return bin.getOperator().apply(bin.getLeftOperand().accept(this), bin.getRightOperand().accept(this));
    }

    @Override
    public Boolean visit(NotForm not) {
        return !not.getOperand().accept(this);
    }

    @Override
    public Boolean visit(ConstantForm con) {
        return con.getValue();
    }

    @Override
    public Boolean visit(AtomForm atom) { 
        if(env.containsKey(atom.toString()))
            return env.get(atom.toString());
        else
            throw new IllegalArgumentException("Invalid Key");
    }

}
