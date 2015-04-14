import java.io.IOException;


public class League {
	private Team[] Teams;
	private int nmbrOfTms;
	
	public League(Team[] t){
		this.Teams = t;
		this.nmbrOfTms = t.length;
	}
	
	public static void makePlayers(){
		Player[] players = new Player[695];
		for(int i = 1; i <696; i++){
			try {
				players[i-1] = JsonToObject.run("http://fantasy.premierleague.com/web/api/elements/"+i+"/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Game[] makeFixtures(League lge){
		Game[] games = null;
		return games;
	}
}
