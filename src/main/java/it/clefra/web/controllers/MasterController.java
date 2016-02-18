/**
 * 
 */
package it.clefra.web.controllers;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.clefra.persistence.model.DummyModel;
import it.clefra.persistence.repositories.DummyRepository;

@RestController @RequestMapping( MasterController.API_ROOT_URI )
public class MasterController {

	private static final Logger LOGGER = LoggerFactory.getLogger( MasterController.class );

	public static final String API_ROOT_URI = "/master";
	
	@Autowired
	private DummyRepository dummyRepository;

//	Da utilizzare perl'internazionalizzazione
//	@Autowired
//	private MessageSource messageSource;

	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SimpleResponseDto>> get() {
		LOGGER.debug("Test");
		List<SimpleResponseDto> output = new ArrayList<>();
		SimpleResponseDto responseDto;
		List<DummyModel> allDummy = dummyRepository.findAll();
		for(DummyModel model : allDummy){
			responseDto = new SimpleResponseDto();
			responseDto.setValue(model.getValue());
			output.add(responseDto);
		}
		LOGGER.debug("find all dummy -> {};", allDummy);
		ResponseEntity<List<SimpleResponseDto>> response = new  ResponseEntity<List<SimpleResponseDto>>(output, HttpStatus.OK);

		return response;
	}
	
	public class SimpleResponseDto{
		private String value;

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public SimpleResponseDto setValue(String value) {
			this.value = value;
			return this;
		}
		
	}
}