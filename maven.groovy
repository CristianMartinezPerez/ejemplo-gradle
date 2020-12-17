/*

	forma de invocación de método call:

	def ejecucion = load 'script.groovy'
	ejecucion.call()

*/

def call(){
  
   stage('Compile') {
        sh 'mvn clean compile -e'
    }
    stage('Test') {
        sh 'mvn clean test -e'
    }
    stage('Jar') {
        sh 'mvn clean package -e'
    }
    stage('SonarQube analysis') {
        withSonarQubeEnv(installationName: 'SonarQube') {
          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
        }
    }
	
	stage('Run') {
				sh 'mvn spring-boot:run &'
				sleep 20
	}
	stage('Rest'){
	   bat 'curl -X GET http://localhost:8082/rest/mscovid/test?msg=testing'
   }
	
    stage('Nexus') {

        nexusPublisher nexusInstanceId: 'Nexus',
        nexusRepositoryId: 'test-nexus',
        packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\cmartinez\\Documents\\personal\\devops\\Unidad 3\\tarea10\\ejemplo-maven\\build\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]

    }

}

return this;