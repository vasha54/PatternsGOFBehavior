/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

/**
 *
 * @author Josval
 */
public class GoldState extends StateAccount{    
    public GoldState(double balance) {
        _balance = balance;
        
        _interest = 0.07f;
        _lowerLimit = 10000.0f;
        _upperLimit = 1000000.0f;
    }
    
    private StateAccount StateChangeCheck(){
        if(_balance < 0.0f)
            return new RedState(_balance);
        else if(_balance <= _lowerLimit)
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
        _balance -= amount;
        
        return StateChangeCheck();
    }

    @Override
    public StateAccount PayInterest() {
        _balance += _interest * _balance;
        
        return StateChangeCheck();
    }    
}
