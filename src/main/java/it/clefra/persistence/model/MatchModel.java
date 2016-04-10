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
	private String home;	
	
	@Field
	private Integer homeGoals;
	
	@Field
	private String away;
	
	@Field
	private String awayGoals;
	
	@Field
	private LocalDate matchDate;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
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
