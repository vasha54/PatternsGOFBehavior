package dao;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.simple.parser.JSONParser;

public class OwnerJSON {

    private final String fileName= "owner.json" ;

    public OwnerJSON() {
    }

    public JSONArray getOwner() throws IOException, ParseException{
        JSONParser jsonParser = new JSONParser();
        
        
        FileReader reader = new FileReader(this.fileName);
        Object obj = jsonParser.parse(reader);
        JSONArray owner = (JSONArray) obj;
        return owner;
    }
}
