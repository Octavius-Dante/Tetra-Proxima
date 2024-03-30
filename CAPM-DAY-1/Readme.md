## CAPM - Day 1 

### Cloud application programming model - framework 

</br>
</br>

**Overview**
</br>
</br>
<p>
CAPM is a framework of SAP BTP, supported with languages JAVA and Node JS, it is supported with libraries and CDS node modules, it can be developed using BAS or VSCode,
the CAP framework is used of building enterprise grade applications and extension which ar cloud native in SAP BTP.
</p>
</br>
</br>

### CDS - Core Data and services  

</br>
</br>

**Overview**
</br>
</br>
<p>
Conceptually CDS is same concept in ABAP but with different flavour in CAPM, The concept says that , we have a design time object which is a cds file, we will create a *.cds file for almost everything eg. databse tables, view, model, services, Ui/UX
</br>
</br>

  - [x] This design time object file is complires by CAPM framework (inside CAP we have node module called <b>@sap/cds</b>)
  - [x] Once the compilation is successeful a <b>runtime</b> object gets created
  - [x] Cloud Documentation CAPM - https://cap.cloud.sap/docs/about
  - [x] SAP CAP official release notes https://cap.cloud.sap/docs/releases/
</p>
</br>
</br>

### Modules for using CAP

</br>
</br>

  - [x] We need to install </br>sap cds-dk</br> (development kit), This kit includes required framework libraries and source code to build, test deploy, run applications.
  - [x] It comes along with cds CLI which will be used by developers to quickly generate the CAP project skeleton.
  - [x] This module needs to be installed globally in our system if we are using VS code, in case we use BAS, this module is pre-installed.
</br>
</br>

- [x] install cds developer kit in your computer using command prompt  
</br>

```bat
npm install -g @sap/cds-dk
```
</br>
</br>

- [x] Post install verify installation of cds kit by using following commands 
</br>
</br>

```bat
cds --help  
```
</br>
or
</br>

```bat
cds help  
```
</br>
</br>

- [x] Node version should be 14 or higher , use following commands to check 
</br>

```bat
node -v 
```
</br>
or 
</br>

```bat
node v 
```
</br>
</br>

- [x] Check your cds version to get a valid response so that supported node version is checked by cds package
</br>
</br>
   <img src="./files/capmd1-1.png" >
</br>
</br>

- [x] if version is not supported following response will be given 
</br>
</br>
  <img src="./files/capmd1-2.png" >
</br>
</br>

- [x] create a folder in your computer and run <b>cds init</b> command. This will create a project skeleton automatically which includes <b>db, srv, ui</b> folders. 
</br>
</br>

```bat
cds init
```
</br>
</br>
  <img src="./files/capmd1-3.png" >
</br>
</br>

- [x] install node version manager nvm to manage node verison in system https://github.com/coreybutler/nvm-windows/releases/tag/1.1.12
</br>
if there is multiple node projects which is assocaited with different version user will be faced with a challenge of switching
</br> different node version to work with different projects
</br>
</br>
  <img src="./files/capmd1-4.png" >
</br>
</br>
<p>
