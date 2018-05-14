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
public class PayPalPayment implements PaymentStrategy {
    private final String email, password;
    private final int code;
    
    public PayPalPayment(String addr, String pwd, int code){
        this.email = addr;
        this.password = pwd;
        this.code = code;
    }

    @Override
    public boolean pay(double amount) {
       System.out.format("Pay %1.2f with paypal for %s\n", amount ,email);
       return false;
    }
    
    public String toString(){
        return "PayPalPayment of " + email;
    }
    
    
}
