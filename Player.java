public class Player {
	private String playerName;
	private int injuryStatus;
	private String position;
	private Stats stats;

	public Player (String playerName, String position, int injuryStatus, Stats stats){
		this.playerName = playerName;
		this.position = position;
		this.stats = stats;
		this.injuryStatus = injuryStatus;
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
		return stats;
	}
}
