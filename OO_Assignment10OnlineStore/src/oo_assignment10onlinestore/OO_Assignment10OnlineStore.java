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
public class OO_Assignment10OnlineStore {

    public static void main(String[] args) {
        
        ShoppingCart s = new ShoppingCart("RaboBank", 456789, 9999);
        s.add(new Watermelon());
        s.add(new Wineglass());
        s.pay();
        
        
    }
    
}
