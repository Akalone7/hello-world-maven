/**
 * 
 */
package it.clefra.web.controllers;


import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.clefra.persistence.model.DummyModel;
import it.clefra.persistence.repositories.DummyRepository;
import it.clefra.web.dto.DummyDto;

@RestController @RequestMapping( MasterController.API_ROOT_URI )
public class MasterController {

	private static final Logger LOGGER = LoggerFactory.getLogger( MasterController.class );

	public static final String API_ROOT_URI = "/master";

	//TODO inserire in un layer di servizi
	@Autowired
	private DummyRepository dummyRepository;

	//	Da utilizzare perl'internazionalizzazione TODO
	//	@Autowired
	//	private MessageSource messageSource;

	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DummyDto>> get() {
		LOGGER.debug("Start getting dummy elements");
		List<DummyDto> output = new ArrayList<>();
		DummyDto dummyDto;

		List<DummyModel> allDummy = dummyRepository.findAll();

		//TODO Web-Persistence Mapper
		for(DummyModel model : allDummy){
			dummyDto = new DummyDto();
			dummyDto.setId(model.getId() != null ? model.getId().toHexString() : null)
			.setValue(model.getValue());
			output.add(dummyDto);
		}
		LOGGER.debug("{} dummy found -> {};", allDummy.size(), allDummy);
		ResponseEntity<List<DummyDto>> response = new  ResponseEntity<List<DummyDto>>(output, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}



	/**
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DummyDto> get(@PathVariable String id) {
		LOGGER.debug("Start getting dummy elements");
		ObjectId objectId = new ObjectId(id);
		DummyDto dummyDto = new DummyDto();
		DummyModel dummyModel = dummyRepository.findOne(objectId);
		dummyDto.setId(dummyModel.getId() != null? dummyModel.getId().toHexString() : null) 
		.setValue(dummyModel.getValue());
		
		ResponseEntity<DummyDto> response = new  ResponseEntity<DummyDto>(dummyDto, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}

	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<DummyDto> insert(@RequestBody(required = true) DummyDto dummyDto ) {
		LOGGER.debug("Start insert dummy element");
		DummyModel dummy = new DummyModel();
		DummyDto output = null;

		//TODO Web<->Persistence Mapper
		dummy.setValue(dummyDto.getValue());
		try{
			DummyModel insertedDummy = dummyRepository.insert(dummy);
			output = new DummyDto()
			.setId(insertedDummy.getId() != null ? insertedDummy.getId().toHexString() : null)
			.setValue(insertedDummy.getValue());
		} catch (final Exception e){
			LOGGER.error(e.getMessage(), e);
		}
		ResponseEntity<DummyDto> response = new  ResponseEntity<DummyDto>(output, HttpStatus.OK);
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}

	/**
	 * @return
	 */
	@RequestMapping(value= "/{dummyId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String dummyId) {
		LOGGER.debug("Start deleting dummy with id {};", dummyId);

		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.FORBIDDEN);

		//TODO Web-Persistence Mapper
		try{
			dummyRepository.delete(new ObjectId(dummyId));
			response = new ResponseEntity<Void>(HttpStatus.OK);
			LOGGER.debug("Dummy {} deleted;", dummyId);
		} catch (final Exception e){
			LOGGER.error(e.getMessage(), e);
		}
		LOGGER.debug("Request computed. Returning response to Client");
		return response;
	}

}