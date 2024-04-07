## CAPM - Day 7 - HANA Deployment

#### App running in Local DB should be shifted to Remote DB

</br>
</br>

So far we have our app running using SQLite and Postgres Sql in our system now we are going to use HANA DB 
</br> - Make the following changes to our app and connect to HANA DB 
</br>
</br>
our applciaiton contains following files which are type CDS in DB, in SRV HANA DB dosent understand these *.cds type 
</br>
So what CAPM framework does when we connect our CAP with HDB it build files necessary for HDB in a folder called GEN
</br> the CAP application converts .cds table from current local db to HANA DB's needed version of files
</br>
</br>

### What HANA understands :
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

<details>
<summary> 1. Check the version of CDS (which must be >2.0) <b> cds -v </b> </summary>
</br>
</br>
<img src="./files/capmd7-0.png" > 
</br>
</br>
</details>

<details>
<summary> 2. Start a HANA cloud instance in SAP BTP </summary>
</br>
<img src="./files/capmd7-1.png" > 
</br>
<img src="./files/capmd7-2.png" >
</br>
</br>
</details>

</br></br>

### Main steps 
</br>

<details>
<summary> 1. Add HANA configuration to our app, which tells CAP framwork that default DB is now HANA <b> -cds add hana </b> </summary>
</br>
</br>
<img src="./files/capmd7-3.png" >
</br>
</details>

<details>
<summary> 2. The above cds add hana command made following changes check package.json  </summary>
</br>
</br>
<img src="./files/capmd7-4.png" >
</br>
<img src="./files/capmd7-5.png" >
</br>
</br>
</details>

<details>
<summary> 3. Add the following lines to the package.json below cds section  </summary>
</br>
</br>
<img src="./files/capmd7-6.png" >
</br>

```json
  "hana":{
    "deploy-format":"hdbtable"
  }
```
</br>
</br>
</details>

<details>
<summary> 4. do NPM install for installing the essentail packages - related to hana db (by scanning package.json) </summary>
</br>
</br>
<img src="./files/capmd7-7.png" >
</br>
</br>
</details>

<details>
<summary> 5. We need to perform CDS build </summary>
</br>

This build creation will create GEN folder in our app directory for integrating to HANA DB 
</br> and create all the hana specific files which will be deployed to HANA cloud
</br>
</br>

```bat
cds build --production
```

</br>
</br>

Cds build command execution 
</br>
</br>
<img src="./files/capmd7-8a.png" >
</br>
<img src="./files/capmd7-8b.png" >
</br>
</br>

After creating build - Gen folder in APP directory (GEN - Generated) 
</br>
</br>
<img src="./files/capmd7-9.png" >
</br>
</br>
</details>

<details>
<summary> 6. Need to login to CLoud foundry from BAS - cf login </summary>
</br>
</br>
<img src="./files/capmd7-10a.png" >
</br>
<img src="./files/capmd7-10b.png" >
</br>
<img src="./files/capmd7-10cd.png" >
</br>
</br>
</details>

<details>
<summary> 7. Need to deploy the DB and everything to HANA  </summary>
</br>
</br>
all generated files will be deployed to HANA using the command  (cds deploy --to hanan:dante)
</br>
</br>

```bat
cds deploy --to hanan:<DB name>
```

</br>
</br>

> This command execution will take some tiem to complete

</br>
</br>
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/blob/main/CAPM-DAY-7/error-log-HDB.txt"> CDS Deploy - Error Log Sample </a>
</br>
</br>
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/blob/main/CAPM-DAY-7/success-log-HDB.txt"> CDS Deploy - Success Log Sample </a>
</br>
</br>

Error log and success log are shared for your reference in case of any error - there will be manys errors listed 
</br> - you can check the file and search for error and understand why error occured - mostly errros will be descriptive and understandable 

</br>
</br>

## delete all csv files in the project and add the files shared here and deploy 
## these are HANA specifc files which will work properly when deploying  

</br>
</br>
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-7/hanacsv"> HANA CSV Folder </a>
</br>
</br>
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-7/hanacsv.zip"> HANA CSV.zip file  </a>
</br>
</br>

</br>
</br>
<img src="./files/capmd7-11a.png" >

</br>
</br>
</details>


<details>
<summary> 8. When deployment is successful </summary>
</br>

IF deployment worked well a new file calle <b>cdsrc-private.json</b> gets created automatically.
</br> this file contain the information about which container in SAP BTP HANA Cloud to connect to.
</br> and private key is stored in this file.

</br>
</br>
<img src="./files/capmd7-11b.png" >
</br>
<img src="./files/capmd7-11c.png" >
</br>
<img src="./files/capmd7-11d.png" >
</br>
<img src="./files/capmd7-11e.png" >
</br>
<details>
	
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
