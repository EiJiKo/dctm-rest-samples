package com.emc.documentum.wrappers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.OperationContext;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.apache.chemistry.opencmis.client.api.QueryStatement;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.OperationContextImpl;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.exceptions.CmisConnectionException;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.emc.documentum.dtos.DocumentumFolder;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;
import com.emc.documentum.model.UserModel;

@Component("DCCMISAPIWrapper")
public class DCCMISAPIWrapper {

	Logger log = Logger.getLogger(this.getClass().getCanonicalName());

	private Session getSession(String username, String password) {
			SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
			Map<String, String> parameter = new HashMap<String, String>();
			parameter.put(SessionParameter.USER, username);
			parameter.put(SessionParameter.PASSWORD, password);
			parameter.put(SessionParameter.ATOMPUB_URL, "http://documentum:8080/emc-cmis/resources");
			parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
			List<Repository> repositories = new ArrayList<Repository>();
			repositories = sessionFactory.getRepositories(parameter);
			for (Repository r : repositories) {
				System.out.println("Found repository: " + r.getName());
			}

			// create session with the first (and only) repository
			Repository repository = repositories.get(0);
			parameter.put(SessionParameter.REPOSITORY_ID, repository.getId());
			Session session = sessionFactory.createSession(parameter);
			return session;
	}

	public UserModel getUserInfo(String username, String password) {
		UserModel user = new UserModel();

		if (getSession(username, password) != null) {
			user.setName(username);
		}

		return user;
	}

	public Document createDocument(Folder folder, HashMap<String, Object> properties)
			throws RepositoryNotAvailableException {
		try {
			return folder.createDocument(properties, null, null);
		} catch (CmisConnectionException e) {
			throw new RepositoryNotAvailableException("CMIS", e);
		}
	}

	public Folder getFolderByPath(String queryFolderPath)
			throws FolderNotFoundException, RepositoryNotAvailableException {
		try {
			return (Folder) (getSession("dmadmin", "password")).getObjectByPath(queryFolderPath);
		} catch (CmisConnectionException e) {
			throw new RepositoryNotAvailableException("CMIS", e);
		}
	}

	public ArrayList<DocumentumFolder> getAllCabinets() throws RepositoryNotAvailableException {
		try {
			Session session = getSession("dmadmin", "password");
			Folder rootFolder = session.getRootFolder();
			ItemIterable<CmisObject> children = rootFolder.getChildren();
			ArrayList<DocumentumFolder> navigationObjects = new ArrayList<>();
			for (CmisObject o : children) {
				navigationObjects.add(new DocumentumFolder(o.getId(), o.getName(), o.getType().getDisplayName()));
			}
			return navigationObjects;
		} catch (CmisConnectionException e) {
			throw new RepositoryNotAvailableException("CMIS", e);
		}
	}

	public ArrayList<DocumentumObject> getChildren(String folderId) throws RepositoryNotAvailableException {
		try {
			Session session = getSession("dmadmin", "password");
			Folder rootFolder = (Folder) session.getObject(folderId);
			ItemIterable<CmisObject> children = rootFolder.getChildren();
			ArrayList<DocumentumObject> navigationObjects = new ArrayList<>();
			for (CmisObject o : children) {
				navigationObjects.add(new DocumentumObject(o.getId(), o.getName(), o.getType().getDisplayName()));
			}
			return navigationObjects;
		} catch (CmisConnectionException e) {
			throw new RepositoryNotAvailableException("CMIS", e);
		}
	}

	public byte[] getDocumentContentById(String documentId)
			throws DocumentNotFoundException, RepositoryNotAvailableException {
		try {
			Session session = getSession("dmadmin", "password");
			Document document = (Document) session.getObject(documentId);

			System.out.println(document.getContentStreamLength());
			System.out.println(document.getContentStream().getLength());
			byte[] fileContent = IOUtils.toByteArray(document.getContentStream().getStream());
			byte[] encodedfile = Base64.encodeBase64(fileContent);
			System.out.println(encodedfile);
			return encodedfile;

		} catch (CmisConnectionException e) {
			throw new RepositoryNotAvailableException("CMIS", e);
		} catch (IOException e) {
			log.log(Level.SEVERE, "IO Exception while reading dm_document input stream", e);
			return new byte[0];
		}
	}

	public Folder createFolder(Folder folder, Map<String, ?> properties) throws RepositoryNotAvailableException {
		try {
			return folder.createFolder(properties);
		} catch (CmisConnectionException e) {
			throw new RepositoryNotAvailableException("CMIS", e);
		}
	}

	public Folder createFolder(Folder folder, String folderName) throws RepositoryNotAvailableException {
		try {
			HashMap<String, Object> properties = new HashMap<String, Object>();
			properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:folder");
			properties.put(PropertyIds.NAME, folderName);
			return createFolder(folder, properties);
		} catch (CmisConnectionException e) {
			throw new RepositoryNotAvailableException("CMIS", e);
		}
	}

	public CmisObject getObjectById(String cabinetId) throws RepositoryNotAvailableException {
		try {
			return getSession("dmadmin", "password").getObject(cabinetId);
		} catch (CmisConnectionException e) {
			throw new RepositoryNotAvailableException("CMIS", e);
		}
	}

	public ItemIterable<QueryResult> getObjectsByName(String name) throws RepositoryNotAvailableException {
		try {
			String queryString = String.format("Select * from cmis:document where cmis:name like '%s'",
					"%" + name + "%");
			log.info("Executing Query " + queryString);
			QueryStatement queryStatement = getSession("dmadmin", "password").createQueryStatement(queryString);

			OperationContext operationContext = new OperationContextImpl();
			operationContext.setMaxItemsPerPage(20);
			ItemIterable<QueryResult> queryResult = queryStatement.query(false, operationContext);
			return queryResult;
		} catch (CmisConnectionException e) {
			throw new RepositoryNotAvailableException("CMIS", e);
		}
	}
	public Document checkoutDocument(String documentId)
	{
		Session session = getSession("dmadmin", "password");
		Document document = (Document) session.getObject(documentId);
		Document checkoutDocument = (Document) session.getObject(document.checkOut());
		return checkoutDocument;
	}
	public Document checkinDocument(String documentId,byte[] content)
	{
		Session session = getSession("dmadmin", "password");
		Document document = (Document) session.getObject(documentId);
		ContentStream contentStream = session.getObjectFactory().createContentStream(
				document.getContentStream().getFileName(), content.length,
				document.getContentStream().getMimeType(), new ByteArrayInputStream(content));
		document.checkIn(false, null, contentStream, "minor version");
		return document;
	}
}
