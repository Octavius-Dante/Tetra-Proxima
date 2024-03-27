
# Promises in JavaScript

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
