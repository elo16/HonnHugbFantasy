
public class Simulation {
	Player[] homeT;
	Player[] awayT;
	Stats[] homeStats;
	Stats[] awayStats;
	Double[][] homeOdds;
	Double[][] awayOdds;
	
	public Simulation(){
		this.homeT = null;
		this.awayT = null;
		this.homeStats = null;
		this.awayStats = null;
		this.homeOdds = null;
		this.awayOdds = null;
	}
	
	public Simulation(Player[] h, Player[] a){

		this.homeT = choosePlayers(h);
		this.awayT = choosePlayers(a);
		this.homeStats = new Stats[this.homeT.length];
		this.awayStats = new Stats[this.awayT.length];
		this.homeOdds = new Double[homeT.length][7];
		this.awayOdds = new Double[awayT.length][7];

	}
	
	public Stats[] getHomeStats(){
		return this.homeStats;
	}
	public Stats[] getAwayStats(){
		return this.awayStats;
	}
	
	public void setHomeOdds(Double[][] o){
		this.homeOdds = o;
	}
	
	public void setAwayOdds(Double[][] o){
		this.awayOdds = o;
	}
	
	public Double[][] getHomeOdds(){
		return this.homeOdds;
	}
	public Double[][] getAwayOdds(){
		return this.awayOdds;
	}
	
	public void runSim(){
		/*
		Player[] homeInTeam = choosePlayers(this.homeT);
		Player[] awayInTeam = choosePlayers(this.awayT);
		Stats[] HomeStats = new Stats[homeInTeam.length];
		Stats[] AwayStats = new Stats[awayInTeam.length];
		*/
		
		generateTeamOdds();
		generateTeamStats();
		this.homeStats = new Stats[this.homeT.length];
		this.awayStats = new Stats[this.awayT.length];
		generateTeamStats();
		
		int homeGoals = 0;
		int awayGoals = 0;
		
		for(int i = 0; i < this.homeStats.length; i ++){
			homeGoals += this.homeStats[i].getGoals();
		}
		for(int i = 0; i < this.awayStats.length; i ++){
			awayGoals += this.awayStats[i].getGoals();
		}
		if(homeGoals == 0){
			for(int i = 0; i < this.awayStats.length; i ++){
				this.awayStats[i].setCleanSheets(1);
			}
		}
		if(homeGoals == 0){
			for(int i = 0; i < this.homeStats.length; i ++){
				this.homeStats[i].setCleanSheets(1);
			}
		}
		if(awayGoals == 0){
			for(int i = 0; i < awayStats.length; i ++){
				awayStats[i].setCleanSheets(1);
			}
		}
	}
	public void generateTeamOdds(){
		Double[][] home = new Double[this.homeT.length][7];
		Double[][] away = new Double[this.awayT.length][7];
		for(int i = 0; i <this.homeT.length; i++){
			Double[] odds = generateOdds(this.homeT[i]);
			for(int j = 0; j < 7; j++){
				home[i][j] = odds[j];
				}
			}
		for(int i = 0; i <this.awayT.length; i++){
			Double[] odds = generateOdds(this.awayT[i]);
			for(int j = 0; j < 7; j++){
				away[i][j] = odds[j];
				}
			}
		}
	
	public static Double[] generateOdds(Player player){
		String[][] history = player.getSeason_history(); 
		Double[] odds = new Double[7];
			//String stringPosition = player.getType_name();
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
		
		odds[0] = oddsscoring;
		odds[1] = oddsassisting;
		odds[2] = oddscleansheet;
		odds[3] = oddsowngoals;
		odds[4] = oddsyellowcards;
		odds[5] = oddsredcards;
		odds[6] = position;
			
		return odds;
	}
	
	public static Player chooseAssister(Player player, Player[] team){
		Player choise = new Player();
		if(Math.random() <= 1.7){
			double[] assistOdds = new double[team.length];
			for(int i = 0; i < team.length; i++){
				if(!player.getFirst_name().equals(team[i].getFirst_name())){
					Double tempOdds[] = generateOdds(team[i]);
					assistOdds[i] = tempOdds[1];
				}else{assistOdds[i] = -1;}
			}
			double tryAssist = 1.0;
			while(tryAssist > 0){
				for(int i = 0; i < assistOdds.length;i++){
					if(assistOdds[i] > tryAssist && assistOdds[i] > 0){
						if(Math.random() <= 0.25){
							choise = team[i];
						}
					}
				}
				if(tryAssist - 0.05 <= 0){tryAssist = 0.95;}
				else{tryAssist = tryAssist - 0.05;}
			}
		}else {return choise;}
		return choise;
	}

	public void generateTeamStats(){
		for(int i = 0; i < this.homeT.length; i ++){
			this.homeStats[i] = generatePlayerStats(this.homeT[i], this.homeT);
		}
		for(int i = 0; i < this.awayT.length; i ++){
			this.awayStats[i] = generatePlayerStats(this.awayT[i], this.awayT);
		}
	}

