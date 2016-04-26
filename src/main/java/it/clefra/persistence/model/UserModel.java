package it.clefra.persistence.model;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author <a href="mailto:clelia.devietro@finconsgroup.com">Clelia De Vietro</a>
 *
 */
@Document( collection = UserModel.COLLECTION_NAME )
public class UserModel implements Serializable{
	private static final long serialVersionUID = 2033888930756342761L;

	public static final String COLLECTION_NAME = "users";
	
	@Field
	@Id
	private ObjectId id;
	
	@Field
	private String username;
	
	@Field
	private String name;
	
	@Field
	private String surname;
	
	@Field
	private String age;
	
	@Field
	private String email;

	@Field
	private String credits;

	@Field
	private List<PlayerModel> team;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public List<PlayerModel> getTeam() {
		return team;
	}
	public void setTeam(List<PlayerModel> team) {
		this.team = team;
	}
}
