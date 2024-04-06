## CAPM - Day 7 - HANA Deployment

#### App running in Local DB should be shifted to Remote DB

</br>
</br>

So far we have our app running using SQLite and Postgres Sql in our system now we are going to use HANA DB 
</br> - Make the following changes to our app and connect to HANA DB 
</br>
</br>
our applciaiton contains following files which are type CDS in DB, in SRV HANA DB dosent udnerstand these *.cds type 
</br>
So what CAPM framework does when we connect our CAP with HDB it build files necessary for HDB 
</br> the CAP application converts .cds table from DB to HDB as need version of files
</br>
</br>

### What HANA understand 
</br>
</br>
HANA understand its own database object format example : hdbtable, hdbsequence, hdbview, hdbprocedure, hdbi, hdbfunction...
</br>
</br>
<img src="./files/design-hana.png" > 
</br>
</br>
</br>

## Steps for integrating CAP to HANA DB
</br>
</br>

### Pre-Requisite
</br>

### 1. Check the version of CDS (which must be >2.0) <b> cds -v </b>
</br>
</br>
<img src="./files/capmd7-0.png" > 
</br>
</br>

### 2. Start a HANA cloud instance in SAP BTP
</br>
<img src="./files/capmd7-1.png" > 
</br>
<img src="./files/capmd7-2.png" >
</br>
</br>

### 3 Main steps 

1. Add HANA configuration to our app, which tells CAP framwork that default DB is now HANA <b> -cds add hana </b>

</br>
<img src="./files/capmd7-3.png" >
</br>

Check package.json for followign details 
</br>
</br>
<img src="./files/capmd7-4.png" >
</br>
<img src="./files/capmd7-5.png" >
</br>
</br>

add the following lines to the package.json
</br>
</br>
<img src="./files/capmd7-6.png" >
</br>
</br>
</br>

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

# NEXT ------ CAPM - DAY 8 - CAPM Security XSUAA

<p align="center"> 
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-8"> CAPM DAY 8 - CAPM Security XSUAA</a> 
</p>
