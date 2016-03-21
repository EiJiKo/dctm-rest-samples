package com.emc.documentum.dtos;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonFormat;

public  class DocumentumObject {

	private String id;
	private String path;
	private String name;
	private String type;
	private String definition;
	@JsonFormat(with = { JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
			JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED })
	private HashMap<String, Object> properties;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public HashMap<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, Object> properties) {
		this.properties = properties;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public DocumentumObject(){
		properties = new HashMap<>();
	}
}
