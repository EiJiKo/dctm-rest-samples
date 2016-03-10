package com.emc.documentum.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class DCRestAPIWrapperData {

	@Value("${documentum.host}")
	public  String host;

	@Value("${documentum.repo}")
	public  String repo;

	@Value("http://${documentum.host}:8080/dctm-rest/repositories/${documentum.repo}/currentuser")
	public  String currentUserURI;
	@Value("http://${documentum.host}:8080/dctm-rest/repositories/${documentum.repo}?dql=")
	public  String dqlQuery;
	@Value("http://${documentum.host}:8080/dctm-rest/repositories/${documentum.repo}/objects")
	public  String fetchObjectUri;
	@Value("${documentum.username}")
	public  String username;
	@Value("${documentum.password}")
	public  String password;
	@Value("http://${documentum.host}:8080/dctm-rest/repositories/${documentum.repo}/cabinets")
	public  String fetchCabinetURI;

}