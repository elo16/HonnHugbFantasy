/**
 * 
 */

/**
 * @author Stulli
 *
 */
public class Points {
	int appearance;
	int goalScored;
	int goalAssist;
	int cleanSheet;
	int penaltySaved;
	int missedPenalty;
	int yellowCards;
	int redCards;
	int ownGoal;
	int inDreamTeam;
	Player player;
	
	public Points(){
	this.appearance = 0;
	this.goalScored = 0;
	this.goalAssist = 0;
	this.cleanSheet = 0;
	this.penaltySaved = 0;
	this.missedPenalty = 0;
	this.yellowCards = 0;
	this.redCards = 0;
	this.ownGoal = 0;
	this.inDreamTeam = 0;
	this.player = null;
	}
	
	public Points(Player player){
	this.appearance = 0;
	this.goalScored = 0;
	this.goalAssist = 0;
	this.cleanSheet = 0;
	this.penaltySaved = 0;
	this.missedPenalty = 0;
	this.yellowCards = 0;
	this.redCards = 0;
	this.ownGoal = 0;
	this.inDreamTeam = 0;
	this.player = player;
	}
	
	public int getPoints(){
		int sum = 0;
		sum += this.appearance;
		sum += this.goalPoints(this.goalScored, this.goalAssist, this.ownGoal, this.player);
		sum += this.goalAssist *3;
		//sum += this.cleanSheetPoints(this.cleanSheet, this.player)
		//sum += this.penaltyPoints(this.penaltySaved, this.missedPenalty, this.player)
		//sum += this.yellowsAndReds(this.yellowCards, this.redCards)
		sum += this.inDreamTeam *3;
		return sum;
	}
	
	public int goalPoints(int goalScored, int goalAssist, int ownGoal, Player player){
		int sumPoints = 0;
		sumPoints += goalAssist *3;
		sumPoints += ownGoal * -2;
		String pos = player.getPosition().toLowerCase();
		if(pos.equals("defender") || pos.equals("goalkeeper")){sumPoints += goalScored *6;}
		if(pos.equals("midfielder")){sumPoints += goalScored *5;}
		if(pos.equals("forward")){sumPoints += goalScored *4;}
		return sumPoints;
	}
}
