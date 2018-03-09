package oo_assignment5pleunchris;

import java.util.HashMap;
import java.util.Map;
import static oo_assignment5pleunchris.ExprFactory.*;

/**
 *
 * @author Pleun
 */
public class Test {

    Map<String, Double> map;

    public Test() {
        map = new HashMap();
    }

    public void run() {

        map.put("x", 2.3);
        map.put("pi", 3.141593);

        //Test 1: x+(-1 + (1 * 2))  --  Shows 1*x
        BaseExpr ex1 = add(v("x"), add(neg(c(1)), mul(c(1),c(2))));
        test(ex1);

        //Test 2: (0+((x*-0)+x))  --  Shows 0+y, x+0, x*0 and -0
        BaseExpr ex2 = add(c(0), add(mul(v("x"), neg(c(0))), v("x")));
        test(ex2);

        //Test 3: ((2 + -2)*5) + x  --  Shows bottom up with the example from the slides.
        BaseExpr ex3 = add(mul(add(c(2), c(-2)), c(5)), v("x"));
        test(ex3);
        
        //Test 
    }

    /**
     * Helper function to print an expression, the partially evaluated
     * expression and the final evaluated expression.
     *
     * @param exp
     * @param map
     */
    public void test(BaseExpr exp) {
        System.out.printf("Exp: \t\t%s\n", exp);
        System.out.printf("Partial Eval: \t%s\n", exp.partialEval());
        System.out.printf("Eval: \t\t%s\n\n", exp.eval(map));
    }
}
