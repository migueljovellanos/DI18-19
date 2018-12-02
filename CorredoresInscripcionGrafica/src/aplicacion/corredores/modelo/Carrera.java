/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.modelo;

import aplicacion.corredores.utils.Cola;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author migue
 */
public class Carrera implements Serializable {

    private final ArrayList<CorredorParaCarrera> corredores;
    private String nombre;
    private Date fecha;
    private String lugar;
    private int maxCorredores;
    private boolean finalizada;
    private Cola dorsales;

    public Carrera(String nombre, Date fecha, String lugar, int maxCorredores) {
        this.corredores = new ArrayList<>();
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.maxCorredores = maxCorredores;
        this.dorsales = new Cola(maxCorredores);

    }

    public boolean addCorredorCarrera(Corredor corredor) {
        String nombre = corredor.getNombre();
        String dni = corredor.getDni();
        Date fechaNacimiento = corredor.getFechaNacimiento();
        String direccion = corredor.getDireccion();
        int telefono = corredor.getTelefono();
        for (CorredorParaCarrera corredorCarrera : corredores) {
            if (corredorCarrera.getNombre().equals(nombre) && corredorCarrera.getDni().equals(dni)) {
                return false;
            }
        }
        corredores.add(new CorredorParaCarrera(nombre, dni, fechaNacimiento, direccion, telefono, dorsales.pull()));
        return true;
    }

    public boolean removeCorredor(int dorsal) {
        for (CorredorParaCarrera corredor : corredores) {
            if (corredor.getDorsal() == dorsal) {
                dorsales.push(dorsal);
                corredores.remove(corredor);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar + ", maxCorredores=" + maxCorredores + ", finalizada=" + finalizada + ", corredores=" + corredores + ", dorsales=" + dorsales + '}';
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getMaxCorredores() {
        return maxCorredores;
    }

    public void setMaxCorredores(int maxCorredores) {
        this.maxCorredores = maxCorredores;
    }

    public Cola getDorsales() {
        return dorsales;
    }

    // SETTERS
    private void setDorsales(Cola dorsales) {
        this.dorsales = dorsales;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public ArrayList<CorredorParaCarrera> getCorredores() {
        return corredores;
    }

}
