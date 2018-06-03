package ooassignment14;

import java.util.Iterator;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class Generator implements Iterator<Integer>{
    private int next = 2;
    
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        if(next == 2)
            return next++;
        else
            return (next+=2);
    }

}
