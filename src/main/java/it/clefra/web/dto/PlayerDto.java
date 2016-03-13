package it.clefra.web.dto;

import it.clefra.web.dto.interfaces.Role;

public abstract class PlayerDto implements Role{
     
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
}
