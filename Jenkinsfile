pipeline {
    agent any
	
	parameters { choice(name: 'herramienta', choices: ['gradle', 'maven'], description: '') }

    stages {
        stage('Pipeline') {
            steps {
			       /*echo "Choice: ${params.herramienta}"*/
                   script{				 
					 /*def ejecucion = (params.herramienta == 'gradle') ? load 'gradle.grovy' : load 'maven.grovy'
					 ejecucion.call()*/		
					 
					if (params.herramienta == 'gradle') 
					{
                        def ejecucion = load 'gradle.groovy'
                        ejecucion.call()
					}
					else 
					{
						def ejecucion = load 'maven.groovy'
                        ejecucion.call()
					}
					 
				   }
            }
        }
    }
}
