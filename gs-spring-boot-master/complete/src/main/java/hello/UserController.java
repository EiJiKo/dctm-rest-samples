package hello;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dto.UserModel;

@RestController
public class UserController {

	@CrossOrigin(origins = "*")
	@RequestMapping("/Hello")
	public String indexTwo() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserModel> result = restTemplate.exchange("http://192.168.210.128:8080/dctm-rest/repositories/MyRepo/currentuser", HttpMethod.GET, new HttpEntity<String>(createHeaders("dmadmin", "password")), UserModel.class);
		//ResponseEntity<String> result = restTemplate.exchange("http://192.168.210.128:8080/dctm-rest/repositories/MyRepo/currentuser", HttpMethod.GET, new HttpEntity<String>(createHeaders("dmadmin", "password")), String.class);
		//String result = restTemplate.getForObject("http://192.168.210.128:8080/dctm-rest/repositories/MyRepo/currentuser", String.class);
		// return "Hello yabo7meed";
		
		//result.getHeaders().add("Access-Control-Allow-Origin", "*");
		//result.getHeaders().add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Referer, User-Agent");
		//result.getHeaders().add("Access-Control-Allow-Methods" , "POST, GET, PUT, DELETE, OPTIONS");
		System.out.println(result.getBody());
		System.out.println(result.getBody().getUserprop().getAcl_name());
		return result.getBody().getUserprop().getAcl_name() ;
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
}