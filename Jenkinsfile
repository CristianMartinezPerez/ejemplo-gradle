pipeline {
    agent any
	
	choice(name: 'herramienta', choices: ['gradle', 'maven'], description: '')

    stages {
        stage('Pipeline') {
            steps {
                   script{
				   				 
					 def ejecucion = (params.herramienta == 'gradle') ? load 'gradle.grovy' : load 'maven.grovy'

				   }
            }
        }
    }
}
