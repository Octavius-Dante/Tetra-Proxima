## CAPM - Day 8 - CAPM Security XSUAA 

#### How to add XSUAA services to our app and deploy 

</br>
</br>

So from previosu session we saw how to deploy our app to cloud 
</br> Now we are going to add XSUAA service to our app using MTA editor to MTA yaml file
</br>
</br>

## Steps to implement XSUAA in cap 
</br>
</br>

### JWT - Json Web Token

</br>
</br>

<details>
<summary> 1. Create a new resource in MTA.yaml file for xs-uaa backing service with following proerties  </summary>
</br>
</br>
	- name == capp-xsuaa
	- service == xsuaa
	- service-plan == application
	- path == ./xs-security.json
</br>
</br>
	
```yaml
  - name: capp-xsuaa
    type: org.cloudfoundry.managed-service
    parameters:
      service: xsuaa
      service-plan: application
      path: ./xs-security.json
      config:
        xsappname: capp-${org}-${space}
        tenant-mode: dedicated
```
</br>
</br>

Using MTA yaml editor from the BAS open the MTA.yaml file and make the following changes
</br>
</br>
<img src="./files/capmd8-1.png" >
</br>
</br>
Define XSUAA section in MTA yaml file  
</br>
</br>
<img src="./files/capmd8-2.png" >
</br>
</br>
Add managed services type for XSUAA 
</br>
</br>
<img src="./files/capmd8-3.png" >
</br>
</br>
define the essential properties as shown below 
</br>
</br>
<img src="./files/capmd8-4.png" >
</br>
</br>
</details>

  

<details>
<summary> 2. Add the dependency of this newly created xs-uaa service to our microservice in require section </summary>
</br>
</br>
Add xsuaa aunthentication to SRV module and UI module in MTA yaml file as shown below

</br>
</br>
<img src="./files/capmd8-9.png" >
</br>
</br>
<img src="./files/capmd8-10.png" >
</br>
</br>
The finla file should look like this 
</br>
</br>
<img src="./files/capmd8-4a.png" >
</br>
</br>

## mta.yaml (final) 
</br>
</br>

```yaml
_schema-version: '3.1'
ID: capp
version: 1.0.0
description: "A simple CAP project."
parameters:
  enable-parallel-deployments: true
build-parameters:
  before-all:
    - builder: custom
      commands:
        - npx cds build --production
modules:
# start of UI Module code
  - name: capp-ui
    type: nodejs
    path: app
    parameters:
      buildpack: nodejs_buildpack
    build-parameters:
      builder: npm-ci
    requires:
      - name: srv-api
        group: destinations
        properties:
          name: srv-api
          strictSSL: true
          forwardAuthToken: true
          url: '~{srv-url}'
      - name: capp-xsuaa 
# end of UI Module code
# -----------------------------------
# start of SRV Module code
  - name: capp-srv
    type: nodejs
    path: gen/srv
    parameters:
      buildpack: nodejs_buildpack
    build-parameters:
      builder: npm
    provides:
      - name: srv-api # required by consumers of CAP services (e.g. approuter)
        properties:
          srv-url: ${default-url}
    requires:
      - name: capp-db
      - name: capp-xsuaa 

# end of SRV Module code
# -----------------------------------
# start of DB - deployer Module code
  - name: capp-db-deployer
    type: hdb
    path: gen/db
    parameters:
      buildpack: nodejs_buildpack
    requires:
      - name: capp-db

# end of DB - deployer Module code
# -----------------------------------
# start of DB Module code
resources:
  - name: capp-db
    type: com.sap.xs.hdi-container
    parameters:
      service: hana
      service-plan: hdi-shared
# end of DB Module code
# -----------------------------------
# start of XSUAA Module code
  - name: capp-xsuaa
    type: org.cloudfoundry.managed-service
    parameters:
      service: xsuaa
      service-plan: application
      path: ./xs-security.json
      config:
        xsappname: capp-${org}-${space}
        tenant-mode: dedicated
# -----------------------------------
# end of XSUAA Module code
```

</br>
</br> 
</details>


