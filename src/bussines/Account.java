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
public class Account {
    protected StateAccount _state;
    protected Owner _owner;
    protected String _identifier;
    
    public String getIdentifier(){
        return _identifier;
    }
    
    public String OwnerDetails(){
        return String.format("%s %s (%s)", _owner.getFirstName(), _owner.getLastName(), _owner.getIdNumber());
    }
    
    public Account(String identifier, Owner owner){
        this._identifier = identifier;
        this._owner = owner;
        this._state = new SilverState(100);
    }
    
    public void Deposit(double amount){
        _state = _state.Deposit(amount);
    }
    
    public void Subtraction(double amount){ 
        _state = _state.Subtraction(amount);
    }
    
    public void PayInterest(){
        _state = _state.PayInterest();
    }
}
