/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo_assignment9pleunchris;

/**
 *
 * @author christianlammers
 */
public  interface Form {
    
    public <R> R accept(FormVisitor<R> v);
    int getPrecedence();
    
}
