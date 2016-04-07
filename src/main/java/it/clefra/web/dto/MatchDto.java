package it.clefra.web.dto;
			
import java.time.LocalDate;

public class MatchDto {
	
	private String home;	
	private Integer homeGoals;
	private String away;
	private String awayGoals;
	private LocalDate matchDate;
	
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public Integer getHomeGoals() {
		return homeGoals;
	}
	public void setHomeGoals(Integer homeGoals) {
		this.homeGoals = homeGoals;
	}
	public String getAway() {
		return away;
	}
	public void setAway(String away) {
		this.away = away;
	}
	public String getAwayGoals() {
		return awayGoals;
	}
	public void setAwayGoals(String awayGoals) {
		this.awayGoals = awayGoals;
	}
	public LocalDate getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}
	
}
