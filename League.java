import java.io.IOException;


public class League {
	public Team[] Teams;
	public Game[] Fixtures;
	
	public League(){
		this.Teams = null;
		this.Fixtures = null;
	}
	
	public void setTeams(Team[] teams){
		this.Teams = teams;
	}
	
	public Team[] getTeams(){
		return this.Teams;
	}
	
	public void setFixtures(Game[] Fix){
		this.Fixtures = Fix;
	}
	
	public Game[] getFixture(){
		return this.Fixtures;
	}
	public static Player[] makePlayers(){
		Player[] players = new Player[695];
		for(int i = 1; i <696; i++){
			try {
				players[i-1] = JsonToObject.run("http://fantasy.premierleague.com/web/api/elements/"+i+"/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return players;
	}
	
	public static Team[] makeTeams(Player[] players){
		Team[] teams = new Team[10];
		//Create the teams and name them
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
		// Sorts the players into the teams
		for(int i = 0; i < teams.length; i++){
			String teamName = teams[i].getTeamName();
			for(int j = 0; j < 695; j++){
				if(teamName.equals(players[j].getTeam_name())){
					teams[i].addPlayer(players[j]);
				}
			}
		}
		return teams;
	}
	
	public static Game[] makeFixtures(Team[] teams){
		Game[] games = new Game[90];
		int gameCount = 0;
		for(int i = 0; i < 9; i++){
			for(int j = i + 1;j < 10; j++){
				games[gameCount] = new Game();
				games[gameCount].setHomeTeam(teams[i]);
				games[gameCount].setAwayTeam(teams[j]);
				
				games[gameCount+45] = new Game();
				games[gameCount+45].setHomeTeam(teams[j]);
				games[gameCount+45].setAwayTeam(teams[i]);
				
				gameCount += 2;
			}
		}
		shaker(games);
		return games;
	}
	
	public static void shaker(Game[]games){
		int n = 2000;
		while(n>=1){
			int a = (int) Math.floor(Math.random()*45);
			int b = (int) Math.floor(Math.random()*45);
			
			Game t = new Game();
			t = games[a];
			games[a] = games[b];
			games[b] = t;
			
			a = (int) Math.floor(Math.random()*45 +45);
			b = (int) Math.floor(Math.random()*45 +45);
			
			t = games[a];
			games[a] = games[b];
			games[b] = t;
			
		}
	}

	public static void main(String[] args){
		League leag = new League();
		Team[] teams = makeTeams(makePlayers());
		leag.setTeams(teams);
		Game[] Fix = makeFixtures(teams);
		leag.setFixtures(Fix);
		
	}
}

