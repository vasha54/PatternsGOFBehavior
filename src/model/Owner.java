/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Josval
 */
public class Owner {
    protected String _firstName;
    protected String _lastName;
    protected String _idNumber;

    public Owner(String firstName, String lastName, String idNumber) {
        this._firstName = firstName;
        this._lastName = lastName;
        this._idNumber = idNumber;   
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String getIdNumber() {
        return _idNumber;
    }

    public void setIdNumber(String _idNumber) {
        this._idNumber = _idNumber;
    }
    
    @Override
    public String toString (){
        return String.format("(%s) %s %s",_idNumber, _firstName, _lastName );
    }
}
