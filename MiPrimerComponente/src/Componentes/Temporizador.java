/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import javax.swing.JButton;
import java.io.Serializable;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import javax.swing.ImageIcon;

public class Temporizador extends JButton implements Serializable {

    public int segundos;
    public int minutos;
    public String texto;
    public Color colorFinalizar;
    public File imagen;
    private int tiempoTotalEnsegundos;
    private int tiempoTotalEnMilisegundos;
    private List<CuentaAtrasFinalizada> listaListeners = new ArrayList();
    java.util.Timer timer = new java.util.Timer();

    public Temporizador() {
        this.setText("Pulse para iniciar la cuenta atras");
        this.setForeground(Color.RED);
        this.setBackground(Color.WHITE);

    }

    private void calcularTiempoTotal() {
        if (getMinutos() > 0) {
            tiempoTotalEnsegundos = (getMinutos() * 60) + getSegundos();
        } else {
            tiempoTotalEnsegundos = getSegundos();
        }
    }

    public void iniciar() {
        setText(String.valueOf(getSegundos()));
        calcularTiempoTotal();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (tiempoTotalEnsegundos > 0) {
                    tiempoTotalEnsegundos--;
                    updateText();
                } else {
                    setBackground(colorFinalizar);
                    setText(texto);
                    ImageIcon icono = new ImageIcon(getImagen().getName());
                    setIcon(icono);
                    setImagen(imagen);
                    timer.cancel();
                    for (CuentaAtrasFinalizada listener : listaListeners) {
                        listener.ejecutar(new Date());
                    }
                }
            }

        }, 0, 1000);

    }

    private void updateText() {
        if (tiempoTotalEnsegundos > 60) {
            int min = (int) tiempoTotalEnsegundos / 60;
            int seg = (int) tiempoTotalEnsegundos % 60;
            if (min == 1) {
                this.setText(min + " minuto" + " " + "y" + " " + seg + " " + " segundos");
            } else {
                this.setText(min + " minutos" + " " + "y" + " " + seg + " " + " segundos");
            }

        } else {
            this.setText(tiempoTotalEnsegundos + " " + " segundos");
        }

    }

    public Color getColorFinalizar() {
        return colorFinalizar;
    }

    public void setColorFinalizar(Color colorFinalizar) {
        this.colorFinalizar = colorFinalizar;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    public void addCuentaAtrasFinalizadaListener(CuentaAtrasFinalizada listener) {
        listaListeners.add(listener);
    }

}
