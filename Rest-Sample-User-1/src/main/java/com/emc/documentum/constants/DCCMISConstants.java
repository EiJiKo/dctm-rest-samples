package com.emc.documentum.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class DCCMISConstants {
	@Value("${documentum.cmis.host}")
	public  String host;

	@Value("${documentum.cmis.port}")
	public  String port;
	
	@Value("${documentum.cmis.repo}")
	public  String repo;

	@Value("${documentum.cmis.username}")
	public  String username;
	@Value("${documentum.cmis.password}")
	public  String password;

}
