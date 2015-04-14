/**
 * 
 */

/**
 * @author Stulli
 *
 */
public class Player {
	
	private String first_name;
	private String second_name;
	private String team_name;
	private String [][] season_history;
	private String minutes;
	private String goals_scored;
	private String assists;
	private String clean_sheets;
	private String goals_conceded;
	private String own_goals;
	private String penalties_saved;
	private String penalties_missed;
	private String yellow_cards;
	private String red_cards;
	private String saves;		
	
	public Player(){
		this.first_name = null;
		this.second_name = null;
		this.team_name = null;
		this.season_history = null;
		this.minutes = null;
		this.goals_scored = null;
		this.assists = null;
		this.clean_sheets = null;
		this.goals_conceded = null;
		this.own_goals = null;
		this.penalties_saved = null;
		this.penalties_missed = null;
		this.yellow_cards = null;
		this.red_cards = null;
		this.saves = null;
	}
	
	public Player(String first_name, String second_name, String team_name, 
			String[][] season_history,String minutes, String goals_scored,
			String assists, String clean_sheets,String goals_conceded, 
			String own_goals, String penalties_saved,String penalties_missed,
			String yellow_cards, String red_cards, String saves)
	{
		this.first_name = first_name;
		this.second_name = second_name;
		this.team_name = team_name;
		this.season_history = season_history;
		this.minutes = minutes;
		this.goals_scored = goals_scored;
		this.assists = assists;
		this.clean_sheets = clean_sheets;
		this.goals_conceded = goals_conceded;
		this.own_goals = own_goals;
		this.penalties_saved = penalties_saved;
		this.penalties_missed = penalties_missed;
		this.yellow_cards = yellow_cards;
		this.red_cards = red_cards;
		this.saves = saves;
	}
	
	public void setFirst_name(String first_name){ this.first_name = first_name; }
	public void setSecond_name(String second_name){ this.second_name = second_name; }
	public void setTeam_name(String team_name){ this.team_name = team_name; }
	public void setSeason_history(String[][] season_history){ this.season_history = season_history; }
	public void setMinutes(String minutes){ this.minutes = minutes; }
	public void setGoals_scored(String goals_scored){ this.goals_scored = goals_scored; }
	public void setAssists(String assists){ this.assists = assists; }
	public void setClean_sheets(String clean_sheets){ this.clean_sheets = clean_sheets; }
	public void setGoals_conceded(String goals_conceded){ this.goals_conceded = goals_conceded; }
	public void setOwn_goals(String own_goals){ this.own_goals = own_goals; }
	public void setPenalties_saved(String penalties_saved){ this.penalties_saved = penalties_saved; }
	public void setPenalties_missed(String penalties_missed){ this.penalties_missed = penalties_missed; }
	public void setYellow_cards(String yellow_cards){ this.yellow_cards = yellow_cards; }
	public void setRed_card(String red_cards){ this.red_cards = red_cards; }
	public void setSaves(String saves){ this.saves = saves; }
	
	public String getFirst_name(){ return this.first_name; }
	public String getSecond_name(){ return this.second_name; }
	public String getTeam_name(){ return this.team_name; }
	public String[][] getSeason_history(){ return this.season_history; }
	public String getMinutes(){ return this.minutes; }
	public String getGoals_scored(){ return this.goals_scored; }
	public String getAssists(){ return this.assists; }
	public String getClean_sheets(){ return this.clean_sheets; }
	public String getGoals_conceded(){ return this.goals_conceded; }
	public String getOwn_goals(){ return this.own_goals; }
	public String getPenalties_saved(){ return this.penalties_saved; }
	public String getPenalties_missed(){ return this.penalties_missed; }
	public String getYellow_cards(){ return this.yellow_cards; }
	public String getRed_cards(){ return this.red_cards; }
	public String getSaves(){ return this.saves; }
}

