package com.emc.documentum.dtos;

import java.util.HashMap;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class DocumentCreation {

	@ApiModelProperty(notes = "object_id of a the container where the document will be created", required = true)
	@NotNull
	private String parentId;

	@ApiModelProperty(notes = "A hash map of document properties", required = true)
	private HashMap<String, Object> properties;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public HashMap<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, Object> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "DocumentCreation [parentId=" + parentId + ", properties=" + properties + "]";
	}

}
