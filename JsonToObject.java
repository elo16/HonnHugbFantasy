import com.google.gson.*;

import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

public class JsonToObject {
	
	public static Player run(String baseurl) throws IOException {
    // Connect to the URL using java's native library
    URL url = new URL(baseurl);
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.connect();

    // Convert to a JSON object to print data
    JsonParser jp = new JsonParser(); //from gson
    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //convert the input stream to a json element
    
    Gson gson = new Gson();
    Player player = gson.fromJson(root , Player.class);
    
    //JsonObject rootobj = root.getAsJsonObject(); //may be an array, may be an object.
    //String first_name = rootobj.get("first_name").getAsString();//just grab the first_name
    return player;
}
	
	

}