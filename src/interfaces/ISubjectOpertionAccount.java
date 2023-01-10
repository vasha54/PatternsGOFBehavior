/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Ioidnterface.java to edit this template
 */
package interfaces;

import bussines.OperationAccount;

/**
 *
 * @author Josval
 */
public interface ISubjectOpertionAccount {
    void attach(IObserverOperationAccount observer);
    void detach(IObserverOperationAccount observer);
    void notify(OperationAccount operation);
}
