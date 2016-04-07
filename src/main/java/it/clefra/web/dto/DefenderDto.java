package it.clefra.web.dto;

public class DefenderDto extends PlayerDto {
	
	@Override
	public boolean isDefender() {
		return true;
	}
}
