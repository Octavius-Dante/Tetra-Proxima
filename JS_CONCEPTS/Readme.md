
# Promises in JavaScript

</br>   
</br>

What is a Promise?
</br>
</br>
A promise in JavaScript is similar to a promise in real life. When we make a promise in real life, it is a guarantee that we are going to do something in the future. Because promises can only be made for the future.
</br>
A promise has 2 possible outcomes: it will either be kept when the time comes, or it won’t.
</br>
This is also the same for promises in JavaScript. When we define a promise in JavaScript, it will be resolved when the time comes, or it will get rejected.
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
// sample code block understanding

return new Promise((resolve, reject) => {
   if(somethingSuccesfulHappend) {
      resolve()
   } else {
      reject();
   }
});

   ```
   </br>
   </br>
