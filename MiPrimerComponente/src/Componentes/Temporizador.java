/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.*;
import java.io.Serializable;
import java.awt.Color;

public class Temporizador extends JButton implements ActionListener, Serializable {

    Timer timer;
    public int segundos;
    public int minutos;
    private boolean congelado = false;
    private String min = "minutos";

    public Temporizador() {
        timer = new Timer(1000, this);
        this.setText("0" + " " + "Minutos" + " " + "0" + " " + "Segundos");
        this.setEnabled(false);
        this.setForeground(Color.RED);
        this.setBackground(Color.WHITE);

    }

    public Temporizador(int minuto, int segundo) {
        timer = new Timer(1000, this);
        this.setText("0" + " " + "Minutos" + " " + "0" + " " + "Segundos");
        estMinuto(minuto);
        estSegundo(segundo);

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

    
    public void estMinuto(int min) {
        this.minutos = min;
    }

    public void estSegundo(int seg) {
        this.segundos = seg;
    }

    public void iniciar() {
        if (congelado) {

        } else {

            timer.start();
        }
    }

    public boolean estaCorriendo() {
        return timer.isRunning();
    }

    public void detenerse() {
        //Stop the animating thread. 
        timer.stop();
    }

    public void reiniciar() {
        timer.stop();
        segundos = 0;
        minutos = 0;
        this.setText("0" + " " + "Minutos" + " " + "0" + " " + "Segundos");

    }

    public int obtMinuto() {
        return this.minutos;

    }

    public int obtSegundo() {
        return this.segundos;
    }

    public void actionPerformed(ActionEvent e) {
        segundos++;

        if (segundos <= 60) {
            this.setText(minutos + " " + min + " " + "y" + " " + segundos + " " + " segundos");
        } else {
            minutos++;
            segundos = 0;
            if (minutos == 1) {
                min = "minuto";
            } else {
                min = "minutos";
            }
        }

    }

    public static void main(String arg[]) {
        Temporizador t = new Temporizador();

    }

}
