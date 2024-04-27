## CAPM - Day 12 - Extension CI/CD

### CI - CD Pipeline in SAP BTP cloud 

</br>
</br>
</br>

### Prerequisite your BAS account should have an active git repository to perfrom CI and CD 
</br> if github integration is not done earlier kindly perform this 
</br> [BAS Github integration](https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/BAS_GIT_integration)
</br>
</br>
</br>

An overview of the process
</br>
</br>
<img src="./files/CI-CD.png" >
</br>
</br>

<details>
<summary> <b> 1. Subscribing CI and CD services in BTP </b> </summary>
</br>
</br>

Create a subscription on Continuos Integration & Delivery in BTP account - Service 1
</br> 
</br>
<img src="./files/capmd12-1.png" >


Create a subscription on Cloud Transport Mangement - Service 2 
</br> 
</br>
<img src="./files/capmd12-2.png" >
</br>
</br>

<img src="./files/capmd12-3.png" >
</br>
</br>
</details>

<details>
<summary> <b> 2. Granting Roles for CI / CD service</b> </summary>
</br>
</br>

4 roles are needed for this service 
</br>

1. CICD Service Administrator
2. CICD Service Developer
3. TMS_LandscapeOperator_RC
4. TMS_Viewer_RC
</br>
</br>

Go to user sub-section in Security section on BTP account 
</br>
</br>
<img src="./files/capmd12-4.png" >
</br>
</br>
<img src="./files/capmd12-5.png" >
</br>
</br>
<img src="./files/capmd12-6.png" >
</br>
</br>
<img src="./files/capmd12-7.png" >
</br>
</br>
<img src="./files/capmd12-8.png" >
</br>
</br>
</details>


<details>
<summary> <b> 3. Create another landscape </b> </summary>
</br>
</br>

Create another sub account and space to simulate Quality and Production Landscape
</br>
</br>
<img src="./files/capmd12-9.png" >
</br>
</br>

Create spaces qlt and prd 
</br>
</br>
<img src="./files/capmd12-10.png" >
</br>
</br>
<img src="./files/capmd12-11.png" >
</br>
</br>
<img src="./files/capmd12-12.png" >
</br>
</br>
<img src="./files/capmd12-13.png" >
</br>
</br>
<img src="./files/capmd12-14.png" >
</br>
</br>
<img src="./files/capmd12-15.png" >
</br>
</br>
</details>


<details>
<summary> <b> 4. Create Destinations for this System Landscapes </b> </summary>
</br>
</br>

**Default Destination setting for this CICD**
</br>
</br> Type : HTTP
</br> Proxy Type : Internet
</br> Authentication : BasicAuthentication
</br>
</br>

We need to create destination in this section 
</br> 
</br>
<img src="./files/capmd12-16.png" >
</br>
</br>

