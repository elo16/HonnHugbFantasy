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
	
	public static Team[] makeTeams(){
		Team[] teams = new Team[10];
		for(int i = 0; i < teams.length; i++){
			teams[i] = new Team();
			switch(i){
			case 0: teams[i].setTeamName("Arsenal");
				break;
			case 1: teams[i].setTeamName("Arsenal");
				break;
			case 2: teams[i].setTeamName("Arsenal");
				break;
			case 3: teams[i].setTeamName("Arsenal");
				break;
			case 4: teams[i].setTeamName("Arsenal");
				break;
			case 5: teams[i].setTeamName("Arsenal");
				break;
			case 6: teams[i].setTeamName("Arsenal");
				break;
			case 7: teams[i].setTeamName("Arsenal");
				break;
			case 8: teams[i].setTeamName("Arsenal");
				break;
			case 9: teams[i].setTeamName("Arsenal");
				break;
			}	
		}
		
		
		return teams;
	}
	
	public static Game[] makeFixtures(League lge){
		Game[] games = null;
		return games;
	}
}
