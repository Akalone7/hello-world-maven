package it.clefra.web.dto;

import it.clefra.persistence.model.PlayerModel;
import it.clefra.persistence.model.RoleType;
import it.clefra.web.dto.interfaces.Role;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerDto <T extends PlayerDto<T>> implements Role{

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

	public static List<PlayerDto> from(List<PlayerModel> playerModels) {
		List<PlayerDto> playerDtos = new ArrayList<PlayerDto>();
		if(playerModels != null){
			for(PlayerModel playerModel : playerModels) {
				PlayerDto playerDto = null;
				switch(playerModel.getRoleType()) {
				case GOALKEEPER:  
					playerDto = GoalkeeperDto.from(playerModel);  
					break;
				case DEFENDER: 
					playerDto = DefenderDto.from(playerModel);
					break;
				case MIDFIELDER:
					playerDto = MidfielderDto.from(playerModel);
					break;
				case FORWARD:
					playerDto = ForwardDto.from(playerModel);
					break;
				}	
				playerDtos.add(playerDto);
			}
		}
		return playerDtos;
	}
	//	public static <T extends PlayerDto<T>> T from(PlayerModel playerModel, Class<T> clazz) {
	//		T playerDto;
	//		try {
	//			playerDto = clazz.newInstance();
	//		} catch (InstantiationException | IllegalAccessException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		
	//		if(playerModel != null) {
	//			playerModel.setName(playerModel.getName());
	//			playerModel.setSurname(playerDto.getSurname());			
	//			if(RoleType.isAcceptable(playerDto.getRoleType())) {
	//				playerModel.setRoleType(RoleType.valueOf(playerDto.getRoleType()));
	//			}
	//		}
	//		
	//		return playerDto;
	//	}
	//	
	//	private Role createActualRole(Role role) {
	//		Role actualRole;
	//		if(role.isGoalkeeper()) {
	//			actualRole = new GoalkeeperDto();
	//		} 
	//		else if(role.isDefender()) {
	//			actualRole = new DefenderDto();
	//		}
	//		else if(role.isMidfielder()) {
	//			actualRole = new MidfielderDto();
	//		}
	//		else {
	//			actualRole = new  ForwardDto();
	//		}
	//		return actualRole;
	//	}

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
