package com.emc.Main;

import com.emc.d2fs.constants.D2fsConstants;
import com.emc.d2fs.models.context.Context;
import com.emc.d2fs.models.node.Node;
import com.emc.d2fs.models.repository.Repository;
import com.emc.d2fs.schemas.models.ModelPort;
import com.emc.d2fs.schemas.models.ModelPortService;
import com.emc.d2fs.services.browser_service.GetBrowserContentRequest;
import com.emc.d2fs.services.browser_service.GetBrowserContentResponse;
import com.emc.d2fs.services.repository_service.CheckLoginRequest;
import com.emc.d2fs.services.repository_service.CheckLoginResponse;
import com.emc.d2fs.services.repository_service.GetRepositoryRequest;

public class Main {
	static ModelPortService service = new ModelPortService();

	public void main(String[] args) {
		
		try {
			doWsSample("repo1", "dmadmin", "d3m04doc", "some unique session identifier", "http://10.76.133.134:8080/D2");
			} catch (Exception e) {
			e.printStackTrace();
			}
	}

	public static void doWsSample(String repositoryId, String login, String password, String uid, String webAppUrl) {
		try {
			System.out.println("Retrieving the port from the following	service: " + service);
			ModelPort port = service.getModelPortSoap11();
			System.out.println("Invoking operation on the port.");
			// Get the repository information from the docbroker
			GetRepositoryRequest repoReq = new GetRepositoryRequest();
			repoReq.setId(repositoryId);
			Repository repo = port.getRepository(repoReq).getRepository();
			if (repo == null)
				System.out.println("could not connect to repository: " + repositoryId);
			Context context = new Context();
			context.setRepository(repo);
			context.setLogin(login);
			context.setPassword(password);
			context.setUid(uid);
			context.setWebAppURL(webAppUrl);
			// Validate user credentials
			CheckLoginRequest checkLoginRequest = new CheckLoginRequest();
			checkLoginRequest.setContext(context);
			CheckLoginResponse checkLoginResponse = port.checkLogin(checkLoginRequest);
			if (!checkLoginResponse.isResult())
				System.out.println("login failed");
			GetBrowserContentRequest getBrowserContentRequest = new GetBrowserContentRequest();
			getBrowserContentRequest.setContext(context);
//			getBrowserContentRequest.setContentTypeName(D2fsConstants.ROOT);
//			GetBrowserContentResponse response = port.getBrowserContent(getBrowserContentRequest);
//			System.out.println("root nodes:");
//			for (Node node : response.getNode().getNodes()) {
//				System.out.printf(" id:%s type:%s label:%s\n", node.getId(), node.getType(), node.getLabel());
//			}
			// Get cabinets in the repository
			getBrowserContentRequest.setContext(context);
			getBrowserContentRequest.setId("0b00000180067f58");
			getBrowserContentRequest.setContentTypeName(D2fsConstants.FOLDER);
			GetBrowserContentResponse response = port.getBrowserContent(getBrowserContentRequest);
			System.out.println("cabinets in repository " + repositoryId + ":");
			for (Node node : response.getNode().getNodes()) {
				System.out.printf(" id:%s type:%s label:%s\n", node.getId(), node.getType(), node.getLabel());
			}
			// Get contents of the user home cabinet
//			String homeId = null;
//			for (Node node : response.getNode().getNodes()) {
//				if (node.getLabel().equals("Concordant Policies")) {
//					homeId = node.getId();
//					break;
//				}
//			}
//			if (homeId != null) {
//				getBrowserContentRequest.setContext(context);
//				getBrowserContentRequest.setId(homeId);
//				getBrowserContentRequest.setContentTypeName(D2fsConstants.FOLDER);
//				response = port.getBrowserContent(getBrowserContentRequest);
//				System.out.println("home cabinet contents:");
//				for (Node node : response.getNode().getNodes()) {
//					System.out.printf(" id:%s type:%s label:%s\n", node.getId(), node.getType(), node.getLabel());
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
