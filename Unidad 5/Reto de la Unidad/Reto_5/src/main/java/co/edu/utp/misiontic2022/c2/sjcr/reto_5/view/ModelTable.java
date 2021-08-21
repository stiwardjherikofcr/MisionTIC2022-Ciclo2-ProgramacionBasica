/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.sjcr.reto_5.view;

import javax.swing.table.DefaultTableModel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author stiwa
 */
public class ModelTable extends DefaultTableModel {

    private @Getter @Setter boolean editables[];

    public ModelTable() {
        super();
    }

    public ModelTable(String[] titles, boolean editables[]) {
        super();
        super.setColumnIdentifiers(titles);
        this.editables = editables;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return this.editables[column];
    }

    @Override
    public Class getColumnClass(int column) {
        return getRowCount() > 0 ? getValueAt(0, column).getClass() : Object.class;
    }

    public void setData(Object[][] data) {
        this.clear();
        for (Object d[] : data) {
            super.addRow(d);
        }
        this.fireTableDataChanged();
    }

    public void clear() {
        super.getDataVector().removeAllElements();
        this.fireTableDataChanged();
    }
}