we have to refer SAP's official documents for creating destination for (CICD ) and Cloud transport 
</br> refer the link for official document found through google search : 
</br>
</br> [Cloud transport mgmt Oauth2 password authentication](https://help.sap.com/docs/cloud-transport-management/sap-cloud-transport-management/creating-destinations-using-sap-cloud-deployment-service-with-oauth2password-authentication)
</br>
</br> [Cloud transport mgmt Basic authentication](https://help.sap.com/docs/cloud-transport-management/sap-cloud-transport-management/creating-destinations-using-sap-cloud-deployment-service-with-basic-authentication) -- this is what we used 
</br>
</br>
<img src="./files/capmd12-17.png" >
</br>
</br>

Click create destination 
</br>
</br>
<img src="./files/capmd12-18.png" >
</br>
</br>

Enter the destination details 
</br>
</br>
<img src="./files/capmd12-19a.png" >
</br>
</br>

Paste the link from the sap document page and modify it 

</br> the link value should be repalced as shown below 
</br> 
</br> domain : This is the domain of your second sub account 
</br> myorg : This is the org name of your second sub account 
</br> myspace : This is the space name in your second sub account 
</br> 
</br> 

```html

// Original Link
https://deploy-service.cf.<domain>/slprot/<myorg>/<myspace>/slp

API Endpoint: https://api.cf.us10-001.hana.ondemand.com
Org Name: 31dfa10dtrial_quality-prod-6cvvjzsk
Space Name : QLT or PRD

// Grab only this part : us10-001.hana.ondemand.com

domain : us10-001.hana.ondemand.com
myorg : 31dfa10dtrial_quality-prod-6cvvjzsk
myspace : QLT

// Final Link should look like this -- this should go in URL part of destination
https://deploy-service.cf.us10-001.hana.ondemand.com/slprot/31dfa10dtrial_quality-prod-6cvvjzsk/QLT/slp

```

</br>
</br>
<img src="./files/capmd12-20.png" >
</br>
</br>
<img src="./files/capmd12-21.png" >
</br>
</br>
<img src="./files/capmd12-22.png" >
</br>
</br>

Test the connection for confirmation
</br>
</br>
<img src="./files/capmd12-23.png" >
</br>
</br>
<img src="./files/capmd12-24.png" >
</br>
</br>

Clone the connection and create it for PRD 
</br>
</br>
<img src="./files/capmd12-25.png" >
</br>
</br>
<img src="./files/capmd12-26.png" >
</br>
</br>
</details>


<details>
<summary> <b> 5. Start Github Integration for CI and CD - PART 1 - Account setup</b> </summary>
</br>
</br>

Launch the Continuous integration from instance and subscription section
</br>
</br>
<img src="./files/capmd12-27.png" >
</br>
</br>
<img src="./files/capmd12-28.png" >
</br>
</br>
<img src="./files/capmd12-29.png" >
</br>
</br>
<img src="./files/capmd12-30.png" >
</br>
</br>
<img src="./files/capmd12-31.png" >
</br>
</br>

Now will register our BTP repository
</br>
</br>
<img src="./files/capmd12-32.png" >
</br>
</br>
<img src="./files/capmd12-33.png" >
</br>
</br>
<img src="./files/capmd12-34.png" >
</br>
</br>

Change the Github repository visibility to PUBLIC so the credentials is not required
</br> now the github repository is private in my case so i mantianed a credential for (github account and password)
</br>
</br>
<img src="./files/capmd12-35.png" >
</br>
</br>

We need to add webhook to github account so creating webhook first
</br>
</br>
<img src="./files/capmd12-36.png" >
</br>
</br>
<img src="./files/capmd12-37.png" >
</br>
</br>
<img src="./files/capmd12-38.png" >
</br>
</br>
<img src="./files/capmd12-39.png" >
</br>
</br>
<img src="./files/capmd12-40a.png" >
</br>
</br>
<img src="./files/capmd12-41.png" >
</br>
</br>
<img src="./files/capmd12-42.png" >
</br>
</br>
</details>

<details>
<summary> <b> 6. Start Github Integration for CI and CD - PART 2 - Github Webhook link</b> </summary>
</br>
</br> Goto Seting of your github repository and paste the generated webhook secret as shown below 
</br>
</br>
<img src="./files/capmd12-43.png" >
</br>
</br>
<img src="./files/capmd12-44.png" >
</br>
</br>
<img src="./files/capmd12-45.png" >
</br>
</br>
<img src="./files/capmd12-46.png" >
</br>
</br>
<img src="./files/capmd12-47.png" >
</br>
</br>
<img src="./files/capmd12-48.png" >
</br>
</br>
<img src="./files/capmd12-49.png" >
</br>
</br>
<img src="./files/capmd12-50.png" >
</br>
</br>
</details>

<details>
<summary> <b> 7. Start Github Integration for CI and CD - PART 3 - Job definition</b> </summary>
</br>
</br>

Let's define a Job in CICD as shown below
</br>
</br>
<img src="./files/capmd12-51.png" >
</br>
</br>
<img src="./files/capmd12-52.png" >
</br>
</br>

There is no Code check or sysntax check or unit testing so leave it untouched.
</br>
</br>
<img src="./files/capmd12-53.png" >
</br>
</br>
<img src="./files/capmd12-54.png" >
</br>
</br>
<img src="./files/capmd12-55.png" >
</br>
</br>
<img src="./files/capmd12-56.png" >
</br>
</br>
<img src="./files/capmd12-57.png" >
</br>
</br>
<img src="./files/capmd12-58.png" >
</br>
</br>
<img src="./files/capmd12-59.png" >
</br>
</br>

We need to create an instance (Cloud transport management) -
</br>
</br>
<img src="./files/capmd12-60.png" >
</br>
</br>
<img src="./files/capmd12-61.png" >
</br>
</br>
<img src="./files/capmd12-62.png" >
</br>
</br>
<img src="./files/capmd12-63.png" >
</br>
</br>
<img src="./files/capmd12-64.png" >
</br>
</br>
<img src="./files/capmd12-65.png" >
</br>
</br>
<img src="./files/capmd12-66.png" >
</br>
</br>
<img src="./files/capmd12-67.png" >
</br>
</br>
<img src="./files/capmd12-68.png" >
</br>
</br>
<img src="./files/capmd12-69.png" >
</br>
</br>

GO back to CICD - Jobs section and create a credentials for service key
</br>
</br>
<img src="./files/capmd12-70.png" >
</br>
</br>
<img src="./files/capmd12-71.png" >
</br>
</br>

Now go back to the Job and link the service key credential we creataed earlier
</br>
</br>
<img src="./files/capmd12-72.png" >
</br>
</br>
<img src="./files/capmd12-73.png" >
</br>
</br>
<img src="./files/capmd12-74.png" >
</br>
</br>
</details>


<details>
<summary> <b> 8. Defining Node for Continuous delivery - Cloud transport management system</b> </summary>
</br>
</br>

Goto Subscription and launch Cloud transport management
</br>
</br>
<img src="./files/capmd12-75.png" >
</br>
</br>
<img src="./files/capmd12-76.png" >
</br>
</br>
<img src="./files/capmd12-77.png" >
</br>
</br>


Defining node 
</br>allow upload to node option means somebody can pull the changes from dev branch and push it to quality branch 
</br>
</br>
<img src="./files/capmd12-78.png" >
</br>
</br>

low code no code approach so only node connection (Defining Prod Node)
</br>
</br>
<img src="./files/capmd12-79.png" >
</br>
</br>
<img src="./files/capmd12-80.png" >
</br>
</br>
<img src="./files/capmd12-81.png" >
</br>
</br>
<img src="./files/capmd12-82.png" >
</br>
</br>
<img src="./files/capmd12-83.png" >
</br>
</br>
So this concludes the landscape definition for continuous delivery  
</br>
</br>
</details>

<details>
<summary> <b> 9. Testing CI / CD flow with code changes </b> </summary>
</br>
</br>
<img src="./files/capmd12-84.png" >
</br>
</br>
<img src="./files/capmd12-85.png" >
</br>
</br>

Watch the job section in CI/CD when git push happens there will be build details listed in this section 
</br>
</br>
<img src="./files/capmd12-86.png" >
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

-->


</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

# --------- End of CAPM Development ---------

<p align="center"> 
	
</br>
</br>

#### Previous Sessions
</br>
<!--
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-12"> CAPM Day 12 - Extension CI CD</a>
-->

- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-11"> CAPM Day 11 - S4HANA Side by Side</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-10"> CAPM Day 10 - Side by Side extension</a>
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
