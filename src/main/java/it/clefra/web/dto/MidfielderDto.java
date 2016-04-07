package it.clefra.web.dto;

public class MidfielderDto extends PlayerDto {

	@Override
	public boolean isMidfielder() {
		return true;
	}
}
