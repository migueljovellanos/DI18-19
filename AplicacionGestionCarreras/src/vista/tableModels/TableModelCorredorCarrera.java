/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.CorredorParaCarrera;
import static utils.Utils.SDF;

/**
 * @author Miguel
 */
public class TableModelCorredorCarrera extends AbstractTableModel {

    private final List<CorredorParaCarrera> listaCorredores;
    private final String[] columnas = {"Dorsal", "Nombre", "DNI", "Tiempo"};

    public TableModelCorredorCarrera(List<CorredorParaCarrera> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    @Override
    public int getRowCount() {
        return listaCorredores.size();
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
                return listaCorredores.get(rowIndex).getDorsal();
            case 1:
                return listaCorredores.get(rowIndex).getNombre();
            case 2:
                return listaCorredores.get(rowIndex).getDni();
            case 3:
                return SDF.format(listaCorredores.get(rowIndex).getFechaNacimiento());
        }
        return null;
    }

}
