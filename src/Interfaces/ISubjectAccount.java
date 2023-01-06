/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Ioidnterface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Josval
 */
public interface ISubjectAccount {
    void Attach(IObserverAccount observer);
    void Detach(IObserverAccount observer);
    void Notify();
}
