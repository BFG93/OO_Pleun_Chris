/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment10onlinestore;

/**
 *
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s4822250 
 */
public class Washingmachine extends Item {
    
   
    
    public Washingmachine(){
        super("Washingmachine",499);
    }

    @Override
    public double shippingCost() {
        return 30;
    }
    
    
}
