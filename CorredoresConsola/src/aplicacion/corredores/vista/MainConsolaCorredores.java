/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.vista;

import aplicacion.corredores.controlador.GestionCorredores;
import aplicacion.corredores.modelo.Corredor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class MainConsolaCorredores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GestionCorredores gestion = new GestionCorredores();
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        String nombre, dni, direccion, fechaAux;
        Date fechaNacimiento = null;
        int telefono;
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        while (!salir) {

            System.out.println("1. Dar de alta a un corredor");
            System.out.println("2. Dar de baja a un corredor");
            System.out.println("3. Modificar datod de un corredor");
            System.out.println("4. Mostrar corredores ordenados por fecha de nacimiento");
            System.out.println("5. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = teclado.nextInt();
            String saltoDeLinea = teclado.nextLine();

            switch (opcion) {
                case 1:
                    
                    System.out.println("Has seleccionado la opcion 1");
                    System.out.println("");

                    System.out.print("Nombre :   ");
                    nombre = teclado.nextLine();
                    System.out.println("");

                    System.out.print("Dni :   ");
                    dni = teclado.nextLine();
                    System.out.println("");

                    System.out.print("Fecha de nacimiento (dd-MM-yyyy) :   ");
                     {
                        try {
                            fechaNacimiento = sdf.parse(teclado.nextLine());
                        } catch (ParseException ex) {
                            System.out.println("Formato de fecha invalido");
                            break;
                        }
                    }
                    System.out.println("");

                    System.out.print("Direccion :   ");
                    direccion = teclado.nextLine();
                    System.out.println("");

                    System.out.print("Telefono :   ");
                    telefono = teclado.nextInt();
                    saltoDeLinea = teclado.nextLine();
                    System.out.println("");

                    Corredor corredor = new Corredor(nombre, dni, fechaNacimiento, direccion, telefono);
                    if (gestion.addCorredorr(corredor)) {
                        System.out.println("Se ha añadido al corredor correctamente");
                    }else{
                        System.out.println("No se ha podido añadir al corredor");
                    }
                    
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    System.out.println("");
                    System.out.println(gestion.toString());
                    System.out.println("");
                    System.out.println("Introduzca el dni del corredor que desea eliminar");
                    dni = teclado.nextLine();
                    if (gestion.deleteCorredor(dni)) {
                        System.out.println("Se ha borrador al corredor seleccionado");
                    } else {
                        System.out.println("No se ha podido borrar al corredor seleccionado");
                    }
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    System.out.println("");
                    gestion.modifyCorredores();
                    break;
                case 4:
                    System.out.println("Has seleccionado la opcion 4");
                    gestion.ordenarCorredoresFechaNacimiento();
                    System.out.println(gestion.toString());

                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }
        }

    }

}
