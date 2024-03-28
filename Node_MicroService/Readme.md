# Node Microservice 

#### adding external module to js code 

</br>
</br>

- [X] Create New folder in VS code 
- [X] perform npm init in terminal (pre-req node js to be installed)
- [X] add start script to launch the .js file in pacakge.json
- [X] file name : server.js

</br>

### package.json

</br>
</br>

``` json

// Before 

{
  "name": "nodemicroservice",
  "version": "1.0.0",
  "description": "test node js mcs service ",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "dante",
  "license": "ISC"
}


// After 

{
  "name": "nodemicroservice",
  "version": "1.0.0",
  "description": "test node js mcs service ",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "start": "node server.js"  
  },
  "author": "dante",
  "license": "ISC"
}

```

</br>
</br>

This option to run script will be avialable after adding the script command in package.json file 
</br>
</br>
<img src="./files/npm1.png" >
</br>
</br>

- [X] node eco system npmjs.com site offers millions of modules available at disposal for resue 
     we choose express module from this link to create a web server (using the code) https://www.npmjs.com/package/express
- [X] install the package express in terminal 
- [X] now package.json file show the following dependencies added for the app

</br>
</br>

``` json

{
  "name": "nodemicroservice",
  "version": "1.0.0",
  "description": "test node js mcs service ",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "start": "node server.js"
  },
  "author": "dante",
  "license": "ISC",
..  "dependencies": {
..    "express": "^4.19.2"
  }
}


```

</br>
</br>

### server.js 

</br>
</br>

```js



console.log("Hello server!");
//console.log('Hello server!');

// Getting the object of reusable module
const express = require('express')

// Initializing an app 
const app = express()

// Add an end point  = /"blank" - this is the default endpoint 
// Which will trigger when app starts 
app.get('/', function (req, res) {
  res.send('Hello SAP developer and programmers !!');
})

console.log("local server is running on http://localhost:3000");

// Start server at port 3000
app.listen(3000)

```
