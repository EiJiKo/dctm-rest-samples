package com.emc.documentum.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.Property;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.apache.chemistry.opencmis.commons.data.PropertyData;

import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;

public class CMISTransformation {

	private static DocumentumObject createDocumentumObject(String baseTypeId) {
		DocumentumObject documentumObject;
		switch (baseTypeId) {
		case "cmis:folder":
		case "folders":
		case "cabinets":
			documentumObject = new DocumentumFolder();
			break;
		case "cmis:document":
		case "documents":
			documentumObject = new DocumentumDocument();
			break;
		default:
			documentumObject = new DocumentumObject();
		}
		return documentumObject;
	}

	public static ArrayList<DocumentumObject> convertCMISQueryResultList(ItemIterable<QueryResult> documentList) {
		ArrayList<DocumentumObject> documentumObjectList = new ArrayList<>();
		for (QueryResult queryResult : documentList) {
			documentumObjectList.add(convertCMISQueryResult(queryResult));
		}
		return documentumObjectList;
	}

	public static DocumentumObject convertCMISQueryResult(QueryResult queryResult) {
		String baseType = queryResult.getPropertyById("cmis:baseTypeId").getFirstValue().toString();
		DocumentumObject documentumObject = createDocumentumObject(baseType);
		documentumObject.setId(queryResult.getPropertyById("cmis:objectId").getFirstValue().toString());
		documentumObject.setName(queryResult.getPropertyById("cmis:name").getFirstValue().toString());
		PropertyData<Boolean> checkedOut = queryResult.getPropertyById("cmis:isVersionSeriesCheckedOut");
		if(checkedOut != null){
			documentumObject.setCheckedOut(checkedOut.getFirstValue());
			documentumObject.setLockUser(queryResult.getPropertyById("cmis:versionSeriesCheckedOutBy").getFirstValue().toString());
		}
		mapPropertyDataList(documentumObject, queryResult.getProperties());
		return documentumObject;
	}

	public static DocumentumObject convertCMISObject(CmisObject cmisObject) {
		DocumentumObject object = createDocumentumObject(cmisObject.getPropertyValue("cmis:baseTypeId").toString());
		object.setId(cmisObject.getId());
		object.setName(cmisObject.getName());
		Property<Boolean> checkedOut = cmisObject.getProperty("cmis:isVersionSeriesCheckedOut");
		if(checkedOut != null){
			object.setCheckedOut(checkedOut.getValue());
			object.setLockUser(cmisObject.getProperty("cmis:versionSeriesCheckedOutBy").getValueAsString());
		}
		mapPropertyList(object, cmisObject.getProperties());
		return object;
	}

	public static DocumentumDocument convertCMISDocument(Document cmisDocument) {
		DocumentumDocument document = new DocumentumDocument();
		document.setId(cmisDocument.getId());
		document.setName(cmisDocument.getName());
		document.setPath(cmisDocument.getPaths().get(0));
		Property<Boolean> checkedOut = cmisDocument.getProperty("cmis:isVersionSeriesCheckedOut");
		if(checkedOut != null){
			document.setCheckedOut(checkedOut.getValue());
			document.setLockUser(cmisDocument.getProperty("cmis:versionSeriesCheckedOutBy").getValueAsString());
		}
		mapPropertyList(document, cmisDocument.getProperties());
		return document;
	}

	public static DocumentumFolder convertCMISFolder(Folder cmisFolder) {
		DocumentumFolder folder = new DocumentumFolder();
		folder.setId(cmisFolder.getId());
		folder.setPath(cmisFolder.getPath());
		folder.setName(cmisFolder.getDescription());
		mapPropertyList(folder, cmisFolder.getProperties());

		return folder;
	}

	private static void mapPropertyList(DocumentumObject object, List<Property<?>> properties) {
		HashMap<String, Object> objectProperties = object.getProperties();
		for (Property<?> property : properties) {
			if (property.getLocalName().startsWith("i_")) {
				continue;
			}

			objectProperties.put(property.getId(), property.getValue());
		}
	}

	private static void mapPropertyDataList(DocumentumObject documentumObject, List<PropertyData<?>> properties) {
		HashMap<String, Object> objectProperties = documentumObject.getProperties();
		for (PropertyData<?> property : properties) {
			if (property.getLocalName().startsWith("i_")) {
				continue;
			}
			objectProperties.put(property.getId(), property.getValues());
		}

	}

	@SuppressWarnings("unchecked")
	public static <T extends DocumentumObject> ArrayList<T> convertCmisObjectList(ArrayList<CmisObject> cmisObjects,
			Class<T> class1) {
		ArrayList<T> documentumObject = new ArrayList<T>();
		for (CmisObject cmisObject : cmisObjects) {
			documentumObject.add((T) convertCMISObject(cmisObject));
		}
		return documentumObject;
	}
}
