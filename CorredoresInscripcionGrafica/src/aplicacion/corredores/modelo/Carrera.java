/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.modelo;

import aplicacion.corredores.utils.Utils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author migue
 */
public class Carrera {
    private String nombre;
    private Date fecha;
    private String lugar;
    private int maxCorredores;
    private Map<Integer, Corredor> ColeccionDorsalesCorredores;

    public Carrera(String nombre, Date fecha, String lugar, int maxCorredores) {
        this.ColeccionDorsalesCorredores = new HashMap<Integer, Corredor>();
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.maxCorredores = maxCorredores;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public int getMaxCorredores() {
        return maxCorredores;
    }

    public Map<Integer, Corredor> getColeccionDorsalesCorredores() {
        return ColeccionDorsalesCorredores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setMaxCorredores(int maxCorredores) {
        this.maxCorredores = maxCorredores;
    }

    public void setColeccionDorsalesCorredores(Map<Integer, Corredor> ColeccionDorsalesCorredores) {
        this.ColeccionDorsalesCorredores = ColeccionDorsalesCorredores;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", fecha=" + Utils.sdf.format(fecha) + ", lugar=" + lugar + ", maxCorredores=" + maxCorredores + ", ColeccionDorsalesCorredores=" + ColeccionDorsalesCorredores + '}';
    }

    
    
    
    
}
