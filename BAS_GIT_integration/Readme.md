## How to Connect BAS with GITHUB

### This GitHub integration is essential for CI - CD Pipeline in SAP BTP cloud 

</br>
</br>
</br>

## How to Initialize GITHUB for BAS 
</br>
</br>

- [x] Create a Private Or Public repository in GITHUB.
- [x] Initiate git in bas using command (git init)
- [x] Add all the files to git staging area using command (git add .)
- [x] Commit the changes using command (git commit -m "description" )
- [x] Then do GIT push

```md
// initiate Git in the project folder
git init

// adding only specific file with file name for staging
git add README.md

// adding all files for staging 
git add .

// staging command 
git commit -m "first commit"

// Initial connection setup commands
git branch -M main
git remote add origin https://github.com/Octavius-Dante/CAP_TEST.git
git push -u origin main

// Regular Git push commands
git add .
git commit -m "your comment/description"
git push

```
</br>
</br>

<details>
<summary> <b>1. Creating a Private repository in GITHUB </b> </summary>
</br>
</br>
Login to GitHub account

</br>
</br>
<img src="./files/bg_1.png" >
</br>
</br>

Create a repository
</br>
</br>
<img src="./files/bg_2.png" >
</br>
</br>

next step
</br>
</br>
<img src="./files/bg_3.png" >
</br>
</br>

next step
</br>
</br>
<img src="./files/bg_4.png" >
</br>
</br>

copy the link shown below 
</br>
</br>
<img src="./files/bg_5.png" >
</br>
</br>
</details>

<details>
<summary> <b> 2. Connecting GitHub in BAS </b> </summary>
</br>
</br>
<img src="./files/bg_6.png" >
</br>
</br>
<img src="./files/bg_7.png" >
</br>
</br>
<img src="./files/bg_8.png" >
</br>
</br>
<img src="./files/bg_9.png" >
</br>
</br>

in the next step copy the 3 lines from GitHub repository and paste it in BAS
to complete the push and proceed to connection
</br>
</br>
<img src="./files/bg_10.png" >
</br>
</br>
<img src="./files/bg_11.png" >
</br>
</br>
<img src="./files/bg_12.png" >
</br>
</br>
<img src="./files/bg_13.png" >
</br>
</br>
<img src="./files/bg_14.png" >
</br>
</br>
<img src="./files/bg_15.png" >
</br>
</br>
<img src="./files/bg_16.png" >
</br>
</br>
<img src="./files/bg_17.png" >
</br>
</br>

Git repository got updated from BAS as shown below 
</br>
</br>
<img src="./files/bg_18.png" >
</br>
</br>
</details>


<details>
<summary> <b> 3. Pushing the code using Push command</b> </summary>
</br>
</br>

Now code any changes to project is tracked by BAS as shown below
</br>
</br>
making small change in the code and it is reflected with a marker
</br>
</br>
<img src="./files/bg_19.png" >
</br>
</br>

We can push the changes to git hub using following commands every time 
</br> when there is a build completion
</br>

```bat

git add .
git commit -m "your comment/description"
git push

```

</br>
</br>
</br>

<img src="./files/bg_20a.png" >
</br>
</br>
<img src="./files/bg_21.png" >
</br>
</br>
<img src="./files/bg_22.png" >
</br>
</br>
</br>
</br>
</details>


<details>
<summary> <b> 4. Exploring the code changes in GUI</b> </summary>

Making some random changes in multiple files
</br>
</br>
<img src="./files/bg_23.png" >
</br>
</br>
<img src="./files/bg_24.png" >
</br>
</br>
<img src="./files/bg_25.png" >
</br>
</br>

Now there is an extension in BAS we can access to see all the changes 
</br>
</br>
<img src="./files/bg_26.png" >
</br>
</br>

All changes are listed in this section 
</br>
</br>
<img src="./files/bg_27.png" >
</br>
</br>

Changes can be compared when any item is selected here
</br>
</br>
<img src="./files/bg_28.png" >
</br>
</br>


Changes can be reverted using this button
</br>
</br>
<img src="./files/bg_29.png" >
</br>
</br>
<img src="./files/bg_29a.png" >
</br>
</br>

Changes can be navigated using these tools
</br>
</br>
<img src="./files/bg_30.png" >
</br>
</br>
</br>
</details>

<details>
<summary> <b> 5. Marking the files for staging in GUI </b> </summary>
</br>
</br>

No by selecting the plus button this file will be used for Staging
</br>
</br>
<img src="./files/bg_31.png" >
</br>
</br>

Staging ready files and not staged files are listed
</br>
</br>
<img src="./files/bg_32.png" >
</br>
</br>
</details>

<details>
<summary> <b> 6. Performing Commit and push </b> </summary>
</br>
</br>
<img src="./files/bg_33.png" >
</br>
</br>

Next step
</br>
</br>
<img src="./files/bg_34.png" >
</br>
</br>

GitHub prompt for running periodic changes (Choosing Yes is advisable)
</br>
</br>
<img src="./files/bg_35.png" >
</br>
</br>

Checking the reflected changes in GitHub
</br>
</br>
<img src="./files/bg_36.png" >
</br>
</br>
</details>


</br>
</br>
</br>


<!--

</br>
</br>

``` cds 
	


``` 

</br>
</br>
<img src="./files/capmd7-1.png" >
</br>
</br>

## MyService.js 
</br>
</br>

```js



```
</br>
<img src="./files/capmd7-2.png" >
</br>
</br>



<details>
<summary> <b> ALL CODE CHANGES - TODAY SESSION </b> </summary>
</br>
</br>

</br>
</br>

</br>
</br>
</details>


-->


</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>

# --------- End of GitHub integration ---------

<p align="center"> 
	
</br>
</br>

#### All Sessions
</br>

- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-12"> CAPM Day 12 - Extension CI CD</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-11"> CAPM Day 11 - S4HANA Side by Side</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-10"> CAPM Day 10 - Side by Side extension</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-9"> CAPM Day 9 - Serverless Fiori App</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-8"> CAPM Day 8 - CAPM Security XSUAA</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-7"> CAPM Day 7 - HANA and Deployment</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-6"> CAPM Day 6 - Fiori App Draft</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-5"> CAPM Day 5 - Fiori Elements</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-4"> CAPM Day 4 - Generic Handlers</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-3"> CAPM Day 3 - EPM DB and CDS Views</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-2"> CAPM Day 2 - Aspects and Reuse Tables</a>
- [x] <a href="https://github.com/Octavius-Dante/Tetra_Proxima/tree/main/CAPM-DAY-1"> CAPM Day 1 - First CAP App </a>

</br>
</br>

</p>
