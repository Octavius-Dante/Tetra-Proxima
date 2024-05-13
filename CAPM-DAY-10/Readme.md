## CAPM - Day 10 - Side by Side extension

# WORK IN PROGRESS - 

</br>

[Side by side extension SAP official reading](https://learning.sap.com/learning-journeys/develop-advanced-extensions-with-sap-cloud-sdk/exploring-side-by-side-extensibility_f2f6f71d-d50c-4a48-b0f9-f5a87f717aa1)

</br>
</br>

### Extension Use case
</br>
</br>

SAP BTP is the main technology platform for doing extension of existing ERP application in any org, 
A main pillar of intelligent enterprise
</br>

1. Intelligent suite - solution like S/4 HANA
2. Intelligent platform - SAP BTP 
3. Intelligent technologies - SAC, RAP, CAP, SAP Build code, SAP Build App, SAP Build Automation, SAP Build Work zone..etc
</br>
</br>

If we want to entend our standard ERP software, What are all the disadvantage of the approach we take
</br>

1. The Extensions have potential to break your standard software
2. Extensions also take longer time to deliver change request
3. Risks for upgrade
4. Contamination of SAP Code 
</br>
</br>

SAP Recommends to build extensions on top of BTP outside the stable core ERP
</br>

1. ERP core software is stable 
2. We can deliver innovation at much faster phase
3. Never cause any problem to sap upgrades becasue The extension is built outside the environment

</br>
</br>

**In-App or Key-User extensibility** are means provided by the SAP product that enables you to extend the apps. For example one may add a new custom field to the UI which is then saved together with the business object instance. It can even be forwarded to follow-up documents in case of process extensibility. Further options of key-user extensibility are own business objects or business logic modifications in pre-defined extension points. This concept applies for cloud software. OnPremise customers have other options to get such kind of enhancements because they have direct access to the code.
</br>
</br>

**Side-by-Side extensibility** refers to enhancements that you create on a different platform (e.g. SAP Cloud Platform) but integrate with your SAP product. As an example, you might react on a certain event in your SAP product, notify your own SCP implementation to handle accordingly. Or you have an own app on SCP that writes data back into the SAP product. The communication works via public APIs in such cases.
</br>
</br>

<img src="./files/Extension_explain.png" >
</br>
</br>

<img src="./files/SAP_SIDE_BY_SIDE_EXT.png" >
</br>
</br>

<img src="./files/CASE_1.png" >
</br>
</br>

<img src="./files/CASE_2.1.png" >
</br>
</br>



Before we proceed the cloud connection to ERP system is important it is a pre-requisite for this session 
</br> If cloud connection to On-Premise or ERP is not performed kindly refer this link and establish connection 
</br> [SAP Cloud connection](https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/SAP_Cloud_Connector)
</br> 

</br>
</br>

## Case 1.0
</br>
</br>

<details>
<summary> <b>1. Checking the BTP destination details for connected system</b> </summary>
</br>
</br>
Before start building app in BAS btp side we should confirm wheher 
</br>systems are available for connection in destiantion section as shown below
</br>
</br>
<img src="./files/capmd10-1.png" >
</br>
</br>
<img src="./files/capmd10-2.png" >
</br>
</br>
<img src="./files/capmd10-3.png" >
</br>
</br>
</details>


<details>
<summary> <b>2. Accessing on-prem system and checking the ODATA service </b> </summary>
</br>
</br>
Go to tcode /n/iwfnd/maint_services
</br>
</br>
<img src="./files/capmd10-4.png" >
</br>
</br>

Selecting a service which we are going to use for our fiori app 
</br>
</br>
<img src="./files/capmd10-5.png" >
</br>
</br>

Testing the service whether it is supplying data to web
</br>
</br>
<img src="./files/capmd10-6.png" >
</br>
</br>

The data is dipslayed in the web in XML format (Odata service is accessible in web)
</br>
</br>
<img src="./files/capmd10-7a.png" >
</br>
</br>

identifying the implemented class in case if we want to make chanegs in ABAP for this exisitng ODATA services
</br> this is a standard demo purpose odata class used in Zservice this SEPMRA_PROD_MAN is available in all S/4 HANA on-premise system
</br> Standard External service : SEPMRA_PROD_MAN - (in case of a Zclass used in service which can be modified as per user convenience)
</br>
</br>
<img src="./files/capmd10-8.png" >
</br>
</br>
<img src="./files/capmd10-9.png" >
</br>
</br>

in the web browser (SEPMRA_PROD_MAN/SEPMRA_C_PD_Product/?$format=json) add this block to the existing link and check the sub category of an odata service
</br>
</br>
<img src="./files/capmd10-10a.png" >
</br>
</br>
<img src="./files/capmd10-10b.png" >
</br>
</br>

Press F12 in chrome browser and navigate to network section and relaod the page to see the type of odata service (product page is v2)
</br>
</br>
<img src="./files/capmd10-11.png" >
</br>
</br>
</details>


<details>
<summary> <b>3. Registering ERP system in BAS - linking erp to subaccount  </b> </summary>
</br>
</br>
<img src="./files/capmd10-12.png" >
</br>
</br>
<img src="./files/capmd10-13.png" >
</br>
</br>

Some times the available catalog services wont be displayed but since destination connection is shown no connection issue we can proceed 
</br>
</br>
<img src="./files/capmd10-14.png" >
</br>
</br>
</details>


<details>
<summary> <b>4. Build Fiori applicaiton in BAS using Fiori elements template - CASE 1.0 </b> </summary>
</br>
</br>

<!--Leveraging the power of S/4 HANA in BTP in side by side extension -->
Go to SAP Fiori template (Fiori Open application generator via command palatte) 
</br> menu --> help --> get started  (or)  menu --> view --> command palette    
</br> 
</br>
<img src="./files/capmd10-15.png" >
</br>
</br>

<img src="./files/capmd10-16.png" >
</br>
</br>

<img src="./files/capmd10-17.png" >
</br>
</br>

<img src="./files/capmd10-18.png" >
</br>
</br>

<img src="./files/capmd10-19a.png" >
</br>
</br>

<img src="./files/capmd10-19b.png" >
</br>
</br>

<img src="./files/capmd10-20.png" >
</br>
</br>

<img src="./files/capmd10-21.png" >
</br>
</br>

<img src="./files/capmd10-22.png" >
</br>
</br>

<img src="./files/capmd10-23.png" >
</br>
</br>

<img src="./files/capmd10-24.png" >
</br>
</br>

<img src="./files/capmd10-25.png" >
</br>
</br>

<img src="./files/capmd10-26a.png" >
</br>
</br>

<img src="./files/capmd10-27.png" >
</br>
</br>

<img src="./files/capmd10-28.png" >
</br>
</br>

<img src="./files/capmd10-29.png" >
</br>
</br>

<img src="./files/capmd10-30.png" >
</br>
</br>

<img src="./files/capmd10-31.png" >
</br>
</br>

<img src="./files/capmd10-32.png" >
</br>
</br>
</details>


<details>
<summary> <b>5. making changes to the template built fiori app (annotations.xml) </b> </summary>
</br>
</br>

<img src="./files/capmd10-33.png" >
</br>
</br>
<img src="./files/capmd10-34.png" >
</br>
</br>
<img src="./files/capmd10-35.png" >
</br>
</br>
<img src="./files/capmd10-36.png" >
</br>
</br>
<img src="./files/capmd10-37.png" >
</br>
</br>
<img src="./files/capmd10-38.png" >
</br>
</br>
<img src="./files/capmd10-39.png" >
</br>
</br>
<img src="./files/capmd10-40.png" >
</br>
</br>

<img src="./files/capmd10-40.png" ></br> </br>
<img src="./files/capmd10-41.png" ></br> </br>
<img src="./files/capmd10-42.png" ></br> </br>
<img src="./files/capmd10-43.png" ></br> </br>
<img src="./files/capmd10-44.png" ></br> </br>
<img src="./files/capmd10-45.png" ></br> </br>
<img src="./files/capmd10-46.png" ></br> </br>
<img src="./files/capmd10-47.png" ></br> </br>
<img src="./files/capmd10-48.png" ></br> </br>
<img src="./files/capmd10-49.png" ></br> </br>
<img src="./files/capmd10-50.png" ></br> </br>
<img src="./files/capmd10-51.png" ></br> </br>
<img src="./files/capmd10-52.png" ></br> </br>
<img src="./files/capmd10-53.png" ></br> </br>
<img src="./files/capmd10-54.png" ></br> </br>
<img src="./files/capmd10-55.png" ></br> </br>
<img src="./files/capmd10-56.png" ></br> </br>
<img src="./files/capmd10-57.png" ></br> </br>
<img src="./files/capmd10-58.png" ></br> </br>
<img src="./files/capmd10-59.png" ></br> </br>
<img src="./files/capmd10-60.png" ></br> </br>
<img src="./files/capmd10-61.png" ></br> </br>
<img src="./files/capmd10-62.png" ></br> </br>
<img src="./files/capmd10-63.png" ></br> </br>
<img src="./files/capmd10-64.png" ></br> </br>
<img src="./files/capmd10-65.png" ></br> </br>
<img src="./files/capmd10-66.png" ></br> </br>
<img src="./files/capmd10-67.png" ></br> </br>
<img src="./files/capmd10-68.png" ></br> </br>
<img src="./files/capmd10-69.png" ></br> </br>
<img src="./files/capmd10-70.png" ></br> </br>
<img src="./files/capmd10-71.png" ></br> </br>
<img src="./files/capmd10-72.png" ></br> </br>
<img src="./files/capmd10-73.png" ></br> </br>
<img src="./files/capmd10-74.png" ></br> </br>
<img src="./files/capmd10-75.png" ></br> </br>
<img src="./files/capmd10-76.png" ></br> </br>
<img src="./files/capmd10-77.png" ></br> </br>
<img src="./files/capmd10-78.png" ></br> </br>
<img src="./files/capmd10-79.png" ></br> </br>
<img src="./files/capmd10-80.png" ></br> </br>
<img src="./files/capmd10-81.png" ></br> </br>
<img src="./files/capmd10-82.png" ></br> </br>
<img src="./files/capmd10-83.png" ></br> </br>
<img src="./files/capmd10-84.png" ></br> </br>
</br>
</br>
</details>


<details>
<summary> <b>6. Deploying the fiori app to BTP cloud</b> </summary>
</br>
</br>

The deployment process is same only new thing is the MTA yaml contents will be different 
</br>
</br>

1. DO cf login
2. Perform building MTA archive 
3. Deploy MTA archive
4. Go to SAP build work zone and assign the deployed app to fiori page from HTML 5 repository 

</br>
</br>

CF login  </br></br>
<img src="./files/capmd10-85.png" ></br> </br>
</br></br>

Create MTA archive build </br></br>
<img src="./files/capmd10-86.png" ></br> </br>
<img src="./files/capmd10-87.png" ></br> </br>
</br></br>

Deploy the app</br></br>
<img src="./files/capmd10-93.png" ></br> </br>
<img src="./files/capmd10-94.png" ></br> </br>
<img src="./files/capmd10-95.png" ></br> </br>
</br></br>

</br>
</br>
</details>


<details>
<summary> <b>7. Assigning the deployed app to fiori tile in SAP build work zone </b> </summary>
</br>
</br>
</br>
<img src="./files/capmd10-96.png" ></br> </br>
<img src="./files/capmd10-97.png" ></br> </br>
<img src="./files/capmd10-98.png" ></br> </br>
<img src="./files/capmd10-99.png" ></br> </br>
<img src="./files/capmd10-100.png" ></br> </br>
<img src="./files/capmd10-101.png" ></br> </br>
<img src="./files/capmd10-102.png" ></br> </br>
<img src="./files/capmd10-103.png" ></br> </br>
<img src="./files/capmd10-104.png" ></br> </br>
<img src="./files/capmd10-105.png" ></br> </br>
<img src="./files/capmd10-106.png" ></br> </br>
<img src="./files/capmd10-107.png" ></br> </br>
<img src="./files/capmd10-109.png" ></br> </br>
<img src="./files/capmd10-110.png" ></br> </br>
<img src="./files/capmd10-111.png" ></br> </br>
<img src="./files/capmd10-112.png" ></br> </br>
</br>
</br>
</br>
</details>

</br>
</br>


## Case 2.1
</br>
</br>

**Complete steps for developing Case 2.1 extension app**
</br>
</br>

<details>
<summary> <b> ALL THE STEPS </b> </summary>
</br>
</br>

1. Explore the opn source odat servive provided by microsoft (https://services.odata.org/V3/Northwind/Northwind.svc/)
2. Download the metadata of the odata service as <b>*.edmx</b> file to our system (remember after download remove the xml extension).
3. To view the EDMX file in VSCode we use CSDL modeler extension provided by SAP
4. Create a new CAP application and perform **cds init**
5. Inside the empty CAP application drag and drop the <b>*.edmx</b> file to SRV folder
</br> system will automatically generate external folder and generate a <b>*.csn</b> file 

6. We could see the output for all entity sets, if we select any entity the data is empty
7. define a new custome **CDS** file **datamodel.cds** anad import the csn file to define our own custom entity
</br> from the available entities inside csn as a projection

8. create a file **datamodel.js** and implement the generic handler to fetch the data from remote odata service.
9. To test the configuration lcoally, we added the **credentials.url** in the **package.json** file and tested the app locally

</br> --  Now the extension app is ready for deploy to Cf </br>

10. Added the configuration to connect to destiantion in BTP. Change the configuration to support [Production] 
</br>with credentials having destiantion and path (NorthWind : /V3/Northwind/Northwind.svc)

11. Install SAP Cloud build tool - check [SAP Documentation](https://sap.github.io/cloud-mta-build-tool/) -- check for setup file here [Github link for setup](https://github.com/SAP/cloud-mta-build-tool/releases) [Github build download page](https://sap.github.io/cloud-mta-build-tool/download/) [Github make.exe download page](https://sap.github.io/cloud-mta-build-tool/makefile/)
</br>

```bat
npm install -g mbt

```
</br>

12. Also install make tool by downloading the **gnumake.4.3.exe** from gnu git [link for gnu git](https://github.com/mbuilov/gnumake-windows) 
</br> and download it and rename it to make.exe

13. Add the system environment variable in the **path**

14. In the project we have added the mta.yaml file using command **cds add mta**

15. define the resources which includes **XSUAA** and **destiantion**

16. create the destination resource directly to cloud foundry cockpit 

17. Added the xs-secuirty.json file using command **cds compile srv/ --to xsuaa > xs-security.json**

</br>

```bat
cds compile srv/ --to xsuaa > xs-security.json

```
</br>

18. Change the **xs-security.json** with the simple role 

19. Need to add 3 security modules in our app so called **passport, @sap/xsenv, @sap/xssex**

20. Now build our **mta.yaml** file using **mbt build** in VSCode or right click on BAS to choose Build MTA archive

21. Now we can deploy the mta on cloud foundry, perform **cf login**

22. Then we right click the mta archive file and deploy

23. We can test our app in POSTMAN by first obtaining the xsuaa token from OAuth 2.0 mechanism 
</br> and call the REST API


</br>
</br>
</details>


</br>
</br>
</br>
</br>



**Free Api provided by Microsoft for testing purpose**
</br>

</br> https://services.odata.org/
</br> https://services.odata.org/V3/Northwind/Northwind.svc/
</br>
</br>


<details>
<summary> <b>1. Access the 3rd party API and retrieve data structure </b> </summary>
</br>
</br>

Access the following link (which has $metadata added to it)
</br>[https://services.odata.org/V3/Northwind/Northwind.svc/$metadata](https://services.odata.org/V3/Northwind/Northwind.svc/$metadata)
</br>
</br> and save the page as NorthWind.edmx file </br> </br> 
<img src="./files/capmd10-113.png" ></br> </br>
<img src="./files/capmd10-114.png" ></br> </br>
<img src="./files/capmd10-115.png" ></br> </br>
<img src="./files/capmd10-116.png" ></br> </br>

</br>
</br>
</details>


<details>
<summary> <b>2. Use the data structure file in app for defining a structure</b> </summary>
</br>
</br>

1. Go to Vs code and create a new project and perform cds init </br></br>
<img src="./files/capmd10-117.png" ></br> </br>

2. do a cds watch </br> </br>
<img src="./files/capmd10-118.png" ></br> </br>

3. drag and drop the *.edmx file to SRV folder make sure the naming should be in proper case (NorthWind.edmx)</br></br>
<img src="./files/capmd10-119.png" ></br> </br>
<img src="./files/capmd10-119a.png" ></br> </br>

</br> </br>

> [!NOTE]
> In case the file drag and drop is perfromed with wrong file name (northwind.edmx) please repeat the process (create new project folder, perform cds init , then perform Northwind.edmx with correct file name)

</br> </br>

4. in command prompt we can see some actions performed </br></br>
<img src="./files/capmd10-120.png" ></br> </br>

5. Access the link here and it takes to a SRV skeleton page as shown below</br></br>
<img src="./files/capmd10-121.png" ></br> </br>
<img src="./files/capmd10-122.png" ></br> </br>
<img src="./files/capmd10-123.png" ></br> </br>

6. A CSN file gets created (CDS schema notation)</br></br>
<img src="./files/capmd10-124.png" ></br> </br>

7. A rough preview into the CSN file</br></br>
<img src="./files/capmd10-125.png" ></br> </br>

7. Install an extension in VSCode to view the EDMX file</br></br>
<img src="./files/capmd10-126.png" ></br> </br>

8. View the file</br></br>
<img src="./files/capmd10-127.png" ></br> </br>
<img src="./files/capmd10-128.png" ></br> </br>
<img src="./files/capmd10-129.png" ></br> </br>

</br>
</br>
</details>

<details>
<summary> <b>3. Use the file to develop the extension app</b> </summary>
</br>
</br>

**The goal is to display only one catalog services exposed with data to web out of many listed**
</br>
</br>

<img src="./files/capmd10-130.png" ></br> </br>
<img src="./files/capmd10-131.png" ></br> </br>

</br>
</br>
Creating a datamodel.cds and datamodel.js inside SRV folder</br> </br>
<img src="./files/capmd10-132.png" ></br> </br>
<img src="./files/capmd10-133.png" ></br> </br>
<img src="./files/capmd10-134.png" ></br> </br>
<img src="./files/capmd10-135a.png" ></br> </br>
<img src="./files/capmd10-136.png" ></br> </br>
<img src="./files/capmd10-137.png" ></br> </br>
</br> </br>


open $metadata page of the NorthWind from this link ([https://services.odata.org/V3/Northwind/Northwind.svc/$metadata](https://services.odata.org/V3/Northwind/Northwind.svc/$metadata)) and look for Customers entity structure and check the details 
</br> </br>
<img src="./files/capmd10-138a.png" ></br> </br>

Following structure is picked from NorthWind.edmx file (now we generate some test data for this structure in [mockaroo.com](https://www.mockaroo.com/))
</br> </br>

```xml

<Property Name="CustomerID" Type="Edm.String" Nullable="false" MaxLength="5" FixedLength="true" Unicode="true"/>
<Property Name="CompanyName" Type="Edm.String" Nullable="false" MaxLength="40" FixedLength="false" Unicode="true"/>
<Property Name="ContactName" Type="Edm.String" MaxLength="30" FixedLength="false" Unicode="true"/>
<Property Name="ContactTitle" Type="Edm.String" MaxLength="30" FixedLength="false" Unicode="true"/>
<Property Name="Address" Type="Edm.String" MaxLength="60" FixedLength="false" Unicode="true"/>
<Property Name="City" Type="Edm.String" MaxLength="15" FixedLength="false" Unicode="true"/>
<Property Name="Region" Type="Edm.String" MaxLength="15" FixedLength="false" Unicode="true"/>
<Property Name="PostalCode" Type="Edm.String" MaxLength="10" FixedLength="false" Unicode="true"/>
<Property Name="Country" Type="Edm.String" MaxLength="15" FixedLength="false" Unicode="true"/>
<Property Name="Phone" Type="Edm.String" MaxLength="24" FixedLength="false" Unicode="true"/>
<Property Name="Fax" Type="Edm.String" MaxLength="24" FixedLength="false" Unicode="true"/>

CustomerID
CompanyName
ContactName
ContactTitle
Address
City
Region
PostalCode
Country
Phone
Fax

```
</br> </br>

Test data generation, I manipulated the file for cusotmer id in excel (becasue the customerID lenght is 5)
</br> </br>
<img src="./files/capmd10-139.png" ></br> </br>

Add the test data to the csv file (copy pasted)
</br> </br>
<img src="./files/capmd10-140.png" ></br> </br>
<img src="./files/capmd10-141.png" ></br> </br>
<img src="./files/capmd10-142.png" ></br> </br>

We have filled data from our local csv file ,Now we make changes to get data from api itself
</br> </br>
<img src="./files/capmd10-143.png" ></br> </br>
<img src="./files/capmd10-144.png" ></br> </br>
<img src="./files/capmd10-145.png" ></br> </br>

The catalog service will display error when accessed 
</br> </br>
<img src="./files/capmd10-146.png" ></br> </br>

Following link is accessed in Postman as well as in browseer to see the data coming from API
</br> </br>
<img src="./files/capmd10-147.png" ></br> </br>
<img src="./files/capmd10-148a.png" ></br> </br>
<img src="./files/capmd10-149.png" ></br> </br>

We have to instruct CAP framewrok to retrieve the data and map to our struture so we need to write code in datamodel.js for catalog service
</br> </br>

Code sample used in datamodel.js 
</br> </br>

```js

const cds = require("@sap/cds");

module.exports = cds.service.impl(async function(){
  const { Customers } = this.entities;
  const service = await cds.connect.to("NorthWind");
  this.on('READ', Customers, async (request) => {    
    // check, pre-checks, make filters, authorization, security
    var data = await service.tx(request).run(request.query);
    console.log(data);  // <------ This part works       
    // data.push({   // <------ This part didnt work -- Gives error in console 
    //     "CustomerID": "CLEON",
    //     "CompanyName": "Dante explore",
    //     "ContactName": "cassian andor",
    //     "ContactTitle": "Developer",
    //     "Address": "KCD street",
    //     "City": "Kuttenberg",
    //     "Region": null,
    //     "PostalCode": "12209",
    //     "Country": "Hungary",
    //     "Phone": "030-0074321",
    //     "Fax": "030-0076545"
    // });    
    return data// <------ This part didnt work so the web didnt return any data.
  });
});

```
</br>
</br>


need to install a component to run things successfully cloud sdk http client is needed

```bat
npm install @sap-cloud-sdk/http-client
npm install -g @sap/cds-dk
```

<img src="./files/capmd10-150.png" ></br> </br>
<img src="./files/capmd10-152.png" ></br> </br>
<img src="./files/capmd10-153.png" ></br> </br>


</br>
</br>
</details>

</br>
</br>

**(*Lets assume the exposing data works and will proceed further to deploy the extension app to Cloud foundry*)**
</br>
</br>

<details>
<summary> <b>4. Preparing for deployment -- Part 1 </b> </summary>
</br>
</br>

**Need to install MBT tool to windows system where vscode is running for building the MTA archive**
</br>
</br>

1. Go to website (https://sap.github.io/cloud-mta-build-tool/) </br></br>
<img src="./files/capmd10-154.png" ></br> </br>

2. Access these pages</br> </br>
<img src="./files/capmd10-155.png" ></br> </br>
<img src="./files/capmd10-156.png" ></br> </br>
<img src="./files/capmd10-157.png" ></br> </br>

3. Use npm install -g mbt </br></br>
<img src="./files/capmd10-158.png" ></br> </br>

4. Download the GNU make from this github page</br> </br>
<img src="./files/capmd10-159.png" ></br> </br>

5. Change the downloaded Gnumake.exe put it in D: or C: drive and rename it</br> </br>
<img src="./files/capmd10-160.png" ></br> </br>

6. Assign the make.exe directory to environment variables **(Open the screenshot in new page to view it bigger)** </br> </br>
<img src="./files/capmd10-161.png" ></br> </br>

7. Add MTA.yaml file (cds add mta)</br> </br>
<img src="./files/capmd10-162.png" ></br> </br>
<img src="./files/capmd10-163.png" ></br> </br>

8. Define destination details in package.json (in credentials section) </br> </br>
<img src="./files/capmd10-164.png" ></br> </br>
<img src="./files/capmd10-165.png" ></br> </br>

**package.json** </br> </br>

```json

{
  "name": "03_CAP",
  "version": "1.0.0",
  "description": "A simple CAP project.",
  "repository": "<Add your repository here>",
  "license": "UNLICENSED",
  "private": true,
  "dependencies": {
    "@sap-cloud-sdk/http-client": "^3.15.0",
    "@sap/cds": "^7.9.0",
    "@sap/cds-dk": "^7.9.1",
    "@sap/xsenv": "^5.1.0",
    "@sap/xssec": "^3.6.1",
    "express": "^4",
    "passport": "^0.7.0"
  },
  "devDependencies": {
    "@cap-js/sqlite": "^1",
    "@sap/cds": "^7.9.0",
    "@sap/cds-dk": "^7.9.1"
  },
  "scripts": {
    "start": "cds-serve"
  },
  "cds": {
    "requires": {
      "NorthWind": {
        "kind": "odata-v2",
        "model": "srv/external/NorthWind",
        "credentials": {
          "destination" : "NorthWind",
          "path" : "/V3/Northwind/Northwind.svc"
        }
      }
    }
  }
}



```
</br> </br>



9. Need to add **xs-security** file to the app by using following command</br> </br>

```bat

cds compile srv/ --to xsuaa > xs-security.json

```

</br> </br>
<img src="./files/capmd10-166.png" ></br> </br>

visit this official page for sample - refer the following links to prepare the files
</br>
</br> [SAP Official page](https://help.sap.com/docs/btp/sap-business-technology-platform/application-security-descriptor-configuration-syntax) 
</br> [Github sample 1](https://github.com/SAP-samples/cloud-application-security-sample/blob/main/spring-security-basis/security/xs-security.json)
</br> [Github sample 2](https://github.com/SAP/cloud-security-services-integration-library/blob/main/samples/spring-security-xsuaa-usage/xs-security.json)
</br>

**xs-security.json** file sample </br> </br>

```json

{
  "xsappname": "03_CAP",
  "tenant-mode": "dedicated",
  "scopes": [
    {
      "name": "$XSAPPNAME.Viewer",
      "description": "Read Permissions."
    }
  ],
  "role-templates": [
    {
      "name": "Viewer",
      "description": "View Data",
      "attribute-references": [],
      "scope-references": ["$XSAPPNAME.Viewer"]
    }
  ],
  "oauth2-configuration": {
    "token-validity": 60900,
    "refresh-token-validity": 2592000,
    "redirect-uris": [
      "https://*.cfapps.us10-001.hana.ondemand.com/login/callback"
    ]
  }
}


```


10. Need to add 2 resources to MTA yaml file as shown below alos made some formatting corrections</br> </br>
<img src="./files/capmd10-167a.png" ></br> </br>


MTA yaml sample for reference 
</br> </br>

```yaml

## generated mta.yaml based on temaplate version 0.4.0
## appname = 03_CAP
## language-nodejs; multitenat=false
## approuter
_schema-version: '3.1'
ID: 03_CAP
version: 1.0.0
description: "Cloud extension project using CAP"
parameters:
  enable-parallel-deployments: true

build-parameters:
  before-all:
    - builder: custom
      commands:
        - npm install --production
        - npx -p @sap/cds-dk cds build --production
        - npm clean-install --production
#----------------------------------------------------------- 

modules:
#--------------------- SERVER MODULE -----------------------
  - name: 03_CAP-srv
#-----------------------------------------------------------  
    type: nodejs
    path: gen/srv
    parameters:
      buildpack: nodejs_buildpack
    build-parameters:
      builder: npm-ci      
    provides:
      - name: srv-api # required by consumers of CAP services (e.g. approuter)
        properties:
          srv-url: ${default-url}
    requires:
      - name: 03_CAP-destination
      - name: 03_CAP-xsuaa    
          
#-------------------END OF SERVER MODULE -------------------
#----------------------------------------------------------- 

resources:
  - name: 03_CAP-destination
    type: org.cloudfoundry.managed-service
    parameters:
      service: destination
      service-plan: lite
  - name: 03_CAP-xsuaa
    type: org.cloudfoundry.managed-service
    parameters:
      path: ./xs-security.json
      service : xsuaa
      service-plan: application   

#-----------------------------------------------------------              

```

</br> </br>


11. Define a destination service in BTP as shown below </br> </br>
<img src="./files/capmd10-168.png" ></br> </br>
<img src="./files/capmd10-169.png" ></br> </br>
<img src="./files/capmd10-170.png" ></br> </br>
<img src="./files/capmd10-171.png" ></br> </br>
<img src="./files/capmd10-172.png" ></br> </br>
<img src="./files/capmd10-173.png" ></br> </br>

[Destination details for BTP download here just import it](https://github.com/Octavius-Dante/Tetra_Proxima/blob/main/CAPM-DAY-10/NorthWind-destination-file-BTP)
</br> </br>

12. Install security components to the app</br> </br>

```bat

npm install @sap/xssec
npm install @sap/xsenv
npm install passport

```
</br> </br>

<img src="./files/capmd10-174.png" ></br> </br>

13. Trying to make a build using command in vscode (ended up in error)</br> </br>
<img src="./files/capmd10-175.png" ></br> </br>

14. So archiving the project in VSCode and moving the app to BAS</br> </br>
<img src="./files/capmd10-176.png" ></br> </br>
<img src="./files/capmd10-177.png" ></br> </br>
<img src="./files/capmd10-178.png" ></br> </br>
<img src="./files/capmd10-179.png" ></br> </br>
<img src="./files/capmd10-180.png" ></br> </br>
<img src="./files/capmd10-181.png" ></br> </br>
<img src="./files/capmd10-182.png" ></br> </br>
<img src="./files/capmd10-183.png" ></br> </br>


<img src="./files/capmd10-184.png" ></br> </br>
<img src="./files/capmd10-185.png" ></br> </br>
<img src="./files/capmd10-186.png" ></br> </br>
<img src="./files/capmd10-187.png" ></br> </br> 
<img src="./files/capmd10-188.png" ></br> </br>
<img src="./files/capmd10-189.png" ></br> </br>
<img src="./files/capmd10-190.png" ></br> </br>
<img src="./files/capmd10-191.png" ></br> </br>
<img src="./files/capmd10-192.png" ></br> </br>
<img src="./files/capmd10-193.png" ></br> </br>
<img src="./files/capmd10-194.png" ></br> </br>
<img src="./files/capmd10-195.png" ></br> </br>
<img src="./files/capmd10-196.png" ></br> </br>
<img src="./files/capmd10-197.png" ></br> </br>
<img src="./files/capmd10-198.png" ></br> </br>
<img src="./files/capmd10-199.png" ></br> </br>
<img src="./files/capmd10-200.png" ></br> </br>

</br>
</br>

</br>
</br>
</details>

<details>
<summary> <b>4. Preparing for deployment -- Part 2 </b> </summary>
</br>
</br>

</br>
</br>
</details>


<details>
<summary> <b>4. Preparing for deployment -- Part 3 </b> </summary>
</br>
</br>

</br>
</br>

</br>
</br>
</details>

<details>
<summary> <b>5. Deployment and testing via postman </b> </summary>
</br>
</br>

</br>
</br>

</br>
</br>
</details>


</br>
</br>
</br>
</br>


## Case 1.0 (files for reference)
</br>

**annotation.xml before changes**

<details>
<summary> annotation.xml file sample </b> </summary>
</br>
</br>

```xml

<edmx:Edmx xmlns:edmx="http://docs.oasis-open.org/odata/ns/edmx" Version="4.0">
    <edmx:Reference Uri="https://sap.github.io/odata-vocabularies/vocabularies/Common.xml">
        <edmx:Include Namespace="com.sap.vocabularies.Common.v1" Alias="Common"/>
    </edmx:Reference>
    <edmx:Reference Uri="https://sap.github.io/odata-vocabularies/vocabularies/UI.xml">
        <edmx:Include Namespace="com.sap.vocabularies.UI.v1" Alias="UI"/>
    </edmx:Reference>
    <edmx:Reference Uri="https://sap.github.io/odata-vocabularies/vocabularies/Communication.xml">
        <edmx:Include Namespace="com.sap.vocabularies.Communication.v1" Alias="Communication"/>
    </edmx:Reference>
    <edmx:Reference Uri="/sap/opu/odata/sap/SEPMRA_PROD_MAN/$metadata">
        <edmx:Include Namespace="SEPMRA_PROD_MAN" Alias="SAP"/>
    </edmx:Reference>
    <edmx:DataServices>
        <Schema xmlns="http://docs.oasis-open.org/odata/ns/edm" Namespace="local">
        </Schema>
    </edmx:DataServices>
</edmx:Edmx>

```
</br>
</br>
</details>

</br>

**annotation.xml after changes**

<details>
<summary> annotation.xml file sample - modified</b> </summary>
</br>
</br>

```xml

<edmx:Edmx xmlns:edmx="http://docs.oasis-open.org/odata/ns/edmx" Version="4.0">
    <edmx:Reference Uri="https://sap.github.io/odata-vocabularies/vocabularies/Common.xml">
        <edmx:Include Namespace="com.sap.vocabularies.Common.v1" Alias="Common"/>
    </edmx:Reference>
    <edmx:Reference Uri="https://sap.github.io/odata-vocabularies/vocabularies/UI.xml">
        <edmx:Include Namespace="com.sap.vocabularies.UI.v1" Alias="UI"/>
    </edmx:Reference>
    <edmx:Reference Uri="https://sap.github.io/odata-vocabularies/vocabularies/Communication.xml">
        <edmx:Include Namespace="com.sap.vocabularies.Communication.v1" Alias="Communication"/>
    </edmx:Reference>
    <edmx:Reference Uri="/sap/opu/odata/sap/SEPMRA_PROD_MAN/$metadata">
        <edmx:Include Namespace="SEPMRA_PROD_MAN" Alias="SAP"/>
    </edmx:Reference>
    <edmx:DataServices>
        <Schema xmlns="http://docs.oasis-open.org/odata/ns/edm" Namespace="local">

            <Annotations Target="SAP.SEPMRA_C_PD_ProductType">
                <Annotation Term="UI.Facets" >
                    <Collection>
                        <Record Type="UI.ReferenceFacet">
                            <PropertyValue Property="Target" AnnotationPath="@UI.FieldGroup#Dreamland"/>
                            <PropertyValue Property="Label" String="More info"/>
                        </Record>
                        <Record Type="UI.ReferenceFacet">
                            <PropertyValue Property="Target" AnnotationPath="to_ProductSalesData/@UI.LineItem#Wonderland"/>
                            <PropertyValue Property="Label" String="Sales related to product"/>
                        </Record>        
                        <Record Type="UI.ReferenceFacet">
                            <PropertyValue Property="Target" AnnotationPath="to_ProductSalesData/@UI.Chart#RevenueByCountry"/>
                            <PropertyValue Property="Label" String="Insights"/>
                        </Record>                                                
                    </Collection>
                </Annotation>
               <Annotation Term="UI.FieldGroup" Qualifier="Dreamland">
                   <Record Type="UI.FieldGroupType">
                       <PropertyValue Property="Data">
                           <Collection>
                               <Record Type="UI.DataField">
                                   <PropertyValue Property="Value" Path="Name"/>
                                   <PropertyValue Property="Label" String="Name"/>
                               </Record>
                               <Record Type="UI.DataField">
                                   <PropertyValue Property="Value" Path="Description"/>
                                   <PropertyValue Property="Label" String="Description"/>
                               </Record>
                               <Record Type="UI.DataField">
                                   <PropertyValue Property="Value" Path="Price"/>
                                   <PropertyValue Property="Label" String="Price"/>
                               </Record>
                               <Record Type="UI.DataField">
                                   <PropertyValue Property="Value" Path="Currency"/>
                                   <PropertyValue Property="Label" String="Currency"/>
                               </Record>
                               <Record Type="UI.DataField">
                                   <PropertyValue Property="Value" Path="DimensionUnit"/>
                                   <PropertyValue Property="Label" String="DimensionUnit"/>
                               </Record>
                               <Record Type="UI.DataField">
                                   <PropertyValue Property="Value" Path="Product"/>
                                   <PropertyValue Property="Label" String="Id"/>
                               </Record>                                                                                                                                                           
                           </Collection>
                       </PropertyValue>
                   </Record>
               </Annotation> 
            </Annotations>
            <Annotations Target="SAP.SEPMRA_C_PD_ProductSalesDataType">
                <Annotation Term="UI.LineItem" Qualifier="Wonderland" >
                    <Collection>
                        <Record Type="UI.DataField">
                            <PropertyValue Property="Value" Path="SalesOrder"/>
                        </Record>
                        <Record Type="UI.DataField">
                            <PropertyValue Property="Value" Path="SoldToParty"/>
                        </Record>
                        <Record Type="UI.DataField">
                            <PropertyValue Property="Value" Path="NetAmount"/>
                        </Record>
                        <Record Type="UI.DataField">
                            <PropertyValue Property="Value" Path="SoldToPartyCountry"/>
                        </Record>                                                                        
                    </Collection>
                </Annotation>
            </Annotations>
        </Schema>
    </edmx:DataServices>
</edmx:Edmx>

```
</br>
</br>
</details>

</br>

**mta.yaml default - before changes** 

<details>
<summary> <b> mta.yaml file sample before changes </b> </summary>
</br>
</br>

```yaml

_schema-version: "3.2"
ID: comdanteproductsmanagaeproduct
description: Generated by Fiori Tools
version: 0.0.1
modules:
- name: comdanteproductsmanagaeproduct-destination-content
  type: com.sap.application.content
  requires:
  - name: comdanteproductsmanagaeproduct-destination-service
    parameters:
      content-target: true
  - name: comdanteproductsmanagaeproduct-repo-host
    parameters:
      service-key:
        name: comdanteproductsmanagaeproduct-repo-host-key
  - name: comdanteproductsmanagaeproduct-uaa
    parameters:
      service-key:
        name: comdanteproductsmanagaeproduct-uaa-key
  parameters:
    content:
      instance:
        destinations:
        - Name: comdanteproductsmanagaeproduct_html_repo_host
          ServiceInstanceName: comdanteproductsmanagaeproduct-html5-srv
          ServiceKeyName: comdanteproductsmanagaeproduct-repo-host-key
          sap.cloud.service: comdanteproductsmanagaeproduct
        - Authentication: OAuth2UserTokenExchange
          Name: comdanteproductsmanagaeproduct_uaa
          ServiceInstanceName: comdanteproductsmanagaeproduct-xsuaa-srv
          ServiceKeyName: comdanteproductsmanagaeproduct-uaa-key
          sap.cloud.service: comdanteproductsmanagaeproduct
        existing_destinations_policy: ignore
  build-parameters:
    no-source: true
- name: comdanteproductsmanagaeproduct-app-content
  type: com.sap.application.content
  path: .
  requires:
  - name: comdanteproductsmanagaeproduct-repo-host
    parameters:
      content-target: true
  build-parameters:
    build-result: resources
    requires:
    - artifacts:
      - comdanteproductsmanagaeproduct.zip
      name: comdanteproductsmanagaeproduct
      target-path: resources/
- name: comdanteproductsmanagaeproduct
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
- name: comdanteproductsmanagaeproduct-destination-service
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
    service-name: comdanteproductsmanagaeproduct-destination-service
    service-plan: lite
- name: comdanteproductsmanagaeproduct-uaa
  type: org.cloudfoundry.managed-service
  parameters:
    path: ./xs-security.json
    service: xsuaa
    service-name: comdanteproductsmanagaeproduct-xsuaa-srv
    service-plan: application
- name: comdanteproductsmanagaeproduct-repo-host
  type: org.cloudfoundry.managed-service
  parameters:
    service: html5-apps-repo
    service-name: comdanteproductsmanagaeproduct-html5-srv
    service-plan: app-host
parameters:
  deploy_mode: html5-repo
  enable-parallel-deployments: true


```

</br>
</br>
</details>

</br>

**mta.yaml default - after changes** 

<details>
<summary> <b> mta.yaml file sample after changes </b> </summary>
</br>
</br>

```yaml

_schema-version: "3.2"
ID: comdanteproductsmanagaeproduct
description: Generated by Fiori Tools
version: 0.0.1
modules:
- name: comdanteproductsmanagaeproduct-destination-content
  type: com.sap.application.content
  requires:
  - name: comdanteproductsmanagaeproduct-destination-service
    parameters:
      content-target: true
  - name: comdanteproductsmanagaeproduct-repo-host
    parameters:
      service-key:
        name: comdanteproductsmanagaeproduct-repo-host-key
  - name: comdanteproductsmanagaeproduct-uaa
    parameters:
      service-key:
        name: comdanteproductsmanagaeproduct-uaa-key
  parameters:
    content:
      instance:
        destinations:
        - Name: comdanteproductsmanagaeproduct_html_repo_host
          ServiceInstanceName: comdanteproductsmanagaeproduct-html5-srv
          ServiceKeyName: comdanteproductsmanagaeproduct-repo-host-key
          sap.cloud.service: comdanteproductsmanagaeproduct
        - Authentication: OAuth2UserTokenExchange
          Name: comdanteproductsmanagaeproduct_uaa
          ServiceInstanceName: comdanteproductsmanagaeproduct-xsuaa-srv
          ServiceKeyName: comdanteproductsmanagaeproduct-uaa-key
          sap.cloud.service: comdanteproductsmanagaeproduct
        existing_destinations_policy: ignore
  build-parameters:
    no-source: true
- name: comdanteproductsmanagaeproduct-app-content
  type: com.sap.application.content
  path: .
  requires:
  - name: comdanteproductsmanagaeproduct-repo-host
    parameters:
      content-target: true
  build-parameters:
    build-result: resources
    requires:
    - artifacts:
      - comdanteproductsmanagaeproduct.zip
      name: comdanteproductsmanagaeproduct
      target-path: resources/
- name: comdanteproductsmanagaeproduct
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
- name: comdanteproductsmanagaeproduct-destination-service
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
    service-name: comdanteproductsmanagaeproduct-destination-service
    service-plan: lite
- name: comdanteproductsmanagaeproduct-uaa
  type: org.cloudfoundry.managed-service
  parameters:
    path: ./xs-security.json
    service: xsuaa
    service-name: comdanteproductsmanagaeproduct-xsuaa-srv
    service-plan: application
- name: comdanteproductsmanagaeproduct-repo-host
  type: org.cloudfoundry.managed-service
  parameters:
    service: html5-apps-repo
    service-name: comdanteproductsmanagaeproduct-html5-srv
    service-plan: app-host
parameters:
  deploy_mode: html5-repo
  enable-parallel-deployments: true


```

</br>
</br>
</details>

</br>
</br>
</br>

<details>
<summary> Access this section of the BAS to get help for developing fiori app </summary>
</br>
</br>
<img src="./files/capmd10-88.png" ></br> </br>
<img src="./files/capmd10-89.png" ></br> </br>
<img src="./files/capmd10-90.png" ></br> </br>
<img src="./files/capmd10-91.png" ></br> </br>
<img src="./files/capmd10-92.png" ></br> </br>
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

# NEXT ------ CAPM - DAY 11 - Side by Side extension 2.0

<p align="center"> 
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-11"> CAPM DAY 11 - Side by Side extension 2.0</a> 
	
</br>
</br>

#### Previous Sessions
</br>
<!--
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-12"> CAPM Day 12 - Extension CI CD</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-11"> CAPM Day 11 - Side by Side extension 2.0</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-10"> CAPM Day 10 - Side by Side extension 1.0</a>
-->

- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-9"> CAPM Day 9 - Serverless Fiori App</a>
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