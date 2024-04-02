## CAPM - Day 3

#### Login to BTP to access BAS (Business Applciation Studio)

</br>
</br>

BAS is a SAP properitary web environemnt used for developing SAP applciations 
</br>it is managed by userspace arhitecture every develoepr who access 
</br>it will get an allocated own space for designing applciation
</br>in trial BTP account of 90 days 
</br>

> [!NOTE]
> (BAS) as 30 days expiry if it is not accessed in 30 days dev space will be deleted by SAP 
 
</br>
</br>

### Access the BAS account as shown in below steps 

if account is not created 

follow the developer blogs mentioend below to get it completed 

(1) https://developers.sap.com/tutorials/appstudio-onboarding.html

(2) https://developers.sap.com/tutorials/set-up-bas.html  

</br>
</br>


BTP Cockpit 
</br>
   <img src="./files/capmd3-1.png" >
</br>

Login to BAS account 
</br>
   <img src="./files/capmd3-2.png" >
</br>

Create the DEV space  
</br>
   <img src="./files/capmd3-3.png" >   
</br>

 Select full stack cloud application in DEV space creation 
</br>
   <img src="./files/capmd3-4.png" >
</br>

select the created dev space
</br>
   <img src="./files/capmd3-5.png" >
</br>

Booting screen of BAS 
</br>
   <img src="./files/capmd3-6.png" >   
</br>

BAS welcome screen 
</br>
   <img src="./files/capmd3-7.png" >  
</br>

Check the OS version which is running this BAS for cloud 
</br>
open terminal 
</br>
   <img src="./files/capmd3-8.png" >  
   <img src="./files/capmd3-9.png" >  
</br>

It is a debian GNU linux version which is running in backend for this BAS application 

</br>

```bat
cat /etc/os-release
```

</br>
</br>

all the CDS, NODE, nvm, npm all are pre installed in BAS thats the advantage in BAS 

</br>
</br>

Change the theme for BAS as shown below in case White is not comfortable for the eyes 

</br>

<img src="./files/capmd3-10.png" >
<img src="./files/capmd3-11.png" >

</br>
</br>
create a project folder like shown below to start your development 
</br>

```bat
mkdir <folder name>
```
</br>
</br>
<img src="./files/capmd3-12.png" >
</br>
<img src="./files/capmd3-13.png" >
</br>
</br>
initialise the project skeleton by using cds init command 
</br>

```bat
cds init
```
</br>
<img src="./files/capmd3-14.png" >
</br>
</br>

Create a file demo.cds under (DB) folder as shown below
</br>
<img src="./files/capmd3-15.png" >
</br>
</br>

Type down the following script in that cds file 
</br>
</br>

```cds
namespace dante_cap;
using { cuid } from '@sap/cds/common';

entity orders : cuid {

}
```
</br>
After creating the file you can notice that in (Data models and services) section in left pane
</br>
This gets created when cds file in db gets generated.
</br>
This Data models and services is only avilable in BAS not in VScode and this helps to see the overview of DB objects avaialble in the project.
</br>
<img src="./files/capmd3-18.png" >
</br>

After creating the file right click the demo.cds file and you will get the CDS Graphic modeler option in command as shown below
</br>
</br>
<img src="./files/capmd3-16.png" >
<img src="./files/capmd3-17.png" >
</br>
</br>

When CDS Graphic modeler is selected it is opens a new graphical editor which looks like SQVI in ABAP 
</br>
use it and create table like shown below 
</br>
<img src="./files/capmd3-19.png" >
<img src="./files/capmd3-20.png" >
<img src="./files/capmd3-21.png" >
</br>
</br>

when you create multple entity and you can define foreign key relation, association, composition as shown below 
<img src="./files/capmd3-22.png" >
but will discuss this later.
</br>
</br>

Will use the commons.cds file from previous day to begin our development
</br>

```cds
namespace com.dante.commons;

using { Currency } from '@sap/cds/common';

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
    CURRENCY : Currency;
    GROSS_AMOUNT: AmountX @(title : '{i18n>GROSS-Amount}');
    NET_AMOUNT: AmountX @(title : '{i18n>NET-Amount}');
    TAX_AMOUNT :AmountX @(title : '{i18n>TAX-Amount}');
}
```
<img src="./files/capmd3-23.png" >
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
