package it.clefra.persistence.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document( collection = LineUpModel.COLLECTION_NAME)
public class LineUpModel {
 public static final String COLLECTION_NAME = "lineups";
 
 @Id
 @Field
 private ObjectId id;
 
 @Field
 private String teamName;
 
 @Field
 private List<PlayerModel> lineUp;
 
 @Field
 private List<PlayerModel> bleachers;

public ObjectId getId() {
	return id;
}

public void setId(ObjectId id) {
	this.id = id;
}

public String getTeamName() {
	return teamName;
}

public void setTeamName(String teamName) {
	this.teamName = teamName;
}

public List<PlayerModel> getLineUp() {
	return lineUp;
}

public void setLineUp(List<PlayerModel> lineUp) {
	this.lineUp = lineUp;
}

public List<PlayerModel> getBleachers() {
	return bleachers;
}

public void setBleachers(List<PlayerModel> bleachers) {
	this.bleachers = bleachers;
}
 
}
