package it.clefra.web.dto;

import it.clefra.persistence.model.LineUpModel;

import java.util.List;

public class LineUpDto {

	private String teamName;
	private List<PlayerDto> lineUp;
	private  List<PlayerDto> bleachers;

	public static LineUpDto from(LineUpModel lineUpModel) {
		LineUpDto lineUpDto = new LineUpDto();
		lineUpDto.setTeamName(lineUpModel.getTeamName());
		lineUpDto.setBleachers(PlayerDto.from(lineUpModel.getBleachers()));
		lineUpDto.setLineUp(PlayerDto.from(lineUpModel.getLineUp()));
		return lineUpDto;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<PlayerDto> getLineUp() {
		return lineUp;
	}
	public void setLineUp(List<PlayerDto> lineUp) {
		this.lineUp = lineUp;
	}
	public List<PlayerDto> getBleachers() {
		return bleachers;
	}
	public void setBleachers(List<PlayerDto> bleachers) {
		this.bleachers = bleachers;
	}
}
