package gui.modelo;

import bussines.Account;
import javax.swing.table.DefaultTableModel;
import interfaces.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
 */
public class UpdateAccountsModel extends DefaultTableModel implements IObserverAccount{

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    private static String [] heardesColums = {"Identificador","Propietario","Estado","Balance"};
    
    private Map<String, Integer> map;

    /**
     * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
     */
    public UpdateAccountsModel() {
        super( heardesColums,0);
        this.map = new HashMap<String,Integer>();
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public void Update(Account account) {
        Object [] tuple = {account.getIdentifier(), account.getOwner(), account.getState().toString().toUpperCase(), String.format("$ %.2f", account.getBalance()) };
        
        if(!this.map.containsKey(account.getIdentifier()))
        {
            this.insertRow(0,tuple);
            this.map.put(account.getIdentifier(), this.getRowCount());
        }
        else
        {
            Integer row = this.getRowCount() - this.map.get(account.getIdentifier());
            for(Integer col = 0; col < tuple.length; col++)
                this.setValueAt(tuple[col], row, col);
        }
        
        this.fireTableDataChanged();
    }
}
