## CAPM - Day 5 - Fiori Elements

#### Continuing Custom service development (CURD)

</br>
</br>

Will continue today from yesterdays application 
</br> - will focus on creating Custom service (Insert, Update and delete) <b>MyServices.cds , Myservice.js</b>

## MyService.js  - (CURD)
</br>
</br>

```js
const cds = require("@sap/cds");
const { employees } = cds.entities("dan.db.master");
const mysrvdemo = function (srv) {

// CAPM DAY -4     
    // Generic handler 
// READ DATA     
    srv.on("READ", "ReadEmployeeSrv", async (req, res) => {

        var results = [];

        // Example 1 : hardcoded data
        // results.push({
        //         "ID":"56AD5671-9034567-12340-ER89GH-6789",
        //         "nameFirst": "Leonardo",
        //         "nameLast": "davinci"
        // });

        // Example 2 : use Select on DB table 
        // results = await cds.tx(req).run(SELECT.from(employees).limit(10));

        // Example 3 : use Select on DB table 
        // results = await cds.tx(req).run(SELECT.from(employees).limit(10).where({"nameFirst":"Susan"} ) );


        // use /entity/key/

        // Example 4 : Caller will pass the condition like ID
        var whereCondition = req.data;
        console.log(whereCondition);
        if (whereCondition.hasOwnProperty("ID")) {
            results = await cds.tx(req).run(SELECT.from(employees).limit(10).where({ "nameFirst": "Susan" }));
        } else {
            results = await cds.tx(req).run(SELECT.from(employees).limit(1));
        }

        // https://cap.cloud.sap/docs/node.js/cds-ql#where

        return results;

    });

// CAPM DAY -5
// CREATE DATA 
    srv.on("CREATE", "InsertEmployeeSrv", async (req, res) => {
        var dataSet = req.data;
        let returnData = await cds.transaction(req).run([

// INSERT operation             
            INSERT.into(employees).entries(dataSet)
        ]).then((resolve, reject) => {
            if (typeof(resolve) !== undefined){
                return req.data;
            } else{
                req.error(500,"Create Failed");
            }
        }).catch( err => {
            req.error(500," There was an error "+ err.toString());
        });
        return returnData;
    });

// UPDATE DATA 
    srv.on("UPDATE", "UpdateEmployeeSrv", async (req, res) => {
        var dataSet = req.data;
        let returnData = await cds.transaction(req).run([

// Update Operation
            UPDATE(employees).set ({
                nameFirst: req.data.nameFirst
            }).where({ID: req.data.ID}),

// Multiple operations can be performed like above 
            UPDATE(employees).set ({
                nameLast: req.data.nameLast
            }).where({ID: req.data.ID}),

            UPDATE(employees).set ({
                nameMiddle: req.data.nameMiddle
            }).where({ID: req.data.ID}),

            UPDATE(employees).set ({
                nameInitials: req.data.nameInitials
            }).where({ID: req.data.ID})            

        ]).then((resolve, reject) => {
            if (typeof(resolve) !== undefined){
                return req.data;
            } else{
                req.error(500,"Update Failed");
            }
        }).catch( err => {
            req.error(500," There was an error "+ err.toString());
        });
        return returnData;
    });

// DELETE DATA     
    srv.on("DELETE", "DeleteEmployeeSrv", async (req, res) => {

        var dataSet = req.data;
        console.log(req.data.ID)
        let returnData = await cds.transaction(req).run([

// DELETE Operation
            DELETE.from(employees).where({ID: req.data.ID})

        ]).then((resolve, reject) => {
            if (typeof(resolve) !== undefined){
                return req.data;
            } else{
                req.error(500,"Delete Failed");
            }
        }).catch( err => {
            req.error(500," There was an error "+ err.toString());
        });
        return returnData;
    });
};


module.exports = mysrvdemo;

```

</br>
</br>
After making the code changes deploy it and run
</br>

## tester.http (add these lines) 
</br>

```http
#### POST to insert data
POST http://localhost:4004/odata/v4/mysrvdemo/InsertEmployeeSrv
Content-Type: application/json    
    
    {
      "ID": "18BD2137-0890-1EEA-A6C2-BB55C197E7FB",
      "nameFirst": "JAVAX",
      "nameMiddle": null,
      "nameLast": "vade",
      "nameInitials": null,
      "sex": "M",
      "language": "E",
      "phoneNumber": null,
      "email": "JAX.VADE@Ey.com",
      "loginName": "jaxvade",
      "Currency_code": "USD",
      "salaryAmount": 999989,
      "accountNumber": "9988776655",
      "bankId": "77052358",
      "bankName": "Bank of NY"
    }

#### PATCH to Update data 
PATCH http://localhost:4004/odata/v4/mysrvdemo/UpdateEmployeeSrv/16BD2137-0890-1EEA-A6C2-BB55C197E7FB
Content-Type: application/json

{

      "nameFirst": "Genghis Khan",
      "nameMiddle": "Altan Tseren delger",
      "nameLast": "mongols",
      "nameInitials": "GK"

}

#### DELETE data 
DELETE http://localhost:4004/odata/v4/mysrvdemo/DeleteEmployeeSrv/18BD2137-0890-1EEA-A6C2-BB55C197E7FB

```
</br>
will test the application now 
</br>
<img src="./files/capmd5-1.png" >
</br>
</br>

Will troubleshoot it by debugging now.
</br>
To Debug we need to create config - (launch.json) file needs to be configures as shown below
</br>
</br>
<img src="./files/capmd5-2.png" >
</br>
<img src="./files/capmd5-3a.png" >
</br>
<img src="./files/capmd5-3b.png" >
<!-- </br>
<img src="./files/capmd5-3c.png" > -->
</br> 
<img src="./files/capmd5-3d.png" >
</br>
</br>


