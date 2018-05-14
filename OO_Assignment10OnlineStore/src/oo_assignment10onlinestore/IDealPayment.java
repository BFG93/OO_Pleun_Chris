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
public class IDealPayment implements PaymentStrategy {
    private  final int accountNumber, pin;
    private final String bank;
    
    
    public IDealPayment(int acc, int pin, String bank){
        this.accountNumber = acc;
        this.pin = pin;
        this.bank = bank;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay %1.2f with IDeal for %d\n", amount ,accountNumber);
       return false;
    }
    
    public String toString(){
        return "IDealPayment with bankaccount " +accountNumber;
    }
    
    
    
}
