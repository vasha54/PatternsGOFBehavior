/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

/**
 *
 * @author Josval
 */
public class RedState extends StateAccount{
    protected double _serviceFee;
    
    public RedState(double balance) {
        _balance = balance;
        
        _interest = 0.0f;
        _lowerLimit = Double.MIN_VALUE;
        _upperLimit = 0.0f;
        _serviceFee = 15.0f;
    }
    
    private StateAccount StateChangeCheck(){
        if (_balance > _upperLimit)
            return new SilverState(_balance);

        return this;
    }    

    @Override
    public StateAccount Deposit(double amount) {
        _balance += amount;
        
        return StateChangeCheck();        
    }

    @Override
    public StateAccount Subtraction(double amount) {
        if(_balance - amount > _lowerLimit)
            _balance -= amount + _serviceFee;        
        
        return this;
    }

    @Override
    public StateAccount PayInterest() {
        return this;
    }

    @Override
    public StateAccount checking() {
        return StateChangeCheck();
    }

    @Override
    public String toString(){
        return "RedState";
    }
}
