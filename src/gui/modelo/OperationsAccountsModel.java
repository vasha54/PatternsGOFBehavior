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
    private static String [] heardesColums = {"Identificador","Propietario","Operación","Cantidad"};

    private int rows;


    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public OperationsAccountsModel() {
        super( heardesColums,0);
    }

   /* @Override
    public Object getValueAt(int row,int column){
        Object data = "";
        if (0<= row && row <getRowCount() && 0<= column && column < getColumnCount()){
            switch (column){
                case 0: //columna del identificador
                    break;
                case 1: //columna del Propietario
                    break;
                case 2: //columna de la Operación
                    break;
                case 3: //columna de la cantidad
                    break;
            }
        }
        else throw new ArrayIndexOutOfBoundsException();
        return data;
    }*/



    @Override
    public void update(OperationAccount subject) {
        Object [] tuple = {subject.getIdentifier(),subject.getOwner(),subject.getOperation(),subject.getAmount()};
        this.insertRow(0,tuple);
        this.fireTableDataChanged();
    }
}
