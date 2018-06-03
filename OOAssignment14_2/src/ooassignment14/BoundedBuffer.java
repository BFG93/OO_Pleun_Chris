/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooassignment14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 * @param <E> class type
 */
public class BoundedBuffer<E> {
    private final E[] buffer;
    private int pointer;
    private final Lock lock;
    private final Condition full, empty;
    
    public BoundedBuffer(int size) {
        buffer = (E[]) new Object[size];
        this.pointer = 0;
        this.lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
    }
    
    public void put(E elem) {
        lock.lock();
        try {
            while(pointer >= buffer.length) {
                full.await();
            }
            buffer[pointer++] = elem;
            empty.signalAll();
        } catch(InterruptedException e) {
            System.out.println("ERROR JUNGE");
        } finally {
            lock.unlock();
        }
    }
    
    public E get() {
        lock.lock();
        E result = null;
        try {
            while (pointer <= 0) {
                empty.await();
            }
            result = buffer[0];
            shiftBuffer();
            full.signalAll();
        } catch(InterruptedException e) {
            System.out.println("Whoopsie");
        } finally {
            lock.unlock();
        }
        return result;
    }

    private void shiftBuffer() {
        for (int i = 1; i < buffer.length; i++) {
            buffer[i-1] = buffer[i];
        }
        buffer[buffer.length-1] = null;
        pointer--;
    }
}