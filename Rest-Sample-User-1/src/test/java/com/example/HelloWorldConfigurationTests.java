package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.emc.documentum.RestSampleUser1Application;

import net.minidev.json.JSONObject;

/**
 * Basic integration tests for service demo application.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestSampleUser1Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0", "management.port=0" })
@DirtiesContext
public class HelloWorldConfigurationTests {

	@Value("${local.server.port}")
	private int port;

	@Test
	public void testGreeting() throws Exception {
		JSONObject response = null ;
		ResponseEntity<JSONObject> entity = new TestRestTemplate().postForEntity("http://localhost:" + this.port + "/api/removeUrl", response , JSONObject.class);
		response = entity.getBody() ;
		Assert.assertNotEquals(null , response);
		//ResponseEntity<JSONObject> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/api/removeUrl", JSONObject.class);		
		//assertEquals(HttpStatus.OK, response.get("success"));
	}
}
