package com.emc.documentum.transformation;

import java.util.ArrayList;
import java.util.List;

import com.emc.documentum.constants.DocumentumProperties;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.model.JsonEntry;
import com.emc.documentum.model.JsonEntry.Content;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.wrappers.DCRestAPIWrapper;

public class CoreRestTransformation {

	private CoreRestTransformation() {

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

	private static DocumentumObject ConvertCoreRSJsonEntry(JsonEntry jsonEntry) {
		Content content = jsonEntry.getContent();
		String linkUrl = DCRestAPIWrapper.getLink(content.getLinks(), "self").getHref();
		String[] linkParts = linkUrl.split("/");
		String baseType = linkParts[linkParts.length - 2];
		DocumentumObject documentumObject = createDocumentumObject(baseType);
		convertCoreRSContent(content, documentumObject);
		return documentumObject;
	}

	public static ArrayList<DocumentumObject> convertCoreRSEntryList(List<JsonEntry> jsonEntryFeed) {
		ArrayList<DocumentumObject> documentumObjectList = new ArrayList<>();
		if (jsonEntryFeed != null) {
			for (JsonEntry jsonEntry : jsonEntryFeed) {
				documentumObjectList.add(ConvertCoreRSJsonEntry(jsonEntry));
			}
		}
		return documentumObjectList;
	}

	public static <T extends DocumentumObject> ArrayList<T> convertCoreRSEntryList(List<JsonEntry> jsonEntryFeed,
			Class<T> responseType) {
		ArrayList<DocumentumObject> documentumObjectList = new ArrayList<>();
		if (jsonEntryFeed != null) {
			for (JsonEntry jsonEntry : jsonEntryFeed) {
				documentumObjectList.add(ConvertCoreRSJsonEntry(jsonEntry));
			}
		}
		return (ArrayList<T>) documentumObjectList;
	}

	private static <T extends DocumentumObject> T convertCoreRSJsonEntry(JsonEntry jsonEntry, Class<T> type) {
		Content content = jsonEntry.getContent();
		String linkUrl = DCRestAPIWrapper.getLink(content.getLinks(), "self").getHref();
		String[] linkParts = linkUrl.split("/");
		String baseType = linkParts[linkParts.length - 2];
		DocumentumObject documentumObject;
		try {
			documentumObject = type.newInstance();
			documentumObject.setType(baseType);
			convertCoreRSContent(content, documentumObject);
			return (T) documentumObject;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static void convertCoreRSContent(Content content, DocumentumObject documentumObject) {

		documentumObject.setId(content.getPropertyByName("r_object_id").toString());
		documentumObject.setName(content.getPropertyByName("object_name").toString());
		documentumObject.setProperties(content.getProperties());
	}

}
