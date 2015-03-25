import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonToJava {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().create();
		gson.toJson("Hello!", System.out);
		
		try(Reader reader = new InputStreamReader(JsonToJava.class.getResourceAsStream("C:\\Users\\Stulli\\Desktop\\Skóli\\Þróun Hugbúnaðar\\685.json"), "UTF-8")){
            -----
			Player p = gson.fromJson(reader, Player.class);
            System.out.println(p.toString());
        }
	}

}