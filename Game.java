
public class Game {
	
	private Team homeTeam;
	private Team awayTeam;
	private int htScore;
	private int atScore;
	Player[] goalScorers;
	Player[] assisters;
	private Stats[] HomeStats;
	private Stats[] AwayStats;

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

	public void playGame(){

		//Player[] homePl = this.homeTeam.getPlayers();
		//Player[] awayPl = this.awayTeam.getPlayers();
		
		//Player[] homeInTeam = Simulation.choosePlayers(this.homeTeam.getPlayers());
		//Player[] awayInTeam = Simulation.choosePlayers(this.awayTeam.getPlayers());
		
		//this.HomeStats = new Stats[homeInTeam.length];
		//this.AwayStats = new Stats[awayInTeam.length];
		
		Simulation gameSim = new Simulation(this.homeTeam.getPlayers(), this.awayTeam.getPlayers());
		
		this.HomeStats = gameSim.getHomeStats();
		this.AwayStats = gameSim.getAwayStats();
		
		int homeGoals = 0;
		int awayGoals = 0;
		
		for(int i = 0; i < HomeStats.length; i ++){
			homeGoals += HomeStats[i].getGoals();
		}
		for(int i = 0; i < AwayStats.length; i ++){
			awayGoals += AwayStats[i].getGoals();
		}
		if(homeGoals == 0){
			for(int i = 0; i < AwayStats.length; i ++){
				AwayStats[i].setCleanSheets(1);
			}
		}
		if(awayGoals == 0){
			for(int i = 0; i < HomeStats.length; i ++){
				HomeStats[i].setCleanSheets(1);
			}
		}
		
		set_htScore(homeGoals);
		set_atScore(awayGoals);
		
		System.out.println(this.homeTeam.getTeamName());
		System.out.println(homeGoals);
		System.out.println(this.awayTeam.getTeamName());
		System.out.println(awayGoals);
		System.out.println(" ");
	}
}
