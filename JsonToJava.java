import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonToJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().create();
		gson.toJson("Hello!", System.out);
	}

}
