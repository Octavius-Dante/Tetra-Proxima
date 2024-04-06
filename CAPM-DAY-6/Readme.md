## CAPM - Day 6 - Fiori App Draft

</br>
</br>
</br>

#### Continuing Fiori elements with additional changes to the app 

</br>
</br>
</br>

<details>
  <summary> <b> Add records count on top of the line item display </b> </summary>
</br>
</br>
Make the following changes to <b>(annotations.cds)</b> as shown below 
</br>
</br>

``` cds 
],
    HeaderInfo  : {
        $Type : 'UI.HeaderInfoType',
        TypeName : 'Purchase Order',
        TypeNamePlural : 'Purchase Orders',
    },

    }

``` 

</br>
dont forget to add the comma it is the completion of previous block and adding the new block below
</br>
<img src="./files/capmd6-1.png" >
</br>
</br>
</br>
</details>


<details>
  <summary> Fiori Open Guided Development  </summary>
</br>
</br>
    
There is another way to develop Fiori apps <b>(Fiori Open Guided Development)</b>
</br>
</br>
This approach uses firoi development based on XML annotations not CDS annotations 
</br>
you can access it by following steps <b> (Menu--> View--> Command and pallete) </b>
</br>
</br>
<img src="./files/capmd6-2.png" >
</br>
<img src="./files/capmd6-3.png" >
</br>
<img src="./files/capmd6-4.png" >
</br>
<img src="./files/capmd6-5.png" >
</br>
<img src="./files/capmd6-6.png" >
</br>
</br>

when insert snippet is selcted the folowing code gets generated and the file is opened in Fiori application modeler
</br>
<img src="./files/capmd6-7.png" >
</br>
<img src="./files/capmd6-8.png" >
</br>
</br>
</br>
</details>


<details>
  <summary> Details page (Second level drill down)  </summary>
</br>
Now will add page map (detaild page pop in from side) next to existing report - follow the steps 
</br>
Right click purchaseorder app folder and select - show page map - option 
</br>
<img src="./files/capmd6-9.png" >
</br>
</br>

select the setting and go back to the purchase order page and refresh (use cds run / watch) if it is not running 
</br>
<img src="./files/capmd6-10.png" >
</br>
<img src="./files/capmd6-11.png" >
</br>
</br>
</details>


<details>
      <summary> Add contents header to Details page  </summary>
Now will add the details to the details page as shown below
</br>
</br>

make the fcollwing changes to annotations.cds 
</br>
</br>

``` cds 

    HeaderInfo  : {
        $Type : 'UI.HeaderInfoType',
        TypeName : 'Purchase Order',
        TypeNamePlural : 'Purchase Orders',
        Title:{
            Label : 'Purchase Order Id',
            Value : PO_ID
        },
        Description:{
            Label : 'Supplier',
            Value : PARTNER_GUID.COMPANY_NAME
        },
        ImageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/SAP_2011_logo.svg/2560px-SAP_2011_logo.svg.png' 
    },
``` 

</br>
</br>
<img src="./files/capmd6-12.png" >
</br>
<img src="./files/capmd6-13.png" >
</br>
</br>
</details>


<details>
      <summary> Adding facets to the details page  </summary>
</br>
</br>
make the following changes to annotations.cds 
</br>
</br>

```cds

    HeaderInfo  : {
        $Type : 'UI.HeaderInfoType',
        TypeName : 'Purchase Order',
        TypeNamePlural : 'Purchase Orders',
        Title:{
            Label : 'Purchase Order Id',
            Value : PO_ID
        },
        Description:{
            Label : 'Supplier',
            Value : PARTNER_GUID.COMPANY_NAME
        },
        ImageUrl: 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/SAP_2011_logo.svg/2560px-SAP_2011_logo.svg.png' 
    },
Facets  : [{
    $Type: 'UI.ReferenceFacet',
    Label: 'More Details',
    Target: ![@UI.FieldGroup#DanteFields]
}
    
],

FieldGroup#DanteFields  : {
    $Type : 'UI.FieldGroupType',
    Data:[
        {
            $Type: 'UI.DataField',
            Value:PO_ID
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.NODE_KEY
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.BP_ID
        },        
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.COMPANY_NAME 
        },
        {
            $Type: 'UI.DataField',
            Value:GROSS_AMOUNT
        },
        {
            $Type: 'UI.DataField',
            Value:NET_AMOUNT
        },
                {
            $Type: 'UI.DataField',
            Value:TAX_AMOUNT
        },
        {
            $Type: 'UI.DataField',
            Value:CURRENCY_code
        },
        {
            $Type: 'UI.DataField',
            Value:LIFECYCLE_STATUS
        }
                                
    ]
}

    }

);


```

