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
import util.ReadFileFromResources;

/**
 * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
 */
public class OwnerJSON {

    private final String fileName= "resource/data/owner1.json" ;

    public OwnerJSON() {
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws ParseException
     * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
     */
    public JSONArray getOwners() throws IOException, ParseException{
        JSONParser jsonParser = new JSONParser();

        ReadFileFromResources reader =new ReadFileFromResources();
        InputStream inputStream= reader.getFileAsIOStream(this.fileName);

        InputStreamReader file = new InputStreamReader(inputStream);
        Object obj = jsonParser.parse(file);
        JSONArray owner = (JSONArray) obj;
        return owner;
    }
}
