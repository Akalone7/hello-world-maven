package it.clefra.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.clefra.persistence.model.SeasonDayModel;
import it.clefra.persistence.repositories.SeasonDayRepository;
import it.clefra.web.dto.SeasonDayDto;

@RestController @RequestMapping(SeasonDayController.API_ROOT_URI) 
public class SeasonDayController {

	private static final Logger LOGGER = LoggerFactory.getLogger( MasterController.class );

	public static final String API_ROOT_URI = "/seasonDays";

	private static final String TEAM_KEY = "team";

	private static final String SEASON_KEY = "limit";


	@Autowired
	private SeasonDayRepository seasonDayRepository;

	/**
	 * @param filter
	 * @param modelMap
	 * @return the last season day optionally filtered by team and limit
	 */
	 
	@RequestMapping(value = "/last", method = RequestMethod.GET)
	public ResponseEntity<List<SeasonDayDto>> getLastSeasonDay(@RequestParam Map<String, String> filter, ModelMap modelMap) {
		LOGGER.debug("Start getting last seasonDay elements");
		String team = null;
		Integer limit = null;
		List<SeasonDayDto> output = new ArrayList<>();

		if(filter != null && !filter.isEmpty()) {
			modelMap.addAllAttributes(filter);
			if(modelMap.containsKey(TEAM_KEY)) {
				team = (String)modelMap.get(TEAM_KEY);
			}
			if(modelMap.containsKey(SEASON_KEY)) {
				limit = (Integer)modelMap.get(SEASON_KEY);
			}
		}
		List<SeasonDayModel> seasonDayModels = seasonDayRepository.findLastNSeasonDaysByTeam(team, limit);
		output = SeasonDayDto.from(seasonDayModels);

		LOGGER.debug("{} season day found;", output.size());
		ResponseEntity<List<SeasonDayDto>> response = new  ResponseEntity<List<SeasonDayDto>>(output, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}
	
	/**
	 * @param filter
	 * @param modelMap
	 * @return all season day
	 */
	 
	@RequestMapping(value = "/{day}",method = RequestMethod.GET)
	public ResponseEntity<SeasonDayDto> getByDay(@PathVariable Integer day) {
		LOGGER.debug("Start getting last seasonDay elements");
		SeasonDayDto output = new SeasonDayDto();
		
		SeasonDayModel seasonDayModel = seasonDayRepository.findSeasonDaysByDay(day);
		output = SeasonDayDto.from(seasonDayModel);

		LOGGER.debug("{} season day found;", seasonDayModel.getId());
		ResponseEntity<SeasonDayDto> response = new  ResponseEntity<>(output, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}
	
	/**
	 * @param filter
	 * @param modelMap
	 * @return all season day
	 */
	 
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SeasonDayDto>> get() {
		LOGGER.debug("Start getting last seasonDay elements");
		List<SeasonDayDto> output = new ArrayList<>();
		
		List<SeasonDayModel> seasonDayModels = seasonDayRepository.findAll();
		output = SeasonDayDto.from(seasonDayModels);

		LOGGER.debug("{} season day found;", output.size());
		ResponseEntity<List<SeasonDayDto>> response = new  ResponseEntity<List<SeasonDayDto>>(output, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}


}
