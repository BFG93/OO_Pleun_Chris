package oo_assignment3pleunchris;

/**
 *
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s4822250
 */
public class Rectangle implements Geometric {
    
    private double x;
    private double y;
    private double h;
    private double w;
    
    public Rectangle(double x, double y, double h, double w) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
    }
    
    @Override
    public double getLeftBorder() {
        return x;
    }

    @Override
    public double getRightBorder() {
        return x+w;
    }

    @Override
    public double getBottomBorder() {
        return y;
    }

    @Override
    public double getTopBorder() {
        return y+h;
    }

    @Override
    public double getArea() {
        return w*h;
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
        return "Rectangle: (" +x+","+y+") to ("+(x+w)+","+(y+h)+")";
    }
    
}
