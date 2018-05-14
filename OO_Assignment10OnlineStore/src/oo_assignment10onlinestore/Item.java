/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment10onlinestore;

import java.util.Objects;

/**
 *
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s4822250
 */
public abstract class Item {
    
    String describtion;
    double price;
    
    public Item(String d, double p){
        this.describtion = d;
        this.price = p;
    
}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.describtion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.describtion, other.describtion)) {
            return false;
        }
        return true;
    }

    
    abstract double shippingCost();
    
}
