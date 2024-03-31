## CAPM - Day 2

#### Correction to yesterday's CAP program
</br>
</br>

The program was using <b>'req.body.name'</b> in return parameter statement it is corrected 
 
</br>
</br>

```JS
const Myservice = function(srv){
    // this code bloc is like DPC extension class in SAP ODATA services  
    srv.on('helloCAP', (req,res) => {
        return "Hello CAP cloud developers, Welcome " + req.data.name;
    });
}

// return Myservice;
module.exports = Myservice;
```
</br>
</br>

#### End result 
</br>
</br>
   <img src="./files/capmd2-1.png" >
</br>
</br>
use the following url parameter value to see the passed value 
</br>
</br>

```url
http://localhost:4004/odata/v4/my/helloCAP(name='dante')
```
</br>
</br>
   <img src="./files/capmd2-2.png" >
</br>
</br>

## Database Concepts 
</br>

### Reuse Types and aspects 
</br>
</br>
