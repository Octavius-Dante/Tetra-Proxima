 # Node JS - Basics - 2 
   
   
   </br>
   </br>
   
   ```js
   

console.log('\n',"Example 6 : Creating Function ");
//////////////////////////////////////////////////////////////////////
// Function definition type-1

var x = 10;
var y = 20;

var addNumber = function(a,b)
{
// In classical function we cannot access global variables this.tax  THIS IS FIXED IN 2024   
    return a + b + this.tax;
}

var result = addNumber(x,y);

console.log(result);

//////////////////////////////////////////////////////////////////////
// ES6 Standard -- arrow function is a new syntax fir creating function
// Function definition type-2

mixNumber = (a,b) => 
{ 
// In arrow function we can access global variables this.tax        
    return a * b + this.tax; 
}

console.log(mixNumber(x,y));


return; // below code wont be processed when return; statement is used.

console.log('\n',"Example 1 : Print data on console");
console.log('\n');
//////////////////////////////////////////////////////////////////////
//Example 1 : print data in console 

console.log("Hello hacker");	
   
   ```
   </br>
   </br>
   
#  UTIL folder resuse.js
   
   </br>
   </br>   
   
   ```js
   
//////////////////////////////////////////////////////////////////////
// Reusable node moudle for programs 

module.exports = {

addNumbers : function(a,b)
{
    console.log(a+b);
},

productNumbers : function(a,b)
{
    console.log(a*b);
},

countArray : function(arr)
{
    console.log(arr.length);
},

PrintArray : (arrinp) =>
{
    for (let i = 0; i < array.length; i++) {
        const element = array[i];
        console.log(element);        
    }
},

PrintArray : (jsonInput) =>{
    for (const key in jsonInput) {
        if (Object.hasOwnProperty.call(jsonInput, key)) {
            const element = jsonInput[key];
            console.log(element);
        }
    }
}

}	
   
   ```
   </br>
   </br>
   
#  consumeModule.js (from main folder where index.js is)
    
   </br>
   </br>   
   
   ```js

//////////////////////////////////////////////////////////////////////
// consuming reusable module into the program

var reuse = require('./util/reuse');

reuse.addNumbers(50,30);
reuse.printJson({"Team" : "liverpool", "Player":"Galliop David"});
reuse.PrintArray([75,95,25,67,83,56,19,33,42]);


   ```

   </br>
   </br>

#  async.js (from main folder where index.js is)

</br>
</br>

### Call back function with asynchronours and synchronous waiting example 
   
   </br>
   </br>

   ```js

//////////////////////////////////////////////////////////////////////
// sample call back function Asynchronous converted to a promise
// EXAMPLE 2

const timerFunction = ms => new Promise(resolve => setTimeout(resolve, ms));

// create a wrapper to call promise and pass parameter value 
const callMyFunction = () => {
    // once the promise execution is finished a function gets called in then 
    return timerFunction(5000).then( () => {
        console.log("I am a wait function");
    });
}

const myFunction_2 = async () => {
    console.log("Before calling async function");
    await callMyFunction();
    console.log("End of my function");
}

myFunction_2();

return;

//////////////////////////////////////////////////////////////////////
// sample call back function not waiting Asynchronous behaviour 
// EXAMPLE 1 

// const myfunction = () =>{
//     console.log("before calling the timer");
//     setTimeout(
//         // call back function, once processing is over
//         function(){},5000);
//     console.log("after calling the timer");
// }

// sample call back function with waiting functionality synchronous behaviour 
const myfunction = () =>{
    console.log("before calling the timer");
    setTimeout(
        // call back function, once processing is over
        function(){
            console.log("after calling the timer");
        },5000);
    // console.log("after calling the timer");
}


myfunction();

   ```

   </br>
   </br>
