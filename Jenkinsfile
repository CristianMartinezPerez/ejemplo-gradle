pipeline {
    agent any

    stages {
        stage('Pipeline') {
            steps {
                   script{
				       stage('Build & Test')
					   {
					      bat "gradle clean build"  

					   }
				       stage('Sonar')
					   {
					   
					   		def scannerHome = tool 'sonar-scanner';
							
							withSonarQubeEnv('SonarQube') { 
							  bat "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"

							}
					   }	
				       stage('Run')
					   {
						  bat "nohup start gradle bootRun &"
						  sleep 20

					   }	
				       stage('Rest')
					   {
					       bat 'curl -X GET http://localhost:8082/rest/mscovid/test?msg=testing'
					   }					   
				   	   stage('Nexus')
					   {
					        nexusPublisher nexusInstanceId: 'Nexus',
							nexusRepositoryId: 'test-nexus',
							packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\cmartinez\\Documents\\personal\\devops\\Unidad 3\\tarea11\\ejemplo-gradle\\build\\libs\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]

					   }
				   
				   }
            }
        }
    }
}
