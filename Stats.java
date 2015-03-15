
public class Stats {

	private int yCards;
	private int rCards;
	private int goals;
	private int ownGoals;
	private int cleanSheets;
	private int penaltySaves;
	private int dreamTeam;
	private int appearances;
	private int assists;

	public Stats(){
		yCards = 0; 
		rCards = 0;
		goals = 0;
		ownGoals = 0;
		assists = 0;
		cleanSheets = 0;
		penaltySaves = 0;
		dreamTeam = 0;
		appearances = 0;
	}
	public Stats (int yCards, int rCards, int goals,int ownGoals, int assists, int cleanSheets, int penaltySaves, int dreamTeam,int appearances){
		yCards = yCards; 
		rCards = rCards;
		goals = goals;
		ownGoals = ownGoals;
		assists = assists;
		cleanSheets = cleanSheets;
		penaltySaves = penaltySaves;
		dreamTeam = dreamTeam;
		appearances = appearances;
	}
	
	public void setyCards (int yCards ){
		this. yCards = yCards ;
	}
	public int getyCards(){
		return yCards ;
	}
	public void setrCards (int rCards ){
		this. rCards = rCards ;
	}
	public int getrCards(){
		return rCards ;
	}
	public void setGoals (int goals ){
		this. goals = goals ;
	}
	public int getGoals(){
		return goals ;
	}
	public void setOwnGoals (int ownGoals ){
		this. ownGoals = ownGoals ;
	}
	public int getOwnGoals(){
		return ownGoals ;
	}
	public void setAssists (int assists ){
		this. assists = assists ;
	}
	public int getAssists(){
		return assists ;
	}
	public void setCleanSheets (int cleanSheets ){
		this. cleanSheets = cleanSheets ;
	}
	public int getCleanSheets(){
		return cleanSheets ;
	}
	public void setPenaltySaves (int penaltySaves ){
		this. penaltySaves = penaltySaves ;
	}
	public int getPenaltySaves(){
		return penaltySaves ;
	}
	public void setDreamTeam (int dreamTeam ){
		this. dreamTeam = dreamTeam ;
	}
	public int getDreamTeam(){
		return dreamTeam ;
	}
	public void setAppearances (int appearances ){
		this. appearances = appearances ;
	}
	public int getAppearances(){
		return appearances ;
	}
}
