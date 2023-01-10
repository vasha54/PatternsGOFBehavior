/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

import dao.OwnerProvider;
import interfaces.IObserverOperationAccount;
import java.util.List;
import model.Owner;
import interfaces.ISubjectOpertionAccount;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Josval
 */
public class AccountsManager implements ISubjectOpertionAccount{
    protected List<Owner> _owners;
    protected List<IObserverOperationAccount> _observers;
    protected List<OperationAccount> _operations;
    protected Random _random;
    protected List<Account> _accounts;
    
    public AccountsManager(){
        _observers = new ArrayList<IObserverOperationAccount>();
        _owners = new OwnerProvider().getOwners();
        _operations = new ArrayList<OperationAccount>();
        _random = new Random();
        _accounts = new ArrayList<Account>();
    }  
    
    protected OperationsAccount getOperation(){
        switch (_random.nextInt(0, 4)) {
            default:
            case 0: return OperationsAccount.CREATE;
            case 1: return OperationsAccount.DEPOSIT;
            case 2: return OperationsAccount.SUBSTRACT;
            case 3: return OperationsAccount.PAY_INTEREST;
        }
    }
    
    protected String getIdentifier(){
        return "La madre para en EnviromentTickCount ...";
    }
    
    protected Account getAccount(){
        return _accounts.isEmpty() ? null : _accounts.get(_accounts.size() - 1);
    }
    
    protected Owner getOwner(){
        if(_owners.isEmpty())
            return null;        
        if(_owners.size() == 1)
            return _owners.get(0);        
        int index = _random.nextInt(0, _owners.size() - 1);        
        Owner owner = _owners.get(index);
        _owners.remove(index);
        return owner;
    }
    
    protected double getAmmount(){
        return _random.nextDouble(1, 1000);
    }
    
    public void SimulateOperation(){
        OperationsAccount operation = getOperation();
        Account account = getAccount();
        double amount = getAmmount();
        
        switch (operation) {
            default:
            case CREATE:  
                Owner owner = getOwner();                
                if (owner != null) {
                    account = new Account( getIdentifier(), owner);
                    _accounts.add(account);
                }
                break;
            case DEPOSIT:
                if(account != null){
                    account.Deposit(amount);
                }
                break;
            case SUBSTRACT:
                if(account != null){
                    account.Subtraction(amount);
                }
                break;
            case PAY_INTEREST:
                if(account != null){
                    account.PayInterest();
                }
                break;
        }
        if(account!=null)
            notify(new OperationAccount(amount, account.getIdentifier(), operation, account.getOwner()));
    }

    @Override
    public void attach(IObserverOperationAccount observer) {
        _observers.add(observer);
    }

    @Override
    public void detach(IObserverOperationAccount observer) {
        _observers.remove(observer);
    }

    @Override
    public void notify(OperationAccount operation) {
        for(IObserverOperationAccount observer : _observers)
            observer.update(operation);
    }
}
