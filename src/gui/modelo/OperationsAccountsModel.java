package gui.modelo;

import bussines.OperationAccount;
import interfaces.IObserverOperationAccount;

import javax.swing.table.DefaultTableModel;

/**
 * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
 */
public class OperationsAccountsModel extends  DefaultTableModel implements IObserverOperationAccount {

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private static String [] heardesColums = {"No.","Identificador","Propietario","Operación","Monto"};
    

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public OperationsAccountsModel() {
        super( heardesColums,0);
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public void update(OperationAccount subject) {
        Object [] tuple = {this.getRowCount()+1,subject.getIdentifier(),subject.getOwner(),subject.getOperation(),String.format("$ %.2f",subject.getAmount())};
        this.insertRow(0,tuple);
        this.fireTableDataChanged();
    }
}
