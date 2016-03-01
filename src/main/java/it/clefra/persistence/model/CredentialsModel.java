package it.clefra.persistence.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document( collection = CredentialsModel.COLLECTION_NAME )
public class CredentialsModel {
	public static final String COLLECTION_NAME = "credentials";

	@Id
	@Field
	private ObjectId id;
	
	@Field
	private String username;
	
	@Field
	private String password;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
