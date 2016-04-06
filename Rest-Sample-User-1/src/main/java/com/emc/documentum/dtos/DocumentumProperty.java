package com.emc.documentum.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DocumentumProperty {

	private String localName;

	private String displayName;

	@JsonFormat(with = { JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
			JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED })
	private Object value;

	private String cardinality;

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getCardinality() {
		return cardinality;
	}

	public void setCardinality(String cardinality) {
		this.cardinality = cardinality;
	}

}
