 # Node JS - Basics - 1  (index.js) # 1


   </br>
   </br>

 Scroll down to bottom of the page for first example - Bottom Up approach
 </br>
 copy the whole program and and execute it 
   
   </br>
   </br>
   
   ```js
   
console.log('\n',"Example 5 : Array of JSON objects");
//////////////////////////////////////////////////////////////////////
// Example 5 : Array of JSON objects - multiple records (row) with fields (column)  
// Similar like internal table in ABAP 

var aEmployees = [{
    "empId" : 1000100,
    "empName" : "Adam",
    "PayScale" : 350000,
    "Currency" : "USD",

} ,
{
    "empId" : 1000200,
    "empName" : "Benniton",
    "PayScale" : 450000,
    "Currency" : "USD",

} ,
{
    "empId" : 1000300,
    "empName" : "Carlyle",
    "PayScale" : 550000,
    "Currency" : "USD",

} ,
{
    "empId" : 1000400,
    "empName" : "Dante",
    "PayScale" : 650000,
    "Currency" : "KWD",

} 
]
for (const key in aEmployees) 
{    console.log('\n',"Record Array position :", key);
    if (Object.hasOwnProperty.call(aEmployees, key)) {
        const element = aEmployees[key];
        console.log(element);
    }
}

console.log('\n');
console.log("Salary is =====>> " + aEmployees[2].PayScale);

console.log('\n',"Example 4 : JSON objects");
console.log('\n');
//////////////////////////////////////////////////////////////////////
// Example 4 : working with Object varibles 
// <3> Object variable - stores multiple variety of values
// it is a ROW based store with line item with multiple different data types
// JSON - Java script object notation
// { 
//   prop:value_1, 
//   prop:value_2, 
//   prop.value_3  
// };

var oEmp = {
        "empId" : 1000100,
        "empName" : "Dante",
        "PayScale" : 350000,
        "Currency" : "USD",

} ;

// Printing an item value to console 
console.log( "Accessing a single item in a row : " + oEmp.empId);

// Replacing the item value 
console.log('\n',"Before Employee name change");
console.log(oEmp.empName);
oEmp.empName = "Aiden";
console.log('\n',"After Employee name change");
console.log(oEmp.empName);

// adding new item to the object 
oEmp.gamer = true;

// Printing all values type-1 
console.log('\n',"Printing all object Type-1");
console.log(oEmp);

// Printing all values type-2 
console.log('\n',"Printing all object Type-2");
console.log("Printing all object : ", JSON.stringify(oEmp));

console.log('\n',"Printing all object Type-3");
// Printing all values type-3
for (const key in oEmp) {
    if (Object.hasOwnProperty.call(oEmp, key)) {
        const element = oEmp[key];
        console.log(element);
    }
}

console.log('\n',"Example 3 : Array variables");
console.log('\n');
//////////////////////////////////////////////////////////////////////
// Example 3 : working with Array variables 
// <2> Array variables - stores multiple values of same data types 
// index item of array stars with zero 
// array created using set brackets - []
// array is a COLUMN based store with index of items
// {0,1,2,3,4}

var arrFruits = ["apple","banana","cherry"];
// Add an item to the last position of the array at the end like (append)
arrFruits.push("+jackfruit");

// Add an item to the Zeroth position
arrFruits.splice(0,0,"+litchi");

// Add an item to the first position
arrFruits.splice(1,0,"@durian");

// Add an item to the fourth position
arrFruits.splice(4,0,"@Mango");

// Remove one element and insert an item in 4th position
arrFruits.splice(4,1,"@Custard Apple");

// arrFruits.splice(index position, how many elements need to be removed, "value");

// removing an item in array with index position
arrFruits.splice(3,1); // this removes an item in 3rd index 
arrFruits.splice(3,2); // this removes 2 item from 3rd index 
arrFruits.splice(3,3); // this removes 3 item from 3rd index 
arrFruits.splice(3,4); // this removes 4 item from 3rd index 

// arrFruits.splice(1,<remove zero item>,"@Mango");
// arrFruits.splice(1,<remove 1 item>,"@Mango");
// arrFruits.splice(<could be any number of items based on total items in array>,<1--replace item>,"@Mango");

// to print every item for loop is needed
for (let i = 0; i < arrFruits.length; i++) {
    const element = arrFruits[i];
    console.log(element);
}

console.log('\n');
console.log("First item in array : Position Zero-->",arrFruits[0]);
console.log("Second item in array : Position One-->",arrFruits[1]);
console.log("Third item in array : Position Two-->",arrFruits[1]);
console.log("Last item in array : Position Last-->",arrFruits[arrFruits.length-1]);

// Array example 1: assign all array items from mentioned position to another array
console.log('\n'); 
console.log('\n',"Array example 1: assign all array items from mentioned position to another array")

let months = ["January", "February", "Monday", "Tuesday"];
let days = months.splice(2);

console.log("Days:",days); // ["Monday", "Tuesday"]
console.log("Months",months); // [ "January", "February"]

// Array example 2: assign an array item from mentioned position to another array
console.log('\n'); 
console.log('\n',"Array example 2: assign an array item from mentioned position to another array");

let months_2 = ["January", "February", "Monday", "Tuesday"];
let days_2 = months_2.splice(2,1); // Remove one element from index positon 2

console.log("Days",days_2); // ["Monday"]
console.log("Months",months_2); // ["January", "February", "Tuesday"]

// Array example 3: assign multiple array items from mentioned position to another array
console.log('\n'); 
console.log('\n',"Array example 3: assign multiple array items from mentioned position to another array");

let months_3 = ["January", "February", "March", "April", "Monday", "Tuesday", "Wednesday", "Thursday"];
let days_3 = months_3.splice(2,3); // Remove 3 element from index position 2 

console.log("Days",days_3); // [ 'March', 'April', 'Monday' ]
console.log("Months",months_3); // [ 'January', 'February', 'Tuesday', 'Wednesday', 'Thursday' ]

// Array example 4: Splicing an array and assigning to other array also adding multiple values to array
console.log('\n'); 
console.log('\n',"Array example 4: Splicing an array and assigning to other array also adding multiple values to array");

let months_4 = ["January", "February", "Monday", "Tuesday"];
let days_4 = months_4.splice(2, 2, "March", "April"); // Take 2 elements from 2nd index and add 2 elements to the 2nd index

console.log("Days",days_4); // ["Monday", "Tuesday"]
console.log("Months",months_4); // ["January", "February", "March", "April"]

console.log('\n',"Example 2 : Scalar variables");
console.log('\n');
//////////////////////////////////////////////////////////////////////
// Example 2 : Working with scalar variables 
// <1> scalar variables - capable of storing one value
// no need to define data types just mention a value 
// so compiler auto decides the data type for the variable  

// var - global variables 
// let - lcoalvariables 
// const - create constants
const pi = 3.14;
var r = 10;
var a = 30;
var area = pi * r * r ;

area += a;
// a = a + area;
// area = area + a;

console.log("Area of the circle is : " + area);
console.log('\n',"Example 1 : Print data on console");
console.log('\n');
//////////////////////////////////////////////////////////////////////
//Example 1 : print data in console 

console.log("Hello hacker");	
   
   ```
   </br>
