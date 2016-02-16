/**
 * 
 */
package it.clefra.web.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping( MasterController.API_ROOT_URI )
public class MasterController {

	private static final Logger LOGGER = LoggerFactory.getLogger( MasterController.class );

	public static final String API_ROOT_URI = "/master";

//	Da utilizzare perl'internazionalizzazione
//	@Autowired
//	private MessageSource messageSource;

	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<SimpleResponseDto> get() {
		LOGGER.debug("Test");
		SimpleResponseDto responseDto = new SimpleResponseDto();
		responseDto.setValue("Test");
		ResponseEntity<SimpleResponseDto> response = new  ResponseEntity<MasterController.SimpleResponseDto>(responseDto, HttpStatus.OK);

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