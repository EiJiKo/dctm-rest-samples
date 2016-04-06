package com.emc.documentum.transformation;

import java.util.ArrayList;
import java.util.List;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.Property;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.apache.chemistry.opencmis.commons.data.PropertyData;

import com.emc.documentum.constants.Cardinality;
import com.emc.documentum.dtos.DocumentumCabinet;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.dtos.DocumentumProperty;

public class CMISTransformation {

	private static DocumentumObject createDocumentumObject(String objectTypeId, String baseTypeId) {
		DocumentumObject documentumObject;
		switch (baseTypeId) {
		case "cmis:folder":
			documentumObject = (objectTypeId.equals("dm_cabinet")) ? new DocumentumCabinet() : new DocumentumFolder();
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

	public static ArrayList<DocumentumObject> convertCMISQueryResultList(ItemIterable<QueryResult> documentList) {
		ArrayList<DocumentumObject> documentumObjectList = new ArrayList<>();
		for (QueryResult queryResult : documentList) {
			documentumObjectList.add(convertCMISQueryResult(queryResult));
		}
		return documentumObjectList;
	}

	public static DocumentumObject convertCMISQueryResult(QueryResult queryResult) {
		String baseType = queryResult.getPropertyById("cmis:baseTypeId").getFirstValue().toString();
		String objectType = queryResult.getPropertyById("cmis:objectTypeId").getFirstValue().toString();
		DocumentumObject documentumObject = createDocumentumObject(objectType, baseType);
		documentumObject.setId(queryResult.getPropertyById("cmis:objectId").getFirstValue().toString());
		documentumObject.setName(queryResult.getPropertyById("cmis:name").getFirstValue().toString());
		PropertyData<Boolean> checkedOut = queryResult.getPropertyById("cmis:isVersionSeriesCheckedOut");
		if (checkedOut != null && checkedOut.getFirstValue() != false) {
			documentumObject.setCheckedOut(checkedOut.getFirstValue());
			documentumObject.setLockUser(
					queryResult.getPropertyById("cmis:versionSeriesCheckedOutBy").getFirstValue().toString());
		}
		mapPropertyDataList(documentumObject, queryResult.getProperties());
		return documentumObject;
	}

	public static DocumentumObject convertCMISObject(CmisObject cmisObject) {
		DocumentumObject object = createDocumentumObject(cmisObject.getPropertyValue("cmis:objectTypeId").toString(),
				cmisObject.getPropertyValue("cmis:baseTypeId").toString());
		object.setId(cmisObject.getId());
		object.setName(cmisObject.getName());
		Property<Boolean> checkedOut = cmisObject.getProperty("cmis:isVersionSeriesCheckedOut");
		if (checkedOut != null && checkedOut.getFirstValue() != false) {
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
		// TODO Get Path breaks after using CMIS Build 7.3.0.8
		// if (cmisDocument.getPaths() != null && cmisDocument.getPaths().size()
		// > 0) {
		// document.setPath(cmisDocument.getPaths().get(0));
		// }
		Property<Boolean> checkedOut = cmisDocument.getProperty("cmis:isVersionSeriesCheckedOut");
		if (checkedOut != null && checkedOut.getFirstValue() != false) {
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
		ArrayList<DocumentumProperty> objectProperties = object.getDocProperties();
		for (Property<?> property : properties) {
			if (property.getLocalName().startsWith("i_")) {
				continue;
			}

			objectProperties.add(new DocumentumProperty(property.getId(), property.getValue(),
					(property.isMultiValued() ? Cardinality.List : Cardinality.Single)));
		}
	}

	private static void mapPropertyDataList(DocumentumObject documentumObject, List<PropertyData<?>> properties) {
		ArrayList<DocumentumProperty> objectProperties = documentumObject.getDocProperties();
		for (PropertyData<?> property : properties) {
			if (property.getLocalName().startsWith("i_")) {
				continue;
			}

			objectProperties.add(new DocumentumProperty(property.getId(), property.getValues(),
					(property.getValues().size() > 0 ? Cardinality.Single : Cardinality.List)));
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
