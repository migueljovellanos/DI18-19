/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.controlador;

import aplicacion.corredores.controlador.GestionCorredores;
import aplicacion.corredores.modelo.Corredor;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author migue
 */
public class MainCorredores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        GestionCorredores gestion = new GestionCorredores();
        Corredor corredor1 = new Corredor("miguel", "1085416T", sdf.parse("10-09-1997"), "avv ajabo aa", 633198895);
        Corredor corredor2 = new Corredor("daniel", "1156451S", sdf.parse("26-04-2004"), "avv ajabo aa", 619101025);
        Corredor corredor3 = new Corredor("susana", "6889479X", sdf.parse("10-06-2014"), "avv ajabo aa", 985154591);

        System.out.println(gestion.toString());
        //metodos añadir
        boolean addCorredor1 = gestion.addCorredorr(corredor1);
        boolean addCorredor1Repetido = gestion.addCorredorr(corredor1);
        boolean addCorredor2 = gestion.addCorredorr(corredor2);
        boolean addCorredor3 = gestion.addCorredorr(corredor3);

        System.out.println(gestion.toString());

        /*metodos borrar
        boolean removeCorredor1=gestion.deleteCorredor(corredor1.getDni());
        System.out.println(gestion.toString());
        boolean removeCorredor1Repetido=gestion.deleteCorredor(corredor1.getDni());
        System.out.println(gestion.toString());
        boolean removeCorredor2=gestion.deleteCorredor(corredor2.getDni());
        System.out.println(gestion.toString());
        boolean removeCorredor3=gestion.deleteCorredor(corredor3.getDni());
         */

        //metodo modificar
        gestion.modifyCorredores();

        System.out.println(gestion.toString());

    }

}
