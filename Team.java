public class Team {

	private String teamName;
	private int goalsFor;
	private int goalsAgainst;
	private int rank;
	private double homeAdvantage;

	public Team(String teamName, int goalsFor, int goalsAgainst, int rank,
			double homeAdvantage) {
		this.teamName = teamName;
		this.goalsFor = goalsFor;
		this.goalsAgainst = goalsAgainst;
		this.rank = rank;
		this.homeAdvantage = homeAdvantage;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public int getRank() {
		return rank;
	}

	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}

	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
