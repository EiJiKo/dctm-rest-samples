package com.emc.documentum.services.rest;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.emc.documentum.delegates.DocumentumRepositoryDelegate;
import com.emc.documentum.model.UserModel;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;

@CrossOrigin(origins = "*")
@RestController
public class FileManagerController {

	@Autowired
	DocumentumRepositoryDelegate dcRestDelegate;

	@RequestMapping("/Hello")
	public String indexTwo() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserModel> result = restTemplate.exchange(
				"http://192.168.210.128:8080/dctm-rest/repositories/MyRepo/currentuser", HttpMethod.GET,
				new HttpEntity<String>(createHeaders("dmadmin", "password")), UserModel.class);
		System.out.println(result.getBody());
		System.out.println(result.getBody().getName());
		return result.getBody().getName();
	}

	HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

	@RequestMapping(value = "/api/listUrl", method = RequestMethod.POST, headers = "Content-Type=application/json;charset=UTF-8")
	public String listURL(@RequestBody String jsonString) {


		JSONObject jsonRequest = null;
		JSONObject jsonRequestParams = null;
		JSONObject resultJson = null ;
		
		try {
			jsonRequest = (JSONObject) JSONValue.parseWithException(jsonString);
			jsonRequestParams = (JSONObject) jsonRequest.get("params");
			String folderId = (String) jsonRequestParams.get("folderId");
			System.out.println(jsonRequestParams);
			System.out.println("folder id " + folderId);
			
			if (folderId == null || folderId.equals("")) {
				//folderId = "0c0007c280000130";
				System.out.println("-----getting cabinets : " + folderId);
				resultJson = dcRestDelegate.getAllCabinetsForFileManager();
			}
			else
			{
				System.out.println("-----getting children for folder ID : " + folderId);
				resultJson = dcRestDelegate.getChildrenForFileManager(folderId);
			}
			return resultJson.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}

	@RequestMapping(value = "/api/renameUrl", method = RequestMethod.POST)
	public String renameUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/copyUrl", method = RequestMethod.POST)
	public String copyUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/removeUrl", method = RequestMethod.POST)
	public String removeUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/editUrl", method = RequestMethod.POST)
	public String editUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/createFolderUrl", method = RequestMethod.POST)
	public String createFolderUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/permissionsUrl", method = RequestMethod.POST)
	public String permissionsUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/extractUrl", method = RequestMethod.POST)
	public String extractUrl() {
		return commonResponse();
	}

	@RequestMapping(value = "/api/uploadUrl", method = RequestMethod.POST)
	public String uploadUrl() {
		return commonResponse();
	}

	// TODO getContentUrl
	// TODO downloadFileUrl

	String commonResponse() {
		JSONObject resultJson = new JSONObject();
		JSONObject json = new JSONObject();
		json.put("success", true);
		json.put("error", null);

		resultJson.put("result", json);
		return resultJson.toJSONString();
		// return "{ \"result\": { \"success\": true, \"error\": null } }" ;
	}
}