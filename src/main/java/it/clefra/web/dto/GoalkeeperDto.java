package it.clefra.web.dto;

import java.util.ArrayList;
import java.util.List;

import it.clefra.persistence.model.PlayerModel;

public class GoalkeeperDto extends PlayerDto<GoalkeeperDto> {

	@Override
	public boolean isGoalkeeper() {
		return true;
	}

	public static GoalkeeperDto from(PlayerModel playerModel) {
		GoalkeeperDto goalkeeperDto = new GoalkeeperDto();

		if(goalkeeperDto != null) {
			goalkeeperDto.setName(playerModel.getName());
			goalkeeperDto.setSurname(playerModel.getSurname());
			goalkeeperDto.setRoleType(playerModel.getRoleType().name());
		}

		return goalkeeperDto;
	}

}
