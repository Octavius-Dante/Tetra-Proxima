## Business Technology Platform - DAY 00 

### Starter guide for cloud foundry BTP

</br>
</br>

**BTP Trial Account**

- [x] Read this blog to create SAP Account and BTP account https://developers.sap.com/tutorials/hcp-create-trial-account.html

</br>

**Break down structure of the accouts**

- [x] SAP Account it is the account of the company -- (Tier 1)
- [x] SAP Global account for billing by SAP for BTP (BTP Trial / Business Account) -- (Tier 2)
- [x] Sub Account (Region wise classification ex: Asia sub1, Eur Sub2, NA Sub3....etc for user accounts) -- (Tier 3)

</br>

**Global Account :**

- [x] This Account is associated with the company for billing purposes for SAP on BTP services 
- [x] It contains many sub accounts of different region (different data centers)
- [x] All SAP services allocated here for business purpose to different sub accounts 

</br>

**Sub Account :**

- [x] This contains service entitlements allocated from global account 
- [x] Different sub account will have same or different services allocated for business needs 
- [x] Users are granted access at this level 
- [x] Instances of services will be availble here and each instance is capable of single or multiple Dev space
- [x] One sub account can have multiple space


</br>

## Environments, Subscriptions, Instances  : 


**1 Environments :**
   </br>
   </br>
<p> 

Environments constitute the actual <B>platform-as-a-service</B> offering of SAP BTP that allows for the development and administration of business applications. 
Environments are anchored in SAP BTP on subaccount level.
SAP BTP offers three environments: ABAP, Cloud Foundry and Kyma. 
Some existing customers still have Neo, but this is no longer offered.

(Kyma is kubernetees termed differently for SAP BTP)

Kubernetes definition : 

Kubernetes automates operational tasks of container management and includes built-in commands for deploying applications, 
rolling out changes to your applications, scaling your applications up and down to fit changing needs, monitoring your applications
and more—making it easier to manage applications.
  
</p>    
   </br>
   </br>

**2 Subscriptions :**
   </br>
   </br>
<p> 
Subscription based services
You will also see these ones called <B>software as a service (SaaS)</B>, or multitenant applications. 
The experience here is that you subscribe to the service, and in return you receive a URL, from which you can access that service. 
Opening the URL brings you to a web application from which you can leverage the service. 
This is how other SaaS like SuccessFactors or S/4HANA Cloud work as well. They are also enabled at a subaccount level, and are independent of the environments. 
You don't need to have Cloud Foundry enabled to subscribe to SAP Launchpad Service, for example.
Examples include Launchpad, SAP Business Application Studio, Cloud Integration, Process Automation...

What is tenant ?  </br>
An application inside BTP is called tenant.
</p>  
   </br>
   </br>   

**3 Instances :**
   </br>
   </br>
<p> 
Instance based services
These are the purest services. They provide a specific functionality, like databases, connectivity, authentication.... You connect your application to them to leverage that functionality. 
These services don't provide a UI to manage them. Instead, they rely on API to connect to applications and other services and provide their services. 
They are provisioned inside an environment, so they are environment specific. 
Each environment has its own organization (for users and applications): In Cloud Foundry, instances are created inside a space. For Kyma, instances are created inside a namespace.

To use an Instance services you need a service key.

</p>    

Service catalog : https://discovery-center.cloud.sap/viewServices

   </br>
   </br>   

**Entitlements and quota :**
   </br> 
   </br> 
<p>    
Entitlements are the heart of all subaccounts in SAP BTP. They define which service and runtime artifacts you are able to use. When you purchase an enterprise account, you're entitled to use a specific set of resources, such as the amount of memory that can be allocated to your applications.
</br>     
  
An entitlement is your right to provision and consume a resource. In other words, entitlements are the service plans that you're entitled to use.
</br> 

A quota represents the numeric quantity that defines the maximum allowed consumption of a resource. In other words, how much of a service plan you're entitled to use.
</br> 

Entitlements and quotas are purchased and managed at global account level, from where they're distributed to subaccounts, which consume them. 
When you remove quotas or entitlements from a subaccount, they become available again at global account level and can be assigned to other subaccounts.
</p>    

   </br>
   </br> 
   
**Quota plans :**  
   </br> 
   </br>  
<p> 
In the Cloud Foundry environment, you can further distribute the quotas that are allocated to a subaccount. This is done by creating space quota plans and assigning them to the spaces.
Space quota plans are optional and are used to limit how much each space can use, not to enable. If you don't create any space quota plans, all spaces in a subaccount using the Cloud Foundry environment have access to all entitlements and quotas in that subaccount. This means that one space could use up all the quota in a subaccount.
If you want to prevent that from happening and set a limit to how much each space can use from the total quota available in the subaccount, you can use quota plans and assign them to spaces.   

   </br> 
   </br>  

### Go through the following blogs 

To Create BTP account : https://developers.sap.com/tutorials/hcp-create-trial-account.html </br> 
To Create an SAP BTP ABAP Environment Trial User : https://developers.sap.com/tutorials/abap-environment-trial-onboarding.html </br> 
To Install eclipse and ABAP Dev Environment plugins : https://developers.sap.com/tutorials/abap-install-adt.html </br>
To Link the BTP account to Eclipse IDE : https://developers.sap.com/tutorials/abap-environment-create-abap-cloud-project.html </br> 
To Link the Github account to Eclipse IDE : https://developers.sap.com/tutorials/abap-install-abapgit-plugin.html </br> 

### Other essential links from SAP developers training blogs

https://developers.sap.com/tutorial-navigator.html?tag=programming-tool%3Aabap-development


### Business Application Studio : 
#### DevSpace 
   </br> 
SAP Business Application Studio is a development environment available on SAP Business Technology Platform. Before you can start developing using SAP Business Application Studio.
   </br> 
   </br>  
In an Enterprise Account you can set up SAP Business Application Studio as a Free-Tier service by checking its free plan during its entitlement configuration.
   </br> 
   </br>  
The business application studio provides a dev space for developers to create private workspace to have pre-defined dependencies installed for creating particular type of applications e.g. sap fiori, Native HANA development, Cloud application programming development etc.

</br> 
</br> 
Git Setup for Windows : https://git-scm.com/download/win 
</br>  
</br>  
Cloud foundry CLI (Command line interface) Tool allows to communicate/ connect to CF : 
</br>  
https://github.com/cloudfoundry/cli/wiki/V6-CLI-Installation-Guide
</br>  
</br>  

