pipeline {
  agent any

  stages {

    stage('Compile') {
      steps {

        sh 'mvn clean compile -e'

      }
    }
    stage('Test') {
      steps {

        sh 'mvn clean test -e'

      }
    }
    stage('Jar') {
      steps {
        sh 'mvn clean package -e'

      }
    }
    stage('SonarQube analysis') {
      steps {
        withSonarQubeEnv(installationName: 'SonarQube') {
          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
        }
      }
    }
    stage('uploadNexus') {
      steps {

        nexusPublisher nexusInstanceId: 'Nexus',
        nexusRepositoryId: 'test-nexus',
        packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\cmartinez\\Documents\\personal\\devops\\Unidad 3\\tarea9\\ejemplo-maven\\build\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]

      }
    }

  }
}