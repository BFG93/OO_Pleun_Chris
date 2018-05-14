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
public class CreditCardPayment implements PaymentStrategy {

    private final String name, date;
    private final int number, cvv;

    public CreditCardPayment(String n, String d, int id, int cvv) {
        this.name = n;
        this.date = d;
        this.number = id;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay %1.2f with card %d of %s\n", amount, number, name);
        return true;
    }

    public String toString() {
        return "CreditCardPayment of " + name + ", number =" + number;
    }
}
