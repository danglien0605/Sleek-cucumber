# Assignment
## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Make sure you have installed all of the following prerequisites on your development machine:
* JDK 8 - [Download and install JDK 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
```
1.8.0_271
```
* Maven - [Download & Install Maven](http://maven.apache.org/)
```
3.8.6
```
* JAVA_HOME System variable [Setup & Verification](https://mkyong.com/java/how-to-set-java_home-on-windows-10/)
* MAVEN_HOME System variable [Setup & Verification](https://mkyong.com/maven/how-to-install-maven-in-windows/)
```
3.8.6
```
* IntelliJ IDE: 
```
2021.3.3
```
*## Running

#### Running test
- From Command line (Windows) or Terminal (MacOS) type this command: 

```
mvn clean verify -D"cucumber.filter.tags=@<tagName>"
```
#### Reporting

- Report will be generated tо directory: `target\cucumber-html-reports`
  