</br>
</br>
<img src="./files/capmd6-14.png" >
</br>
<img src="./files/capmd6-15.png" >
</br>
</br>
</details>


<details>
      <summary> Adding field group address to facets page  </summary>
</br>
</br>
Now will add additional data to the details page as shown below (add the facet details address) 
</br>
</br>

``` cds 
Facets  : [{
    $Type: 'UI.ReferenceFacet',
    Label: 'More Details',
    Target: ![@UI.FieldGroup#DanteFields]
},
{
    $Type: 'UI.ReferenceFacet',
    Label: 'Address Details',
    Target: ![@UI.FieldGroup#AddressFields]
}
    
],


FieldGroup#AddressFields  : {
    $Type : 'UI.FieldGroupType',
    Data:[
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.ADDRESS_GUID.COUNTRY
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.ADDRESS_GUID.STREET
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.ADDRESS_GUID.CITY
        }

    ]
                          
},

FieldGroup#DanteFields  : {
    $Type : 'UI.FieldGroupType',
    Data:[
        {
            $Type: 'UI.DataField',
            Value:PO_ID
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.NODE_KEY
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.BP_ID
        },        
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.COMPANY_NAME 
        },
        {
            $Type: 'UI.DataField',
            Value:GROSS_AMOUNT
        },
        {
            $Type: 'UI.DataField',
            Value:NET_AMOUNT
        },
                {
            $Type: 'UI.DataField',
            Value:TAX_AMOUNT
        },
        {
            $Type: 'UI.DataField',
            Value:CURRENCY_code
        },
        {
            $Type: 'UI.DataField',
            Value:LIFECYCLE_STATUS
        }
                                
    ]
}
    }

);


```

</br>
<img src="./files/capmd6-16.png" >
</br>
<img src="./files/capmd6-17.png" >
</br>
</br>
</details>

<details>
      <summary> Adding facets collection  </summary>
</br>
</br>
Now if i want to combine two different blocks in same section need to define (Collection facets) as shown below
</br>
</br>

```cds 
Facets                   : [{
        $Type : 'UI.CollectionFacet',
        Facets: [
            {
                $Type : 'UI.ReferenceFacet',
                Label : 'More Details',
                Target: ![@UI.FieldGroup#DanteFields]
            },
            {
                $Type : 'UI.ReferenceFacet',
                Label : 'Address Details',
                Target: ![@UI.FieldGroup#AddressFields]
            },
        ],
    },
    
],
```

</br>
</br>
<img src="./files/capmd6-18.png" >
</br>
</br>
</details>


<details>
      <summary> Correcting the facet collection   </summary>
</br>
</br>
    
Now more details group look not fitting aesthetics so correcting the facet section breaking it to 3 groups as shown below 
</br>
</br>

