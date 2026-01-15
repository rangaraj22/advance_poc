Quick usage:
1. unzip the project
2. open in IDE
3. mvn clean test
4. Reports will be generated under /reports/ExtentReport.html



pass environment for manve/jenkins for multiple environment
commandline:
mvn clean test -Denv=qa

jenkins
environment qa

local QA run:default
mvn clean test
UAT run:
mvn clean test -Denv=uat

jenkins: withbrowser
mvn clean test -Denv=qa -Dbrowser=chrome
