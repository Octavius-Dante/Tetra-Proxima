## CAPM - Day 8 - CAPM Security XSUAA 

#### How to add XSUAA services to our app and deploy 

</br>
</br>

So from previosu session we saw how to deploy our app to cloud 
</br> Now we are going to add XSUAA service to our app using MTA editor to MTA yaml file
</br>
</br>

Steps to implement XSUAA in cap 
</br>
</br>

1. Create a new resource in MTA.yaml file for xs-usaa backing service with following proerties 
	1. name == capp-xsuaa
	2. service == xsuaa
	3. service-plan == application
	4. path == ./xs-security.json

2. Add the dependency of this newly created xs-uaa service to our microservice in require section

3. Create the xs-security.json file using sap btp documentation : https://help.sap.com/docs/btp/sap-business-technology-platform/application-security-descriptor-configuration-syntax
	and aqdpat file to have 2 roles - viewer and the Admin role.
	the Viewer role also have an attribute called bank name whcih will be for row level security.
	
4. add 3 node module which will help in security configuration for our app 
		-npm install passport; 
		-npm install @sap/xssec; 
		-npm install @sap/xsenv
	
	

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
