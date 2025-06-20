## XSUAA - How to manually create an XSUAA service and service key using SAP documentation

</br>

### xsuaa architecture 

</br>
</br>   
https://learning.sap.com/learning-journey/discover-sap-business-technology-platform/illustrating-sap-authorization-and-trust-management-service-xsuaa-_b9fde282-4cff-4dca-b146-7c8f8dde9955
</br>
</br>   
https://sap.github.io/cloud-sdk/docs/java/guides/cloud-foundry-xsuaa-service
</br>   
</br>
https://community.sap.com/t5/technology-blogs-by-sap/demystifying-xsuaa-in-sap-cloud-foundry/ba-p/13468237

</br>   
</br>   

- [x] Create a New backing service instance for XSUAA 
- [x] While creating this instance we need to pass our Role Configuration (JSON) = xs-security.json
- [x] Documentation for making xs-security file
</br> https://help.sap.com/viewer/4505d0bdaf4948449b7f7379d24d0f0d/2.0.03/en-US/6d3ed64092f748cbac691abc5fe52985.html

- [x] We need to bind our app with this backing service
- [x] If we use Java, we need to add a security module (Spring) to restrict access to end points
</br> https://github.com/SAP/cloud-security-xsuaa-integration
- [x] Deploy and Test our app


</br>   
</br>   

## XSUAA  
</br>   
</br>   

### JSON file for creating xsuaa instance (Authorization and Trust Management Service)
</br>   
</br>   
   
   ```json
{
    "xsappname": "06springbtpdb",
    "scopes": [
        {
            "name": "$XSAPPNAME.Display",
            "description": "display"
        },
        {
            "name": "$XSAPPNAME.Edit",
            "description": "edit"
        }
    ],
    "role-templates": [
        {
            "name": "Viewer",
            "description": "View all DATA",
            "default-role-name": "Viewer: Authorized to Read All VENDOR",
            "scope-references": [
                "$XSAPPNAME.Display"
            ]
        },
        {
            "name": "Editor",
            "description": "Edit, DATA",
            "scope-references": [
                "$XSAPPNAME.Edit"
            ]
        }
    ],
    "authorities": [
        "$ACCEPT_GRANTED_AUTHORITIES"
    ],
    "oauth2-configuration": {
        "token-validity": 9000,
        "redirect-uris": [
            "https://*.cfapps.us10-001.hana.ondemand.com/login/callback"
        ]
    },
    "xsenableasyncservice": "true"
}
   ```
   
</br>   
</br>      

## manifest.yml 

</br>   
</br>      

```yml

---
applications:
- name: 06springbtpdb
  path: target/06springbtpdb-0.0.1-SNAPSHOT.war
  random-route: true
  memory: 1024M
  buildpacks:
  - sap_java_buildpack
  services:
  - mysql
  - minionx      

```

</br>   
</br>      

## XSUAA instance is created in BTP account using the JSON file 

</br>   
</br>      
<img src="./files/1xsuaa.png" >
</br>   
</br>      
<img src="./files/2xsuaa.png" >
</br>   
</br>      
<img src="./files/3xsuaa.png" >
</br>   
</br>      
<img src="./files/4xsuaa.png" >
</br>   
</br>      
<img src="./files/5xsuaa.png" >
</br>   
</br>      
<img src="./files/6xsuaa.png" >
</br>   
</br>      
