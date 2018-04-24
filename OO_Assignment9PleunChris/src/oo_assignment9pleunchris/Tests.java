/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment9pleunchris;

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
        // ~A /\ B -> C
        Form f1 = imply(and(not(atom("A")), atom("B")), atom("C"));
        // (~A -> B) /\ C
        Form f2 = and(imply(not(atom("A")), atom("B")), atom("C"));
        // A \/ B /\ C \/ D
        Form f3 = or(atom("A"), or(and(atom("B"), atom("C")), atom("D")));
        // (A \/ B ) /\ (C \/ D)
        Form f4 = and(or(atom("A"), atom("B")), or(atom("C"), atom("D")));

        PrintFormVisitor pfv = new PrintFormVisitor();
        f1.accept(pfv);
        System.out.println("");
        f2.accept(pfv);
        System.out.println("");
        f3.accept(pfv);
        System.out.println("");
        f4.accept(pfv);
        System.out.println("");
    }

}
