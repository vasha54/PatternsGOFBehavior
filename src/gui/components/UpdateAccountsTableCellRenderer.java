package gui.components;

import gui.modelo.OperationsAccountsModel;
import gui.modelo.UpdateAccountsModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 *
 */
public class UpdateAccountsTableCellRenderer extends DefaultTableCellRenderer {
    public UpdateAccountsTableCellRenderer() {
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
        UpdateAccountsModel model = (UpdateAccountsModel) table.getModel();
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column==2) {
            Color a = Color.WHITE;
            switch (value.toString()){
                case "SILVERSTATE":
                    a=Color.LIGHT_GRAY;
                    break;
                case "REDSTATE":
                    a=Color.PINK;
                    break;
                case "GOLDSTATE":
                    a=Color.ORANGE;
                    break;
            }
            c.setBackground(a);
        }else
            c.setBackground(Color.WHITE);
        return c;
    }
}
