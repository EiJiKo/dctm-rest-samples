## DCTM Rest Samples

The following guide describes how to setup your Document Integration Layer

---
## 1. Project Dependencies

* Documentum Installation including the Documentum Core Rest 7.3 and EMC CMIS 1.1 applications
* [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) to compile the code
* [Spring Tool Suite (STS) ](https://spring.io/tools/sts/all) which includes a built-in functionality to run the Spring Boot Application.

## 2. Getting Started

Clone the repository to your local environment. The repository currently contains two projects :-
1. `Rest-Sample-User-1` ( needs to be renamed soon ie: `DocumentumIntegrationLayer`) Which provides the Rest Microservices integrating with the configured repositories.
2. `D2FS Client` ( Soap Client used for D2 Integration )

##### Cloning the Repository

Use git to clone the repository into a new folder

    git clone https://github.com/mmohen/dctm-rest-samples.git ./IntegrationLayer

##### Building the Application

Import the projects into your STS workspace and load them as existing maven projects
![alt tag](https://cloud.githubusercontent.com/assets/17758685/14206005/370bb9fa-f810-11e5-9b7a-a2f44d7beedd.PNG)

Import the two projects

![alt tag](https://cloud.githubusercontent.com/assets/17758685/14206006/370bc404-f810-11e5-9174-9f7a8f7be80f.PNG)

Edit the Spring Project's [application.properties](https://github.com/mmohen/dctm-rest-samples/blob/master/Rest-Sample-User-1/src/main/resources/application.properties) file which contains the configuration for the Core REST & CMIS Application. 

Make sure that the link used to reference the ACS Server can be referenced from your machine, if you are using the Documentum Developer Image the host name will be demo-server you can edit as an entry in your hosts file pointing to the ACS Server


## 2. Spring Boot Application

After configuring your link to the repositoris, Run the `Rest-Sample-User-1` Project as a Spring Boot App

![spring-boot](https://cloud.githubusercontent.com/assets/17758685/14206282/61092344-f812-11e5-9fc1-ec83a836d096.PNG)


##### Testing the application

Use the following endpoints to get a list of cabinets avilable for the configured used

`http://localhost:8080/cmis/services/get/cabinets`
`http://localhost:8080/corerest/services/get/cabinets`

You should get a response similar to this

	[
	  {
		"id": "0c0007c280000104",
		"name": "postgres",
		"type": "Cabinet",
		"properties": {
		  "cmis:objectId": "0c0007c280000104",
		  "cmis:path": "/postgres",
		  "cmis:allowedChildObjectTypeIds": [
			"cmis:folder",
			"cmis:document"
		  ],
		  "cmis:name": "postgres",
		  "cmis:lastModifiedBy": "postgres",
		  "cmis:objectTypeId": "dm_cabinet",
		  "cmis:lastModificationDate": 1393801987000,
		  "cmis:baseTypeId": "cmis:folder",
		  "cmis:createdBy": "postgres",
		  "cmis:creationDate": 1393801987000
		},
		"checkedOut": false
	  },
	  {
		"id": "0c0007c280000105",
		"name": "dmadmin",
		"type": "Cabinet",
		"properties": {
		  "cmis:objectId": "0c0007c280000105",
		  "cmis:path": "/dmadmin",
		  "cmis:allowedChildObjectTypeIds": [
			"cmis:folder",
			"cmis:document"
		  ],
		  "cmis:name": "dmadmin",
		  "cmis:lastModifiedBy": "postgres",
		  "cmis:objectTypeId": "dm_cabinet",
		  "cmis:lastModificationDate": 1393801987000,
		  "cmis:baseTypeId": "cmis:folder",
		  "cmis:createdBy": "postgres",
		  "cmis:creationDate": 1393801987000
		},
		"checkedOut": false
	  },
	  {
		"id": "0c0007c280000107",
		"name": "Temp",
		"type": "Cabinet",
		"properties": {
		  "cmis:objectId": "0c0007c280000107",
		  "cmis:path": "/Temp",
		  "cmis:allowedChildObjectTypeIds": [
			"cmis:folder",
			"cmis:document"
		  ],
		  "cmis:name": "Temp",
		  "cmis:lastModifiedBy": "postgres",
		  "cmis:objectTypeId": "dm_cabinet",
		  "cmis:lastModificationDate": 1393801988000,
		  "cmis:baseTypeId": "cmis:folder",
		  "cmis:createdBy": "postgres",
		  "cmis:creationDate": 1393801988000
		},
		"checkedOut": false
	  }
	]



