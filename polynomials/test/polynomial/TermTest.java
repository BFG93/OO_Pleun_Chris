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
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class TermTest {
    
    public TermTest() {
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
     * Test of toString method, of class Term.
     */
    @Test
    public void testToString() {
        
    }

    /**
     * Test of plus method, of class Term.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Term t1 = new Term(1,1);
        Term t2 = new Term(2,1);
        t1.plus(t2);
        Term ans = new Term(3,1);
        assertEquals(ans, t1);
    }
    
    @Test
    public void testPlusDiff() {
        System.out.println("plus different coef");
        Term t1 = new Term(1,1);
        Term t2 = new Term(2,2);
        t1.plus(t2);
        Term ans = null;
        assertEquals(ans, t1);
        //Wrongly gives answer 3x. Should asser that this.coefficient == other.coefficient.
    }
    
    @Test
    public void testPlusZero() {
        System.out.println("plus zero");
        Term t1 = new Term(1,1);
        Term t2 = new Term(0,0);
        Term ans = new Term(1,1);
        t1.plus(t2);
        assertEquals(ans, t1);
    }

    /**
     * Test of times method, of class Term.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Term t1 = new Term(3,4);
        Term t2 = new Term(1,2);
        Term ans = new Term(3,6);
        t1.times(t2);
        assertEquals(ans, t1);
    }

    @Test
    public void testTimesZero() {
        System.out.println("times zero");
        Term t1 = new Term(3,4);
        Term t2 = new Term(0,0);
        Term ans = new Term(0,0);
        t1.times(t2);
        assertEquals(ans, t1);
        //Gives incorrect answer 0.000000x^4, instead of just 0.000000
    }
    
    /**
     * Test of equals method, of class Term.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Term t1 = new Term(3,7);
        Object t2 = new Term(3,7);
        boolean ans = true;
        boolean test = t1.equals(t2);
        assertEquals(ans, test);
    }

    /**
     * Test of divide method, of class Term.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Term t1 = new Term(4,3);
        Term t2 = new Term(2,2);
        Term ans = new Term(2,1);
        t1.divide(t2);
        assertEquals(ans, t1);
    }
    
    @Test
    public void testDivideZero() {
        System.out.println("divide zero");
        Term t1 = new Term(4,3);
        Term t2 = new Term(0,0);
        Term ans = null;
        t1.divide(t2);
        assertEquals(ans, t1);
        //Returns Infinityx^3 instead of throwing an error. 
    }
    
    @Test
    public void testDivSelf() {
        System.out.println("divide self");
        Term t1 = new Term(4,3);
        Term t2 = new Term(4,3);
        Term ans = new Term(1,0);
        t1.divide(t2);
        assertEquals(ans, t1);
    }
    
    @Test
    public void testComm() {
        System.out.println("commutativity");
        Term t1 = new Term(2,3);
        Term t2 = new Term(4,3);
        
        Term t3 = new Term(2,3);
        Term t4 = new Term(4,3);
        t1.plus(t2);
        t4.plus(t3);
        assertEquals(t4, t1);
    }
    
    @Test
    public void testAss() {
        System.out.println("associativity");
        Term t1 = new Term(2,3);
        Term t2 = new Term(4,3);
        Term t3 = new Term(1,3);
        
        Term t4 = new Term(2,3);
        Term t5 = new Term(4,3);
        Term t6 = new Term(1,3);
        t1.plus(t2);
        t1.plus(t3);
        t5.plus(t6);
        t4.plus(t5);
        assertEquals(t4, t1);
    }
    
    @Test
    public void testDist() {
        System.out.println("distributivity");
        Term t1 = new Term(2,1);
        Term t2 = new Term(4,3);
        Term t3 = new Term(1,3);
        
        Term t4 = new Term(2,1);
        Term t4copy = new Term(t4);
        Term t5 = new Term(4,3);
        Term t6 = new Term(1,3);
        t2.plus(t3);
        t1.times(t2);
        
        t4.times(t5);
        t4copy.times(t6);
        t4.plus(t4copy);
        assertEquals(t4, t1);
    }
    
}
