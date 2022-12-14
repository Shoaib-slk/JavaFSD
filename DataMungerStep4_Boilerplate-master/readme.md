## Seed code - Boilerplate for step 4 - Database Engine Assignment

### Problem Statement

In our previous Assignment Step 3, we might have used different ways to identify the datatype, but using the **regular expression** we can identify them easily.

**Note : Once you have cloned boilerplate from the given gitlab URL, import the project into eclipse. 
Your project’s test cases might show compile time errors for methods, as you have not written the complete code.**

### Expected Output
Display each column header along with its data type

Ths output of this Assignment step will look like the following

            Enter the file name:
            (Input from the user) data/ipl.csv
            Output
                id:java.lang.Integer
                season:java.lang.Integer
                city:java.lang.String
                date:java.util.Date
                team1:java.lang.String
                team2:java.lang.String
                toss_winner:java.lang.String
                toss_decision:java.lang.String
                result:java.lang.String
                dl_applied:java.lang.Integer
                winner:java.lang.String
                win_by_runs:java.lang.Integer
                win_by_wickets:java.lang.Integer
                player_of_match:java.lang.String
                venue:java.lang.String
                umpire1:java.lang.String
                umpire2:java.lang.String
                umpire3:java.lang.Object

### Project structure

The folders and files you see in this repositories is how it is expected to be in projects, which are submitted for automated evaluation by Hobbes

    Project
    |
    ├── resources                                 // If a project needs any data file, it can be found here/placed here, if data is huge they can be mounted, no need put it in your repository
    |
    ├── com.stackroute.datamunger                // all your java file will be stored in this package
    |    └── query
    |        └── DataTypeDefinitions.java        // this class contains a String array to hold the column data types
    |        └── Header.java                     // This class implements the getHeader method to return a Header object which contains a String array for containing headers.
    |    └── reader
    |        └── CsvQueryProcessor.java          // This class is used to read data from CSV file
    |        └── QueryProcessingEngine.java      //abstract class containing three abstract methods that should be implemented in CsvQueryProcessor class
    |    └── test                               
    |        └── DataMungerTest.java             // all your test cases are written using JUnit, these test cases can be run by selecting Run As -> JUnit Test       
    |
    ├── .classpath                                // This file is generated automatically while creating the project in eclipse
    |
    ├── .hobbes                                   // Hobbes specific config options, such as type of evaluation schema, type of tech stack etc., Have saved default values for convenience
    |
    ├── .project                                // This is automatically generated by eclipse if this file is removed your eclipse will not recognize this as your eclipse project. 
    |
    |
    ├── pom.xml                                 // This is a default file generated by maven if this file is removed your project will not get recognized in hobbes.
    |
    └── PROBLEM.md                              // This files describes the problem of the assignment/project, you can provide as much as information and clarification you want about the project in this file

> PS: All lint rule files are by default copied during the evaluation process, however, if need to be customizing, you should copy from this repo and modify in your project repo

#### To use this as a boilerplate for your new project, you can follow these steps

1. Clone the base boilerplate in the folder **assignment-solution-step4** of your local machine
     
    `git clone https://gitlab-jpmc.stackroute.in/stack_java_datamunging/DataMungerStep4_Boilerplate.git assignment-solution-step4`

2. Navigate to assignment-solution-step4 folder

    `cd assignment-solution-step4`

3. Remove its remote or original reference

     `git remote rm origin`

4. Create a new repo in gitlab named `assignment-solution-step4` as private repo

5. Add your new repository reference as remote

     `git remote add origin https://gitlab-jpmc.stackroute.in/{{yourusername}}/assignment-solution-step4.git`

     **Note {{yourusername}} should be replaced by your username from gitlab**

5. Check the status of your repo 
     
     `git status`

6. Use the following command to update the index using the current content found in the working tree, to prepare the content staged for the next commit.

     `git add .`
 
7. Commit and Push the project to git

     `git commit -a -m "Initial commit | or place your comments according to your need"`

     `git push -u origin master`

8. Check on the git repo online, if the files have been pushed

### Important instructions for Participants
> - We expect you to write the assignment on your own by following the guidelines, learning plan, and the practice exercises
> - The code must not be plagiarized, the mentors will randomly pick the submissions and may ask you to explain the solution
> - The code must be properly indented, code structure maintained as per the boilerplate and properly commented
> - Follow the problem statement and stories shared with you

## MENTORS TO BEGIN REVIEW YOUR WORK ONLY AFTER 

- You add the respective Mentor as a Reporter/Master into your Assignment Repository
- You have checked your Assignment on the Automated Evaluation Tool - Hobbes (Check for necessary steps in your Boilerplate - README.md file. ) and got the required score - Check with your mentor about the Score you must achieve before it is accepted for Manual Submission. 
- Intimate your Mentor on Slack and/or Send an Email to learner.support@stackroute.in - with your Git URL 
- Once you done working and is ready for final submission.

### Further Instructions on Release

*** Release 0.1.0 ***

- Right-click on the Assignment select Run As -> Java Application to run your Assignment.
- Right-click on the Assignment select Run As -> JUnit Test to run your Assignment.