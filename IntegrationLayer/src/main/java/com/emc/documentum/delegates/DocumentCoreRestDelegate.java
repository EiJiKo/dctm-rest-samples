package com.emc.documentum.delegates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.emc.documentum.constants.DocumentumProperties;
import com.emc.documentum.constants.LinkRelation;
import com.emc.documentum.dtos.DocumentCreation;
import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.dtos.DocumentumProperty;
import com.emc.documentum.exceptions.CanNotDeleteFolderException;
import com.emc.documentum.exceptions.DocumentCheckinException;
import com.emc.documentum.exceptions.DocumentCheckoutException;
import com.emc.documentum.exceptions.DocumentCreationException;
import com.emc.documentum.exceptions.DocumentumException;
import com.emc.documentum.exceptions.FolderCreationException;
import com.emc.documentum.exceptions.ObjectNotFoundException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;
import com.emc.documentum.wrappers.corerest.DctmRestClientX;
import com.emc.documentum.wrappers.corerest.model.JsonObject;
import com.emc.documentum.wrappers.corerest.model.PlainRestObject;
import com.emc.documentum.wrappers.corerest.util.RestTransformation;

@Component("DocumentCoreRestDelegate")
public class DocumentCoreRestDelegate implements DocumentumDelegate {

	@Autowired
	@Lazy
	DctmRestClientX restClientX;

	@Override
	public String getIdentifier() {
		return "corerest";
	}

