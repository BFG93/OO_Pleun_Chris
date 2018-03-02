package oo_assignment3pleunchris;
import java.util.Comparator;
/**
 *
 * @author Pleun
 */
public class XComparator implements Comparator<Geometric> {

    @Override
    public int compare(Geometric o1, Geometric o2) {
        if(o1.getLeftBorder()< o2.getLeftBorder()){
            return -1;
        } else if(o1.getLeftBorder() > o2.getLeftBorder()) {
            return 1;
        } else 
            return 0;
    }
}
