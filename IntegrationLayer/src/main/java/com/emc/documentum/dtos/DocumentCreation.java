package com.emc.documentum.dtos;

import java.util.HashMap;

public class DocumentCreation {

	private String folderPath;

	private HashMap<String, Object> properties;

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

	public HashMap<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, Object> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "DocumentCreation [folderPath=" + folderPath + ", properties=" + properties + "]";
	}

}
