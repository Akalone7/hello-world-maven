package it.clefra.persistence.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author <a href="mailto:clelia.devietro@finconsgroup.com">Clelia De Vietro</a>
 *
 */
@Document(collection = MatchModel.COLLECTION_NAME)
public class MatchModel {
	public static final String COLLECTION_NAME = "matches";
    
	@Id
	@Field
	private ObjectId id;
	
	@Field
	private LineUpModel home;	
	
	@Field
	private Integer homeGoals;
	
	@Field
	private LineUpModel away;
	
	@Field
	private Integer awayGoals;
	
	@Field
	private LocalDate matchDate;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public LineUpModel getHome() {
		return home;
	}
	public void setHome(LineUpModel home) {
		this.home = home;
	}
	public Integer getHomeGoals() {
		return homeGoals;
	}
	public void setHomeGoals(Integer homeGoals) {
		this.homeGoals = homeGoals;
	}
	public LineUpModel getAway() {
		return away;
	}
	public void setAway(LineUpModel away) {
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
