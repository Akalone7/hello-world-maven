package it.clefra.web.dto;

import java.util.ArrayList;
import java.util.List;

import it.clefra.persistence.model.PlayerModel;

public class DefenderDto extends PlayerDto<DefenderDto> {

	@Override
	public boolean isDefender() {
		return true;
	}

	public static DefenderDto from(PlayerModel playerModel) {
		DefenderDto defenderDto = new DefenderDto();

		if(defenderDto != null) {
			defenderDto.setName(playerModel.getName());
			defenderDto.setSurname(playerModel.getSurname());
			defenderDto.setRoleType(playerModel.getRoleType().name());
		}

		return defenderDto;
	}


}
