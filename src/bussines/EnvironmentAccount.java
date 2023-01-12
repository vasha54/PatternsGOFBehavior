/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

/**
 *
 * @author Josval
 */
public class EnvironmentAccount {
    
    private static class LoadEnvironmentAccount{
        static final EnvironmentAccount INSTANCE = new EnvironmentAccount();
    }
    
    private EnvironmentAccount(){}
    
    public static EnvironmentAccount getInstance(){
        return LoadEnvironmentAccount.INSTANCE;
    }
    
    private CreatorStateAccountConfig creatorStateAccountConfig;
    
    public void setCreatorStateAccountConfig(CreatorStateAccountConfig creatorStateAccountConfig){
        this.creatorStateAccountConfig = creatorStateAccountConfig;
    }
    
    public CreatorStateAccountConfig getCreatorAccountConfig(){
        return this.creatorStateAccountConfig;
    }
}
