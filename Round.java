public class Round {
	private Game[] Games;

	public Round() {
		this.Games = null;
	}	
	
	public Round(Game[] games) {
		this.Games = games;
	}
	
	public void setgames(Game[] games){
		this.Games = games;
	}
	
	public Game[] getGames(){
		return this.Games;
	}
	
	public void playRound(){
		
	}

}
