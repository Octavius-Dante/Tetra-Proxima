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
.  "dependencies": {
.    "express": "^4.19.2"
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
});

app.get('/index', (req,res) => {
    res.sendFile(__dirname + '/webapp/index.html');
});

app.get('/vendors', (req,res) => {
    res.sendFile(__dirname + '/webapp/vendor.json');
});

app.get('/test', (req,res) => {
    res.sendFile(__dirname + '/webapp/test.html');
});

console.log("local server is running on http://localhost:3000");

// Start server at port 3000
app.listen(3000)

```

</br>
</br>

### webapp Folder
### /webapp/index.html

</br>
</br>

``` html

<html>
<head>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            height: 100svh;
            overflow: hidden;
        }

        #preloader {
            height: 100%;
            width: 100%;
            background: #333;
            position: relative;
        }

        .preload-item {
            position: absolute;
            width: 25px;
            aspect-ratio: 1;
            border: 1px solid greenyellow;
            border-radius: 100vh;
            top: 50%;
            left: 50%;
            translate: -50% -50%;
            animation: preloader-animation 4s linear infinite var(--_delay, 0s);
        }

        .preload-item:nth-child(2) {
            --_delay: .5s;
        }

        .preload-item:nth-child(3) {
            --_delay: 1s;
        }

        .preload-item:nth-child(4) {
            --_delay: 1.5s;
        }

        .preload-item:nth-child(5) {
            --_delay: 2s;
        }

        .preload-item:nth-child(6) {
            --_delay: 2.5s;
        }

        .preload-item:nth-child(7) {
            --_delay: 3s;
        }

        .preload-item:nth-child(8) {
            --_delay: 3.5s;
        }

        @keyframes preloader-animation {
            from {
                opacity: 0;
            }

            20%,
            80% {
                opacity: 1;
            }

            to {
                opacity: 0;
                width: 300px;
            }
        }
    </style>

</head>

<body>

    <div id="preloader">
        <div class="preload-item"></div>
        <div class="preload-item"></div>
        <div class="preload-item"></div>
        <div class="preload-item"></div>
        <div class="preload-item"></div>
        <div class="preload-item"></div>
        <div class="preload-item"></div>
        <div class="preload-item"></div>
    </div>

</body>

</html>

```

</br>
</br>

### /webapp/vendors.json

</br>
</br>

</br>
</br>

### /webapp/test.html

</br>
</br>

</br>
</br>

