package com.emc.documentum.wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.codehaus.groovy.classgen.GeneratorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.emc.d2fs.constants.D2fsConstants;
import com.emc.d2fs.models.attribute.Attribute;
import com.emc.d2fs.models.context.Context;
import com.emc.d2fs.models.item.Item;
import com.emc.d2fs.models.node.Node;
import com.emc.d2fs.models.repository.Repository;
import com.emc.d2fs.schemas.models.ModelPort;
import com.emc.d2fs.schemas.models.ModelPortService;
import com.emc.d2fs.services.browser_service.GetBrowserContentRequest;
import com.emc.d2fs.services.browser_service.GetBrowserContentResponse;
import com.emc.d2fs.services.content_service.GetDQLContentRequest;
import com.emc.d2fs.services.content_service.GetDQLContentResponse;
import com.emc.d2fs.services.property_service.GetPropertiesRequest;
import com.emc.d2fs.services.property_service.GetPropertiesResponse;
import com.emc.d2fs.services.repository_service.CheckLoginRequest;
import com.emc.d2fs.services.repository_service.CheckLoginResponse;
import com.emc.d2fs.services.repository_service.GetRepositoryRequest;
import com.emc.documentum.constants.DCD2Constants;
import com.emc.documentum.exceptions.RepositoryNotAvailableException;
import com.emc.documentum.model.JsonEntry;
import com.emc.documentum.model.JsonFeed;

@Component("DCD2APIWrapper")
public class DCD2APIWrapper {
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());

	@Autowired
	DCD2Constants data;

	ModelPortService service = new ModelPortService();

	public List<Item> getAllCabinets() throws RepositoryNotAvailableException {
		try {
			ModelPort port = getPort();
			Context context = getContext(port,data.repo,data.username,data.password,data.UID);
			// Validate user credential
			CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
			checkLoginRequest.setContext(context);
			CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
			if (!checkLoginResponse.isResult())
				System.out.println("login failed");
			GetDQLContentRequest r = new GetDQLContentRequest();
			r.setContext(context);
			r.setDql("select * from dm_cabinet");
			GetDQLContentResponse response = port.getDQLContent(r);
			if (response.getDocItems() != null && response.getDocItems().getItems()!=null)
				return response.getDocItems().getItems();
			throw new RepositoryNotAvailableException(data.repo);

		} catch (Exception e) {
			throw new RepositoryNotAvailableException(data.repo);
		}

	}
	
	public List<Item> getChildren(String folderId) {
		ModelPort port = getPort();
		Context context = getContext(port,data.repo,data.username,data.password,data.UID);
		// Validate user credentials
		CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
		checkLoginRequest.setContext(context);
		CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
		if (!checkLoginResponse.isResult())
			System.out.println("login failed");
		GetBrowserContentRequest request = new GetBrowserContentRequest();
		GetDQLContentRequest r = new GetDQLContentRequest();
		r.setContext(context);
		r.setDql("select *,r_lock_owner from dm_folder where  FOLDER(ID('" + folderId
				+ "')) union select *,r_lock_owner from dm_document where FOLDER(ID('" + folderId + "'))");
		GetDQLContentResponse response = port.getDQLContent(r);
		return response.getDocItems().getItems();

	}

	public List<Item> getChildren(String folderId, int pageNumber, int pageSize) {
		ModelPort port = getPort();
		Context context = getContext(port, data.repo, data.username, data.password, data.UID);
		// Validate user credentials
		CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
		checkLoginRequest.setContext(context);
		CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
		if (!checkLoginResponse.isResult())
			System.out.println("login failed");
		GetBrowserContentRequest request = new GetBrowserContentRequest();
		GetDQLContentRequest r = new GetDQLContentRequest();
		r.setContext(context);
		r.setDql("select *,r_lock_owner from dm_folder where  FOLDER(ID('" + folderId
				+ "')) union select *,r_lock_owner from dm_document where FOLDER(ID('" + folderId + "'))");
		GetDQLContentResponse response = port.getDQLContent(r);
		List<Item> returnedNodes = new ArrayList<>();
		List<Item> responseNodes = response.getDocItems().getItems();
		for (int i = ((pageNumber - 1) * pageSize); i < responseNodes.size() && i < (pageNumber * pageSize); i++)
			returnedNodes.add(responseNodes.get(i));
		return returnedNodes;

	}

	public List<Attribute> getObjectProperties(String objectId) {
		ModelPort port = getPort();
		Context context = getContext(port, data.repo, data.username, data.password, data.UID);

		GetPropertiesRequest req = new GetPropertiesRequest();
		req.setContext(context);
		req.setId(objectId);
		GetPropertiesResponse res = port.getProperties(req);
		return res.getAttributes();
	}

	private ModelPort getPort() {
		return service.getModelPortSoap11();
	}

	private Context getContext(ModelPort port, String repoId, String username, String password, String UID) {

		System.out.println("Invoking operation on the port.");
		// Get the repository information from the docbroker
		String host = data.host + ":" + data.port + "/D2";
		GetRepositoryRequest repoReq = new GetRepositoryRequest();
		repoReq.setId(repoId);
		Repository repo = port.getRepository(repoReq).getRepository();
		if (repo == null)
			System.out.println("could not connect to repository: " + repoId);
		Context context = new Context();
		context.setRepository(repo);
		context.setLogin(username);
		context.setPassword(password);
		context.setUid(UID);
		context.setWebAppURL(host);
		return context;
	}
}
