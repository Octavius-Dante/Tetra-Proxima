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
    srv.on("CREATE", "InsrEmployeeSrv", async (req, res) => {
        var dataSet = [];
        let returnData = await cds.transaction(tx).run([

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
        var dataSet = [];
        let returnData = await cds.transaction(tx).run([

// Update Operation
            UPDATE.into(employees).set ({
                nameFirst: req.data.nameFirst
            }).where({ID: req.data.ID}),

// Multiple operations can be perfromed liek above 
            UPDATE.into(employees).set ({
                nameLast: req.data.nameLast
            }).where({ID: req.data.ID}),

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

        var dataSet = [];
        let returnData = await cds.transaction(tx).run([

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
</br>

```http
#### POST to insert data
POST http://localhost:4004/odata/v4/mysrvdemo/InsertEmployeeSrv
Content-Type: application/json    
    
    {
      "ID": "02BD2137-0890-1EEA-A6C2-BB55C190999A",
      "nameFirst": "John",
      "nameMiddle": null,
      "nameLast": "RAMBO",
      "nameInitials": null,
      "sex": "Max-Forwards: ",
      "language": "E",
      "phoneNumber": null,
      "email": "J.Rambo@Ey.com",
      "loginName": "RAMBOJ",
      "Currency_code": "USD",
      "salaryAmount": 999989,
      "accountNumber": "9988776655",
      "bankId": "77052358",
      "bankName": "Bank of NY"
    }
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
</br>
<img src="./files/capmd5-3c.png" >
</br>
<img src="./files/capmd5-3d.png" >
</br>
</br>

After confguring the launch.json file will looks liek as follows 
</br>
### launch.json
</br>

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "command": "npm start",
      "name": "Run npm start",
      "request": "launch",
      "type": "node-terminal"
    },
    
    {
      "name": "Launch Chrome",
      "request": "launch",
      "type": "chrome",
      "url": "http://localhost:8080",
      "webRoot": "${workspaceFolder}"
    },

    {
      "name": "cds serve",
      "request": "launch",
      "type": "node",
      "cwd": "${workspaceFolder}",
      "runtimeExecutable": "cds",
      "args": [
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
</br>
```cds

```

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
