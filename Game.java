
public class Game {
	
	private Team homeTeam;
	private Team awayTeam;
	private int htScore;
	private int atScore;
	Player[] goalScorers;
	Player[] assisters;

	public Game(){
		homeTeam = null;
		awayTeam = null;
		htScore = 0;
		atScore = 0;
	}
	
	public Game(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.htScore = 0;
		this.atScore = 0;
	}
	
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	public void setAwayTeam(Team awayTeam){ 
		this.awayTeam = awayTeam;
	}
	public Team getHomeTeam() {
		return this.homeTeam;
	}
	public Team getAwayTeam() {
		return this.awayTeam;
	}
	
	public void set_htScore(int htScore){ 
		this.htScore = htScore;
	}
	public void set_atScore(int atScore){ 
		this.atScore = atScore;
	}
	public int gethtScore() {
		return this.htScore;
	}
	public int getatScore() {
		return this.atScore;
	}
	
	public void setGoalScorers(Player[] p){
		this.goalScorers = p;
	}
	public Player[] getGoalScorers(){
		return this.goalScorers;
	}
	public void setAssisters(Player[] p){
		this.assisters = p;
	}
	public Player[] getAssisters(){
		return this.assisters;
	}
	
	public static Player[] chooseScorers(Player[] home, Player[] away, int homeGoals, int awayGoals){
		Player[] scorers = new Player[homeGoals+awayGoals];
		for(int i = 0; i < homeGoals; i++){
			
		}
		for(int i = 0; i < awayGoals; i++){
			
		}
		return scorers;
	} 
	
	public void playGame(){
		Player[] homePl = this.homeTeam.getPlayers();
		Player[] awayPl = this.awayTeam.getPlayers();
		int homeTgoalChance = 0;
		int awayTgoalChance = 0;
		
		int goals = 0; int minutes = 0;
		for(int i = 0; i < homePl.length; i++){
			goals += Integer.parseInt(homePl[i].getGoals_scored());
			minutes += Integer.parseInt(homePl[i].getMinutes());
		}
		homeTgoalChance = goals/minutes;
		
		goals = 0; minutes = 0;
		for(int i = 0; i < awayPl.length; i++){
			goals += Integer.parseInt(awayPl[i].getGoals_scored());
			minutes += Integer.parseInt(awayPl[i].getMinutes());
		}
		awayTgoalChance = goals/minutes;
		
		int homeGoals = (int)Math.floor(Math.random()* homeTgoalChance);
		int awayGoals = (int)Math.floor(Math.random()* awayTgoalChance);
		set_htScore(homeGoals);
		set_atScore(awayGoals);
		
		Player[] scorers = new Player[homeGoals+awayGoals];
		scorers = chooseScorers(homePl, awayPl, homeGoals, awayGoals);
	}
}
