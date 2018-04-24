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
public interface FormVisitor<R> {
    <R> R visit(BinOpForm bin);
    <R> R visit(NotForm not);
    <R> R visit(ConstantForm con);
    <R> R visit(AtomForm str);
}
