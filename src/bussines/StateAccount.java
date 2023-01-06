/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

/**
 *
 * @author Josval
 */
public abstract class StateAccount {
    protected double _balance;
    protected double _interest;
    protected double _lowerLimit;
    protected double _upperLimit;

    public double getBalance() {
        return _balance;
    }
    
    public abstract StateAccount Deposit(double amount);
    public abstract StateAccount Subtraction(double amount);
    public abstract StateAccount PayInterest();
}
