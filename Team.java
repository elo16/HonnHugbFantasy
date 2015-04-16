public class Team {

	private String teamName;
	private int goalsFor;
	private int goalsAgainst;
	private int rank;
	private Player[] players;
	private int totalPlayers;

	public Team(){
		this.teamName = null;
		this.goalsFor = 0;
		this.goalsAgainst = 0;
		this.rank = -1;
		this.players = null;
		this.totalPlayers = 0;
	}
	
	public Team(String teamName, int goalsFor, int goalsAgainst, int rank, Player[] players) {
		this.teamName = teamName;
		this.goalsFor = goalsFor;
		this.goalsAgainst = goalsAgainst;
		this.rank = rank;
		//this.homeAdvantage = homeAdvantage;
		this.players = players;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int length(){
		return players.length;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public int getRank() {
		return rank;
	}

	public int getTotalPlayers() {
		return totalPlayers;
	}
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void setTotalPlayers(int TP){
		this.totalPlayers = TP;
	}
	
	public Player[] getPlayers(){
		return this.players;
	}
	public void addPlayer(Player newPlayer){
		Player[] oldArray = this.players;	
		Player[] newArray = new Player[this.totalPlayers + 1];
		for(int i = 0; i < this.totalPlayers; i++){
			newArray[i] = oldArray[i];
		}
		
		this.totalPlayers++;
		newArray[this.totalPlayers-1] = newPlayer;
		this.players = newArray;
	}
}