<details>
<summary> 3. Create the xs-security.json file using SAP Documentation </summary>
</br>
</br>
Create a new file named xs-security.json as shown below 
</br>
</br>
<img src="./files/capmd8-5.png" >
<img src="./files/capmd8-6.png" > 
</br>
</br>

- SAP BTP documentation : [xs-security.json document SAP](https://help.sap.com/docs/btp/sap-business-technology-platform/application-security-descriptor-configuration-syntax)
- Add 2 roles - viewer and the Admin role.
- Viewer role and Admin roles are defined to demonstrate example of row level security for the app.

</br>
</br>

## xs-security.json
</br>
</br>

```json
{
  "xsappname": "mycapapp",
  "tenant-mode": "dedicated",
  "scopes": [
    {
      "name": "$XSAPPNAME.Viewer",
      "description": "someone can view data using this scope"
    },
    {
      "name": "$XSAPPNAME.Admin",
      "description": "someone can perform CURD on data using this scope"
    }
  ],
  "attributes": [
    {
      "name": "BankName",
      "description": "Bank Name property",
      "valueType": "string"
    }
  ],
  "role-templates": [
    {
      "name": "Viewer",
      "description": "View all data from our Catalog service",
      "default-role-name": "Viewer: Authorized to Read All Data",
      "scope-references": [
        "$XSAPPNAME.Viewer"
      ],
      "attribute-references": [
        {
          "name": "BankName"
        }
      ]
    },
    {
      "name": "Admin",
      "description": "Edit, delete all data from service",
      "scope-references": [
        "$XSAPPNAME.Admin"
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
</details>
 

<details>
<summary>4. add 3 node module which will help in security configuration for our app </summary>
</br>

- npm install passport 
- npm install @sap/xssec 
- npm install @sap/xsenv
</br>
</br> 
</details>

<details>
<summary> 5. App router changes <b>xs-app.json</b> </summary>
</br>
</br>
We need to inform app router to contact Xsuaa to mandate the use of JWT token in <b> xs-app.json </b> file
</br> Change authenticationMethod : route and add ( "auhenticationType" : "xsuaa"" )
</br>
</br>   
<img src="./files/capmd8-7.png" >
</br>
</br>
<img src="./files/capmd8-8.png" >
</br>
</br>

## xs-app.json
</br>
</br>

```json
{
    "welcomeFile": "purchaseorderapp/webapp/",
    "authenticationMethod": "route",
    "sessionTimeout": 100,
    "pluginMetadataEndpoint": "/metadata",
    "routes": [
      {
        "source": "^/purchaseorderapp/webapp/(.*)",
        "target": "$1",
        "localDir": "purchaseorderapp/webapp/",
        "authenticationType": "xsuaa"
      },
      {
        "source": "^/(.*)$",
        "destination": "srv-api",
        "authenticationType": "xsuaa"
      }
    ]
  }
```

</br>
</br> 
</details>

<details>
<summary> 6. Code changes in catalog services for XSUAA </summary>
</br>
We need to secure our resource to only use authenticated user, hence we need to add an annotation in catalog services
   </br> ( requires : 'authenticated-user')
</br>
</br>
<img src="./files/capmd8-15a.png" >
</br>
</br>

adding restriction to read employee set 
</br>
</br>
<img src="./files/capmd8-15b.png" > 
</br>
</br>
</details>


<details>
<summary> 7. Define XSUAA security strategy for cloud </summary>
</br>
We need to tell system that if we run app in cloud foundry BTP (production environemnt) 
</br> use JWT strategy for security. by defining it in package.json 
</br>
	
by defining following block of code in package.json
</br>
</br>

```json

 "cds": {
    "requires": {
      "db": {
        "kind": "hana",
        "credentials": {
          "database": "dan-key"
        }
      },
.      "auth":{
.        "[production]":{
.          "strategy": "JWT"
.        }
      }
    }
  },

```

</br>
</br>
</details>

</br>
<details>
<summary> Data Scope access design concept for defining roles - scenario where all data is accessed and specific data is accessed </summary>
</br>
<img src="./files/data_scope_design.png" >
</br>
</details>
</br>

<details>
<summary> 8. Define XSUAA security strategy for local testing with local users defined </summary>
</br>
</br>
authentication strategies section can be located in following CAPIRE document link
</br>

[Capire Authentication document ](https://cap.cloud.sap/docs/node.js/authentication#enforcement)     
</br>
</br>
<img src="./files/capmd8-14.png" > 
</br>
</br>
</br>
Add following block of code under cds section in <b> package.json </b> and test it locally,
Production deployment of app will check JWT token, local XSUAA test will check for mentioned users
</br>
</br>

```json

  "cds": {
    "requires": {
      "db": {
        "kind": "hana",
        "credentials": {
          "database": "dan-key"
        }
      },
.      "auth":{
.        "[production]":{
.          "strategy": "JWT"
.        },
.        "[development]":{
.         "strategy": "mock",
.         "users":{           
.          }
        }
      }
    }
  },

```

</br>
Testing 
</br>
<img src="./files/capmd8-16.png" > 
<img src="./files/capmd8-17.png" > 
<img src="./files/capmd8-18.png" > 
</br>

Add the user section with user name and assign : Viewer role and test 
</br>
</br>
</br>

```json

"users":{
            "dante":{
              "roles":["Viewer"],
              "userAttributes":{}
            },
            "dan":{
              "roles":[],
              "userAttributes":{}              
            }
          }

```

<img src="./files/capmd8-19.png" > 
<img src="./files/capmd8-20.png" > 
<img src="./files/capmd8-21.png" > 
<img src="./files/capmd8-22.png" > 
</br>
</br>

## package.json (with complete changes)
</br>
</br>

```json
{
  "name": "dan",
  "version": "1.0.0",
  "description": "A simple CAP project.",
  "repository": "<Add your repository here>",
  "license": "UNLICENSED",
  "private": true,
  "dependencies": {
    "@sap/cds": "^7",
    "@sap/cds-hana": "^2",
    "@sap/cds-odata-v2-adapter-proxy": "^1.9.21",
    "@sap/xssec": "^3",
    "passport": "^0"
  },
  "devDependencies": {
    "@cap-js/sqlite": "^1.2.1",
    "@sap/cds-dk": "^7",
    "@sap/ux-specification": "^1.108.14"
  },
  "scripts": {
    "start": "cds-serve",
    "deploy": "cds deploy --to hana:dorimon --profile hybrid",
    "run": "cds watch --profile hybrid",
    "watch-purchaseorderapp": "cds watch --open purchaseorderapp/webapp/index.html?sap-ui-xx-viewCache=false"
  },
  "sapux": [
    "app/purchaseorderapp"
  ],
  "cds": {
    "requires": {
      "[hybrid]": {
        "db": "hana"
      },
      "auth":{
        "[production]":{
          "strategy": "JWT"
        },
        "[development]":{
          "strategy": "mock",
          "users": {
            "dante":{
              "roles":["Viewer"],
              "userAttributes":{
                "BankName":["$UNRESTRICTED"]
              }
            },
            "dan":{
              "roles":["Viewer"],
              "userAttributes":{
                "BankName":["My Bank of London","My Bank of New York","My Bank of San Francisco"]
              }
            }
          }
        }
      }
    },
    "auth": "xsuaa"
  }
}

```
</br>
</br>

<img src="./files/capmd8-27.png" > 
</br>
</br>
</details>


<details>
<summary> 9. Alternative testing of service with XSUAA using HTTP file</summary>
</br>
</br>
<img src="./files/capmd8-23.png" > 
<img src="./files/capmd8-24.png" > 
</br>
</br>

This is example for authentication failed (temporarily) edited the packge.json file to show how error occurs
</br>
</br>
<img src="./files/capmd8-25.png" > 
</br>
</details>


<details>
<summary> 10. Depolying the app with xsuaa to cloud and defining roles </summary>
</br>
</br>

- Right click the mta.yaml file and select "Build MTA project"
- mta_archives section of the app contains *.mtar file - right clikc and select "Deploy MTA archive"
</br>
</br>

post deployment if any errors encountered use th following comamdnto check the logs specifically
</br> command to check the logs of failed deployment 
</br>

actual commands 
```bat 
cf logs <appname>-ui --recent
cf logs <appname>-srv --recent
cf logs <appname>-db --recent
cf logs <appname>-bd-deployer --recent
```

with app name 
```bat 
cf logs dante-ui --recent
cf logs dante-srv --recent
cf logs dante-db --recent
cf logs dante-db-deployer --recent

```
</br>
</br>

After deployment you get 2 sections (SRV and UI) srv represents our odata services, ui represents our Fiori Ui page
</br>
<img src="./files/capmd8-28-00.png" > 
</br>
</br>
</br>


- SAP BTP cloud foundry will allow the user to access the App from ui without any issues as shown below
</br>
<img src="./files/capmd8-28-a.png" > 
</br>
</br>
</br>

- But if the service (srv) is accessed it wont allow the user to see the data (It is restricted for security reasons)
</br>
</br>
<img src="./files/capmd8-28-b.png" > 
</br>
<img src="./files/capmd8-28-c.png" > 
</br>
</br>
</br>

- In order to see the data set we need to access it from ui link by adding the catalog service
</br> with data set name as shown here
</br> || (Cloud Link) + (/CatalogService/<dataset_name>) || - (example : /CatalogService/EmployeeSet, /CatalogService/BusinesspartnerSet)
</br>
<img src="./files/capmd8-28-d.png" > 
</br>
</br>
</br>

- In order to restrict this visbility we defined a restriction in CatalogService for (EmployeeSet) it still works here
</br>
<img src="./files/capmd8-28-e.png" > 
</br>
</br>
</br>


- To access the restricted Employeeset We need to define the roles in cloud the same roles we defined earlier during (mock strategy) for local xsuaa testing
</br>
</br>

Defining Roles in security section 
</br>
</br>
<img src="./files/capmd8-28-1.png" >
<img src="./files/capmd8-28-2.png" >
<img src="./files/capmd8-28-3.png" >
<img src="./files/capmd8-28-4.png" > 
</br>
</br>
</br>

Assigning the Roles to user id/account (mail-id)
</br>
</br>
<img src="./files/capmd8-29-1.png" >
<img src="./files/capmd8-29-2.png" >
<img src="./files/capmd8-29-3.png" >
<img src="./files/capmd8-29-4.png" > 
<img src="./files/capmd8-29-5.png" > 
<img src="./files/capmd8-29-6.png" > 
<img src="./files/capmd8-29-7.png" > 
</br>
</br>

Assign your current cloud account mail-id (assigning a role to access your app)
</br>
<img src="./files/capmd8-29-8.png" > 
</br>
</br>
</br>

After the role is assigned please open an incognito window in the browser and login to your account and access the Ui with catalog service and check employeeset
</br>
</br> if its not logged in again you cannot access the data (because active session in cloud foundry cannot be refreshed) it will pick up the new roles only in next login 
</br>
<img src="./files/capmd8-30.png" > 
</br>
<img src="./files/capmd8-31.png" > 
</br>
</br>
</details>


<!--

</br>
</br>

``` cds 
	


``` 

</br>
</br>
<img src="./files/capmd7-1.png" >
</br>
</br>

## MyService.js 
</br>
</br>

```js



```
</br>
<img src="./files/capmd7-2.png" >
</br>
</br>



<details>
<summary> <b> ALL CODE CHANGES - TODAY SESSION </b> </summary>
</br>
</br>

</br>
</br>

</br>
</br>
</details>


-->

</br>
</br>
</br>


</br>
</br>
</br>

Roles and scopes 

[BTP XSUAA - SAP developers blog](https://developers.sap.com/tutorials/btp-app-prepare-xsuaa.html)

[MTA deployment - SAP developers blog](https://developers.sap.com/tutorials/btp-app-cap-mta-deployment.html)

</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>


</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

# NEXT ------ CAPM - DAY 9 - Serverless Fiori App

<p align="center"> 
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-9"> CAPM DAY 9 - Serverless Fiori App</a> 
</p>
