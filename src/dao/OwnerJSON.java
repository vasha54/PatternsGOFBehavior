package dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OwnerJSON {

    private final String fileName= "owner.json" 

    public OwnerJSON() {
    }

    public void getJSONArrayThisFile() throws IOException, JSONException{
		InputStream file = null;
		file = assetFiles.open(pathAsset+File.separator+filename);
		BufferedReader in = new BufferedReader(new InputStreamReader(file));
		String jsonStr="",line;

		while((line = in.readLine()) != null){
			jsonStr += line;
		}

		// JSONArray array = new JSONArray(jsonStr);

		// return array;
	}
}
