package oo_assignment3pleunchris;
/**
 *
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s4822250
 */
public interface Geometric extends Comparable<Geometric> {
    
    public double getLeftBorder();
    public double getRightBorder();
    public double getBottomBorder();
    public double getTopBorder();
    
    public double getArea();
    
    public void move(double dx, double dy);
    public int compareTo(Geometric g);
   
}
