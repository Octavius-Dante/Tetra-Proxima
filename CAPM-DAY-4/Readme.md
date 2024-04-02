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

After making the file with mentioend contents dont just run it deploy it and run 
</br> (from 2024 onwards Npm takes care of this) you can directly run it 
</br> if you find cds-serve in package.json - it takes care automatically (instead if you find cds run, cds watch) then you have to manually do it - deploy it and run 

<img src="./files/capmd4-2.png" >
</br>
</br>





Change the theme for BAS as shown below in case White is not comfortable for the eyes 

</br>


```JS

```

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
