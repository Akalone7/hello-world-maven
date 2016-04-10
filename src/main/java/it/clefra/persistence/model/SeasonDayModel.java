package it.clefra.persistence.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = SeasonDayModel.COLLECTION_NAME)
public class SeasonDayModel {
	public static final String COLLECTION_NAME = "seasonDays";

	@Id
	@Field
	private ObjectId id;
	
	@Field
	private Integer seasonDay;
	
	@Field
	private List<MatchModel> matches;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getSeasonDay() {
		return seasonDay;
	}

	public void setSeasonDay(Integer seasonDay) {
		this.seasonDay = seasonDay;
	}

	public List<MatchModel> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchModel> matches) {
		this.matches = matches;
	}
}
