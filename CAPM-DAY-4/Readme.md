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
#### (service creation - no need to deploy, DB and View creation need to deploy)
</br>

#### (from 2024 onwards Npm takes care of this) you can directly run it 
#### if you find cds-serve in package.json - it takes care automatically (instead if you find cds run, cds watch) then you have to manually do it - deploy it and run 
<img src="./files/capmd4-2.png" >
</br>
</br>

Now run the applciaiton through terminal and test it as shown below 
</br>
<img src="./files/capmd4-3.png" >
</br>
<img src="./files/capmd4-4.png" >
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
</br>
