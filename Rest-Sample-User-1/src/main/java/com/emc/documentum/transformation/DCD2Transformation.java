package com.emc.documentum.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emc.d2fs.models.attribute.Attribute;
import com.emc.d2fs.models.node.Node;
import com.emc.documentum.dtos.DocumentumObject;

public class DCD2Transformation {
	private DCD2Transformation(){
		
	}
	public static <T extends DocumentumObject> T convertD2Object(Node d2Object, Class<T> type)
	{
		T object = null ;
		try {
			object = type.newInstance();
			object.setId(d2Object.getId());
			object.setName(d2Object.getLabel());
			object.setType(d2Object.getType());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	
	

	@SuppressWarnings("unchecked")
	public static <T extends DocumentumObject> ArrayList<T> convertD2ObjectList(List<Node> list,
			Class<T> class1) {
		ArrayList<T> documentumObject = new ArrayList<T>();
		for (Node d2object : list) {
			documentumObject.add((T) convertD2Object(d2object , class1));
		}
		return documentumObject;
	}
	public static Map<String,Object> convertD2Properties(List<Attribute> attributes)
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		for(Attribute attribute:attributes)
		{
			properties.put(attribute.getName(), attribute.getValue());
		}
		return properties;
	}
	
}
