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

import com.emc.documentum.constants.DocumentumProperties;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.model.JsonEntry;
import com.emc.documentum.model.JsonEntry.Content;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.wrappers.DCRestAPIWrapper;

public class ObjectMapper {

	private ObjectMapper() {

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

	public static DocumentumFolder convertCMISFolder(Folder cmisFolder) {
		DocumentumFolder folder = new DocumentumFolder();
		folder.setId(cmisFolder.getId());
		folder.setPath(cmisFolder.getPath());
		folder.setName(cmisFolder.getDescription());
		mapPropertyList(folder, cmisFolder.getProperties());

		return folder;
	}

	public static DocumentumDocument convertCMISDocument(Document cmisDocument) {
		DocumentumDocument document = new DocumentumDocument();
		document.setId(cmisDocument.getId());
		document.setName(cmisDocument.getName());
		document.setPath(cmisDocument.getPaths().get(0));
		mapPropertyList(document, cmisDocument.getProperties());
		return document;
	}

	public static DocumentumFolder convertCoreRSFolder(JsonObject restFolder) {
		DocumentumFolder folder = new DocumentumFolder();
		folder.setId((String) restFolder.getPropertyByName(DocumentumProperties.OBJECT_ID));
		ArrayList<?> folderPath = (ArrayList<?>) restFolder.getPropertyByName(DocumentumProperties.FOLDER_PATH);
		if (folderPath != null & folderPath.size() > 0) {
			folder.setPath(folderPath.get(0).toString());
		}
		folder.setName(restFolder.getName());
		folder.setProperties(restFolder.getProperties());
		folder.setDefinition(restFolder.getDefinition());
		folder.setType(restFolder.getType());
		return folder;
	}

	public static DocumentumObject convertCMISObject(CmisObject cmisObject) {
		DocumentumObject object = createDocumentumObject(cmisObject.getPropertyValue("cmis:baseTypeId").toString());
		object.setId(cmisObject.getId());
		object.setName(cmisObject.getName());
		mapPropertyList(object, cmisObject.getProperties());
		return object;
	}

	public static DocumentumObject convertCoreRSObject(JsonObject restObject) {
		DocumentumObject object = new DocumentumObject();
		object.setId((String) restObject.getPropertyByName(DocumentumProperties.OBJECT_ID));
		object.setName(restObject.getName());
		object.setProperties(restObject.getProperties());
		object.setDefinition(restObject.getDefinition());
		object.setType(restObject.getType());
		return object;
	}

	public static DocumentumDocument convertCoreRSDocument(JsonObject restDocument) {
		DocumentumDocument document = new DocumentumDocument();
		document.setId((String) restDocument.getPropertyByName(DocumentumProperties.OBJECT_ID));
		document.setName(restDocument.getName());
		document.setProperties(restDocument.getProperties());
		document.setDefinition(restDocument.getDefinition());
		document.setType(restDocument.getType());
		return document;
	}

	public static DocumentumObject convertCMISQueryResult(QueryResult queryResult) {
		String baseType = queryResult.getPropertyById("cmis:baseTypeId").getFirstValue().toString();
		DocumentumObject documentumObject = createDocumentumObject(baseType);
		documentumObject.setId(queryResult.getPropertyById("cmis:objectId").getFirstValue().toString());
		documentumObject.setName(queryResult.getPropertyById("cmis:name").getFirstValue().toString());
		mapPropertyDataList(documentumObject, queryResult.getProperties());
		return documentumObject;
	}

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

	public static ArrayList<DocumentumObject> convertCoreRSEntryList(List<JsonEntry> jsonEntryFeed) {
		ArrayList<DocumentumObject> documentumObjectList = new ArrayList<>();
		for (JsonEntry jsonEntry : jsonEntryFeed) {
			documentumObjectList.add(ConvertCoreRSJsonEntry(jsonEntry));
		}
		return documentumObjectList;
	}

	private static DocumentumObject ConvertCoreRSJsonEntry(JsonEntry jsonEntry) {
		Content content = jsonEntry.getContent();
		String linkUrl = DCRestAPIWrapper.getLink(content.getLinks(), "self").getHref();
		String[] linkParts = linkUrl.split("/");
		String baseType = linkParts[linkParts.length - 2];
		DocumentumObject documentumObject = createDocumentumObject(baseType);

		documentumObject.setId(content.getPropertyByName("r_object_id").toString());
		documentumObject.setName(content.getPropertyByName("object_name").toString());
		documentumObject.setProperties(content.getProperties());
		return documentumObject;
	}

}
