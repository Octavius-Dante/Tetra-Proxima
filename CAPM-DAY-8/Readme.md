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
<img src="./files/capmd8-2.png" >
</br>
</br>
<img src="./files/capmd8-3.png" >
</br>
</br>
<img src="./files/capmd8-4.png" >
</br>
</br>
</details>




    


2. Add the dependency of this newly created xs-uaa service to our microservice in require section

3. Create the xs-security.json file using
   	- sap btp documentation : [xs-app.json document SAP](https://help.sap.com/docs/btp/sap-business-technology-platform/application-security-descriptor-configuration-syntax)
	- and adapt files to have 2 roles - viewer and the Admin role.
	- the Viewer role also have an attribute called bank name whcih will be for row level security.
	
4. add 3 node module which will help in security configuration for our app 
   	- npm install passport; 
	- npm install @sap/xssec; 
	- npm install @sap/xsenv

5. We need to inform app router to contact Xsuaa to mandate the use of JWT token in <b> xs-app.json </b> file
   </br> Change authenticationMethod : route and add ( "auhenticationType" : "xsuaa"" )

6. We need to secure our resource to only use authenticated user, hence we need to add an annotation in catalog services
   </br> ( requires : 'authenticated-user')

7. We need to tell system  taht if we run app locally (development environemnt) in BAS tool,
   </br> use mock strategy for testing security. After deployment to CF (production environemnt) we use JWT strategy.

8. Additionally we configure demo local users for testing purpose authentication strategies section in following CAPIRE document section 
   </br> [Capire Authentication document ](https://cap.cloud.sap/docs/node.js/authentication#enforcement)     

</br>
</br>

Add following block of code under cds section in <b> package.json </b> and test it locally,
Production deployment of app will check JWT token local test will check for mentioned users
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
</br>
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
command to check the logs of failed deployment 
</br>

actual command 
```bat 
cf logs <appname>-ui --recent
```

with app name 
```bat 
cf logs dante-ui --recent
```

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

# NEXT ------ CAPM - DAY 8 - CAPM Security XSUAA

<p align="center"> 
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-8"> CAPM DAY 8 - CAPM Security XSUAA</a> 
</p>
