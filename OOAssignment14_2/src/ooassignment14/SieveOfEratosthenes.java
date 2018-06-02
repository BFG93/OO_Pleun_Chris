package ooassignment14;

import java.util.Iterator;

/**
 *
 * @author Pleun
 */
public class SieveOfEratosthenes implements Iterator<Integer>{
    private int prime;
    private Iterator<Integer> source;
    
    public SieveOfEratosthenes(int prime, Iterator source){
        this.prime = prime;
        this.source = source;
    }
    
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int next = source.next();
        while(next%prime == 0) 
            next = source.next();
        return next;
    }

}