	public static Stats generatePlayerStats(Player player, Player[] team){
			
			Double[] playerOdds = generateOdds(player);
			int playerGoals = 0;
			Player assister;
			if(playerOdds[0] >= Math.random()){
				playerGoals += 1; 
				assister = chooseAssister(player, team);
				for(int j = 2; j < 7; j++){
					if((playerOdds[0]/j) >= Math.random()){
						playerGoals += 1 ;
						assister = chooseAssister(player, team);
					}else break;
				}
				System.out.println("Goal:" + " " + player.getFirst_name() + " " + player.getSecond_name() + " " + playerGoals);
				if(assister.getFirst_name() != null){System.out.println("Assister: " + assister.getFirst_name());}
			}
			
			/*
			int playerASSists = 0;
			if(playerOdds[1] >= Math.random()){
				playerASSists += 1;
				for(int j = 0; j < 4; j++){
					if((playerOdds[0]*0.25) >= Math.random()) playerASSists += 1;
					else break;
				}
			}
			*/
			
			int playerOwnGoals = 0;
			if(playerOdds[3] >= Math.random()) playerOwnGoals = 1;	
			int playerYellowCards = 0;										
			if(playerOdds[4] >= Math.random()) playerYellowCards = 1;
			int playerRedCards = 0;
			if(playerOdds[5] >= Math.random()){ playerRedCards = 1; playerYellowCards = 0;}
			//h�r vantar a� reikna saves, penaltySaves, penaltyMisses me� svipu�um a�fer�um 
			
			Stats playerStats = new Stats(playerGoals, 0, playerOwnGoals, playerYellowCards,
			playerRedCards, 0, 0, 0, 0, 0, 0, 0, player);
			
		return playerStats;
	}

	public static Player[] choosePlayers(Player[] allPlayers) {
		Player[] willPlay = new Player[11];
		int[] apMinutes = new int[allPlayers.length];
		
		for(int i = 0; i < apMinutes.length; i++){
			String temp = allPlayers[i].getMinutes();
			apMinutes[i] = Integer.parseInt(temp); }
		
		int defCounter = 0;
		int midCounter = 0;
		int forCounter = 0;
		int[] lowestFourMin = new int[4];
		int[] lowestFourMinMid = new int[4];
		int[] lowestFourMinFor = new int[2];
		
		for(int i = 0; i < allPlayers.length; i++){
			String pos = allPlayers[i].getType_name();

			if(pos.equals("Goalkeeper")){
				int goalieMinutes = 0;
				if(apMinutes[i] > goalieMinutes){
					willPlay[0] = allPlayers[i];
					goalieMinutes = Integer.parseInt(willPlay[0].getMinutes());
				}
			}
			else if(pos.equals("Defender")){
				int wichWP = 1;
				if(defCounter < 4){
					lowestFourMin[defCounter] = i;
				}
				else{ 
				int lowestMinutes = Integer.parseInt(allPlayers[lowestFourMin[0]].getMinutes());
				while(wichWP < 4){
					int defendersMinutes = Integer.parseInt(allPlayers[lowestFourMin[wichWP]].getMinutes());
					if(defendersMinutes < lowestMinutes){
						break;
					}
					wichWP++;
				}
				if(wichWP == 4){ wichWP = 1; }
				int lowestDefMinutes = Integer.parseInt(allPlayers[lowestFourMin[wichWP]].getMinutes());
				if(lowestDefMinutes < apMinutes[i])
					lowestFourMin[wichWP] = i;
				}
				defCounter++;
			}
			else if(pos.equals("Midfielder")){
				int wichWP = 1;
				if(midCounter < 4){
					lowestFourMinMid[midCounter] = i;
				}
				else{ 
				int lowestMinutes = Integer.parseInt(allPlayers[lowestFourMinMid[0]].getMinutes());
				while(wichWP < 4){
					int defendersMinutes = Integer.parseInt(allPlayers[lowestFourMinMid[wichWP]].getMinutes());
					if(defendersMinutes < lowestMinutes){
						break;
					}
					wichWP++;
				}
				if(wichWP == 4){ wichWP = 1; }
				int lowestDefMinutes = Integer.parseInt(allPlayers[lowestFourMinMid[wichWP]].getMinutes());
				if(lowestDefMinutes < apMinutes[i])
					lowestFourMinMid[wichWP] = i;
				}
				midCounter++;
			}
		
			else if(pos.equals("Forward")){

				if(forCounter < 2){
					lowestFourMinFor[forCounter] = i;
				}
				else{ 
				int firstMinutes = Integer.parseInt(allPlayers[lowestFourMinMid[0]].getMinutes());
				int secondMinutes = Integer.parseInt(allPlayers[lowestFourMinMid[1]].getMinutes());
				
				if(firstMinutes < secondMinutes && firstMinutes < apMinutes[i]){
					lowestFourMinMid[0] = i;
				}

				}
				forCounter++;
			}
		}
		for(int k = 0; k < 4; k++){
			willPlay[k+1] = allPlayers[lowestFourMin[k]];
			willPlay[k+5] = allPlayers[lowestFourMinMid[k]];
		}
		willPlay[9] = allPlayers[lowestFourMinFor[0]];
		willPlay[10] = allPlayers[lowestFourMinFor[1]];
		
		return willPlay;
	}
}