/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment10onlinestore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Christian Lammers s4578236
 * @author Pleun Scholten s4822250
 */
public class ShoppingCart {

    List<Item> items;
    boolean paid = false;
    PaymentStrategy strategy;

    public ShoppingCart(String bank, int nr, int pin) {
        strategy = new IDealPayment(nr, pin, bank);
        items = new LinkedList<>();
    }

    public void changePaymentStrategy(PaymentStrategy p) {
        strategy = p;
    }

    public boolean add(Item item) {
        if (paid) {
            return false;
        } else {
            items.add(item);
            return true;
        }
    }

    public boolean pay() {
        double sum = total();
        if (paid || sum == 0.0) {
            return false;
        } else {
            return strategy.pay(sum);
        }
    }
    
    public double shippingCosts(){
        double cost = 0;
        List<Double> costs = new ArrayList<>();
        for (Item i : items){
            costs.add(i.shippingCost());
        }
        Set<Double> set = new HashSet<>(costs);
        for (Double d : set){
            cost += d;
        }
        return cost;
        
    }

    private double total() {

        double sum = 0;
        for (int i = 0; i < items.size(); i++) {
            sum += items.get(i).price;
        }
        sum += shippingCosts();
        return sum;
    }
}
