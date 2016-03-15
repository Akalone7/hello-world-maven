package it.clefra.persistence.model;

public enum RoleType {
	GOALKEEPER,
	DEFENDER,
	MIDFIELDER,
	FORWARD;

	public static boolean isAcceptable(String roletype) { 
		boolean res = true;
		
		try { 
			RoleType.valueOf(roletype);
		} catch (Exception e) {
			res = false;
		} 
		
		return res;
	}
}
