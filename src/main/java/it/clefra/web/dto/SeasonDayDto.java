package it.clefra.web.dto;

import it.clefra.persistence.model.SeasonDayModel;

import java.util.ArrayList;
import java.util.List;

public class SeasonDayDto {

	private Integer seasonDay;
	private List<MatchDto> matches;
	
	public static SeasonDayDto from(SeasonDayModel seasonDayModel) {
		SeasonDayDto seasonDayDto = new SeasonDayDto();
		if(seasonDayModel != null) {
			seasonDayDto.setSeasonDay(seasonDayModel.getSeasonDay());
			seasonDayDto.setMatches(MatchDto.from(seasonDayModel.getMatches()));
		}
		return seasonDayDto;
	}
	
	public static List<SeasonDayDto> from(List<SeasonDayModel> seasonDayModels) {
		List<SeasonDayDto> seasonDayDtos = new ArrayList<SeasonDayDto>();
		for(SeasonDayModel seasonDayModel : seasonDayModels) {
			seasonDayDtos.add(from(seasonDayModel));
		}
		return seasonDayDtos;
	}
	
	public Integer getSeasonDay() {
		return seasonDay;
	}
	public void setSeasonDay(Integer seasonDay) {
		this.seasonDay = seasonDay;
	}
	public List<MatchDto> getMatches() {
		return matches;
	}
	public void setMatches(List<MatchDto> matches) {
		this.matches = matches;
	}
	
}
