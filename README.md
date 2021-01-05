# Getting Started

ci

## Windows
Version para Gradle
### Compile, Test, Jar
*  gradle build

### Run Jar
* Local:      gradle bootRun 
* Background: gradle bootRun &

### Testing Application
* Abrir navegador: http://localhost:8082/rest/mscovid/test?msg=testing

## Linux

### Compile Code, Test, Jar
* ./gradlew build

### Run Jar
* Local:      ./gradlew build
* Background: nohup bash gradlew bootRun &

### Testing Application
* curl -X GET 'http://localhost:8082/rest/mscovid/test?msg=testing'
