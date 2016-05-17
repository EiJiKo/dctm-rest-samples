package com.emc.documentum.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.emc.d2fs.models.attribute.Attribute;
import com.emc.d2fs.models.context.Context;
import com.emc.d2fs.models.item.Item;
import com.emc.d2fs.models.node.Node;
import com.emc.documentum.constants.Cardinality;
import com.emc.documentum.dtos.DocumentumCabinet;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.dtos.DocumentumProperty;

public class DCD2Transformation {
	private DCD2Transformation() {

	}

	public static <T extends DocumentumObject> T convertD2NodeObject(Node d2Object,Context context) {
		T object = null;
		object = (T) createDocumentumObject(d2Object.getIcon());
		object.setId(d2Object.getId());
		object.setName(d2Object.getLabel());
		String lockUser = (d2Object.getLocked() == null || d2Object.getLocked().equals("None")) ? null : (d2Object.getLocked().equals("You") ? context.getLogin() : d2Object.getLocked() );
		boolean isLocked = lockUser == null;
		object.setLockUser(lockUser);
		object.setCheckedOut(isLocked);
		// object.setType(d2Object.getType());
		if (d2Object.getAttributes() != null) {
			object.setProperties(convertD2PropertiesList(d2Object.getAttributes()));
		}
		return object;
	}

	public static <T extends DocumentumObject> T convertD2DocItemObject(Item d2Object,Context context) {
		T object = null;
		object = (T) createDocumentumObject(d2Object.getIcon());
		object.setId(d2Object.getId());
		// object.setType(d2Object.getType());
		String lockUser = (d2Object.getLocked() == null || d2Object.getLocked().equals("None")) ? null : (d2Object.getLocked().equals("You") ? context.getLogin() : d2Object.getLocked() );
		boolean isLocked = lockUser != null;
		object.setLockUser(lockUser);
		object.setCheckedOut(isLocked);
		if (d2Object.getAttributes() != null) {
			object.setProperties(convertD2PropertiesList(d2Object.getAttributes()));
			for (DocumentumProperty property : object.getProperties()) {
				if (property.getLocalName().equals("object_name")) {
					object.setName(property.getValue() + "");
					object.getProperties().remove(property);
					break;
				}
			}
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	public static <T extends DocumentumObject> ArrayList<T> convertD2DocItemObjectList(List<Item> list,Context context) {
		ArrayList<T> documentumObject = new ArrayList<T>();
		for (Item d2object : list) {
			documentumObject.add((T) convertD2DocItemObject(d2object,context));
		}
		return documentumObject;
	}

	private static DocumentumObject createDocumentumObject(String baseTypeId) {
		DocumentumObject documentumObject;
		if(baseTypeId.contains("dm_cabinet")){
			documentumObject = new DocumentumCabinet(); 
		}
		else if (baseTypeId.contains("dm_folder")){
			documentumObject = new DocumentumFolder();
		}
		else if (baseTypeId.contains("dm_document")) 
		{
			documentumObject = new DocumentumDocument();
		}
		
		else
			documentumObject = new DocumentumObject();
		return documentumObject;
	}

	@SuppressWarnings("unchecked")
	public static <T extends DocumentumObject> ArrayList<T> convertD2NodeObjectList(List<Node> list,Context context) {
		ArrayList<T> documentumObject = new ArrayList<T>();
		for (Node d2object : list) {
			documentumObject.add((T) convertD2NodeObject(d2object,context));
		}
		return documentumObject;
	}

	public static HashMap<String, Object> convertD2Properties(List<Attribute> attributes) {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		for (Attribute attribute : attributes) {
			properties.put(attribute.getName(), attribute.getValue());
		}
		return properties;
	}

	public static ArrayList<DocumentumProperty> convertD2PropertiesList(List<Attribute> attributes) {
		ArrayList<DocumentumProperty> properties = new ArrayList<DocumentumProperty>();
		for (Attribute attribute : attributes) {
			DocumentumProperty temp = new DocumentumProperty(attribute.getName(), attribute.getName(),
					attribute.getValue(), Cardinality.Single);
			properties.add(temp);
		}
		return properties;
	}

}
