## DCTM Rest Samples

### The following guide describes how to setup your project so that it connects to Documentum via Core Rest and CMIS.
---
## 1. Documentum Image

A documentum image with the following applications needs to be available
 1. Documentum Rest 7.3
 2. EMC CMIS 1.1
 
The [application.properties](https://github.com/mmohen/dctm-rest-samples/blob/master/Rest-Sample-User-1/src/main/resources/application.properties) file contains the details for the documentum image. Make sure that the Link used by Core-Rest to download content can be resolved from the project run-time. Ex: The Developer machine returns the following when accessing a document

`http://demo-server:9080/ACS/servlet/ACS?command=read&version=2.3&docbaseid=0007c2&basepath=%2Fopt%2Fdctm%2Fdata%2FMyRepo%2Fcontent_storage_01%2F000007c2&filepath=80%2F00%2F04%2F7a.docx&objectid=090007c2800041f8&cacheid=dAAEAgA%3D%3DegQAgA%3D%3D&format=msw12&pagenum=0&signature=aXBsVSzwjiyH2F%2Bammzm%2B8Zs3vFdsoLyYHXGQJKhxSJxQbKIN8jK8%2BOMx67LilWrbw8FrJp8xBPLzIny2IdRgOp%2BOnof8yqNrp7X8DU6%2B%2BqjOOqkXv3P15M3G11i02F6z3ojmAkBtJJErKCMCMJ95xDKmWqc1JtsQlrILIMl8AY%3D&servername=demo-serverACS1&mode=1&timestamp=1457608451&length=12758&mime_type=application%2Fvnd.openxmlformats-officedocument.wordprocessingml.document&parallel_streaming=true&expire_delta=360`

Solve this by Adding the entry `demo-server` to your machine's hosts file pointing to the documentum image.

## 2. Spring Boot Application

After cloning the repository. Using Spring Tool Suite, you can update & build the maven project. Run the Application by performing a right-click on the project. Run-As and click Spring Boot App.



