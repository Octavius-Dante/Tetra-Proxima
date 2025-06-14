## CAPM - Day 9 - Serverless Fiori App 

#### How to add Freestyle Fiori app (ui) to an available SRV

</br>
</br>

**Central Fiori Launchpad  (AKA) SAP Build Work Zone**

So from previous session we saw how to deploy our app to cloud with XSUAA
</br> Now we are going to create a freestyle Fiori app just Ui by only using existing Srv -
</br>
</br>

### The development in this session is going to answer following Questions
</br>
</br>

1. Can we build Free style Fiori application and deploy them on BTP ?
2. Is it possible to show an example of free style app using CAPM OData ?
3. If i want to build freestyle Fiori app as a separate microservice, what is the option for me ?
4. I have heard about central Fiori launchpad in SAP BTP, what is it and how to use ?
5. My company is building html5 apps in BTP which they call as Fiori apps, how it is different ?
6. If I want to build multiple Fiori apps on single OData offered by CAPM, what is the best practice ?
7. When Fiori app is deployed Fiori, it was deployed as Node JS application, how can we deploy it as an independent Fiori app ?
8. What is managed app router, I have heard about it but never used it?

</br>
</br>

<img src="./files/Serverless_Fiori_design.png" >

</br>
</br>

[SAP Blog on SAP Build work zone](https://community.sap.com/t5/technology-blogs-by-members/access-fiori-apps-via-sap-build-work-zone-site-with-federated-sap-s-4hana/ba-p/13558780)

Configuration Steps for BTP content Federation: -
</br>
</br>
</br>Step 1: - Subscribe to the SAP Build Work Zone, standard edition.
</br>Step 2: - Cloud connector Setup
</br>Step 3: - Setup the Runtime and Design-Time destinations in SAP BTP
</br>Step 4: - Expose content from SAP S/4HANA
</br>Step 5: - Import the content in SAP Build Work Zone, standard edition.
</br>Step 6: - Assign the imported roles to the Site.
</br>Step 7: - Add the roles to the user.
</br>Step 8: - Access the federated content


</br>
</br>

### Advantages of HTML5 apps over NodeJs Fiori app

</br>

1. It provides a good isolation from our CAP project, hence if there is a change in Ui, 
   we don't need to touch or re-deploy the cap application 

2. In a global team, each team is responsible for one Fiori app, they can work independently
   in their apps with separate git repositories and different lifecycle and transport

3. If we add all Fiori apps inside cap project the project becomes bulkier,
   also Ui developer has to go through lot of files when developing UI so separated from CAP gives less clutter. 
   
4. We can use managed app router with html5 apps, app router itself is a separate node application which requires memory and downtime when we deploy our app.
   The managed app router is managed by Cloud Foundry environment in BTP.

5. Integration with SAP Fiori Launchpad <b> (Central Fiori launchpad aka SAP Build work zone) </b> in SAP BTP. Because our app is available as a HTML5 app inside html5 repository.   

</br>
</br>


### Building Fiori App using existing SRV services 
</br>

<details>
<summary> 1. Accessing OData service (SRV) module of our previous app from Postman Tool </summary>
</br>
</br>

[some reading on postman on JWT](https://sap.github.io/cloud-sdk/docs/js/guides/retrieve-jwt)
</br>

[Reading on JWT and OAuth 2.0](https://frontegg.com/blog/oauth-vs-jwt#OAuth_vs_JWT_Key_Differences)
</br>

<img src="./files/OAuth2.0.png" >
</br>
</br>


When SRV module is accessed from cloud deployed app it appears like this
</br>
</br>
<img src="./files/capmd9-1.png" >
</br>
</br>
<img src="./files/capmd9-2.png" >
</br>
</br>
<img src="./files/capmd9-3.png" >
</br>
</br>
<img src="./files/capmd9-4.png" >
</br>
</br>

Creating a call service in postman tool for our SRV module
</br>
</br>
<img src="./files/capmd9-5.png" >
</br>
</br>

Select Authorization tab
</br>
</br>
<img src="./files/capmd9-6.png" >
</br>
</br>

Select OAuth 2.0 in this section
</br>
</br>
<img src="./files/capmd9-7.png" >
</br>
</br>

Fill the necessary values here 
</br>
</br>
<img src="./files/capmd9-8.png" >
</br>
</br>

Get the required values from BTP cloud account and add it to Postman
</br>
</br>
<img src="./files/capmd9-9.png" >
</br>
</br>
<img src="./files/capmd9-10.png" >
</br>
</br>
<img src="./files/capmd9-11.png" >
</br>
</br>

Before pasting the url need to add the following at the last of the URL 
</br> ( <b>/url/oauth/token</b> )
</br>
</br>
<img src="./files/capmd9-12.png" >
</br>
</br>

Client ID & Client Secret 
</br>
</br>
<img src="./files/capmd9-13.png" >
</br>
</br>
<img src="./files/capmd9-14.png" >
</br>
</br>
</br>

BTP Account userid and the password should be <b> BAS account password </b> don't confuse it with (BTP GLobal account password)
</br>
</br>
<img src="./files/capmd9-15.png" >
</br>
</br>
<img src="./files/capmd9-16.png" >
</br>
</br>
<img src="./files/capmd9-17.png" >
</br>
</br>

Token added acknowledgement will be shown in right bottom of screen
</br>
</br>
<img src="./files/capmd9-18.png" >
</br>
</br>

Now fire the call service and it should bring the data
</br>
</br>
<img src="./files/capmd9-19.png" >
</br>
</br>
<img src="./files/capmd9-20.png" >
</br>
</br>
</br>

Now we need to decrypt the JWT Token go to the website : https://www.base64decode.org
</br>
</br>
<img src="./files/capmd9-21.png" >
</br>
</br>
<img src="./files/capmd9-22.png" >
</br>
</br>
</br>

</details>



<details>
<summary> 2. Create Destination in BTP account and establish connection </summary>
</br>
</br>

We will use the available information from postman and this scope details from token to create Destination in BTP account as shown below
</br>
</br>
</br>

Go to the connectivity section in the sub account and click destination
</br>
</br>
<img src="./files/capmd9-23.png" >
</br>
</br>

select create new destination
</br>
</br>
<img src="./files/capmd9-24.png" >
</br>
</br>

Change the authentication type to - <b> OAuth2 User Token Exchange </b>
</br>
</br>
<img src="./files/capmd9-25.png" >
</br>
</br>

### Now fill the necessary details from available data source as shown below
</br>
</br>

Copy this link from postman or our OData SRV or from our deployed SRV application
</br>
</br>
<img src="./files/capmd9-26.png" >
</br>
</br>
<img src="./files/capmd9-27.png" >
</br>
</br>
<img src="./files/capmd9-28.png" >
</br>
</br>
<img src="./files/capmd9-29.png" >
</br>
</br>
<img src="./files/capmd9-30.png" >
</br>
</br>
<img src="./files/capmd9-31.png" >
</br>
</br>

A success message showing that connection is established 
</br>
</br>
<img src="./files/capmd9-32.png" >
</br>
</br>

</br>
</br>
</details>


<details>
<summary> 3. Create Freestyle Fiori app using BAS </summary>
</br>
</br>
Go to BAS and press F1 and Search for 'Fiori Open Application generator'
</br>
</br>
<img src="./files/capmd9-33.png" >
</br>
</br>

Choose the template as shown below 
</br>
</br>
<img src="./files/capmd9-34.png" >
</br>
</br>
<img src="./files/capmd9-35.png" >
</br>
</br>
</br>
</br>


<details>
<summary> How to get the V2 OData path </summary>
</br>
</br>
<img src="./files/capmd9-36a.png" >
</br>
</br>
<img src="./files/capmd9-36b.png" >
</br>
</br>
<img src="./files/capmd9-36c.png" >
</br>
</br>
<img src="./files/capmd9-36d.png" >
</br>
</br>
</details>
</br>
</br>
</br>
</br>

<img src="./files/capmd9-36.png" >
</br>
</br>
<img src="./files/capmd9-37.png" >
</br>
</br>
<img src="./files/capmd9-38.png" >
</br>
</br>
<img src="./files/capmd9-39.png" >
</br>
</br>
<img src="./files/capmd9-40.png" >
</br>
</br>
<img src="./files/capmd9-41.png" >
</br>
</br>
<img src="./files/capmd9-42.png" >
</br>
</br>
<img src="./files/capmd9-43.png" >
</br>
</br>
<img src="./files/capmd9-44.png" >
</br>
</br>
<img src="./files/capmd9-45.png" >
</br>
</br>
<img src="./files/capmd9-46.png" >
</br>
</br>
<img src="./files/capmd9-47.png" >
</br>
</br>
</details>
</br>
</br>
</br>

### Backing service used for HTML 5 apps 
</br>
</br>

- [x] Destination service - to read the destination from SAP BTP at runtime for the purpose of connection
- [x] Connectivity service - once the destination is read, it will use connectivity service to connect to our OData service 
- [x] HTML5 Deployer - this will be used to deploy our app to HTML5 repository
- [x] HTML5 Repo Runtime - Will load the Fiori app when requested at runtime 
- [x] Fiori launchpad service - which displays Fiori apps as a tile (a central place for all Fiori apps to appear as a tile)
</br> (we cant provide end user with a link a every Fiori app developed in business that's why this launchpad service is there)
</br>
</br>

**Best place to learn fiori and access samples** : [sapui5.hana.ondemand.com](https://sapui5.hana.ondemand.com/#/)

- [x] To make our Fiori app to interact with central Fiori launchpad service we need to check few settings in manifest.json file 
         1. sap.cloud - this allows the app to be exposed to public access 
         2. Cross Navigation : 'crossNavigation' - this allows the app to be navigated between launchpad service and repository 

- [x] we have to deploy the generated app to BTP cloud via Central Fiori launchpad 
</br>
</br>

Web Application - HTML5 Repo
</br>
</br>
<img src="./files/capmd9-48.png" >
</br>
</br>


- [x] **Build MTA archive using MTA.yaml file (right click-> Build mta project)**
- [x] **After The build is complete select the archive *.mtar (right click-> Deploy MTA archive)**

</br>
</br>

**Now this deployment wont go to BTP cloud it goes to SAP HTML5 repository**
</br> because if you take a look at the MTA.yaml file it as the clear explanation
</br> earlier we deployed Node JS application with DB deployer, Db and XSUAA 
</br> now it has Fiori-Ui related artifacts and XSUAA services and it is deployed as HTML5 application 

</br>
</br>

<details>
<summary> <b> MTA.yaml sample </b> </summary>
</br>

## MTA.yaml file (for reference)
</br>
</br>

```yaml

_schema-version: "3.2"
ID: comdantefreestylepo
description: Generated by Fiori Tools
version: 0.0.1
modules:
- name: comdantefreestylepo-destination-content
  type: com.sap.application.content
  requires:
  - name: comdantefreestylepo-destination-service
    parameters:
      content-target: true
  - name: comdantefreestylepo-repo-host
    parameters:
      service-key:
        name: comdantefreestylepo-repo-host-key
  - name: comdantefreestylepo-uaa
    parameters:
      service-key:
        name: comdantefreestylepo-uaa-key
  parameters:
    content:
      instance:
        destinations:
        - Name: comdantefreestylepo_html_repo_host
          ServiceInstanceName: comdantefreestylepo-html5-srv
          ServiceKeyName: comdantefreestylepo-repo-host-key
          sap.cloud.service: comdantefreestylepo
        - Authentication: OAuth2UserTokenExchange
          Name: comdantefreestylepo_uaa
          ServiceInstanceName: comdantefreestylepo-xsuaa-srv
          ServiceKeyName: comdantefreestylepo-uaa-key
          sap.cloud.service: comdantefreestylepo
        existing_destinations_policy: ignore
  build-parameters:
    no-source: true
- name: comdantefreestylepo-app-content
  type: com.sap.application.content
  path: .
  requires:
  - name: comdantefreestylepo-repo-host
    parameters:
      content-target: true
  build-parameters:
    build-result: resources
    requires:
    - artifacts:
      - comdantefreestylepo.zip
      name: comdantefreestylepo
      target-path: resources/
- name: comdantefreestylepo
  type: html5
  path: .
  build-parameters:
    build-result: dist
    builder: custom
    commands:
    - npm install
    - npm run build:cf
    supported-platforms: []
resources:
- name: comdantefreestylepo-destination-service
  type: org.cloudfoundry.managed-service
  parameters:
    config:
      HTML5Runtime_enabled: true
      init_data:
        instance:
          destinations:
          - Authentication: NoAuthentication
            Name: ui5
            ProxyType: Internet
            Type: HTTP
            URL: https://ui5.sap.com
          existing_destinations_policy: update
      version: 1.0.0
    service: destination
    service-name: comdantefreestylepo-destination-service
    service-plan: lite
- name: comdantefreestylepo-uaa
  type: org.cloudfoundry.managed-service
  parameters:
    path: ./xs-security.json
    service: xsuaa
    service-name: comdantefreestylepo-xsuaa-srv
    service-plan: application
- name: comdantefreestylepo-repo-host
  type: org.cloudfoundry.managed-service
  parameters:
    service: html5-apps-repo
    service-name: comdantefreestylepo-html5-srv
    service-plan: app-host
parameters:
  deploy_mode: html5-repo
  enable-parallel-deployments: true


```

</br>
</details>

<details>
<summary> <b> Deploy log </b> </summary>
</br>

## Deploy log for reference 
</br>
</br>

```bat

cf deploy /home/user/projects/freestylepo/mta_archives/comdantefreestylepo_0.0.1.mtar -f
Deploying multi-target app archive /home/user/projects/freestylepo/mta_archives/comdantefreestylepo_0.0.1.mtar in org 5acbc7d5trial / space dev as lordes.cloud9@gmail.com...

Uploading 1 files...
  /home/user/projects/freestylepo/mta_archives/comdantefreestylepo_0.0.1.mtar

 0s  0 B / 7.72 KiB    0.00%
 0s  7.72 KiB / 7.72 KiB  100.00%
 0s  7.72 KiB / 7.72 KiB  100.00% 0s
OK
Operation ID: af8db2d6-02b5-11ef-a437-eeee0a83c17b
Deploying in org "5acbc7d5trial" and space "dev"
Detected MTA schema version: "3"
No deployed MTA detected - this is initial deployment of MTA with ID "comdantefreestylepo"
Detected new MTA version: "0.0.1"
Processing service "comdantefreestylepo-xsuaa-srv"...
Setting service "comdantefreestylepo-xsuaa-srv" parameters from "xs-security.json"
Creating service "comdantefreestylepo-xsuaa-srv" from MTA resource "comdantefreestylepo-uaa"...
Processing service "comdantefreestylepo-destination-service"...
Creating service "comdantefreestylepo-destination-service" from MTA resource "comdantefreestylepo-destination-service"...
Processing service "comdantefreestylepo-html5-srv"...
Creating service "comdantefreestylepo-html5-srv" from MTA resource "comdantefreestylepo-repo-host"...
1 of 1 done
1 of 1 done
1 of 1 done
Creating service key "comdantefreestylepo-repo-host-key" for service instance "comdantefreestylepo-html5-srv"...
Creating service key "comdantefreestylepo-destination-content-comdantefreestylepo-destination-service-credentials" for service instance "comdantefreestylepo-destination-service"...
Creating service key "comdantefreestylepo-uaa-key" for service instance "comdantefreestylepo-xsuaa-srv"...
Creating service key "comdantefreestylepo-app-content-comdantefreestylepo-repo-host-credentials" for service instance "comdantefreestylepo-html5-srv"...
Uploading content module "comdantefreestylepo-app-content" in target service "comdantefreestylepo-repo-host"...
Deploying content module "comdantefreestylepo-destination-content" in target service "comdantefreestylepo-destination-service"...
Deploying content module "comdantefreestylepo-app-content" in target service "comdantefreestylepo-repo-host"...
Skipping deletion of services, because the command line option "--delete-services" is not specified.
Process finished.
Use "cf dmol -i af8db2d6-02b5-11ef-a437-eeee0a83c17b" to download the logs of the process.

 *  Terminal will be reused by tasks, press any key to close it.

```
</br>
</details>

</br>
</br>

Check the deployed app in repository using following command 
</br>
</br>

```bat

cf html5-list
```
</br>
</br>
<img src="./files/capmd9-49.png" >
</br>
</br>
<img src="./files/capmd9-50.png" >
</br>
</br>


<details>
<summary> <b> Now we access Fiori launchpad service </b> </summary>
</br>
</br>
</br>
To get it we need to create an instance for SAP Build work zone, standard Edition
</br>
</br>
<img src="./files/capmd9-51.png" >
</br>
</br>
<img src="./files/capmd9-52.png" >
</br>
</br>

Don't launch the app yet, need to assign the role permission for this app first
</br>
</br>
<img src="./files/capmd9-52.png" >
</br>
</br>
<img src="./files/capmd9-54.png" >
</br>
</br>
<img src="./files/capmd9-55.png" >
</br>
</br>
<img src="./files/capmd9-56.png" >
</br>
</br>

**Post assignment of role need to logout and login to get the role to be reflected on my account**
</br>
</br>
<img src="./files/capmd9-57.png" >
</br>
</br>
</details>

<details>
<summary> <b> Access the repository for publishing Fiori tile </b> </summary>
</br>
</br>

<img src="./files/capmd9-58.png" >
</br>
</br>

<img src="./files/capmd9-59.png" >
</br>
</br>

<img src="./files/capmd9-60.png" >
</br>
</br>

<img src="./files/capmd9-61.png" >
</br>
</br>

<img src="./files/capmd9-62.png" >
</br>
</br>

<img src="./files/capmd9-63.png" >
</br>
</br>

<img src="./files/capmd9-64.png" >
</br>
</br>

<img src="./files/capmd9-65.png" >
</br>
</br>

<img src="./files/capmd9-66.png" >
</br>
</br>

In some cases the deployed app wont get reflected in HTML5 repository in that case have to do the following
</br> go to Channel manager and refresh the repository so the app gets updated for access
</br>
</br>
<img src="./files/capmd9-67.png" >
</br>
</br>
<img src="./files/capmd9-68.png" >
</br>
</br>

Now we create catalog from content explorer as shown below
</br>
</br>
<img src="./files/capmd9-69.png" >
</br>
</br>
<img src="./files/capmd9-70.png" >
</br>
</br>

Lets create a group
</br>
</br>
<img src="./files/capmd9-71.png" >
</br>
</br>
<img src="./files/capmd9-72.png" >
</br>
</br>
<img src="./files/capmd9-73.png" >
</br>
</br>
<img src="./files/capmd9-74.png" >
</br>
</br>

Now we can test the app 
</br>
</br>
<img src="./files/capmd9-75.png" >
</br>
</br>
<img src="./files/capmd9-76.png" >
</br>
</br>
<img src="./files/capmd9-77.png" >
</br>
</br>
<img src="./files/capmd9-78.png" >
</br>
</br>
<img src="./files/capmd9-79.png" >
</br>
</br>
<img src="./files/capmd9-80.png" >
</br>
</br>
<img src="./files/capmd9-81.png" >
</br>
</br>

Now the app is accessible 
</br>
</br>
<img src="./files/capmd9-82.png" >
</br>
</br>
</details>


<details>
<summary><b> Automatic role creation for HTML5app </b></summary>
</br>
</br>

In case we want to create roles automatically like we did in Node JS app during deployment 
</br> we need to make changes in following places can refer the standard template in SAP official help pages
</br>
</br>
<img src="./files/capmd9-83.png" >
</br>
</br>
<img src="./files/capmd9-84.png" >
</br>
</br>

</br> in SAP build work zone we need to assign the **App to Role**

Same role will be created in roles section in BTP and that role we need to assign it to user 
</br> In BTP we need to assign the **Role to User**

</br>
</br>

Rememebr this --- App to Role assignment in Build work zone --- Role to User assignment in BTP---
</br>
</br>
<img src="./files/capmd9-85.png" >
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
</br>
</br>

# NEXT ------ CAPM - DAY 10 - S/4 HANA Side by Side Extension 1.0

<p align="center"> 
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-10"> CAPM DAY 10 - S/4 HANA Side by Side Extension 1.0</a> 
	
</br>
</br>

#### Previous Sessions
</br>
<!--
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-12"> CAPM Day 12 - Extension CI CD</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-11"> CAPM Day 11 - S4HANA Side by Side</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-10"> CAPM Day 10 - Side by Side extension</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-9"> CAPM Day 9 - Serverless Fiori App</a>
-->

- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-8"> CAPM Day 8 - CAPM Security XSUAA</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-7"> CAPM Day 7 - HANA and Deployment</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-6"> CAPM Day 6 - Fiori App Draft</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-5"> CAPM Day 5 - Fiori Elements</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-4"> CAPM Day 4 - Generic Handlers</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-3"> CAPM Day 3 - EPM DB and CDS Views</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-2"> CAPM Day 2 - Aspects and Reuse Tables</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-1"> CAPM Day 1 - First CAP App </a>

</br>
</br>

</p>
