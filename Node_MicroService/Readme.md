# Node Microservice 

#### adding external module called express to js code installed from npm repository

</br>
</br>

#### Activities

</br>
</br>

- [X] Create New folder in VS code 
- [X] perform npm init in terminal (pre-req node js to be installed)
- [X] add start script to launch the .js file in pacakge.json
- [X] create file (server.js)
- [X] node eco system npmjs.com site offers millions of modules available at disposal for resue 
     we choose express module from this link to create a web server (using the code) https://www.npmjs.com/package/express
- [X] install the package express in terminal (npm install express)
- [X] Create /webapp/ fodler and add 3 files (index.html, test.html, vendor.json)
- [X] Create manifest.yml file in main directory
- [X] Deploy the app to BTP account

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

### Now package.json file show the following dependencies added for the app

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

//Express module -- middleware to expose whole folder 
app.use(express.static('webapp'));

// inorder to avoid creating multiple following code above code is sufficient to access the objects but with right extension
// example "index.html", "test.html", "vendor.json"

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
```
``` css
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
```
``` html
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

``` json

{
    "result" :[
    {
        "companyName": "SAP Labs",
        "contactPerson": "Prakash Kumar",
        "firstName": "Ravikanth",
        "lastName": "Mallipeddu",
        "website": "www.sap.com",
        "email": "ravi@sap.com",
        "status": "A",
        "regDate": "2022-11-06T02:53:11.380+00:00"
    },
    
    
    {
        "companyName": "EMC2",
        "contactPerson": "Rajesh",
        "firstName": "Megha",
        "lastName": "Sharma",
        "website": "www.emc2.com",
        "email": "megha@emc2.com",
        "status": "A",
        "regDate": "2022-11-06T02:53:11.380+00:00"
    },
    
    
    {
        "companyName": "EMC2",
        "contactPerson": "Vinit",
        "firstName": "Sonia",
        "lastName": "Mehra",
        "website": "www.emc2.com",
        "email": "sonia@emc2.com",
        "status": "A",
        "regDate": "2022-11-06T02:53:11.380+00:00"
    },
    
    
    {
        "companyName": "EMC2",
        "contactPerson": "Rupesh",
        "firstName": "Stevia",
        "lastName": "Phillip",
        "website": "www.emc2.com",
        "email": "stevia@emc2.com",
        "status": "A",
        "regDate": "2022-11-06T02:53:11.380+00:00"
    },
    
    {
        "companyName": "SAP",
        "contactPerson": "Lohitaksh",
        "firstName": "Sakshi",
        "lastName": "Gupta",
        "website": "www.sap.com",
        "email": "sakshi@sap.com",
        "status": "A",
        "regDate": "2022-11-06T02:53:11.380+00:00"
    },
    
    {
        "companyName": "SAP",
        "contactPerson": "Prakash",
        "firstName": "Ravikanth",
        "lastName": "Malipeddu",
        "website": "www.sap.com",
        "email": "ravikanth@sap.com",
        "status": "A",
        "regDate": "2022-11-06T02:53:11.380+00:00"
    },
    
    {
        "companyName": "SAP",
        "contactPerson": "Sakshi",
        "firstName": "Anjali",
        "lastName": "Kumari",
        "website": "www.sap.com",
        "email": "anjali@sap.com",
        "status": "A",
        "regDate": "2022-11-06T02:53:11.380+00:00"
    },
    
    {
        "companyName": "EMC2",
        "contactPerson": "Anurag",
        "firstName": "Ananya",
        "lastName": "Biswas",
        "website": "www.emc2.com",
        "email": "ananya@emc2.com",
        "status": "A",
        "regDate": "2022-11-06T02:53:11.380+00:00"
    },
    
    
    {
        "companyName": "EMC2",
        "contactPerson": "Prakash",
        "firstName": "Srinivas",
        "lastName": "Kondacha",
        "website": "www.emc2.com",
        "email": "srinivas@emc2.com",
        "status": "A",
        "regDate": "2022-11-06T02:53:11.380+00:00",
        "addressess" : [
            {
                "addressType":"H",
                "street":"MG Road",
                "city":"Bangalore",
                "country":"India",
                "region":"APJ"
            },
            {
                "addressType":"P",
                "street":"Richmond Road",
                "city":"Bangalore",
                "country":"India",
                "region":"APJ"
            }
        ]
    }]
}

```
</br>
</br>

### /webapp/test.html

</br>
</br>

``` html

<html>

<head>
    <style>
```
``` css       
      :root {
        --dark-green: rgb(0, 35, 51);
        --light-green: #00ff84;
      }

      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }

      body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        background-color: var(--dark-green);
      }

      .pyramid {
        position: absolute;
        top: 10%;
        width: 200px;
        height: 200px;
        transform-style: preserve-3d;
        animation: animate 4s linear infinite;
      }

      @keyframes animate {
        0% {
          transform: rotateX(-30deg) rotateY(0deg);
        }
        100% {
          transform: rotateX(-30deg) rotateY(360deg);
        }
      }

      .pyramid div {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        transform-style: preserve-3d;
      }

      .pyramid div span {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: linear-gradient(#003911, var(--light-green));
        clip-path: polygon(50% 0%, 0% 100%, 100% 100%);
        transform: rotateY(calc(90deg * var(--i))) translateZ(99px) rotateX(30deg);
        transform-origin: bottom;
      }

      .pyramid .glow {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: var(--light-green);
        transform: rotateX(90deg) translateZ(-150px);
        filter: blur(20px);
        box-shadow: 0 0 500px var(--light-green);
      }
```
``` html    
    </style>
</head>

<body>
    <div class="pyramid">
      <div class="glow"></div>
      <div>
        <span style="--i: 0"></span>
        <span style="--i: 1"></span>
        <span style="--i: 2"></span>
        <span style="--i: 3"></span>
      </div>
    </div>
</body>

</html>

```

</br>
</br>

