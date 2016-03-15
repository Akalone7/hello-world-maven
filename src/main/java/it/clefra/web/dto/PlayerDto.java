package it.clefra.web.dto;

import it.clefra.persistence.model.PlayerModel;
import it.clefra.persistence.model.RoleType;
import it.clefra.web.dto.interfaces.Role;

public abstract class PlayerDto implements Role{

	private String name;

	private String surname;

	private String roleType;

	public static PlayerModel toPlayerModel(PlayerDto playerDto) {
		PlayerModel playerModel = new PlayerModel();
		
		if(playerDto != null) {
			playerModel.setName(playerDto.getName());
			playerModel.setSurname(playerDto.getSurname());			
			if(RoleType.isAcceptable(playerDto.getRoleType())) {
				playerModel.setRoleType(RoleType.valueOf(playerDto.getRoleType()));
			}
		}
		
		return playerModel;
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

	public boolean isGoalkeeper() {
		return false;
	}

	public boolean isDefender() {
		return false;
	}

	public boolean isMidfielder() {
		return false;
	}

	public boolean isForward(){
		return false;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
}
