package it.clefra.web.dto;

import java.util.ArrayList;
import java.util.List;

import it.clefra.persistence.model.PlayerModel;

public class ForwardDto extends PlayerDto<ForwardDto> {

	@Override
	public boolean isForward(){
		return true;
	}
	
	public static ForwardDto from(PlayerModel playerModel) {
		ForwardDto forwardDto = new ForwardDto();
		
		if(forwardDto != null) {
			forwardDto.setName(playerModel.getName());
			forwardDto.setSurname(playerModel.getSurname());
			forwardDto.setRoleType(playerModel.getRoleType().name());
		}
		
		return forwardDto;
	}
	
}
