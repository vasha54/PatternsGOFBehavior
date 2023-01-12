/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

/**
 *
 * @author Josval
 */
public class InitialState extends StateAccount{

    @Override
    public StateAccount Deposit(double amount) {
        _balance += amount;
        return new SilverState(_balance);
    }

    @Override
    public StateAccount Subtraction(double amount) {
        _balance -= amount;
        return new SilverState(_balance);
    }

    @Override
    public StateAccount PayInterest() {
        return new SilverState(_balance);
    }

    @Override
    public StateAccount checking() {
        return this;
    }
    
    @Override
    public String toString(){
        return "InitialState";
    }
}
