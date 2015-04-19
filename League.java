import java.io.IOException;


public class League {
	public Team[] Teams;
	public Game[] Fixtures;
	public Round[] Rounds;
	public int playedGamesCount;
	public int playedRoundsCount;
	
	public League(){
		this.Teams = null;
		this.Fixtures = null;
		this.Rounds = null;
		this.playedGamesCount = 0;
		this.playedRoundsCount = 0;
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
	
	public void setRounds(Round[] rounds){
		this.Rounds = rounds;
	}
	
	public Game[] getFixtures(){
		return this.Fixtures;
	}
	
	public Round[] getRounds(){
		return this.Rounds;
	}
	
	public void setPlayedGamesCount(int N){
		this.playedGamesCount = N;
	}
	
	public int getPlayedGamesCount(){
		return this.playedGamesCount;
	}
	
	public void setPlayedRoundsCount(int N){
		this.playedGamesCount = N;
	}
	
	public int getPlayedRoundsCount(){
		return this.playedGamesCount;
	}
	
	public static Player[] makePlayers(){
		Player[] players = new Player[695];
		for(int i = 1; i <696; i++){
			try {
				players[i-1] = JsonToObject.run("http://fantasy.premierleague.com/web/api/elements/"+i+"/");
				players[i-1].setTotal_Points("0");
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
			case 1: teams[i].setTeamName("Chelsea");
				break;
			case 2: teams[i].setTeamName("Liverpool");
				break;
			case 3: teams[i].setTeamName("Man Utd");
				break;
			case 4: teams[i].setTeamName("Man City");
				break;
			case 5: teams[i].setTeamName("Newcastle");
				break;
			case 6: teams[i].setTeamName("Southampton");
				break;
			case 7: teams[i].setTeamName("Swansea");
				break;
			case 8: teams[i].setTeamName("Spurs");
				break;
			case 9: teams[i].setTeamName("West Ham");
				break;
			}	
		}
		// Sorts the players into the teams
		for(int i = 0; i < teams.length; i++){
			String teamName = teams[i].getTeamName();
			for(int j = 0; j < players.length; j++){
				if(teamName.equals(players[j].getTeam_name())){
					teams[i].addPlayer(players[j]);
				}
			}
		}
		return teams;
	}
	
	public static Round[] makeRounds(Team[] teams){
		Round[] rounds = new Round[9];
		
		for(int i = 0; i < rounds.length; i++){
			rounds[i] = new Round();
			Game[] games = new Game[5];
			for(int j = 0; j < games.length; j++){
				games[j] = new Game();
			}
			games[0].setHomeTeam(teams[0]);
			games[0].setAwayTeam(teams[5]);
			games[1].setHomeTeam(teams[1]);
			games[1].setAwayTeam(teams[6]);
			games[2].setHomeTeam(teams[2]);
			games[2].setAwayTeam(teams[7]);
			games[3].setHomeTeam(teams[3]);
			games[3].setAwayTeam(teams[8]);
			games[4].setHomeTeam(teams[4]);
			games[4].setAwayTeam(teams[9]);
			rounds[i].setGames(games);
			
			//1=5=6=7=8=9=4=3=2=1
			//5=6=7=8=9=4=3=2=1
			Team temp = teams[1];
			teams[1] = teams[5];
			teams[5] = teams[6];
			teams[6] = teams[7];
			teams[7] = teams[8];
			teams[8] = teams[9];
			teams[9] = teams[4];
			teams[4] = teams[3];
			teams[3] = teams[2];
			teams[2] = temp;
			
			}		
		
		return rounds;
	}
	
	
	public static League makeLeag(){
		League leag = new League();
		Player[] allPlayers = makePlayers();
		Team[] teams = makeTeams(allPlayers);
		leag.setTeams(teams);
		Round[] allRounds = makeRounds(teams);
		leag.setRounds(allRounds);
		return leag;
	}
	
	public static void playRound(League leag){
		int t = leag.getPlayedRoundsCount();
		Round[] rounds = leag.getRounds();
		rounds[t].playRound();
		leag.setPlayedRoundsCount(t+1);
	}
	
	public static void main(String[] args){
		
		League mainLeague = makeLeag();
		playRound(mainLeague);
		
		System.out.println("fukkin virkar maður!!");
		
		
	}
}
