/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment9pleunchris;

import java.util.HashMap;
import static oo_assignment9pleunchris.ExprFactory.*;

/**
 *
 * @author christianlammers
 */
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashMap<String, Boolean> env = new HashMap<>();
        
        env.put("a", true);
        env.put("b", false);
        env.put("c", false);
        env.put("d", false);
        
        // ~a /\ b -> c
        Form f1 = imply(and(not(atom("a")), atom("b")), atom("c"));
        // ~a -> (b /\ c)
        Form f2 = and(not(atom("a")),imply( atom("b"), atom("c")));
        // a \/ b /\ c \/ d
        Form f3 = or(atom("a"), or(and(atom("b"), atom("c")), atom("d")));
        // (a \/ b ) /\ (c \/ d)
        Form f4 = and(or(atom("a"), atom("b")), or(atom("c"), atom("d")));
        // True \/ False -> a
        Form f5 = imply(or(True(), False()), atom("a"));
        
        PrintFormVisitor pfv = new PrintFormVisitor();        
        EvalFormVisitor efv = new EvalFormVisitor(env);
        
        f1.accept(pfv);
        System.out.println(" : "+f1.accept(efv));
        f2.accept(pfv);
        System.out.println(" : "+f2.accept(efv));
        f3.accept(pfv);
        System.out.println(" : "+f3.accept(efv));
        f4.accept(pfv);
        System.out.println(" : "+f4.accept(efv));
        f5.accept(pfv);
        System.out.println(" : "+f5.accept(efv));
    }

}
