package com.emc.documentum.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.emc.documentum.RestSampleUser1Application;
import com.emc.documentum.dtos.DocumentumFolder;

/**
 * Unit Tests for Integration Layer
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestSampleUser1Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0", "management.port=0" })
@DirtiesContext
public abstract class IntegrationLayerTests {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${local.server.port}")
	private int port;

	protected abstract String getAPI();

	@Test
	public void testCabinetsRetrieval() throws Exception {
		DocumentumFolder[] cabinets = null;
		cabinets = retrieveCabinets(getAPI());
		Assert.assertTrue(getAPI() + " Zero Cabinets Returned", cabinets.length > 0);

	}

	@Test
	public void testCabinetsType() {
		DocumentumFolder[] cabinets = null;
		cabinets = retrieveCabinets(getAPI());
		for (DocumentumFolder folder : cabinets) {
			Assert.assertTrue(getAPI() + " : Cabinet Type not equal Cabinet", folder.getType().equals("Cabinet"));
		}

	}

	private DocumentumFolder[] retrieveCabinets(String api) {
		ResponseEntity<DocumentumFolder[]> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port + "/" + api + "/services/get/cabinets", DocumentumFolder[].class);
		return entity.getBody();
	}
}
