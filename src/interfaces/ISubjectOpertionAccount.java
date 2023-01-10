/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Ioidnterface.java to edit this template
 */
package interfaces;

/**
 *
 * @author Josval
 */
public interface ISubjectOpertionAccount {
    void Attach(IObserverOperationAccount observer);
    void Detach(IObserverOperationAccount observer);
    void Notify();
}
