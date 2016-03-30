package com.emc.documentum.transformation;

import java.util.ArrayList;
import java.util.List;

import com.emc.d2fs.models.node.Node;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;

public class DCD2Transformation {
	private DCD2Transformation(){
		
	}
	public static DocumentumObject convertD2Object(Node d2Object)
	{
		DocumentumObject object = new DocumentumObject();
		object.setId(d2Object.getId());
		object.setName(d2Object.getLabel());
		object.setType(d2Object.getType());
		return object;
	}
	@SuppressWarnings("unchecked")
	public static <T extends DocumentumObject> ArrayList<T> convertD2ObjectList(List<Node> list,
			Class<T> class1) {
		ArrayList<T> documentumObject = new ArrayList<T>();
		for (Node d2object : list) {
			documentumObject.add((T) convertD2Object(d2object));
		}
		return documentumObject;
	}
}
