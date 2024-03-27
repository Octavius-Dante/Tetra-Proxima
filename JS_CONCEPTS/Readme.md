
# Promises in JavaScript

</br>   
</br>

What is a Promise?
</br>
</br>
A promise in JavaScript is similar to a promise in real life. When we make a promise in real life, it is a guarantee that we are going to do something in the future. Because promises can only be made for the future.
</br>
</br>
A promise has 2 possible outcomes: it will either be kept when the time comes, or it won’t.
</br>
</br>
This is also the same for promises in JavaScript. When we define a promise in JavaScript, it will be resolved when the time comes, or it will get rejected.
</br>
</br>
First of all, a Promise is an object. There are 3 states of the Promise object:
   
</br>

- [X] Pending: Initial State, before the Promise succeeds or fails
- [X] Resolved: Completed Promise
- [X] Rejected: Failed Promise
   
   </br>   
   </br>
   
   <img src="./files/promise.png" >
   
   </br>
   </br>   

```js

////////////////////////////////////////////////////////////////////
// promise function 

////////////////////////////////////////////////////////////////////
// sample code block for understanding

return new Promise((resolve, reject) => {
   if(somethingSuccesfulHappened) {
      const successObject = {
         msg: 'Success',
         data,//...some data we got back
      }
      resolve(successObject); 
   } else {
      const errorObject = {
         msg: 'An error occured',
         error, //...some error we got back
      }
      reject(errorObject);
   }
});

////////////////////////////////////////////////////////////////////
// sample code block for understanding

return new Promise((resolve, reject) => {
   if(somethingSuccesfulHappend) {
      resolve()
   } else {
      reject();
   }
});

////////////////////////////////////////////////////////////////////
// sample code block for understanding

const myPromise = new Promise((resolve, reject) => {  
    let condition;  
    
    if(condition is met) {    
        resolve('Promise is resolved successfully.');  
    } else {    
        reject('Promise is rejected');  
    }
});

   ```
   </br>
   </br>


What is Chaining?
   </br>
   </br>
Callback functions have been used alone for asynchronous operations in JavaScript for many years. But in some cases, using Promises can be a better option.
   </br>
   </br>
If there are multiple async operations to be done and if we try to use good-old Callbacks for them, we’ll find ourselves quickly inside a situation called 
   </br>
<b>Callback hell:</b>
   </br>
   </br>

```js

firstRequest(function(response) {  
    secondRequest(response, function(nextResponse) {    
        thirdRequest(nextResponse, function(finalResponse) {     
            console.log('Final response: ' + finalResponse);    
        }, failureCallback);  
    }, failureCallback);
}, failureCallback);

```

   </br>
   </br>
   </br>
However if we handle the same operation with Promises, since we can attach Callbacks rather than passing them, 
</br>
this time the same code above looks much cleaner and easier to read:
 </br>
 </br>
 
```js

firstRequest()
  .then(function(response) {
    return secondRequest(response);
}).then(function(nextResponse) {  
    return thirdRequest(nextResponse);
}).then(function(finalResponse) {  
    console.log('Final response: ' + finalResponse);
}).catch(failureCallback);

```

