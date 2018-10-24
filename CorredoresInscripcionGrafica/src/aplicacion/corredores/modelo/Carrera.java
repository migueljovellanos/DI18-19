/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.modelo;

import aplicacion.corredores.utils.Cola;
import aplicacion.corredores.utils.Utils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author migue
 */
public class Carrera {

    private String nombre;
    private Date fecha;
    private String lugar;
    private int maxCorredores;
    private final Map<Integer, Corredor> ColeccionDorsalesCorredores;
    private final Map<Integer, Date> ColeccionDorsalesTiempos;
    private Cola dorsales;

    public Carrera(String nombre, Date fecha, String lugar, int maxCorredores) {
        this.ColeccionDorsalesCorredores = new TreeMap<>();
        this.ColeccionDorsalesTiempos = new HashMap<>();
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.maxCorredores = maxCorredores;
        this.dorsales = new Cola(maxCorredores);

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

    public Cola getDorsales() {
        return dorsales;
    }

    public Map<Integer,Date> getColeccionDorsalesTiempos() {
        return ColeccionDorsalesTiempos;
    }    

    public void setDorsales(Cola dorsales) {
        this.dorsales = dorsales;
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

    public void addCorredorCarrera(Corredor corredor) {
        ColeccionDorsalesCorredores.put(dorsales.pull(), corredor);
    }

    public void removeCorredor(int dorsal) {
        if (ColeccionDorsalesCorredores.containsKey(dorsal)) {
            ColeccionDorsalesCorredores.remove(dorsal);
            dorsales.push(dorsal);
        }
    }
    
    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", fecha=" + Utils.sdf.format(fecha) + ", lugar=" + lugar + ", maxCorredores=" + maxCorredores + ", ColeccionDorsalesCorredores=" + ColeccionDorsalesCorredores + ", dorsales=" + dorsales.toString() + '}';
    }

}
