package it.clefra.web.dto;

import it.clefra.persistence.model.CredentialsModel;

public class CredentialsDto {

	private String username;
	private String password;

	public static CredentialsModel toCredentialsModel(CredentialsDto credentialDto)  {
		CredentialsModel credentialModel = new CredentialsModel();
		if(credentialDto != null) {
			credentialModel.setUsername(credentialDto.getUsername());
			credentialModel.setPassword(credentialDto.getPassword());
		}
		return credentialModel;
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
