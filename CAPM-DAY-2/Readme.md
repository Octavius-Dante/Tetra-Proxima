## CAPM - Day 2

#### Correction to yesterday's CAP program
</br>
</br>

The program was using <b>'req.body.name'</b> in return parameter statement it is corrected 
 
</br>
</br>

```JS
const Myservice = function(srv){
    // this code bloc is like DPC extension class in SAP ODATA services  
    srv.on('helloCAP', (req,res) => {
        return "Hello CAP cloud developers, Welcome " + req.data.name;
    });
}

// return Myservice;
module.exports = Myservice;
```
</br>
</br>

#### End result 
</br>
</br>
   <img src="./files/capmd2-1.png" >
</br>
</br>
use the following url parameter value to see the passed value 
</br>
</br>

```url
http://localhost:4004/odata/v4/my/helloCAP(name='dante')
```
</br>
</br>
   <img src="./files/capmd2-2.png" >
</br>
</br>

## Database Concepts 
</br>

### Reuse Types and aspects 
</br>
</br>

<p>
When we design database artifacts, at times we have many simialr objects and their datatypes.
</br> Instead of hardcoding the type as primitive type, it is recommended to create custom types.
</br> Using custom data type increase reusability and reduce maintenance.
</br> when we create a seperate CDS file for reuse purpose and consume it, this file contains enumerators and aspects. 
</br>
</br> There are common aspect provided by SAP, primary key generation, currency.
</br> Admin data : created by, created date, changed by, changed date - these are called temporal data
</br>
</br>
<b>Aspect means a variable defined in seperate file whcih can be accessed globally. </b>
</br> it is combination of many fields (Structures in ABAP).
</br>
</p>

</br>
</br>
create another table to the cds file employee as mentioned below 
</br>
</br>

```cds 

context trans {
    entity order {
        key id         : int16;
            customer   : String;
            location   : String;
            total      : Decimal(10, 2);
            currency   : String;
            created_on : Date;
            created_by : String;
    };

    entity employee {
        key id   : int16;
            name : String;
            city : String;
    }
}

```

</br>
</br>
define another cds file named commons.cds in db folder 
</br>
define a data type here this is like a global variable ready to be accessed by our table fields
this global definition is called aspect in SAP capm cds terminology 
</br>
</br>

</br>
</br>
<img src ="./files/capmd2-4.png">
</br>
</br>

```cds

namespace com.dante.commons;

// similar like data element in abap defining in common.cds will make it available for global access
type Guid: String(32);

```

</br>
</br>
create sample data for our employee table by copying and editing our old csv data file as shown below
</br>
</br>

<img src="./files/capmd2-3.png" >

</br>
</br>

alterations to the main cds file (sample.cds)  // id data type int 16 is replaced with global variable 

</br>
</br>

```cds

namespace com.dante.finance;

// internal definition of namesapce  from './file name'

// accessing the global aspect for consumption 
using { com.dante.commons } from './commons';


context trans {
    entity order {
        key id         : commons.Guid;
            customer   : String;
            location   : String;
            total      : Decimal(10, 2);
            currency   : String;
            created_on : Date;
            created_by : String;
    };

    entity employee {
        key id   : commons.Guid;
            name : String;
            city : String;
    }
}

```

</br>
</br>

alterations to the main cds file (sample.cds)  // id data type int 16 is replaced with global variable 

</br>
</br>

defined new data types in common.cds file as mentioned below for reusability example 

</br>
</br>

```cds

namespace com.dante.commons;

// similar like data element in abap defining in common.cds will make it available for global access
type Guid   : String(32);

// Enumerator data type like predefined values for a variable 
type Gender : String(1) enum {

    male   = 'M';
    female = 'f';
    undisclosed = 'u';
};

// Amount data type with currency property 
type AmountX : Decimal(10,2)@(
     semantics.Amount.currencyCode : 'CURRENCY_CODE',
     sap.unit:'CURRENCY_CODE'
);

// Structure data type with resuable property of amount 
aspect Amount :{
    CURRENCY_CODE : String(4);
    GROSS_AMOUNT: AmountX;
    NET_AMOUNT: AmountX;
    TAX_AMOUNT :AmountX;
}


```

</br>
</br>

using of the Amount global varaible from common.cds into sample.cds file 

</br>
</br>

```cds
namespace com.dante.finance;

// internal definition of namesapce  from './file name' 
using { com.dante.commons } from './commons';


context trans {
    entity order {
        key id         : commons.Guid;
            customer   : String;
            location   : String;
            total      : Decimal(10, 2);
            currency   : String;
            created_on : Date;
            created_by : String;
    };

    entity order_2 : commons.Amount { 
        key id         : commons.Guid;
            customer   : String;
            location   : String;
            created_on : Date;
            created_by : String;
    };

    entity employee {
        key id   : commons.Guid;
            name : String;
            city : String;
            Gender : commons.Gender;
    }
}
```

</br>
</br>

order_2 table data *.csv file 
</br>

```csv

id,customer,location,created_on,created_by,GROSS_AMOUNT,NET_AMOUNT,TAX_AMOUNT,CURRENCY_CODE
1,Wikibox,Az Zāhir,2024-01-22,Aime,439.49,400,250,YER
2,Brightdog,Yuecheng,2024-11-24,Adelice,841.54,500,260,CNY
3,Dazzlesphere,Agoo,2024-09-13,Lucky,163.65,750,213,PHP
4,Livetube,Marseille,2024-07-03,Hasty,233.15,670,340,EUR
5,Zoovu,San José de Ocoa,2024-08-31,Thor,127.18,780,40,DOP

```

</br>
</br>

employeee table data *.csv file 
</br>

```csv

id,name,city,gender
1,Wikibox,Az Zāhir,m
2,Brightdog,Yuecheng,f
3,Dazzlesphere,Agoo,m
4,Livetube,Marseille,f
5,Zoovu,San José de Ocoa,m
6,Zoomcast,Bulnes,f
7,Gabtune,Daja Lorong,u
8,Gabvine,La Caya,f
9,Tagpad,Ciputih,u
10,Browsedrive,Marteleira,f

```

</br>
</br>

deploy database with different name with 3 tables 

</br>
</br>
<img src="./files/capmd2-5.png" >
</br>
</br>
<img src="./files/capmd2-6.png" >
</br>
</br>

change the DB connection to new name (supernova) and check the data of the order_2 table and employee table

</br>
</br>
<img src="./files/capmd2-7.png" >
</br>
</br>
<img src="./files/capmd2-8.png" >
</br>
</br>

### Custom aspect usage in table has been tested now will focus on standard aspect provided by sap for database

</br>
</br>

To learn detail about available aspects : https://cap.cloud.sap/docs/cds/common

</br>
</br>

> [!IMPORTANT]
> add the following block of code to your sample cds as shown below 

</br>
</br>

```cds

// SAP standard common aspects 
using { } from '@sap/cds/common';

```

</br>
</br>

<img src="./files/capmd2-9.png" >
</br>
</br>

Press ctrl + click the link on <b>'@sap/cds/common'</b> it navigates to sap standard common.cds block as shwon below 

</br>
</br>

</br>
</br>
