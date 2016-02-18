package it.clefra.persistence.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author <a href="mailto:francesco.mirenda@finconsgroup.com">Francesco L Mirenda</a>
 *
 */
@Document( collection = DummyModel.COLLECTION_NAME )
public class DummyModel {
	public static final String COLLECTION_NAME = "dummy";
	
	@Field
	@Id
	private ObjectId id;
	
	@Field
	private String value;

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
