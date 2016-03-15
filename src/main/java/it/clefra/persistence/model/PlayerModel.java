package it.clefra.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author <a href="mailto:clelia.devietro@finconsgroup.com">Clelia De Vietro</a>
 *
 */
@Document( collection = PlayerModel.COLLECTION_NAME )
public class PlayerModel {
	public final static String COLLECTION_NAME = "players";
	
	@Id
	@Field
	private String id;

	@Field
	private String name;
	
	@Field
	private String surname;
	
	@Field
	private RoleType roleType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
}
