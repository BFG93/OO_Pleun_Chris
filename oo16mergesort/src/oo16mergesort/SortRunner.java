/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo16mergesort;

/**
 *
 * @author christianlammers
 */
public class SortRunner implements Runnable {
    
    MergeSort ms;
    public static int [] array;
    
    public SortRunner(int [] array){
        
        ms = new MergeSort();
        this.array = array;
        
    }

    @Override
    public void run() {
        ms.sort(array);
        System.out.println(ms.isSorted(array));
        
    }
    
}
