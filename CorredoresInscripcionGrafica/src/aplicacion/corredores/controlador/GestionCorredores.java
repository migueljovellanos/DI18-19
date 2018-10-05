/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.controlador;

import aplicacion.corredores.modelo.Corredor;
import aplicacion.corredores.utils.Utils;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class GestionCorredores {

    //atributos
    private ArrayList<Corredor> corredores = new ArrayList<Corredor>();
   

    public GestionCorredores() {
    }

    public ArrayList<Corredor> getCorredores() {
        return corredores;
    }

    public boolean addCorredorr(Corredor corredor) {
        if (corredores.contains(corredor) == false) {
            corredores.add(corredor);
            return true;
        }
        return false;
    }

    public boolean deleteCorredor(String dni) {
        for (Corredor corredor : corredores) {
            if (corredor.getDni().equals(dni)) {
                corredores.remove(corredor);
                return true;
            }
        }
        return false;
    }

    public void modifyCorredores() {
        String varString;
        String constante = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(toString());
        System.out.println("Introduzca numero de corredor que desea modificar: ");
        varString = sc.nextLine();
        int numCorredor = Integer.parseInt(varString) - 1;
        Corredor corredor = corredores.get(numCorredor);

        varString = "";
        System.out.print("Nombre : " + corredor.getNombre() + "     ");
        System.out.print("Nuevo nombre : ");
        sc.reset();
        varString = sc.nextLine();
        if (!varString.equals(constante)) {
            corredor.setNombre(varString);
        }
        System.out.println("");

        System.out.print("Dni : " + corredor.getDni() + "     ");
        System.out.print("Nuevo dni : ");
        sc.reset();
        varString = sc.nextLine();
        if (!varString.equals(constante)) {
            if (varString.length() != 9) {
                System.out.println("El DNI tiene un formato incorrecto"
                        + "debe tener 8 digitos mas un digito de control");
            }
            corredor.setDni(varString);
        }
        System.out.println("");

        System.out.print("Direccion : " + corredor.getDireccion() + "     ");
        System.out.print("Nueva direccion : ");
        sc.reset();
        varString = sc.nextLine();
        if (!varString.equals(constante)) {
            corredor.setDireccion(varString);
        }
        System.out.println("");

        System.out.print("Telefono : " + corredor.getTelefono() + "     ");
        System.out.print("Nuevo telefono : ");
        sc.reset();
        int numaux = sc.nextInt();
        String saltoDeLinea = sc.nextLine();
        if (Integer.toString(numaux).length() != 9) {
            System.out.println("Formato de numero incorrecto");
        }
        corredor.setTelefono(numaux);
        System.out.println("");

        corredores.set(numCorredor, corredor);
    }

    public void ordenarCorredoresFechaNacimiento() {
        Collections.sort(corredores, new Comparator<Corredor>() {
            @Override
            public int compare(Corredor corredor1, Corredor corredor2) {
                return corredor1.getFechaNacimiento().compareTo(corredor2.getFechaNacimiento());
            }
        });

    }

    public void escribirCsv() {
        String outputFile = "C:\\Users\\migue\\Documents\\DI1819\\CorredoresInscripcionGrafica\\corredores.csv";
        boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File ArchivoEmpleados = new File(outputFile);
            ArchivoEmpleados.delete();
        }

        try {

            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

            csvOutput.write("Nombre");
            csvOutput.write("Dni");
            csvOutput.write("Fecha Nacimiento");
            csvOutput.write("Direccion");
            csvOutput.write("Numero Telefono");
            csvOutput.endRecord();

            for (Corredor corredor : corredores) {

                csvOutput.write(corredor.getNombre());
                csvOutput.write(corredor.getDni());
                csvOutput.write(Utils.sdf.format(corredor.getFechaNacimiento()));
                csvOutput.write(corredor.getDireccion());
                csvOutput.write(String.valueOf(corredor.getTelefono()));
                csvOutput.endRecord();
            }

            csvOutput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerCsv() {

        try {

            CsvReader corredores_import = new CsvReader("C:\\Users\\migue\\Documents\\DI1819\\CorredoresInscripcionGrafica\\corredores.csv");
            corredores_import.readHeaders();

            while (corredores_import.readRecord()) {

                String nombre = corredores_import.get(0);
                String dni = corredores_import.get(1);
                String fechaNacimiento = corredores_import.get(2);
                String direccion = corredores_import.get(3);
                int telefono = Integer.valueOf(corredores_import.get(4));

                Corredor corredorAux = new Corredor(nombre, dni, Utils.sdf.parse(fechaNacimiento), direccion,telefono);

                corredores.add(corredorAux);
            }

            corredores_import.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(GestionCorredores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        int var = 0;
        String cad = "";
        for (Corredor corredor : corredores) {
            var = var + 1;
            cad = cad + var + "      " + corredor.toString() + "\n";
        }
        return cad;
    }
}
