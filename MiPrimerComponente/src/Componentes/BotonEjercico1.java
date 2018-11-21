/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Miguel
 */
public class BotonEjercico1 extends JButton implements Serializable {

    public String rutaDondeGuardar;

    public BotonEjercico1() {
        super();
        this.rutaDondeGuardar = "C:\\Users\\Miguel\\Desktop\\registroPulsaciones.txt";
        addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registrarPulsacion();
                } catch (IOException ex) {
                    Logger.getLogger(BotonEjercico1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public String getRutaDondeGuardar() {
        return rutaDondeGuardar;
    }

    public void setRutaDondeGuardar(String rutaDondeGuardar) {
        this.rutaDondeGuardar = rutaDondeGuardar;
    }

    private void registrarPulsacion() throws IOException {
        try {
            File file = new File(getRutaDondeGuardar());
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String strDate = new Date().toString();
            bw.write(strDate + "\r \n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
