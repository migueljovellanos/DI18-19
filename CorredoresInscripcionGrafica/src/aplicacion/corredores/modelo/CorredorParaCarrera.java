/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Miguel
 */
public class CorredorParaCarrera extends Corredor implements Serializable {

    private int dorsal;
    private String tiempo;

    public CorredorParaCarrera(String nombre, String dni, Date fechaNacimiento, String direccion, int telefono, int dorsal) {
        super(nombre, dni, fechaNacimiento, direccion, telefono);
        setDorsal(dorsal);
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

}
