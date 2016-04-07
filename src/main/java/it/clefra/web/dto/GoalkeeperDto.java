package it.clefra.web.dto;

public class GoalkeeperDto extends PlayerDto {

	@Override
	public boolean isGoalkeeper() {
		return true;
	}
}
