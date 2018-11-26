/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.corredores.vista.tableModels;

import aplicacion.corredores.modelo.Carrera;
import static aplicacion.corredores.utils.Utils.sdf;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author migue
 */
public class TableModelCarreras extends AbstractTableModel {

    private final List<Carrera> listaCarreras;
    private final String[] columnas = {"Finalizada", "Nombre", "Fecha", "Lugar", "Max. participantes"};

    public TableModelCarreras(ArrayList<Carrera> carreras) {
        this.listaCarreras = carreras;
    }

    @Override
    public int getRowCount() {
        return listaCarreras.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                if (listaCarreras.get(rowIndex).isFinalizada()) {
                    return "SI";
                } else {
                    return "NO";
                }
            case 1:
                return listaCarreras.get(rowIndex).getNombre();
            case 2:
                return sdf.format(listaCarreras.get(rowIndex).getFecha());
            case 3:
                return listaCarreras.get(rowIndex).getLugar();
            case 4:
                return listaCarreras.get(rowIndex).getMaxCorredores();
        }
        return null;
    }

}
