package com.emc.documentum.wrappers;

import java.io.IOException;
import java.io.InputStream;
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
import org.apache.chemistry.opencmis.commons.data.PropertyData;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.emc.documentum.constants.FolderConstants;
import com.emc.documentum.dtos.NavigationObject;
import com.emc.documentum.exceptions.DocumentNotFoundException;
import com.emc.documentum.exceptions.FolderNotFoundException;
import com.emc.documentum.model.UserModel;

@Component("DCCMISAPIWrapper")
public class DCCMISAPIWrapper {

	Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	Session session = getSession("dmadmin", "password");

	private Session getSession(String username, String password) {
		SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put(SessionParameter.USER, username);
		parameter.put(SessionParameter.PASSWORD, password);
		parameter.put(SessionParameter.ATOMPUB_URL, "http://documentum:8080/emc-cmis/resources/");
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

	public Document createDocument(Folder folder, HashMap<String, Object> properties) {
		return folder.createDocument(properties, null, null);
	}

	public Folder getFolderByPath(String queryFolderPath) throws FolderNotFoundException {
		return (Folder) session.getObjectByPath(queryFolderPath);
	}

	public ArrayList<NavigationObject> getAllCabinets() {
		Session session = getSession("dmadmin", "password");
		Folder rootFolder = session.getRootFolder();
		ItemIterable<CmisObject> children = rootFolder.getChildren();
		ArrayList<NavigationObject> navigationObjects = new ArrayList<>();
		for (CmisObject o : children) {
			navigationObjects.add(
					new NavigationObject(o.getId(), FolderConstants.ROOT, o.getName(), o.getType().getDisplayName()));
		}
		return navigationObjects;
	}

	public ArrayList<NavigationObject> getChildren(String folderId) {
		Session session = getSession("dmadmin", "password");
		Folder rootFolder = (Folder) session.getObject(folderId);
		ItemIterable<CmisObject> children = rootFolder.getChildren();
		ArrayList<NavigationObject> navigationObjects = new ArrayList<>();
		for (CmisObject o : children) {
			navigationObjects.add(new NavigationObject(o.getId(), folderId, o.getName(), o.getType().getDisplayName()));
		}
		return navigationObjects;
	}

	public byte[] getDocumentContentById(String documentId) throws DocumentNotFoundException {
		Session session = getSession("dmadmin", "password");
		Document document = (Document) session.getObject(documentId);

		// String fileContent;
		try {
			System.out.println(document.getContentStreamLength());
			System.out.println(document.getContentStream().getLength());

			// fileContent = getContentAsString(document.getContentStream());
			// System.out.println(fileContent.length());
			byte[] fileContent = IOUtils.toByteArray(document.getContentStream().getStream());
			byte[] encodedfile = Base64.encodeBase64(fileContent);
			System.out.println(encodedfile);
			return encodedfile;
		} catch (IOException e) {
			log.log(Level.SEVERE, "IO Exception while reading dm_document input stream", e);
		}

		return new byte[0];
	}

	private static String getContentAsString(ContentStream stream) throws IOException {
		InputStream in2 = stream.getStream();
		StringBuffer sbuf = null;
		sbuf = new StringBuffer(in2.available());
		int count;
		byte[] buf2 = new byte[100];
		while ((count = in2.read(buf2)) != -1) {
			for (int i = 0; i < count; i++) {
				sbuf.append((char) buf2[i]);
			}
		}
		in2.close();
		return sbuf.toString();
	}

	public Folder createFolder(Folder folder, Map<String, ?> properties) {
		return folder.createFolder(properties);
	}

	public Folder createFolder(Folder folder, String folderName) {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put(PropertyIds.OBJECT_TYPE_ID, "cmis:folder");
		properties.put(PropertyIds.NAME, folderName);
		return createFolder(folder, properties);
	}

	public CmisObject getObjectById(String cabinetId) {
		return session.getObject(cabinetId);
	}

	public ItemIterable<QueryResult> getObjectsByName(String name){
		String queryString = String.format("Select * from cmis:document where cmis:name like '%s'","%" +name + "%");
		log.info("Executing Query " + queryString);
		QueryStatement queryStatement = session.createQueryStatement(queryString);
		
		OperationContext operationContext = new OperationContextImpl();
		operationContext.setMaxItemsPerPage(20);
		ItemIterable<QueryResult> queryResult = queryStatement.query(false, operationContext);
		return queryResult;
	}

}
