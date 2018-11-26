/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.modelo;

import aplicacion.corredores.utils.Utils;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author migue
 */
public class Corredor implements Serializable{

    //Atributos
    private String nombre;
    private String dni;
    private Date fechaNacimiento;
    private String direccion;
    private int telefono;

   

    
    public Corredor(String nombre, String dni, Date fechaNacimiento, String direccion, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        
        return "nombre= " + nombre + ", dni= " + dni + ", fechaNacimiento= " + Utils.SDF.format(fechaNacimiento) + ", direccion= " + direccion + ", telefono= " + telefono + '}';
    }

}