```cds

Facets                   : [{
        $Type : 'UI.CollectionFacet',
        Facets: [
            {
                $Type : 'UI.ReferenceFacet',
                Label : 'More Details',
                Target: ![@UI.FieldGroup#DanteFields]
            },
            {
                $Type : 'UI.ReferenceFacet',
                Label : 'Address Details',
                Target: ![@UI.FieldGroup#AddressFields]
            },
                        {
                $Type : 'UI.ReferenceFacet',
                Label : 'Amount Details',
                Target: ![@UI.FieldGroup#AmountFields]
            },
        ],
    },
    
],


FieldGroup#AddressFields  : {
    $Type : 'UI.FieldGroupType',
    Data:[
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.ADDRESS_GUID.COUNTRY
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.ADDRESS_GUID.STREET
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.ADDRESS_GUID.CITY
        }

    ]
                          
},


FieldGroup#AmountFields  : {
    $Type : 'UI.FieldGroupType',
    Data:[
        {
            $Type: 'UI.DataField',
            Value:GROSS_AMOUNT
        },
        {
            $Type: 'UI.DataField',
            Value:NET_AMOUNT
        },
                {
            $Type: 'UI.DataField',
            Value:TAX_AMOUNT
        },
        {
            $Type: 'UI.DataField',
            Value:CURRENCY_code
        },

    ]
                          
},

FieldGroup#DanteFields  : {
    $Type : 'UI.FieldGroupType',
    Data:[
        {
            $Type: 'UI.DataField',
            Value:PO_ID
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.NODE_KEY
        },
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.BP_ID
        },        
        {
            $Type: 'UI.DataField',
            Value:PARTNER_GUID.COMPANY_NAME 
        },
        {
            $Type: 'UI.DataField',
            Value:LIFECYCLE_STATUS
        }
                                
    ]
}

```

</br>
</br>
<img src="./files/capmd6-19.png" >
</br>
</br>
</details>


<details>
  <summary> <b> Adding line item to the details page below facet </b> </summary>
</br>
</br>

We added UI proerpties so far to purchase order section we should add seperate bloc kfor purchase order line items as shown below
</br>
</br>

add the following block of code below at the end of the file - a new section for purchase order line items
</br>
</br>

```cds
annotate CatalogService.PurchseOrderItems with @(

UI: {LineItem: [
    {
        $Type: 'UI.DataField',
        Value: PO_ITEM_POS
    },
    {
        $Type: 'UI.DataField',
        Value: PRODUCT_GUID_NODE_KEY,
    },
    // {
    //     $Type: 'UI.DataField',
    //     Value: PRODUCT_GUID.ProductId,
    // },

    {
        $Type: 'UI.DataField',
        Value: GROSS_AMOUNT,
    },
    {
        $Type: 'UI.DataField',
        Value: NET_AMOUNT,
    },
    {
        $Type: 'UI.DataField',
        Value: TAX_AMOUNT,
    },
    {
        $Type: 'UI.DataField',
        Value: CURRENCY_code,
    },

], }

);


```

</br>
</br>

add the following block of code below facet section as instructed in the image
</br>
</br>

``` cds
        {
            $Type : 'UI.ReferenceFacet',
            Label : 'Line Items',
            Target: Items.![@UI.LineItem]
        },
```

</br>
<img src="./files/capmd6-20.png" >
</br>
</br>
<img src="./files/capmd6-21.png" >
</br>
</br>
</br>


also a small change in CatalogService.cds file as mentioned below 
</br>
- comment the line (entity CProductValuesView)
- add the line entity ProductSet
</br>
</br>

```cds

 entity ProductSet as projection on db.master.product; 
    //entity CProductValuesView as projection on cds.CDSViews.CProductValuesView;

```
</br>
</br>
</details>

<details>
  <summary> Details page adding (Third level drill down)  </summary>
</br>
</br>

