/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author migue
 */
public class Cola {

    LinkedList cola = new LinkedList();

    public void push(int a) {
        cola.addFirst(a);
    }

    public int pull() {
        return (int) cola.removeLast();
    }

    public void sort() {
        Collections.sort(cola);
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
