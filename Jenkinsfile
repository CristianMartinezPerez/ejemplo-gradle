pipeline {
    agent any
	
	parameters { choice(name: 'herramienta', choices: ['gradle', 'maven'], description: '') }

    stages {
        stage('Pipeline') {
            steps {
                   script{
				   	 echo "Choice: ${params.herramienta}"
					 
					 def ejecucion = (params.herramienta == 'gradle') ? load 'gradle.grovy' : load 'maven.grovy'
					 ejecucion.call()

				   }
            }
        }
    }
}
