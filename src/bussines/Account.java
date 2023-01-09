/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

import interfaces.IObserverAccount;
import interfaces.ISubjectAccount;

import java.util.ArrayList;
import java.util.List;

import model.Owner;

/**
 *
 * @author Josval
 */
public class Account implements ISubjectAccount{
    protected StateAccount _state;
    protected Owner _owner;
    protected String _identifier;
    protected List<IObserverAccount> _observersAccount;
    
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
        this._observersAccount = new ArrayList<IObserverAccount>();
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

    @Override
    public void Attach(IObserverAccount observer) {
        _observersAccount.add(observer);
    }

    @Override
    public void Detach(IObserverAccount observer) {
        _observersAccount.remove(observer);
    }

    @Override
    public void Notify() {
        for(IObserverAccount observer : _observersAccount)
            observer.Update(this);
    }
}
