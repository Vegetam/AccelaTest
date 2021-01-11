# AccelaTest

Create a simple command line JAVA application with database access;

Based on an input from the command line provide the following functionality;

Provide help
1. Add Person (id, firstName, surname)
2. Edit Person (firstName, surname)
3. Delete Person (id)
4. Count Number of Persons
5. List Persons

Additional Requirements, nice to have
1. Ability to Add Person from XML / JSON
2. Test coverage
3. Maven or Gradle Build
4. Executable Jar

# Technology Stack

Spring Boot 

Maven

Java 11

Junit create few Junit testing

H2 setted as in-memory Database (so the data won't be persistent)

#### Steps

##### Clone source code from git

$  git clone https://github.com/Vegetam/AccelaTest 

### Run as Java Application

After you cloned the project import the project as Maven
Once everything as been imported run as java application the following class AccelaApplication

After you run this application you will have 5 option to select.

Here is what this application is doing :
![website image][]

[website image]: /screenshot/1.png "Screenshot 1"

### Run as JAR

if you want to run as jar please go with the console to the folder Jar
and then run the following command :

java -jar com.fm.accela-0.0.1-SNAPSHOT.jar
