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
- To avoid this we have an <b>adapter</b> which will use v2 version as v4 

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
