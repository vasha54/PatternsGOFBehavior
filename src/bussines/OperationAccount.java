/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

import model.Owner;

/**
 *
 * @author Josval
 */
public class OperationAccount {
    double _amount;
    String _identifier;
    OperationsAccount _operation;
    Owner _owner;

    public OperationAccount(double _amount, String _identifier, OperationsAccount _operation, Owner _owner) {
        this._amount = _amount;
        this._identifier = _identifier;
        this._operation = _operation;
        this._owner = _owner;
    }

    public double getAmount() {
        return _amount;
    }

    public String getIdentifier() {
        return _identifier;
    }

    public OperationsAccount getOperation() {
        return _operation;
    }

    public Owner getOwner() {
        return _owner;
    }
}
