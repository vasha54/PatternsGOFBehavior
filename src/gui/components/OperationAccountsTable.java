package gui.components;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
 */
public class OperationAccountsTable extends JTable {

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public OperationAccountsTable() {
        super();
    }

    /**
     *
     * @param renderer  the <code>TableCellRenderer</code> to prepare
     * @param row       the row of the cell to render, where 0 is the first row
     * @param col    the column of the cell to render,
     *                  where 0 is the first column
     * @return
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row,
                                     int col) {
        Component comp = super.prepareRenderer(renderer, row, col);

        int align = JLabel.LEFT;

        switch (col){
            case 0,1:
                align=JLabel.CENTER;
                break;
            case 4:
                align =JLabel.RIGHT;
                break;
        }

        ((JLabel) comp).setHorizontalAlignment(align);
        return comp;
    }
}
