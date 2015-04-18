
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
	/*
	public static Player[] chooseScorers(Player[] home, Player[] away, int homeGoals, int awayGoals){
		Player[] scorers = new Player[homeGoals+awayGoals];
		for(int i = 0; i < homeGoals; i++){
			
		}
		for(int i = 0; i < awayGoals; i++){
			
		}
		return scorers;
	} 
	*/
	public Double[] generateOdds(Player player){
		String[][] history = player.getSeason_history(); 
		Double[] odds = new Double[7];
		if(history != null){
			String stringPosition = player.getType_name();
			double goals = 0;
			double minutes = 0;
			double assists = 0;
			double cleansheet = 0;
			double owngoals = 0;
			double yellowcards = 0;
			double redcards = 0;
			double position = 0;
			for(int i = 0; i < history.length; i++){
				minutes += Double.parseDouble(history[i][1]);
				goals += Double.parseDouble(history[i][2]);
				assists += Double.parseDouble(history[i][3]);
				cleansheet += Double.parseDouble(history[i][4]);
				owngoals += Double.parseDouble(history[i][6]);
				yellowcards += Double.parseDouble(history[i][9]);
				redcards += Double.parseDouble(history[i][9]);
			}
			//deilt me� 90 til a� reikna l�kur � hverjum leik en ekki hverri m�n�tu
			double oddsscoring = goals/(minutes/90); 
			double oddsassisting = assists/(minutes/90);
			double oddscleansheet = cleansheet/(minutes/90);
			double oddsowngoals = owngoals/(minutes/90);
			double oddsyellowcards = yellowcards/(minutes/90);
			double oddsredcards = redcards/(minutes/90);
			
			if(stringPosition == "Defender"){
				position = 1;
			} else if(stringPosition == "Midfielder"){
				position = 2;
			} else if(stringPosition == "Forward"){
				position = 3;
			} else {
				position = 0;
			}
			
			odds[0] = oddsscoring;
			odds[1] = oddsassisting;
			odds[2] = oddscleansheet;
			odds[3] = oddsowngoals;
			odds[4] = oddsyellowcards;
			odds[5] = oddsredcards;
			odds[6] = position;
		}

		return odds;
	}
	
	public int generatePlayerStats(Player[] players){
		
		int teamGoals = 0;	
		
		for(int i = 0; i < players.length; i++){															   
			Double[] playerOdds = generateOdds(players[i]);
			int playerGoals = 0;
			if(playerOdds[0] >= Math.random()) playerGoals = 1;
			int playerASSists = 0;										//H�r �yrfti eiginlega frekar eitthva� eins og chooseASSister(Player[] players, i);
			if(playerOdds[1] >= Math.random()) playerASSists = 1;		//													i svo a� ekki s� h�gt a� leggja upp� sj�lfan sig :S
			int playerOwnGoals = 0;
			if(playerOdds[3] >= Math.random()) playerOwnGoals = 1;
			int playerYellowCards = 0;
			if(playerOdds[4] >= Math.random()) playerYellowCards = 1;
			int playerRedCards = 0;
			if(playerOdds[5] >= Math.random()) playerRedCards = 1;
	
			/*veit ekki alveg hvert �g er a� fara me� �etta :S En e-h svona: Hvert li� skilar arrayi af st�tsum allra leikmanna
						||
						VV
			Stats gameStats = new Stats(playerGoals, playerASSists, playerOwnGoals, playerYellowCards, playerRedCards, 0, 0, 0, 0, 0, 0, players[i] ); */
			
			teamGoals += playerGoals;
		}
		return teamGoals;
	}
	
	public void playGame(){
		/*
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
		*/
		
		Player[] homePl = this.homeTeam.getPlayers();
		Player[] awayPl = this.awayTeam.getPlayers();
		
		int homeGoals = generatePlayerStats(homePl);
		int awayGoals = generatePlayerStats(awayPl);
		
		set_htScore(homeGoals);
		set_atScore(awayGoals);
		
		System.out.println(this.homeTeam.getTeamName());
		System.out.println(homeGoals);
		System.out.println(this.awayTeam.getTeamName());
		System.out.println(awayGoals);
		System.out.println(" ");
		
		//Player[] scorers = new Player[homeGoals+awayGoals];
		//scorers = chooseScorers(homePl, awayPl, homeGoals, awayGoals);
	}
}
