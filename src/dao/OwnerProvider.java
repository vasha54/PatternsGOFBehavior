package dao;

import model.Owner;

public class OwnerProvider {

    private  OwnerJSON _ownerJson;
    private  OwnerRandom _ownerRandom;
    private  OwnerSingleDirectory _ownerSingleDirectory;


    public OwnerProvider() {
        this._ownerJson = new OwnerJSON();
        this._ownerRandom = new OwnerRandom();
        this._ownerSingleDirectory = new OwnerSingleDirectory();
    }


}