package gui.modelo;

import javax.swing.table.DefaultTableModel;

/**
 * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
 */
public class UpdateAccountsModel extends DefaultTableModel {

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private static String [] heardesColums = {"Identificador","Propietario","Estado","Balance"};

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public UpdateAccountsModel() {
        super( heardesColums,0);
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
