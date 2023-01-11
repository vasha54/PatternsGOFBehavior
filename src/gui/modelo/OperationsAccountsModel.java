package gui.modelo;

import bussines.OperationAccount;
import interfaces.IObserverOperationAccount;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
 */
public class OperationsAccountsModel extends  DefaultTableModel implements IObserverOperationAccount {

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private static String [] heardesColums = {"No.","Identificador","Propietario","Operación","Monto"};

    private List<Color> rowColours;
    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public OperationsAccountsModel() {
        super( heardesColums,0);
        rowColours =new ArrayList<Color>();
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     *
     * @param subject
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    @Override
    public void update(OperationAccount subject) {
        Object [] tuple = {this.getRowCount()+1,subject.getIdentifier(),subject.getOwner(),subject.getOperation(),String.format("$ %.2f",subject.getAmount())};
        Color background = Color.WHITE;

        switch (subject.getOperation()){
            case SUBSTRACT:
                background=Color.RED;
                break;
            case DEPOSIT:
                background=Color.GREEN;
                break;
            case PAY_INTEREST:
                background=new Color(0,127,0);
                break;
        }

        this.rowColours.add(background);
        this.insertRow(0,tuple);
        this.fireTableDataChanged();
    }

    /**
     *
     * @param row
     * @return
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public Color getRowColour(int row) {
        return rowColours.get(this.getRowCount()-(row+1));
    }

}
