# Tetra_Proxima

#### BTP Training - Test applications (28/02/2024)
#### Maven Repository : https://mvnrepository.com/
#### Ui5 Libray : https://sapui5.hana.ondemand.com/#/controls  
#### Spring framework reference documentation : https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/htmlsingle/

 </br>
 </br>


 http://localhost:8080/APP_end_point_name 

 </br>
 </br>
 
https://developers.sap.com/tutorials/btp-cf-buildpacks-java-create.html

https://github.com/SAP/btp-environment-variable-access

https://help.sap.com/docs/btp/sap-business-technology-platform/developing-java-in-cloud-foundry-environment

https://github.com/SAP/cloud-security-services-integration-library/blob/main/java-security/README.md

 </br>
 </br>
 
### Steps for Postgre DB integration : 
 <p>
 </br>
1. Add conenction properties for our postgre DB running locally
 </br>
 </br>
2. We need annotations to our POJO class to specify that our class will act like and entity.
   </br>
   We need to add annotations which will also tell JPA taht my entity have a primary key and colums.
   </br>
   It may so happen that your class property name and your DB columns names may different. EG. @Emtoty ,@Id
 </br>
 </br>
3. We need to add a special interface which inherits from JPARepository interface, which will proovide all the runtime           
   capabilities (CURDQ - Create, Update, Read, Delete, Query).
 </br>
 </br>
4. Replace hardcoded data in our service class with Read DB Operations. 
 </br>
  </br>
  </p>

