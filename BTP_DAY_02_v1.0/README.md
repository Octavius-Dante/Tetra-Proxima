# Maven & Spring Tool Suite - Starter guide

</br>
</br>
Maven is essential for managing the project with needed artifacts 
</br>
</br>

**Installation of MAVEN to system**

- [X] Prerequisite java installation Legacy sJava 8 (v1.8) is sufficient for Maven as on Q4-2023 
- [X] Download the MAVEN file (extract in the needed Directory) https://maven.apache.org/download.cgi

</br>

**Installation of Spring tools suite to system**

- [X] Prerequisite java installation version 17 or greater needed for Spring tool suite as on Q4-2023 
- [X] Spring Tools Suite (STS) https://spring.io/tools

</br>

**(1) Maven download**
   </br>
   </br>
    <img src="./files/1-maven.png" >
   </br>
   </br>
   
**(2) Spring Tools suite for windows download - this is a modified version of eclipse IDE**
   </br>
   </br>
    <img src="./files/2-sts.png" >
   </br>
   </br>
   
**(3) Post Spring STS extraction, increase the RAM allocation for STS by making changes to '*.ini file in STS directory**

- Change the values as mentioned in screenshot initial it will be 512m or 256m , change it to 1G and 6G accordingly MB to GB allocation of RAM for this spring software.
   </br>
   </br>
    <img src="./files/3-sts.png" >
   </br>
   </br>

**(4) Extract Maven Apache server file to a directory and set environment variables**
   </br>
   </br>
   <img src="./files/maven_path.png" >
   </br>
   </br>
   <img src="./files/env_variables.png" >
   </br>
   </br>

   
# Starting spring tool suite : Troubleshooting issues

</br>

- [x] **LSP (Spring boot language server) error when you launch Spring STS.**
  
   </br>
   
*Problem :*
   </br>
   </br>
    <img src="./files/sts_error_1.jpg" >
   </br>
   </br>
   </br>
      
*Solution : Change the active provider from (Native) to (Direct)*
   </br>
   </br>
    <img src="./files/sts_error_fix.jpg" >
   </br>
   </br>


# Creating a spring starter project

- Step 1 - select the starter project 
   </br>
   </br>
    <img src="./files/sts_starter.png" >
   </br>
   </br>
   </br>
- Step 2 - Fill all necessary data
   </br>
   </br>
    <img src="./files/sts_starter_2.png" >
   </br>
   </br>
   </br>
- Step 3 - Click finish
   </br>
   </br>
    <img src="./files/sts_starter_3.png" >
   </br>
   </br>
   </br>
  
- Step 4 - files will be generated - select pom file

</br>

   > [!NOTE]   
   > What is POM file ?  >Project Object Model is a file which is required by maven to manage all dependencies required for the project.
   
   </br>
   </br>
   <img src="./files/pom.png" >
   </br>
   </br>
   </br>

- Step 5 - After creating POM file if there is any error in the file in the mentioned location, it can be fixed.

   *Problem :*
   </br>
   </br>
    <img src="./files/xml_error.png" >
   </br>
   </br>
   </br>

   *Solution :*
   </br>
   </br>
    <img src="./files/sts_error_fix_2.jpg" >
   </br>
   </br>
   </br>