	@Override
	public DocumentumFolder createFolder(String cabinetName, String folderName) throws FolderCreationException,
			ObjectNotFoundException, RepositoryNotAvailableException, DocumentumException {
		JsonObject cabinet = restClientX.getObjectByPath(cabinetName);
		try {
			return RestTransformation.convertJsonObject(restClientX
					.createFolder((String) cabinet.getPropertyByName(DocumentumProperties.OBJECT_ID), folderName),
					DocumentumFolder.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new DocumentumException("Unable to instantiate class of type " + DocumentumDocument.class.getName());
		}

	}

	@Override
	public DocumentumDocument createDocument(DocumentCreation docCreation) throws DocumentumException {
		JsonObject folder = restClientX.getObjectById(docCreation.getParentId());
		byte[] data = "".getBytes();
		try {
			return RestTransformation.convertJsonObject(
					restClientX.createContentfulDocument(folder, data, "FileName", "MimeType"),
					DocumentumDocument.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new DocumentCreationException(
					"Unable to instantiate class of type " + DocumentumDocument.class.getName());
		}

	}

	@Override
	public DocumentumFolder getCabinetByName(String cabinetName)
			throws ObjectNotFoundException, RepositoryNotAvailableException, DocumentumException {

		return (DocumentumFolder) RestTransformation.convertJsonObject(restClientX.getObjectByPath("/" + cabinetName));
	}

	@Override
	public DocumentumObject getObjectById(String objectId)
			throws ObjectNotFoundException, RepositoryNotAvailableException {
		return RestTransformation.convertJsonObject(restClientX.getObjectById(objectId));
	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets() throws RepositoryNotAvailableException {
		return this.getAllCabinets(1, 20);
	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId) throws RepositoryNotAvailableException {
		return this.getChildren(folderId, 1, 20);
	}

	@Override
	public ArrayList<DocumentumObject> getChildren(String folderId, int pageNumber, int pageSize)
			throws RepositoryNotAvailableException {
		return RestTransformation
				.convertCoreRSEntryList(restClientX.getChildrenByObjectId(folderId, pageNumber, pageSize));
	}

	@Override
	public byte[] getDocumentContentById(String documentId)
			throws ObjectNotFoundException, RepositoryNotAvailableException {
		return restClientX.getContentById(documentId, true).getData();
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentByName(String name) throws RepositoryNotAvailableException {
		return RestTransformation.convertCoreRSEntryList(restClientX.queryMultipleObjectsByName("%" + name + "%"));

	}

	@Override
	public DocumentumDocument checkoutDocument(String documentId)
			throws RepositoryNotAvailableException, DocumentCheckoutException, DocumentumException {
		try {
			return RestTransformation.convertJsonObject(restClientX.checkout(documentId), DocumentumDocument.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new DocumentumException("Unable to instantiate class of type " + DocumentumDocument.class.getName());
		}
	}

	@Override
	public DocumentumDocument checkinDocument(String documentId, byte[] content)
			throws RepositoryNotAvailableException, DocumentCheckinException, DocumentumException {
		try {
			return RestTransformation.convertJsonObject(restClientX.checkinDocument(documentId, content),
					DocumentumDocument.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new DocumentumException("Unable to instantiate class of type " + DocumentumDocument.class.getName());
		}

	}

	@Override
	public DocumentumFolder createFolderByParentId(String parentId, String folderName)
			throws FolderCreationException, RepositoryNotAvailableException, DocumentumException {
		try {
			JsonObject folder = restClientX.createFolder(parentId, folderName);
			return RestTransformation.convertJsonObject(folder, DocumentumFolder.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new DocumentumException("Unable to instantiate class of type " + DocumentumDocument.class.getName());
		}
	}

	@Override
	public ArrayList<DocumentumFolder> getAllCabinets(int pageNumber, int pageSize)
			throws RepositoryNotAvailableException {
		return RestTransformation.convertCoreRSEntryList(restClientX.getAllCabinets(pageNumber, pageSize),
				DocumentumFolder.class);
	}

	@Override
	public void deleteObject(String objectId, boolean deleteChildrenOrNot) throws CanNotDeleteFolderException {
		restClientX.deleteObjectById(objectId, deleteChildrenOrNot);

	}

	@Override
	public DocumentumObject cancelCheckout(String documentId)
			throws RepositoryNotAvailableException, DocumentCheckoutException {
		JsonObject document = restClientX.cancelCheckout(documentId);
		try {
			return RestTransformation.convertJsonObject(document, DocumentumDocument.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new DocumentCheckoutException(
					"Unable to instantiate class of type " + DocumentumDocument.class.getName());
		}

	}

	@Override
	public DocumentumFolder createFolder(String parentId, HashMap<String, Object> properties)
			throws FolderCreationException, ObjectNotFoundException, RepositoryNotAvailableException,
			DocumentumException {
		JsonObject folder = restClientX.createFolder(parentId,
				(String) properties.get(DocumentumProperties.OBJECT_NAME));
		try {
			return RestTransformation.convertJsonObject(folder, DocumentumFolder.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new DocumentumException("Unable to instantiate class of type " + DocumentumDocument.class.getName());
		}
	}

	@Override
	public DocumentumDocument createDocument(String parentId, DocumentumDocument document)
			throws DocumentCreationException, RepositoryNotAvailableException {
		JsonObject folder = restClientX.getObjectById(parentId);
		byte[] data = "".getBytes();
		HashMap<String, Object> properties = document.getPropertiesAsMap();

		if (!properties.containsKey("r_object_type")) {
			properties.put("r_object_type", "dm_document");
		}

		if (!properties.containsKey("object_name")) {
			properties.put("object_name", document.getName());
		}
		try {
			return RestTransformation.convertJsonObject(restClientX.createContentfulDocument(folder, data, "text/*",
					new PlainRestObject("dm_document", properties)), DocumentumDocument.class);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new DocumentCreationException(
					"Unable to instantiate class of type " + DocumentumDocument.class.getName());
		}
	}

	@Override
	public ArrayList<DocumentumProperty> getObjectProperties(String objectId) throws RepositoryNotAvailableException {
		return RestTransformation.convertJsonObject(restClientX.getObjectById(objectId)).getProperties();
	}

	@Override
	public ArrayList<DocumentumObject> getDocumentRelationsByRelationName(String objectId, String relationName,
			int pageNumber) throws RepositoryNotAvailableException, DocumentumException {
		return RestTransformation
				.convertCoreRSEntryList(restClientX.getDocumentAnnotations(objectId, relationName, pageNumber));
	}

	@Override
	public DocumentumObject createDocumentAnnotation(String documentId, byte[] content,
			HashMap<String, Object> properties) throws DocumentumException {
		JsonObject document = restClientX.getObjectById(documentId);

		if (!document.isDocument()) {
			throw new DocumentumException(documentId + " is not a document");
		}
		Integer pageNumberProperty = (Integer) properties.get("page_number");
		if (pageNumberProperty == null) {
			throw new DocumentumException("annotation page number is missing.");
		}
		List<String> keywords = new ArrayList<String>();
		keywords.add("page_number = " + pageNumberProperty);

		String annotationNameProperty = (String) properties.get("annotation_name");
		String annotationName = (annotationNameProperty == null)
				? documentId + "_Annot_" + ((int) (Math.random() * 10000)) : annotationNameProperty;

		String folderIdproperty = (String) properties.get("folder_id");
		JsonObject folder;
		if (folderIdproperty == null) {
			String folderUrl = document.getHref(LinkRelation.PARENT);
			String[] urlParts = folderUrl.split("/");
			folderIdproperty = urlParts[urlParts.length - 1];
		}
		folder = restClientX.getObjectById(folderIdproperty);

		String formatProperty = (String) properties.get("format");
		String format = formatProperty == null ? "crtext" : formatProperty;
		HashMap<String, Object> creationProperties = new HashMap<>();
		creationProperties.put(DocumentumProperties.OBJECT_NAME, annotationName);
		creationProperties.put(DocumentumProperties.CONTENT_TYPE, format);
		creationProperties.put(DocumentumProperties.KEYWORDS, keywords);
		PlainRestObject noteCreation = new PlainRestObject("dm_note", creationProperties);

		DocumentumObject note = RestTransformation
				.convertJsonObject(restClientX.createContentfulObject(folder, content, "text/*", noteCreation));

		HashMap<String, Object> relationShipProperties = new HashMap<>();
		relationShipProperties.put("relation_name", "DM_ANNOTATE");
		relationShipProperties.put("parent_id", documentId);
		relationShipProperties.put("child_id", note.getId());
		relationShipProperties.put("permanent_link", true);
		PlainRestObject relationshipCreation = new PlainRestObject("dm_relation", relationShipProperties);

		restClientX.createRelationShip(relationshipCreation);

		return note;
	}

	@Override
	public ArrayList<DocumentumObject> getRenditionsByDocumentId(String doumentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumObject renameObject(String objectId, String newName) throws ObjectNotFoundException {
		JsonObject object = restClientX.getObjectById(objectId);
		if (object == null) {
			throw new ObjectNotFoundException(objectId);
		}
		JsonObject updatedObject = restClientX.update(object,
				Collections.<String, Object>singletonMap(DocumentumProperties.OBJECT_NAME, newName));
		return RestTransformation.convertJsonObject(updatedObject);
	}

	@Override
	public DocumentumObject updateProperties(String objectId, Map<String, Object> newProperties)
			throws ObjectNotFoundException {
		JsonObject object = restClientX.getObjectById(objectId);
		if (object == null) {
			throw new ObjectNotFoundException(objectId + " not found.");
		}
		return RestTransformation.convertJsonObject(restClientX.update(object, newProperties));
	}

	@Override
	public DocumentumObject addCommentToDocument(String documentId, String comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override

	public ArrayList<DocumentumObject> getDocumentComments(String documentId, String relationName)
			throws DocumentumException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentumObject copyObject(String objectId, String targetFolderId)
			throws DocumentumException, RepositoryNotAvailableException {
		if (objectId.equals(targetFolderId)) {
			throw new DocumentumException("source object equals target folder Id .");
		}
		JsonObject object = restClientX.getObjectById(objectId);
		if (object == null) {
			throw new ObjectNotFoundException("object " + objectId + " not found.");
		}
		JsonObject targetFolder = restClientX.getObjectById(targetFolderId);
		if (targetFolderId == null) {
			throw new ObjectNotFoundException("target folder " + targetFolderId + " not found.");
		}
		if (!targetFolder.isFolder()) {
			throw new DocumentumException(targetFolderId + " is not a folder.");
		}
		return RestTransformation.convertJsonObject(restClientX.copy(object, targetFolder));
	}

	@Override
	public DocumentumObject moveObject(String objectId, String targetFolderId)
			throws DocumentumException, RepositoryNotAvailableException {
		if (objectId.equals(targetFolderId)) {
			throw new DocumentumException("source object equals target folder Id .");
		}
		JsonObject object = restClientX.getObjectById(objectId);
		if (object == null) {
			throw new ObjectNotFoundException("object " + objectId + " not found.");
		}
		JsonObject targetFolder = restClientX.getObjectById(targetFolderId);
		if (targetFolderId == null) {
			throw new ObjectNotFoundException("target folder " + targetFolderId + " not found.");
		}
		if (!targetFolder.isFolder()) {
			throw new DocumentumException(targetFolderId + " is not a folder.");
		}
		restClientX.move(object, targetFolder);
		object = restClientX.getObjectById(objectId);
		return RestTransformation.convertJsonObject(object);

	}

}
