package com.emc.documentum.dtos;

public class NavigationObject {

	String id;
	String parent;
	String text;
	String type;
	NavigationObject[] children;
	
	public NavigationObject(String id, String parent ,String text, String type, NavigationObject[] children) {
		this.id = id;
		this.parent = parent;
		this.text = text;
		this.type = type;
		this.children = children;
	}

	public NavigationObject[]  getChildren() {
		return children;
	}

	public void setChildren(NavigationObject[]  children) {
		this.children = children;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}