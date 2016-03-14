package com.emc.documentum.services.rest;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.emc.documentum.model.UserModel;

@CrossOrigin(origins = "*")
@RestController
public class FileManagerController {

	@CrossOrigin(origins = "*")
	@RequestMapping("/Hello")
	public String indexTwo() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserModel> result = restTemplate.exchange("http://192.168.210.128:8080/dctm-rest/repositories/MyRepo/currentuser", HttpMethod.GET, new HttpEntity<String>(createHeaders("dmadmin", "password")), UserModel.class);
		//result.getHeaders().add("Access-Control-Allow-Origin", "*");
		//result.getHeaders().add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
		//result.getHeaders().add("Access-Control-Allow-Methods" , "POST, GET, PUT, DELETE, OPTIONS");
		System.out.println(result.getBody());
		System.out.println(result.getBody().getName());
		return result.getBody().getName() ;
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
		
		
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/listUrl", method = RequestMethod.POST)
	public String listURL() {
		/*JsonObject json = new JsonObject() ;
		HashMap<String,Object> props = new HashMap<String , Object>() ;
		props.put("result", \"[ {        "name": "joomla",        "rights": "drwxr-xr-x",        "size": "4096",        "date": "2015-04-29 09:04:24",        "type": "dir"    }, {        "name": "magento",        "rights": "drwxr-xr-x",        "size": "4096",        "date": "17:42",        "type": "dir"    }, {        "name": "index.php",        "rights": "-rw-r--r--",        "size": "549923",        "date": "2013-11-01 11:44:13",        "type": "file"    }]\") ;
		json.setProperties(props);
		return json ;*/
		return "{\"result\": [{\"name\": \"joomla\",\"rights\": \"drwxr-xr-x\",\"size\": \"4096\",\"date\": \"2015-04-29 09:04:24\",\"type\":\"dir\"},{\"name\": \"magento\",\"rights\":\"drwxr-xr-x\",\"size\": \"4096\",\"date\": \"2011-02-19 05:02:04\",\"type\": \"dir\"},{\"name\": \"index.php\",\"rights\": \"-rw-r--r--\",\"size\":\"549923\",\"date\": \"2013-11-01 11:44:13\",\"type\": \"file\"}]}" ;
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/renameUrl", method = RequestMethod.POST)
	public String renameUrl() {
		return commonResponse() ;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/copyUrl", method = RequestMethod.POST)
	public String copyUrl() {
		return commonResponse() ;
	}
	

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/removeUrl", method = RequestMethod.POST)
	public String removeUrl() {
		return commonResponse() ;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/editUrl", method = RequestMethod.POST)
	public String editUrl() {
		return commonResponse() ;
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/createFolderUrl", method = RequestMethod.POST)
	public String createFolderUrl() {
		return commonResponse() ;
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/permissionsUrl", method = RequestMethod.POST)
	public String permissionsUrl() {
		return commonResponse() ;
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/extractUrl", method = RequestMethod.POST)
	public String extractUrl() {
		return commonResponse() ;
	}

	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/uploadUrl", method = RequestMethod.POST)
	public String uploadUrl() {
		return commonResponse() ;
	}

	//TODO getContentUrl
	//TODO downloadFileUrl
		
	String commonResponse()
	{
		return "{ \"result\": { \"success\": true, \"error\": null } }" ;
	}
}