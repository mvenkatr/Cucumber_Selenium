Description:

This project automates the automation assignment using Selenium with Cucumber framework and Maven as build management tool.

Prerequisites/Configuration setup required for the project:

JRE/JDK 1.8

Maven 3.1.1

Download and setup project on local machine:

Download and open the project as an existing maven project in Eclipse IDE

Select correct maven directory under ‘Maven home directory' in File->Settings->Build,execution, deployment->Maven

Select correct JDK for the project

Re-build the project and all the maven dependencies will be automatically resolved.


Run from Maven:

Go to terminal or open command prompt

Navigate to Project path

Run the command ‘mvn clean install’

Viewing reports:

When executing from IDE, reports are generated at ‘target/html report/Report/index.html’

Note: If chrome driver has issues add appropriate driver and execute as the Development was done using chrome driver for mac.

Following Enhancements can be done for the project:

-- Test data can be inculded to cucumber feature file for easier user expirience in BDD
-- The project can be run from Jenkins by installing appropriate maven dependency plugins forjenkins.
-- Screeenshots can be enabled for easy reporting purpose.
