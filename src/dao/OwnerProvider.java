package dao;

import model.Owner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class OwnerProvider {

    /**
     *
     */
    private  OwnerJSON _ownerJson;

    /**
     *
     */
    private  OwnerRandom _ownerRandom;

    /**
     *
     */
    private  OwnerSingleDirectory _ownerSingleDirectory;

    /**
     *
     */
    public OwnerProvider() {
        this._ownerJson = new OwnerJSON();
        this._ownerRandom = new OwnerRandom();
        this._ownerSingleDirectory = new OwnerSingleDirectory();
    }

    /**
     *
     * @return
     * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
     */
    public List<Owner> getOwners(){
        List<Owner> owners = new ArrayList<Owner>();
        JSONArray dataJason = null;
            try {
                dataJason= this._ownerSingleDirectory.getOwners();
            }catch (NullPointerException | UnsupportedOperationException e){
                try {
                    dataJason = this._ownerJson.getOwners();
                } catch (IOException | ParseException | IllegalArgumentException ex) {
                    dataJason = this._ownerRandom.getOwners();
                }
            }finally {
                if (dataJason != null){
                    for(int i=0;i<dataJason.size();i++){
                        JSONObject ownerJSON= (JSONObject) dataJason.get(i);
                        if (ownerJSON!=null){
                            if(ownerJSON.containsKey("identidad") &&
                                    ownerJSON.containsKey("nombre") &&
                                    ownerJSON.containsKey("apellidos")){
                                Owner owner = new Owner( ownerJSON.get("nombre").toString(),
                                                         ownerJSON.get("apellidos").toString(),
                                                         ownerJSON.get("identidad").toString());
                                owners.add(owner);
                            }
                        }
                    }
                }
            }
        return owners;
    }

}