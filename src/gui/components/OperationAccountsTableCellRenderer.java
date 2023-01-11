package gui.components;

import gui.modelo.OperationsAccountsModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class OperationAccountsTableCellRenderer extends DefaultTableCellRenderer {

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public OperationAccountsTableCellRenderer() {
        super();
    }

    /**
     *
     * @param table  the <code>JTable</code>
     * @param value  the value to assign to the cell at
     *                  <code>[row, column]</code>
     * @param isSelected true if cell is selected
     * @param hasFocus true if cell has focus
     * @param row  the row of the cell to render
     * @param column the column of the cell to render
     * @return
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        OperationsAccountsModel model = (OperationsAccountsModel) table.getModel();
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(model.getRowColour(row));
        return c;
    }
}
