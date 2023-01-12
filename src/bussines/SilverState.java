/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

/**
 *
 * @author Josval
 */
public class SilverState extends StateAccount{
    
    public SilverState(double balance) {
        _balance = balance;        
        _interest = 0.04f;
        _lowerLimit = 1.0f;
        _upperLimit = 1000.0f;
    }
    
    private StateAccount StateChangeCheck(){
        if (_balance < _lowerLimit)
            return new RedState(_balance);
        else if (_balance > _upperLimit)
            return new GoldState(_balance);
        return this;
    }    

    @Override
    public StateAccount Deposit(double amount) {
        _balance += amount;        
        return StateChangeCheck();        
    }

    @Override
    public StateAccount Subtraction(double amount) {
        _balance -= amount;        
        return StateChangeCheck();
    }

    @Override
    public StateAccount PayInterest() {
        _balance += _interest * _balance;        
        return StateChangeCheck();
    }

    @Override
    public StateAccount checking() {
        return StateChangeCheck();
    }

    @Override
    public String toString(){
        return "SilverState";
    }
}
