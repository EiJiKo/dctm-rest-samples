package com.emc.documentum.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class DCD2Constants {
	
	@Value("${documentum.D2.host}")
	public  String host;

	@Value("${documentum.D2.port}")
	public  String port;
	
	@Value("${documentum.D2.repo}")
	public  String repo;

	@Value("${documentum.D2.username}")
	public  String username;
	@Value("${documentum.D2.password}")
	public  String password;
	
	@Value("${documentum.D2.UID}")
	public String UID;
}
