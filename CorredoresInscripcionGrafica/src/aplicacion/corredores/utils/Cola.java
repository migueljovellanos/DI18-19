/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.utils;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author migue
 */
public class Cola implements Serializable{

    LinkedList cola = new LinkedList();

    public Cola(int max) {
        for (int i = 1; i <= max; i++) {
            this.push(i);
        }
    }

    
    public void push(int a) {
        cola.addFirst(a);
        Collections.sort(cola);
    }

    public int pull() {
        return (int) cola.removeFirst();
    }

    

    @Override
    public String toString() {
        String msg = "";

        for (Object object : cola) {
            msg = msg + object.toString()+"\n";
        }

        return msg;
    }

}
