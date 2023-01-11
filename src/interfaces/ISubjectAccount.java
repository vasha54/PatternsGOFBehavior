/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bussines.Account;

/**
 *
 * @author Josval
 */
public interface ISubjectAccount {
    void attach(IObserverAccount observer);
    void detach(IObserverAccount observer);
    void notify(Account account);
}
