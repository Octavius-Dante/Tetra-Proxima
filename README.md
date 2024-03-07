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


### Spring Boot Connect to PostgreSQL Database Examples 

https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples
</br>
https://studygyaan.com/spring-boot/how-to-connect-postgresql-database-in-spring-boot-project

</br>
</br>

## Spring Boot + PostgreSQL + UUID String
</br>

It’s easy to use UUID String as Primary Key when you are using PostgreSQL database.
</br>
To archive this, just configure your Entity to use UUID2 generator.
</br>

```java

@Id
@GenericGenerator(name = "uuid2", strategy = "uuid2")
@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
@Column(length = 36, nullable = false, updatable = false)
private String id;

```
 </br>
 </br>
 </br>


## Shortcut keys  
 </br>
 </br>
 Ctrl + Shift + F  -- Code Alignment 
 </br>
 Ctrl + Shift + C  -- Code comments 
 </br>
 Ctrl + Shift + T -- Open Type window
 </br>
 Ctrl + Shift + L -- Show key assist
 
 </br> 
 </br>
 </br>
https://www.baeldung.com/spring-data-jpa-batch-inserts
</br>
</br>
