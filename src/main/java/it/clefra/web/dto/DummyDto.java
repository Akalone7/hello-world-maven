package it.clefra.web.dto;
/**
 * @author <a href="mailto:francesco.mirenda@finconsgroup.com">Francesco L Mirenda</a>
 *
 */
public class DummyDto {
	private String id;
	
	private String value;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public DummyDto setId(String id) {
		this.id = id;
		return this;
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
	public DummyDto setValue(String value) {
		this.value = value;
		return this;
	}

}
