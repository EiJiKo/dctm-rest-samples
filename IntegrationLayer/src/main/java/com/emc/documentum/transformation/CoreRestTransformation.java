package com.emc.documentum.transformation;

import java.util.ArrayList;
import java.util.List;

import com.emc.documentum.constants.DocumentumProperties;
import com.emc.documentum.dtos.DocumentumCabinet;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.model.JsonEntry;
import com.emc.documentum.model.JsonEntry.Content;
import com.emc.documentum.model.JsonLink;
import com.emc.documentum.model.JsonObject;
import com.emc.documentum.wrappers.DCRestAPIWrapper;

public class CoreRestTransformation {

	private CoreRestTransformation() {

	}

	public static DocumentumObject convertJsonObject(JsonObject jsonObject) {
		DocumentumObject documentumObject = getDocumentumObject(jsonObject);
		mapJsonObjectProperties(jsonObject, documentumObject);
		return documentumObject;

	}

	private static void mapJsonObjectProperties(JsonObject jsonObject, DocumentumObject documentumObject) {
		documentumObject.setId((String) jsonObject.getPropertyByName(DocumentumProperties.OBJECT_ID));
		documentumObject.setName((String) jsonObject.getPropertyByName("object_name"));
		documentumObject.setProperties(jsonObject.getProperties());
		documentumObject.setDefinition(jsonObject.getDefinition());
		Object lockUser = jsonObject.getPropertyByName("r_lock_owner");
		if (lockUser != null && lockUser.toString().length() > 0) {
			documentumObject.setCheckedOut(true);
			documentumObject.setLockUser(lockUser.toString());
		}
	}

	private static DocumentumObject getDocumentumObject(JsonObject jsonObject) {
		JsonLink link = DCRestAPIWrapper.getLink(jsonObject.getLinks(), "canonical");
		if(link == null){
			link = DCRestAPIWrapper.getLink(jsonObject.getLinks(), "self");
		}
		String[] linkParts = link.getHref().split("/");
		String baseType = linkParts[linkParts.length - 2];
		DocumentumObject documentumObject = createDocumentumObject(baseType);
		return documentumObject;
	}

	public static <T extends DocumentumObject> T convertJsonObject(JsonObject jsonObject, Class<T> classType)
			throws InstantiationException, IllegalAccessException {
		T documentumObject = classType.newInstance();
		mapJsonObjectProperties(jsonObject, documentumObject);
		return documentumObject;

	}

	@Deprecated
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

	@Deprecated
	public static DocumentumObject convertCoreRSObject(JsonObject restObject) {
		DocumentumObject object = new DocumentumObject();
		mapJsonObjectProperties(restObject, object);
		return object;
	}

	@Deprecated
	public static DocumentumDocument convertCoreRSDocument(JsonObject restDocument) {
		DocumentumDocument document = new DocumentumDocument();
		document.setId((String) restDocument.getPropertyByName(DocumentumProperties.OBJECT_ID));
		document.setName(restDocument.getName());
		document.setProperties(restDocument.getProperties());
		document.setDefinition(restDocument.getDefinition());
		document.setType(restDocument.getType());
		Object lockUser = restDocument.getPropertyByName("r_lock_owner");
		if (lockUser != null && lockUser.toString().length() > 0) {
			document.setCheckedOut(true);
			document.setLockUser(lockUser.toString());
		}
		return document;
	}

	private static DocumentumObject createDocumentumObject(String baseTypeId) {
		DocumentumObject documentumObject;
		switch (baseTypeId) {
		case "cmis:folder":
		case "folders":
			documentumObject = new DocumentumFolder();
			break;
		case "cabinets":
			documentumObject = new DocumentumCabinet();
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
		Object lockUser = content.getPropertyByName("r_lock_owner");
		if (lockUser != null && lockUser.toString().length() > 0) {
			documentumObject.setCheckedOut(true);
			documentumObject.setLockUser(lockUser.toString());
		}
	}

}
