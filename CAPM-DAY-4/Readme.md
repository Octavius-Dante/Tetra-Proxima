## CAPM - Day 4 - Generic Handlers

#### Creating of odata services to our app 

</br>
</br>

Will continue today from yesterdays application 
</br> - will focus on creating services on top of data model we created on previous day 
</br> - odata services 
 
</br>

Go to our application SRV folder and create a file (CatalogService.cds) as shown below 
</br>
```cds
// importing data models and views to our service
using {dan.db} from '../db/datamodel';
using {dante.cds} from '../db/CDSViews';

// so in cap services odata will trim tha name when there is upper case in the word
// example MyName will be dispalyed as My the part (Name) will be removed
// to avoid this we use @(path:<service-name>) annotation

service CatalogService @(path: 'CatalogService') {

    entity BusinessPartnerSet as projection on db.master.businesspartner;
    entity AddressSet         as projection on db.master.address;
    entity EmployeeSet        as projection on db.master.employees;
    entity PurchseOrderItems  as projection on db.transaction.poitems;

    entity POs                as
        projection on db.transaction.purchaseorder {
            *,
            Items : redirected to PurchseOrderItems
        };

    entity CProductValuesView as projection on cds.CDSViews.CProductValuesView;

}

}

```
</br>
<img src="./files/capmd4-1.png" >
</br>
</br>

After creationg the file deploy it and run (best practise) 

#### if you find cds-serve in package.json - it takes care automatically this is new feature from 2024
#### (service creation - no need to deploy, DB and View creation need to deploy) - if you find cds-serve in package.json
#### (instead if you find cds watch) then it takes care automatically

<img src="./files/capmd4-2.png" >
</br>
</br>

Now run the applicaiton through terminal and test it as shown below (i didnt deploy) i just run it works 
</br>
<img src="./files/capmd4-3.png" >
</br>
<img src="./files/capmd4-4.png" >
</br>
</br>
</br>
</br>

Now we can check developer tools in browser for identifying odata vesion as shown below 
</br>
</br>
<img src="./files/capmd4-6.png" >
</br>
</br>
</br>

older version example go to this web page https://services.odata.org/ and select any link 
</br>
</br>
<img src="./files/capmd4-5a.png" >
</br>
</br>
</br>

use <b>(?$format=json) </b> to the link and you will see the following page press f12 and check the version 
</br>
</br>
<img src="./files/capmd4-7.png" >
</br>
</br>

### Backward compatibility 
</br>
</br>

- default sap fiori which comes out of on-prem is odata v2 
- defualt sap fiori which comes out of cloud is odata v4
- SAP applicaitons developed in odata v2 cannot be used for odata v4 - requries (redesign or code changes)
- To avoid this we have an <b>adapter</b> which will use v4 version as v2
- SAP provided this adpters as node module (goto npm site : https://www.npmjs.com/search?q=odata-v2-adapter)
- Search for odata-v2-adapter (pick the proxy one)
- install the adapter using command
- create JS file is (srv) directory (./srv/server.js:) and copy the contents
- run and test the application
  - OData V2 service will be available at http://localhost:4004/v2/
  - OData V4 service will be available at http://localhost:4004/
</br>

```bat
npm install @sap/cds-odata-v2-adapter-proxy -s
```
</br>

### server.js
</br>

```js
const cds = require("@sap/cds");
const cov2ap = require("@sap/cds-odata-v2-adapter-proxy");
cds.on("bootstrap", (app) => app.use(cov2ap()));
module.exports = cds.server;
```

</br>
<img src="./files/capmd4-8.png" >
</br>
<img src="./files/capmd4-9.png" >
</br>
<img src="./files/capmd4-10.png" >
</br>


</br>
</br>
### OData v2 
</br>
it can be identified by represneration d in front of result set 
</br>
</br>

</br>
</br>
cloud BAS main page
</br>
<img src="./files/capmd4-10a.png" >
</br>

local VSCode main page
</br>
<img src="./files/capmd4-11a.png" >
</br>

</br> Add v2/ after the cloud link an then navigate from thae page 
</br> https://port4004-workspaces-ws-n8568.us10.trial.applicationstudio.cloud.sap/v2/
</br>
</br> SAP cloud BAS
</br> https://port4004-workspaces-ws-n8568.us10.trial.applicationstudio.cloud.sap/v2/odata/v4/CatalogService/BusinessPartnerSet
</br>
</br>
</br>  Add v2/ after the local host link an then navigate from thae page
</br> http://localhost:4004/v2/
</br>
</br> VSCode
</br> http://localhost:4004/v2/odata/v4/CatalogService/BusinessPartnerSet

</br>
cloud BAS
<img src="./files/capmd4-10b.png" >
</br>
</br>
VSCode
<img src="./files/capmd4-11b.png" >
</br>
</br>

</br>

### CURDQ Testing for cloud 
</br>
 We cannot test CURD operation through postman on this cloud application it is not supported only local VS code works with postman
</br>
</br>

### A way to test CURDQ in cloud 
</br>
create tester.http (any name of your choice *.http) file under (srv) folder like shown below 
</br>
</br>

determine the correct link before you add it to tester.http file 
</br>
<img src="./files/capmd4-12a.png" >
</br>
<img src="./files/capmd4-12c.png" >
</br>
</br>

click the link (send request) to test
</br>
<img src="./files/capmd4-12b.png" >
</br>
</br>

if the link is correct following output window will appear with right data 
</br>
<img src="./files/capmd4-12d.png" >
</br>
</br>


Contents of tester.http
</br>

```http



```
</br>
</br>

### Testing POST call testing challenges - and troubleshoot 
</br>

When copied the data of some random GET and modified it for posting following corrections carried out 
 - serialization error for bank id error <b>FIX -(change the length) of BANKID</b>
 - Email format error <b>FIX -(we have to modify the REGEX expression in our program)</b>
       - (https://www.tutorialspoint.com/checking-for-valid-email-address-using-regular-expressions-in-java)

</br>

```json

"message": "Deserialization Error: Invalid value 121000358 (string) for property \"bankId\".
The length of the Edm.String value must not be greater than the MaxLength facet value (8)."

```

```json
{
  "error": {
    "code": "400",
    "message": "Value \"sunny.winter@Ey.com\" is not in specified format \"/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/\"",
    "target": "email",
    "@Common.numericSeverity": 4
  }
```

</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
