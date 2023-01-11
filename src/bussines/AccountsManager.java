/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

import dao.OwnerProvider;
import interfaces.*;
import java.util.List;
import model.Owner;
import java.util.ArrayList;
import java.util.Random;
import java.time.*;

/**
 *
 * @author Josval
 */
public class AccountsManager implements ISubjectOpertionAccount, ISubjectAccount{
    protected List<Owner> _owners;
    protected List<IObserverOperationAccount> _observersOperationAccount;
    protected List<IObserverAccount> _observersAccount;
    protected List<OperationAccount> _operations;
    protected Random _random;
    protected List<Account> _accounts;
    protected Clock _clock;
    
    public AccountsManager(){
        _observersOperationAccount = new ArrayList<IObserverOperationAccount>();
        _observersAccount = new ArrayList<IObserverAccount>();
        _owners = new OwnerProvider().getOwners();
        _operations = new ArrayList<OperationAccount>();
        _random = new Random();
        _accounts = new ArrayList<Account>();
        _clock = Clock.systemDefaultZone();
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
        String buffer = _clock.instant().toString();            
        return buffer.replace("Z", "")
                     .replace(":", "")
                     .replace(".", "")
                     .substring(buffer.length() - 15);
    }
    
    protected Account getAccount(){
        return _accounts.isEmpty() ? null  : _accounts.get(
               _accounts.size() == 1 ? 0 : _random.nextInt(0, _accounts.size() - 1)                
        );
    }
    
    protected Owner getOwner(){
        if(_owners.isEmpty())
            return null;
        int index = _owners.size() == 1 ? 0 :_random.nextInt(0, _owners.size() - 1);        
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
        double amount = 0;
        
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
                    amount = getAmmount();
                    account.Deposit(amount);
                }
                break;
            case SUBSTRACT:
                if(account != null){
                    amount = getAmmount();
                    account.Subtraction(amount);
                }
                break;
            case PAY_INTEREST:
                if(account != null){
                    account.PayInterest();
                }
                break;
        }
        if(account!=null){
            notify(new OperationAccount(amount, account.getIdentifier(), operation, account.getOwner()));
            notify(account);
        }
    }

    @Override
    public void attach(IObserverOperationAccount observer) {
        _observersOperationAccount.add(observer);
    }

    @Override
    public void detach(IObserverOperationAccount observer) {
        _observersOperationAccount.remove(observer);
    }

    @Override
    public void notify(OperationAccount operation) {
        for(IObserverOperationAccount observer : _observersOperationAccount)
            observer.update(operation);
    }

    @Override
    public void attach(IObserverAccount observer) {
        _observersAccount.add(observer);
    }

    @Override
    public void detach(IObserverAccount observer) {
        _observersAccount.remove(observer);
    }

    @Override
    public void notify(Account account) {
        for(IObserverAccount observer : _observersAccount)
            observer.Update(account);
    }
}
