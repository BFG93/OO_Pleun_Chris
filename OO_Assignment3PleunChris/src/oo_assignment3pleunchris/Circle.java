package oo_assignment3pleunchris;
/**
 *
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s4822250
 */
public class Circle implements Geometric {
    
    private double x;
    private double y;
    private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    
    @Override
    public double getLeftBorder() {
        return x - r;
    }

    @Override
    public double getRightBorder() {
        return x + r;
    }

    @Override
    public double getBottomBorder() {
        return y - r;
    }

    @Override
    public double getTopBorder() {
        return y + r;
    }

    @Override
    public double getArea() {
        return Math.PI * (r*r);
    }

    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public int compareTo(Geometric g) {
         if(this.getArea() < g.getArea()){
            return -1;
        } else if(this.getArea() > g.getArea()) {
            return 1;
        } else 
            return 0;
    }
    
    @Override
    public String toString(){
        return "Circle: (" +x+","+y+") with radius "+r;
    }
}

