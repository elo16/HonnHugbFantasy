/**
 * 
 */

/**
 * @author Stulli
 *
 */
public class mockPlayer {
	private String playerName;
	private int injuryStatus;
	private String position;
	private Stats stats;

	public mockPlayer(){
	this.playerName = "Olivier Giroud";
	this.injuryStatus = 0;
	this.position = "Striker";
	this.stats = new Stats(0, 1, 2, 3, 4, 5, 6, 7, 8);
	
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	public String getPosition(){
		return position;
	}
	
	public void setInjuryStatus(int injuryStatus){
		this.injuryStatus = injuryStatus;
	}
	public int getInjuryStatus(){
		return injuryStatus;
	}

	public void setStats(Stats stats){
		this.stats = stats;
	}
	public Stats getStats(){
		return this.stats;
	}
}

