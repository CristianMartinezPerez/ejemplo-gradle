pipeline {
    agent any

    stages {
        stage('Pipeline') {
            steps {
                   script{
				       stage('Build & Test')
					   {
					      sh "gradle clean build"  

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
					   }	
				       stage('Rest')
					   {
					   }					   
				   	   stage('Nexus')
					   {
					   }
				   
				   }
            }
        }
    }
}
