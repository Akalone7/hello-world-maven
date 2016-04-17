package it.clefra.web.dto;
			
import it.clefra.persistence.model.MatchModel;
import it.clefra.persistence.model.SeasonDayModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatchDto {
	
	private LineUpDto home;	
	private Integer homeGoals;
	private LineUpDto away;
	private Integer awayGoals;
	private LocalDate matchDate;
	
	public static MatchDto from(MatchModel matchModel) {
		MatchDto matchDto = new MatchDto();
		if(matchModel != null) {
			matchDto.setAway(LineUpDto.from(matchModel.getAway()));
			matchDto.setAwayGoals(matchModel.getAwayGoals());
			matchDto.setHome(LineUpDto.from(matchModel.getHome()));
			matchDto.setHomeGoals(matchModel.getHomeGoals());
			matchDto.setMatchDate(matchModel.getMatchDate());
		}
		return matchDto;
	}
	
	public static List<MatchDto> from(List<MatchModel> matchModels) {
		List<MatchDto> matchDtos = new ArrayList<MatchDto>();
		for(MatchModel matchModel : matchModels) {
		   matchDtos.add(MatchDto.from(matchModel));
		}
		return matchDtos;
	}
	
	public LineUpDto getHome() {
		return home;
	}
	public void setHome(LineUpDto home) {
		this.home = home;
	}
	public Integer getHomeGoals() {
		return homeGoals;
	}
	public void setHomeGoals(Integer homeGoals) {
		this.homeGoals = homeGoals;
	}
	public LineUpDto getAway() {
		return away;
	}
	public void setAway(LineUpDto away) {
		this.away = away;
	}
	public Integer getAwayGoals() {
		return awayGoals;
	}
	public void setAwayGoals(Integer awayGoals) {
		this.awayGoals = awayGoals;
	}
	public LocalDate getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}
	
}
