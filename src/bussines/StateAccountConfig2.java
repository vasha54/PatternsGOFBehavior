/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

/**
 *
 * @author Josval
 */
public class StateAccountConfig2 extends CreatorStateAccountConfig{

    @Override
    public StateAccount getInitialState() {
        return new SilverState(100);
    }
    
}
