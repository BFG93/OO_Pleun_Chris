/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sjaak
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class PolynomialTest {

    public PolynomialTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Polynomial.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polynomial instance = new Polynomial("2 0 5 1");
        String expResult = "2,000000 + 5,000000x";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Polynomial.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial b = new Polynomial("2 0 4 3");
        Polynomial instance = new Polynomial("1 0 2 2 2 3");
        Polynomial copyInstance = new Polynomial(instance);
        instance.plus(b);
        assertEquals(String.format("%s plus %s:", copyInstance, b), new Polynomial("3 0 2 2 6 3"), instance);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial b = new Polynomial("1 0 2 2 3 4");
        Polynomial instance = new Polynomial("2 0 3 2");
        Polynomial copyInstance = new Polynomial(instance);
        instance.minus(b);
        assertEquals(String.format("%s minus %s:", copyInstance, b), new Polynomial("1 0 1 2 -3 4"), instance);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Polynomial b = new Polynomial(" 1 2 3 3");
        Polynomial instance = new Polynomial("2 2 1 3");
        Polynomial copyInstance = new Polynomial(instance);
        instance.times(b);
        assertEquals(String.format("%s times %s:", copyInstance, b), new Polynomial("2 4 7 5 3 6"), instance);

    }

    /**
     * Test of equals method, of class Polynomial.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other_poly = new Polynomial("1 2");
        Polynomial instance = new Polynomial("-1 2 ");
        boolean expResult = false;
        boolean result = instance.equals(other_poly);
        assertEquals(expResult, result);
    }

    /**
     * Test of divide method, of class Polynomial.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Polynomial b = new Polynomial("1 1");;
        Polynomial instance = new Polynomial("1 2 3 4");
        Polynomial expResult = new Polynomial("1 1 3 3");
        Polynomial result = instance.divide(b);
        assertEquals(expResult, result);
    }

    @Test
    public void testDivideZero() {
        System.out.println("divide zero");
        Polynomial denom = new Polynomial();
        Polynomial numer = new Polynomial("1 0 1 2 2 4");
        Polynomial ans = null;
        Polynomial result = numer.divide(denom);
        assertEquals(ans, result);
    }

    @Test
    public void testTimesZero() {
        System.out.println("times zero");
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial("4 0 1 1 1 3");
        Polynomial ans = new Polynomial();
        p2.times(p1);
        assertEquals(ans, p2);
    }

    @Test
    public void testDivSelf() {
        System.out.println("divide self");
        Polynomial p1 = new Polynomial("2 0 1 1 ");
        Polynomial p2 = new Polynomial("2 0 1 1");
        Polynomial ans = new Polynomial("1 0");
        Polynomial result = p2.divide(p1);
        assertEquals(ans, result);
        //Gives incorrect error!
    }

    @Test
    public void testAddZero() {
        System.out.println("times zero");
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial("4 0 1 1 1 3");
        Polynomial ans = new Polynomial("4 0 1 1 1 3");
        p2.plus(p1);
        assertEquals(ans, p2);
    }

    @Test
    public void testMinusZero() {
        System.out.println("times zero");
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial("4 0 1 1 1 3");
        Polynomial ans = new Polynomial("4 0 1 1 1 3");
        p2.minus(p1);
        assertEquals(ans, p2);
    }

    @Test
    public void testRemoveZero() {
        System.out.println("removing zeros");
        Polynomial p1 = new Polynomial("2 0 1 1 ");
        Polynomial p2 = new Polynomial("-2 0 1 1");
        Polynomial ans = new Polynomial("-4 0 1 2");
        p1.times(p2);
        assertEquals(ans, p1);
    }

    @Test
    public void testCommutativity() {
        System.out.println("commutativity");
        Polynomial p1 = new Polynomial("2 0 4 3");
        Polynomial p2 = new Polynomial("1 0 2 2 2 3");
        Polynomial p1copy = new Polynomial(p1);
        p1.plus(p2);
        p2.plus(p1copy);
        assertEquals(p2, p1);
    }

    @Test
    public void testAssociativity() {
        System.out.println("Associativity");
        Polynomial p1 = new Polynomial("2 0 4 3");
        Polynomial p2 = new Polynomial("1 0 2 2 2 3");
        Polynomial p3 = new Polynomial("1 0 1 3");
        Polynomial p1copy = new Polynomial(p1);
        Polynomial p2copy = new Polynomial(p2);
        p1.plus(p2);
        p1.plus(p3);
        p2.plus(p3);
        p2.plus(p1copy);
        assertEquals(p2, p1);
    }

    @Test
    public void testDistributivity() {
        System.out.println("Distributivity");
        Polynomial p1 = new Polynomial("2 0 4 3");
        Polynomial p2 = new Polynomial("1 0 2 2 2 3");
        Polynomial p3 = new Polynomial("1 0 1 3");
        Polynomial p1copy = new Polynomial(p1);
        Polynomial p2copy = new Polynomial(p2);
        Polynomial p3copy = new Polynomial(p3);
        // p1 * (p2 +p3)
        p2.plus(p3);
        p1.times(p2);

        //p1*p2 + p1*p3
        p2copy.times(p1copy);
        p3copy.times(p1copy);
        p2copy.plus(p3copy);

        assertEquals(p2copy, p1);
    }

}
