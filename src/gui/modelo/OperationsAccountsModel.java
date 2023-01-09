package gui.modelo;

import javax.swing.table.DefaultTableModel;

/**
 * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
 */
public class OperationsAccountsModel extends  DefaultTableModel {

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private static String [] heardesColums = {"Identificador","Propietario","Operación","Cantidad"};

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public OperationsAccountsModel() {
        super( heardesColums,0);
        //this.fireTableDataChanged();
    }
}
