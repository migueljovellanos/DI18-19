/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Miguel
 */
public class TemporizadorPrueba extends JLabel implements Serializable {

    public int segundos;
    private List<CuentaAtrasFinalizada> listaListeners = new ArrayList();

    public TemporizadorPrueba() {
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void addCuentaAtrasFinalizadaListener(CuentaAtrasFinalizada listener) {
        listaListeners.add(listener);
    }

    public void start(CuentaAtrasFinalizada listener) {
        setText(String.valueOf(getSegundos()));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (getSegundos() >= 0) {
                    setText(String.valueOf(getSegundos()));
                    setSegundos(segundos - 1);
                } else {
                    setText("Se ha acabado la cuenta atras");
                    timer.cancel();
                    for (CuentaAtrasFinalizada listener : listaListeners) {
                        listener.ejecutar();
                    }

                }
            }
        }, 0, 1000);
    }
}
