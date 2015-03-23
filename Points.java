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
		//sum += this.goalPoints();
		sum += this.goalAssist *3;
		//sum += this.cleanSheetPoints()
		//sum += this.penaltyPoints
		//sum += this.yellowsAndReds()
		sum += this.inDreamTeam *3;
		return sum;
	}
	
	
}
