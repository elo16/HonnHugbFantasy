public class Round {
	private Game[] Games;

	public Round() {
		this.Games = null;
	}	
	
	public Round(Game[] games) {
		this.Games = games;
	}
	
	public void setGames(Game[] games){
		this.Games = games;
	}
	
	public Game[] getGames(){
		return this.Games;
	}
	
	public void playRound(){
		Game[] g = this.getGames();
		for(int i = 0; i < g.length; i++){
			g[i].playGame();
		}
		this.setGames(g);
	}

}
