package it.clefra.web.dto;

import it.clefra.persistence.model.UserModel;

import java.util.List;

public class UserDetailDto {

	private String username;
	private String name;
	private String surname;
	private String age;
	private String email;
	private String credits;
	private List<PlayerDto> team;
	
	public static UserDetailDto from(UserModel userModel) {
		UserDetailDto userDetailDto = new UserDetailDto();
		
		if(userModel != null) {
			userDetailDto.setName(userModel.getName());
			userDetailDto.setSurname(userModel.getSurname());
			userDetailDto.setAge(userModel.getAge());
			userDetailDto.setEmail(userModel.getEmail());
			userDetailDto.setCredits(userModel.getCredits());
			userDetailDto.setUsername(userModel.getUsername());

		}
		
		return userDetailDto;
	}
	
	public static UserModel toUserModel(UserDetailDto userDetailDto) {
		UserModel userModel = new UserModel();
		
		if(userDetailDto != null) {
			userModel.setName(userDetailDto.getName());
			userModel.setSurname(userDetailDto.getSurname());
			userModel.setAge(userDetailDto.getAge());
			userModel.setEmail(userDetailDto.getEmail());
			userModel.setCredits(userDetailDto.getCredits());
			userModel.setUsername(userDetailDto.getUsername());

		}
		
		return userModel;
	}

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

	public List<PlayerDto> getTeam() {
		return team;
	}

	public void setTeam(List<PlayerDto> team) {
		this.team = team;
	}
	
}

