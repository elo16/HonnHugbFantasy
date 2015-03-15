
public class Game {
	
	private Team homeTeam;
	private Team awayTeam;
	private int htScore;
	private int atScore;

	public Game(){
		homeTeam = null;
		awayTeam = null;
		htScore = -1;
		atScore = -1;
	}
	
	public Game(Team homeTeam, Team awayTeam, int htScore, int atScore) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.htScore = htScore;
		this.atScore = atScore;
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
	
	public void sethtScore(int htScore){ 
		this.htScore = htScore;
	}
	public void setatScore(int atScore){ 
		this.atScore = atScore;
	}
	public int gethtScore() {
		return this.htScore;
	}
	public int getatScore() {
		return this.atScore;
	}
}
