

**Things needed for deploying a CAP application**

```yaml

File to be created :
---------------------- 
	approuter - xs-app.json
	security - xs-security.json	-xsuaa - users and roles


npm install - dependencies installation 
-----------------------------------------
approuter : 
	@sap/app-router
	
Development / Deployment :	
	@sap/cds
	@sap/cds-hana

XSUAA :
	@sap/xssec
	@sap/xsenv
	passport

Odata V2 adapter :
	@sap/cds-odata-v2-adapter-proxy


Things to configure in mta yaml file
--------------------------------------
 srv 
 ui
 db 
 db-deployer 
 destination services
 xsuaa
 
 
In file package.json- following things to be defined 
------------------------------------------------------
authentication 
local users and roles 

```
