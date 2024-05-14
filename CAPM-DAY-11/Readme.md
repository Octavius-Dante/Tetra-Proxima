## CAPM - Day 11 - S4HANA Side by Side

# WORK IN PROGRESS -  

</br>
</br>
</br>

### The development in this session is regarding side by side extension using SAP standard API
</br>
</br>
<img src="./files/SAP_EXT_2.2.png" >

</br>
</br>
The place where we can look for SAP standard API is their official website SAP API Hub : </br>

[SAP API website](https://api.sap.com/) </br></br>


**SAP Business API hub** </br>

SAP Business API hub provides teh docuemntation for all teh publically available APIs for integration with SAP Business solutions e.g.S/4 HANA
</br>We can search APIs for different kinds, view their documentation, attributes and system details and integrate.
</br> example this link shows sales order api : https://api.sap.com/api/OP_API_SALES_ORDER_SRV_0001/resource/Sales_Order_Header </br>
</br>

Pre-requisites</br>

1. Go to the https://api.sap.com and check the avilable APIs
2. Go to the technical specification of the API and download the edmx file
3. Cross check if the same API is acticvated in S/4 HANA usign tcode /n/iwfnd/maint_service
4. Test the service in the browser (or in postman)

</br>
</br>

<details>
<summary> <b> How to Navigate in SAP API Hub website </b> </summary>
</br>
</br>

SAP API business hub is a place for documentaion of the API and details of the entity type and entity sets
</br> and what types of API available in the SAP products ODATA v2, v2, SOAP and release version details 
</br>
</br>
<img src="./files/capmd11-1.png" ></br></br>
<img src="./files/capmd11-2.png" ></br> </br>
<img src="./files/capmd11-3.png" ></br> </br>
<img src="./files/capmd11-4.png" ></br> </br>

[SAP On premise link](https://api.sap.com/products/SAPS4HANA/overview)</br> </br>

<img src="./files/capmd11-5.png" ></br> </br>
<img src="./files/capmd11-6.png" ></br> </br>
<img src="./files/capmd11-7.png" ></br> </br>
<img src="./files/capmd11-8.png" ></br> </br>
<img src="./files/capmd11-9.png" ></br> </br>
<img src="./files/capmd11-10.png" ></br> </br>
<img src="./files/capmd11-11.png" ></br> </br>
<img src="./files/capmd11-12.png" ></br> </br>
<img src="./files/capmd11-13.png" ></br> </br>

</br>
</br>
</details>

<!-- </br> </br> </br> </br> -->

</br> </br> 

## Steps for implementing side by side extension using SAP standard API 

</br> </br> 

<details>
<summary> <b> All the steps for developing standard API Extension </b> </summary>
</br>
</br>

1. Create a new capproject and do **cds init**
2. Run **cds watch** and import the edmx file to the **srv** folder
3. Add a new **CatalogService.cds** and **CatalogService.js**

</br>
</br>
</details>

</br> </br> 

<details>
<summary> <b>1. Access the SAP On-premise system and locate the API  </b> </summary>
</br>
</br>
<img src="./files/capmd11-14.png" ></br> </br>
<img src="./files/capmd11-15.png" ></br> </br>

Get the technical name of the API from the SAP API hub page </br> </br>
<img src="./files/capmd11-12.png" ></br> </br>
<img src="./files/capmd11-13.png" ></br> </br>


<details>
<summary> API search Method - Filter (Search only implemented API) </summary>
</br>
</br>
<img src="./files/capmd11-16.png" ></br> </br>
<img src="./files/capmd11-16a.png" ></br> </br>
<img src="./files/capmd11-16b.png" ></br> </br>
</br>
</br>
</details>

<details>
<summary> API search Method - Add service (Search all available API's for implementation) </summary>
</br>
</br>
<img src="./files/capmd11-17.png" ></br> </br>
<img src="./files/capmd11-17a.png" ></br> </br>
<img src="./files/capmd11-17b.png" ></br> </br>
</br>
</br>
</details>

Now filtering the API based on the business documentation</br> </br>
<img src="./files/capmd11-18.png" ></br> </br>
<img src="./files/capmd11-19.png" ></br> </br>
<img src="./files/capmd11-20.png" ></br> </br>
<img src="./files/capmd11-21.png" ></br> </br>
<img src="./files/capmd11-22.png" ></br> </br>
<img src="./files/capmd11-23.png" ></br> </br>
<img src="./files/capmd11-24a.png" ></br> </br>
<img src="./files/capmd11-24b.png" ></br> </br>
</br>
</br>
</details>

<details>
<summary> <b>2. Developing the extension app - PART # 1</b> </summary>
</br>
</br>
<img src="./files/capmd11-25.png" ></br> </br>
<img src="./files/capmd11-26.png" ></br> </br>
<img src="./files/capmd11-27.png" ></br> </br>
<img src="./files/capmd11-28.png" ></br> </br>
<img src="./files/capmd11-29.png" ></br> </br>
<img src="./files/capmd11-30.png" ></br> </br>
</br>
</br>
</details>

<!-- 

<details>
<summary> <b> ALL CODE CHANGES - TODAY SESSION </b> </summary>
</br>
</br>
</br>
</br>
</br>
</br>
</details>


<img src="./files/capmd11-31.png" ></br> </br>
<img src="./files/capmd11-32.png" ></br> </br>
<img src="./files/capmd11-33.png" ></br> </br>
<img src="./files/capmd11-34.png" ></br> </br>
<img src="./files/capmd11-35.png" ></br> </br>
<img src="./files/capmd11-36.png" ></br> </br>
<img src="./files/capmd11-37.png" ></br> </br>
<img src="./files/capmd11-38.png" ></br> </br>
<img src="./files/capmd11-39.png" ></br> </br>
<img src="./files/capmd11-40.png" ></br> </br>
<img src="./files/capmd11-41.png" ></br> </br>
<img src="./files/capmd11-42.png" ></br> </br>
<img src="./files/capmd11-43.png" ></br> </br>
<img src="./files/capmd11-44.png" ></br> </br>
<img src="./files/capmd11-45.png" ></br> </br>
<img src="./files/capmd11-46.png" ></br> </br>
<img src="./files/capmd11-47.png" ></br> </br>
<img src="./files/capmd11-48.png" ></br> </br>
<img src="./files/capmd11-49.png" ></br> </br>
<img src="./files/capmd11-50.png" ></br> </br>
<img src="./files/capmd11-51.png" ></br> </br>
<img src="./files/capmd11-52.png" ></br> </br>
<img src="./files/capmd11-53.png" ></br> </br>
<img src="./files/capmd11-54.png" ></br> </br>
<img src="./files/capmd11-55.png" ></br> </br>
<img src="./files/capmd11-56.png" ></br> </br>
<img src="./files/capmd11-57.png" ></br> </br>
<img src="./files/capmd11-58.png" ></br> </br>
<img src="./files/capmd11-59.png" ></br> </br>
<img src="./files/capmd11-60.png" ></br> </br>
<img src="./files/capmd11-61.png" ></br> </br>
<img src="./files/capmd11-62.png" ></br> </br>
<img src="./files/capmd11-63.png" ></br> </br>
<img src="./files/capmd11-64.png" ></br> </br>
<img src="./files/capmd11-65.png" ></br> </br>
<img src="./files/capmd11-66.png" ></br> </br>
<img src="./files/capmd11-67.png" ></br> </br>
<img src="./files/capmd11-68.png" ></br> </br>
<img src="./files/capmd11-69.png" ></br> </br>
<img src="./files/capmd11-70.png" ></br> </br>
<img src="./files/capmd11-71.png" ></br> </br>
<img src="./files/capmd11-72.png" ></br> </br>
<img src="./files/capmd11-73.png" ></br> </br>
<img src="./files/capmd11-74.png" ></br> </br>
<img src="./files/capmd11-75.png" ></br> </br>
<img src="./files/capmd11-76.png" ></br> </br>
<img src="./files/capmd11-77.png" ></br> </br>
<img src="./files/capmd11-78.png" ></br> </br>
<img src="./files/capmd11-79.png" ></br> </br>
<img src="./files/capmd11-80.png" ></br> </br>
<img src="./files/capmd11-81.png" ></br> </br>
<img src="./files/capmd11-82.png" ></br> </br>
<img src="./files/capmd11-83.png" ></br> </br>
<img src="./files/capmd11-84.png" ></br> </br>
<img src="./files/capmd11-85.png" ></br> </br>
<img src="./files/capmd11-86.png" ></br> </br>
<img src="./files/capmd11-87.png" ></br> </br>
<img src="./files/capmd11-88.png" ></br> </br>
<img src="./files/capmd11-89.png" ></br> </br>
<img src="./files/capmd11-90.png" ></br> </br>
<img src="./files/capmd11-91.png" ></br> </br>
<img src="./files/capmd11-92.png" ></br> </br>
<img src="./files/capmd11-93.png" ></br> </br>
<img src="./files/capmd11-94.png" ></br> </br>
<img src="./files/capmd11-95.png" ></br> </br>
<img src="./files/capmd11-96.png" ></br> </br>
<img src="./files/capmd11-97.png" ></br> </br>
<img src="./files/capmd11-98.png" ></br> </br>
<img src="./files/capmd11-99.png" ></br> </br>
<img src="./files/capmd11-100.png" ></br> </br>
<img src="./files/capmd11-101.png" ></br> </br>
<img src="./files/capmd11-102.png" ></br> </br>
<img src="./files/capmd11-103.png" ></br> </br>
<img src="./files/capmd11-104.png" ></br> </br>
<img src="./files/capmd11-105.png" ></br> </br>
<img src="./files/capmd11-106.png" ></br> </br>
<img src="./files/capmd11-107.png" ></br> </br>
<img src="./files/capmd11-108.png" ></br> </br>
<img src="./files/capmd11-109.png" ></br> </br>
<img src="./files/capmd11-110.png" ></br> </br>
<img src="./files/capmd11-111.png" ></br> </br>
<img src="./files/capmd11-112.png" ></br> </br>
<img src="./files/capmd11-113.png" ></br> </br>
<img src="./files/capmd11-114.png" ></br> </br>
<img src="./files/capmd11-115.png" ></br> </br>
<img src="./files/capmd11-116.png" ></br> </br>
<img src="./files/capmd11-117.png" ></br> </br>
<img src="./files/capmd11-118.png" ></br> </br>
<img src="./files/capmd11-119.png" ></br> </br>
<img src="./files/capmd11-120.png" ></br> </br>
<img src="./files/capmd11-121.png" ></br> </br>
<img src="./files/capmd11-122.png" ></br> </br>
<img src="./files/capmd11-123.png" ></br> </br>
<img src="./files/capmd11-124.png" ></br> </br>
<img src="./files/capmd11-125.png" ></br> </br>
<img src="./files/capmd11-126.png" ></br> </br>
<img src="./files/capmd11-127.png" ></br> </br>
<img src="./files/capmd11-128.png" ></br> </br>
<img src="./files/capmd11-129.png" ></br> </br>
<img src="./files/capmd11-130.png" ></br> </br>
<img src="./files/capmd11-131.png" ></br> </br>
<img src="./files/capmd11-132.png" ></br> </br>
<img src="./files/capmd11-133.png" ></br> </br>
<img src="./files/capmd11-134.png" ></br> </br>
<img src="./files/capmd11-135.png" ></br> </br>
<img src="./files/capmd11-136.png" ></br> </br>
<img src="./files/capmd11-137.png" ></br> </br>
<img src="./files/capmd11-138.png" ></br> </br>
<img src="./files/capmd11-139.png" ></br> </br>
<img src="./files/capmd11-140.png" ></br> </br>
<img src="./files/capmd11-141.png" ></br> </br>
<img src="./files/capmd11-142.png" ></br> </br>
<img src="./files/capmd11-143.png" ></br> </br>
<img src="./files/capmd11-144.png" ></br> </br>
<img src="./files/capmd11-145.png" ></br> </br>
<img src="./files/capmd11-146.png" ></br> </br>
<img src="./files/capmd11-147.png" ></br> </br>
<img src="./files/capmd11-148.png" ></br> </br>
<img src="./files/capmd11-149.png" ></br> </br>
<img src="./files/capmd11-150.png" ></br> </br>
<img src="./files/capmd11-151.png" ></br> </br>
<img src="./files/capmd11-152.png" ></br> </br>
<img src="./files/capmd11-153.png" ></br> </br>
<img src="./files/capmd11-154.png" ></br> </br>
<img src="./files/capmd11-155.png" ></br> </br>
<img src="./files/capmd11-156.png" ></br> </br>
<img src="./files/capmd11-157.png" ></br> </br>
<img src="./files/capmd11-158.png" ></br> </br>
<img src="./files/capmd11-159.png" ></br> </br>
<img src="./files/capmd11-160.png" ></br> </br>
<img src="./files/capmd11-161.png" ></br> </br>
<img src="./files/capmd11-162.png" ></br> </br>
<img src="./files/capmd11-163.png" ></br> </br>
<img src="./files/capmd11-164.png" ></br> </br>
<img src="./files/capmd11-165.png" ></br> </br>
<img src="./files/capmd11-166.png" ></br> </br>
<img src="./files/capmd11-167.png" ></br> </br>
<img src="./files/capmd11-168.png" ></br> </br>
<img src="./files/capmd11-169.png" ></br> </br>
<img src="./files/capmd11-170.png" ></br> </br>
<img src="./files/capmd11-171.png" ></br> </br>
<img src="./files/capmd11-172.png" ></br> </br>
<img src="./files/capmd11-173.png" ></br> </br>
<img src="./files/capmd11-174.png" ></br> </br>
<img src="./files/capmd11-175.png" ></br> </br>
<img src="./files/capmd11-176.png" ></br> </br>
<img src="./files/capmd11-177.png" ></br> </br>
<img src="./files/capmd11-178.png" ></br> </br>
<img src="./files/capmd11-179.png" ></br> </br>
<img src="./files/capmd11-180.png" ></br> </br>
<img src="./files/capmd11-181.png" ></br> </br>
<img src="./files/capmd11-182.png" ></br> </br>
<img src="./files/capmd11-183.png" ></br> </br>
<img src="./files/capmd11-184.png" ></br> </br>
<img src="./files/capmd11-185.png" ></br> </br>
<img src="./files/capmd11-186.png" ></br> </br>
<img src="./files/capmd11-187.png" ></br> </br>
<img src="./files/capmd11-188.png" ></br> </br>
<img src="./files/capmd11-189.png" ></br> </br>
<img src="./files/capmd11-190.png" ></br> </br>
<img src="./files/capmd11-191.png" ></br> </br>
<img src="./files/capmd11-192.png" ></br> </br>
<img src="./files/capmd11-193.png" ></br> </br>
<img src="./files/capmd11-194.png" ></br> </br>
<img src="./files/capmd11-195.png" ></br> </br>
<img src="./files/capmd11-196.png" ></br> </br>
<img src="./files/capmd11-197.png" ></br> </br>
<img src="./files/capmd11-198.png" ></br> </br>
<img src="./files/capmd11-199.png" ></br> </br>
<img src="./files/capmd11-200.png" ></br> </br> -->






<!--

</br>
</br>

``` cds 
	


``` 

</br>
</br>
<img src="./files/capmd11-1.png" >
</br>
</br>

## MyService.js 
</br>
</br>

```js



```
</br>
<img src="./files/capmd11-2.png" >
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

# NEXT ------ CAPM - DAY 12 - Extension CI/CD

<p align="center"> 
<a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-12"> CAPM DAY 12 - Extension CI/CD</a> 
	
</br>
</br>

#### Previous Sessions
</br>
<!--
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-12"> CAPM Day 12 - Extension CI CD</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-11"> CAPM Day 11 - Side by Side extension 2.0</a>
-->


- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-10"> CAPM Day 10 - Side by Side extension 1.0</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-9"> CAPM Day 9 - Serverless Fiori App</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-8"> CAPM Day 8 - CAPM Security XSUAA</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-7"> CAPM Day 7 - HANA and Deployment</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-6"> CAPM Day 6 - Fiori App Draft</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-5"> CAPM Day 5 - Fiori Elements</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-4"> CAPM Day 4 - Generic Handlers</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-3"> CAPM Day 3 - EPM DB and CDS Views</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-2"> CAPM Day 2 - Aspects and Reuse Tables</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-1"> CAPM Day 1 - First CAP App </a>

</br>
</br>

</p>
