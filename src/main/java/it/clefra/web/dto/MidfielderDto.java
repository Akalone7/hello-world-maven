package it.clefra.web.dto;

import java.util.ArrayList;
import java.util.List;

import it.clefra.persistence.model.PlayerModel;

public class MidfielderDto extends PlayerDto<MidfielderDto> {

	@Override
	public boolean isMidfielder() {
		return true;
	}
	
	public static MidfielderDto from(PlayerModel playerModel) {
		MidfielderDto midfielderDto = new MidfielderDto();
		
		if(midfielderDto != null) {
			midfielderDto.setName(playerModel.getName());
			midfielderDto.setSurname(playerModel.getSurname());
			midfielderDto.setRoleType(playerModel.getRoleType().name());
		}
		
		return midfielderDto;
	}
}
