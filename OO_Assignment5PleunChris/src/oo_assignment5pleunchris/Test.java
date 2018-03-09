package oo_assignment5pleunchris;

import java.util.HashMap;
import java.util.Map;
import static oo_assignment5pleunchris.ExprFactory.*;

/**
 *
 * @author Pleun
 */
public class Test {

    public void run() {
        Map<String, Double> map = new HashMap<>();
        map.put("x", 2.3);
        BaseExpr ex1 = add(v("x"), add(c(1.0), c(2.0)));
        System.out.println(ex1);
    }
}
