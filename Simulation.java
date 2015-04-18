
public class Simulation {

	public static Double[] generateOdds(Player player){
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
			//deilt með 90 til að reikna líkur á hverjum leik en ekki hverri mínútu
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
	
	public static Stats generatePlayerStats(Player player){
			
			Double[] playerOdds = generateOdds(player);
			int playerGoals = 0;
			if(playerOdds[0] >= Math.random()){
				playerGoals += 1;
				for(int j = 2; j < 7; j++){
					if((playerOdds[0]/j) >= Math.random()) playerGoals += 1;
					else break;
				}
				System.out.println(player.getFirst_name() + " " + player.getSecond_name() + " " + playerGoals);
				//chooseAssister(Player[] players); <---- Vantar eitthvað svona og hann á ekki að geta lagt upp á sjálfan sig
				//  || en þangað til má þetta vera svona 
				//  VV
				// ---------
			}
			int playerASSists = 0;
			if(playerOdds[1] >= Math.random()){
				playerASSists += 1;
				for(int j = 0; j < 4; j++){
					if((playerOdds[0]*0.25) >= Math.random()) playerASSists += 1;
					else break;
				}
			}
				// ---------
			int playerOwnGoals = 0;
			if(playerOdds[3] >= Math.random()) playerOwnGoals = 1;	
			int playerYellowCards = 0;										
			if(playerOdds[4] >= Math.random()) playerYellowCards = 1;
			int playerRedCards = 0;
			if(playerOdds[5] >= Math.random()){ playerRedCards = 1; playerYellowCards = 0;}
			//hér vantar að reikna saves, penaltySaves, penaltyMisses með svipuðum aðferðum 
			
			Stats playerStats = new Stats(playerGoals, playerASSists, playerOwnGoals, playerYellowCards,
			playerRedCards, 0, 0, 0, 0, 0, 0, 0, player);
			
		return playerStats;
	}
	
/* VINNUSVÆÐI
	private static Player[] choosePlayers(Player[] allPlayers) {
		Player[] willPlay = new Player[11];
		Player goalie = new Player();
		for(int i = 0; i < allPlayers.length; i++){
			String pos = allPlayers[i].getType_name();
			if(pos.equals("Goalkeaper")){
				String minutes = allPlayers[i].getMinutes();
					Double minutes = Parse.
					if(minutes > goalie.getMinutes())
			}
		}
			
		return willPlay;
	} */
}