### launch.json

</br> change few more parameters to the config details added as shown below (project directory, and cds watch command, name description)
</br> After confguring the launch.json, the file should look like below json sample code 


```json
{
  "version": "0.2.0",
  "configurations": [


    {
      "command": "cds watch",
      "name": "Debug My CAP Application",
      "request": "launch",
      "type": "node-terminal",
      "cwd": "${workspaceFolder}/dante_cap"
    } ,

    {
      "name": "cds serve",
      "request": "launch",
      "type": "node",
      "cwd": "${workspaceFolder}/dante_cap",
      "runtimeExecutable": "npx",
      "args": [
      "cds",
      "serve",
      "--with-mocks",
      "--in-memory?"
      ],
      "skipFiles": [
      "<node_internals>/**"
      ]
      }
  ]
}
```
</br>
</br>

Set a breakpoint to our <b>MyService.js</b> code as shown below
</br>
</br>
<img src="./files/capmd5-4a.png" >
</br>
<img src="./files/capmd5-4b.png" >
</br>

</br>
</br>
To launch the Debugging 
</br>
<img src="./files/capmd5-5.png" >
</br>
</br>

When Debuggin is successfully launched following screen changes can be identified
</br>
</br>

Colour of the BAS will be changed
</br>
</br>
<img src="./files/capmd5-6.png" >
</br>
</br>

A small debug navigation window will appear - this prooves that debuggin mode is active 
</br>
</br>
<img src="./files/capmd5-6a.png" >
</br>
</br>

Go to tester.http and trigger the POST call for our MyService.js (Insert Employee service) 
</br>
</br>
<img src="./files/capmd5-6b.png" >
</br>
</br>

The trigger from tester.http file should stop at breakpoint as shown in the screen
</br>
</br>
<img src="./files/capmd5-6c.png" >
</br>
</br>

A debug navigation window will have all the navigation buttons enabled for usage
</br>
</br>
<img src="./files/capmd5-7.png" >
</br>
</br>

### Navigation window options 
</br>

</br>
This is like F8 in ABAP full execution of the code 
</br>
<img src="./files/capmd5-7a.png" >
</br>
This is like F5 in ABAP line by line execution
</br>
<img src="./files/capmd5-7b.png" >
</br>
This is New - there is JS code and CDS standard framework code 
</br> (all sql instruction is written inside a cds.transaction) if you want to step inside that specific block this button will help 
</br> when step-by-step execution wont access places like this, then <b>"step into"</b> is used.
</br>
<img src="./files/capmd5-7c.png" >
</br>
This is like F7 in ABAP full execution of the current code block even going outside of the call stack
</br>
<img src="./files/capmd5-7d.png" >
</br>
</br>

you can check the data of the variable in debug console as shown below 
</br>
</br>
<img src="./files/capmd5-8a.png" >
</br>

Have to navigate in the stacks to get the entry to edit 
</br>
<img src="./files/capmd5-8b.png" >
</br>
<img src="./files/capmd5-8c.png" >
</br>
<img src="./files/capmd5-8d.png" >
</br>
<img src="./files/capmd5-8e.png" >
</br>
</br>

The successful post of the data is refelected in response window
</br>
<img src="./files/capmd5-8f.png" >
</br>

</br>
PATCH before posting 
</br>
<img src="./files/capmd5-9a.png" >
</br>
PATCH after posting  
</br>
<img src="./files/capmd5-9b.png" >
</br>

Delete call tested 
</br>
<img src="./files/capmd5-9c.png" >
</br>
</br>

</br>
</br>

## How to Initialize GITHUB for BAS 
</br>
</br>

- [x] Create a Private repository in GITHUB and copy the link of that git hub.
- [x] Initiate git in bas using command (git init)
- [x] Add all the files to git staging area using command (git add)
- [x] Commit the changes using command (git commit -m "description" )
- [x] No we do GIT push

```md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Octavius-Dante/CAP_TEST.git
git push -u origin main
```
</br>
</br>

For me Git was already logged in to the browser so the authentication was different 
</br> but step is same, git connection step remains same. only user authentication differs.



</br>
</br>
<img src="./files/capmd5-git0.png" >
</br>
<img src="./files/capmd5-git1.png" >
</br>
<img src="./files/capmd5-git2.png" >
</br>
<img src="./files/capmd5-git3.png" >
</br>

when code changes were moade it appears like this 
</br>
<img src="./files/capmd5-git4.png" >
</br>

Code comparison 
</br>
<img src="./files/capmd5-git5.png" >
</br>

Reverting the changes 
</br>
<img src="./files/capmd5-git6.png" >
</br>
<img src="./files/capmd5-git7.png" >
</br>
<img src="./files/capmd5-git8.png" >
</br>
</br>
</br>

Commiting to Git hub using auto sync option 
</br>
<img src="./files/capmd5-git9.png" >
</br>
<img src="./files/capmd5-git10.png" >
</br>
<img src="./files/capmd5-git11.png" >
</br>
</br>
</br>

Commiting to git hub using graphical editor to - give version details 
</br>
<img src="./files/capmd5-git12.png" >
</br>
</br>
</br>
</br>


## HANA DB instance creation 
</br>
It is covered in following link please check 
</br>
https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/SAP_HANA_DB_CREATION
</br>
</br>

Followed by HDI Schema 
</br>
https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/SAP_HANA_HDI_SCHEMA_CREATION
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
</br>
</br>
</br>