```cds

// Purchase order item entity

annotate CatalogService.PurchseOrderItems with @(

UI: {
        LineItem: [
            {
                $Type: 'UI.DataField',
                Value: PO_ITEM_POS
            },
            {
                $Type: 'UI.DataField',
                Value: PRODUCT_GUID_NODE_KEY,
            },
            // {
            //     $Type: 'UI.DataField',
            //     Value: PRODUCT_GUID.ProductId,
            // },

            {
                $Type: 'UI.DataField',
                Value: GROSS_AMOUNT,
            },
            {
                $Type: 'UI.DataField',
                Value: NET_AMOUNT,
            },
            {
                $Type: 'UI.DataField',
                Value: TAX_AMOUNT,
            },
            {
                $Type: 'UI.DataField',
                Value: CURRENCY_code,
            },
        ], 
        HeaderInfo  : {
            $Type : 'UI.HeaderInfoType',
            TypeName : 'Item',
            TypeNamePlural : 'Items',
            Title:{
                $Type : 'UI.DataField',
                Value : NODE_KEY,               
            },
            Description:{
                $Type : 'UI.DataField',
                Value : PO_ITEM_POS,               
            },            
        },
        Facets : [
                {
                  $Type : 'UI.ReferenceFacet',
                  Target: '@UI.FieldGroup#LineItemHeader',
                  Label : 'More Info'
                },
                {
                  $Type : 'UI.ReferenceFacet',
                  Target: '@UI.FieldGroup#ProductDetails',
                  Label : 'Product details'
                },                
        ],

FieldGroup #LineItemHeader : {
        $Type: 'UI.FieldGroupType',
        Data : [
            {
                $Type: 'UI.DataField',
                Value: PO_ITEM_POS
            },
            {
                $Type: 'UI.DataField',
                Value: PRODUCT_GUID_NODE_KEY
            },
            {
                $Type: 'UI.DataField',
                Value: GROSS_AMOUNT
            },
            {
                $Type: 'UI.DataField',
                Value: NET_AMOUNT
            },
            {
                $Type: 'UI.DataField',
                Value: TAX_AMOUNT
            },
            {
                $Type: 'UI.DataField',
                Value: CURRENCY_code
            }                                                            
            
        ],
    },

FieldGroup #ProductDetails: {
        $Type: 'UI.FieldGroupType',
        Data : [
            {
                $Type: 'UI.DataField',
                Value: PRODUCT_GUID.PRODUCT_ID
            },
            {
                $Type: 'UI.DataField',
                Value: PRODUCT_GUID.Description
            },
            {
                $Type: 'UI.DataField',
                Value: PRODUCT_GUID.TYPE_CODE
            },
            {
                $Type: 'UI.DataField',
                Value: PRODUCT_GUID.CATEGORY
            },
            {
                $Type: 'UI.DataField',
                Value: PRODUCT_GUID.SUPPLIER_GUID.COMPANY_NAME
            },
            {
                $Type: 'UI.DataField',
                Value: PRODUCT_GUID.TAX_TARIF_CODE
            }    
        ],
    },    

    }

);


```

</br>
</br>
<img src="./files/capmd6-22.png" >
</br>
</br>
</br>
</details>


<details>
<summary> Performing delete operation </summary>
</br>
</br>
delete operation is available by default on the page app allows us to delete the records as shown below 
</br>
</br>
<img src="./files/capmd6-23.png" >
<img src="./files/capmd6-24.png" >
<img src="./files/capmd6-25.png" >
</br>
</br>
</br>
</details>

</br>
</br>
</br>
</br>


## Fiori App Draft

</br>
</br>

So far our Fiori app performed retreiving line items in multiple level and deleted record 
</br>  but not performed anuy CREATE or UPDATE operation yet.
</br>  SAP as provided an option to Create and Ppdate and that can be done using Fiori App draft.

</br>
</br>

### What is draft ? 
</br>
</br>
A draft is a temporary version of a business entity that has not yet been explicitly saved as an active version.
</br>
</br>

### Drafts are used:
- To keep unsaved changes if an editing activity is interrupted, allowing users to resume editing later.
- To prevent data loss if an app terminates unexpectedly.
</br>
</br>
</br>
</br>

### Association vs Composition 
</br>
</br>

Association - a relationship betweene entitits which is a lose coupling. 
- Both objects should exist together. However, they can work independently. Example Airplane and passenger
- A passenger can travel alone without depending on Airpalne 
- An Airpalne can fly alone without depending on a passenger 
- In Similar way an Entity can be accessed seperately but it can be assocaited and accessed (header and line item) 

</br>
</br>

Composition - a relationship betweene entitits which is a tight coupling. 
- Both objects must exist together. However, they cannot function independently. Example Airplane and wings
- An Airpalne cannot fly without wings a dependency
- A purchase order line items cannot be created without depending on Purchase order header info

</br>


<!--
<details>
  <summary> <b> REFERENCE sample for drill down </b> </summary>
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
