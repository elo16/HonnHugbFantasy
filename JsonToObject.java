import com.google.gson.*;

import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

public class JsonToObject {
	
	public static void main(String[] args) throws IOException {

    // Connect to the URL using java's native library
    URL url = new URL("http://fantasy.premierleague.com/web/api/elements/1/");
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.connect();

    // Convert to a JSON object to print data
    JsonParser jp = new JsonParser(); //from gson
    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //convert the input stream to a json element
    
    Gson gson = new Gson();
    Player player = gson.fromJson(root , Player.class);
    
    //JsonObject rootobj = root.getAsJsonObject(); //may be an array, may be an object.
    //String first_name = rootobj.get("first_name").getAsString();//just grab the first_name
    System.out.println(player.season_history[2][1]);
	}
	
	public class Player {
		
		private String first_name;
		private String second_name;
		private String team_name;
		private String [][] season_history;
		private String minutes;
		private String goals_scored;
		private String assists;
		private String clean_sheets;
		private String goals_conceded;
		private String own_goals;
		private String penalties_saved;
		private String penalties_missed;
		private String yellow_cards;
		private String red_cards;
		private String saves;
		
		
	}

}