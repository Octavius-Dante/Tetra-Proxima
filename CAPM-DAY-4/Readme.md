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
namespace dante.cds;

using { dan.db.master, dan.db.transaction } from './datamodel';

context CDSViews {
    define view![POWorklist] as // to make it case sensitive even in output and runtime 
     select from transaction.purchaseorder{
        key PO_ID as![PurchaseOrderID],
        key Items.PO_ITEM_POS as![ItemPosition],
        PARTNER_GUID as![PartnerID],
        PARTNER_GUID.COMPANY_NAME as ![CompanyName],
        GROSS_AMOUNT as![GrossAmount],
        NET_AMOUNT as![NEtAmount],
        TAX_AMOUNT as![TAxAmount],
        CURRENCY as![CurrencyCode],
        OVERALL_STATUS as![Status],
        Items.PRODUCT_GUID.PRODUCT_ID as![ProductId],
        Items.PRODUCT_GUID.DESCRIPTION as![ProductName],      
        PARTNER_GUID.ADDRESS_GUID.CITY as![City],
        PARTNER_GUID.ADDRESS_GUID.COUNTRY as![Country],
     };


     define view![ProductValueHelp] as
     select from master.product{
      @EndUserText.label:[
         {
            language: 'EN',
            text: 'Product id'
         },
         {
            language: 'DE',
            text: 'Prodekt id'            
         }
      ]
      PRODUCT_ID as![ProductId],
            @EndUserText.label:[
         {
            language: 'EN',
            text: 'Product Description'
         },
         {
            language: 'DE',
            text: 'Prodekt Beschreibung'            
         }
      ]
      DESCRIPTION as![Description]
     };


   define view![ItemView] as 
   select from transaction.poitems{
      PARENT_KEY.PARTNER_GUID.NODE_KEY as![CustomerID],
      PRODUCT_GUID.NODE_KEY as![ProductId],
      CURRENCY as![CurrencyCode],
      GROSS_AMOUNT as![GrossAmount],
      NET_AMOUNT as![NetAmount],
      TAX_AMOUNT as![TaxAmount],
      PARENT_KEY.OVERALL_STATUS as![Status]     
   };


   define view ![ProductView] as 
   // Mixin is a keyword to define lose coupling 
   // which will never load items data for product rather load on demand 
   // another name (assocaition - join on demand)
   select from master.product 
   mixin{
      // View on view
      PO_ORDER: Association[*] to ItemView on PO_ORDER.ProductId = $projection.ProductId
   } into {
      NODE_KEY as![ProductId],
      DESCRIPTION as![Description],
      CATEGORY as![Category],
      PRICE as![Price],
      SUPPLIER_GUID.BP_ID as![SupplierId],
      SUPPLIER_GUID.COMPANY_NAME as![CompanyName],
      SUPPLIER_GUID.ADDRESS_GUID.CITY as![City],
      SUPPLIER_GUID.ADDRESS_GUID.COUNTRY as![Country],
      // Exposed Association, at runtime in odata we will see a link to laod 
      // dependent data
      PO_ORDER as![To_Items]
   } ; //;


// Consumption View
   define view CProductValuesView as
   select from ProductView{
      ProductId,
      Country,
      
// used Round function and type cast it to Decimal
      round(sum(To_Items.GrossAmount),2) as![TotalPurchaseAmount] : Decimal(10,2) , 
      To_Items.CurrencyCode as![CurrencyCode],

// when aggregation like sum, min, max, avg - group by clause should be used       
   } group by ProductId, Country, To_Items.CurrencyCode


}

```
</br>
<img src="./files/capmd4-1.png" >
</br>
</br>

After making the file with mentioend contents dont just run it deploy it and run
</br> if it is run directly - it goes to dump liek shown below 
</br>

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
