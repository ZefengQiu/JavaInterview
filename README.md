# JavaInterview

## Description
For Veeva backend dev interview, change ant project to use Gradle. Upgrade the lib to later version.
Implement dependency injection, inheritance and polymorphism for future improvement and easy to union test.

## Build, Run, Test, Result

* ./gradlew build
* ./gradlew run
* ./gradlew test
* cat combined.csv  (to check output of the sample files)

(after run the main function, output is at root directory in this project)

## Arguments
For passing args into main function in java, plz edit "build.gradle" file, in the end `run { args = [] }` section. And put the file under src/main/resources folder. If you want to add more test cases, follow the same style of Test.java files under src/test/java, and add test files in the resources folder under test.  

## Unit Test
For limited time, I added two kind test files -- one with Chinese, the other with empty info of person.

