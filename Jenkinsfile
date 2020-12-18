pipeline {
    agent any
	
	parameters { choice(name: 'herramienta', choices: ['gradle', 'maven'], description: '') }

    stages {
        stage('Pipeline') {
            steps {
			       /*echo "Choice: ${params.herramienta}"*/
                   script{				 
					 /*def ejecucion = (params.herramienta == 'gradle') ? load 'gradle.groovy' : load 'maven.groovy'
					 ejecucion.call()*/		
					 
					 env.HERRAMIENTA = params.herramienta 
					 
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
		
		post{
			success{
			        slackSend color: 'good', message: '[Cristian Martinez] [${env.JOB_NAME}] [${env.HERRAMIENTA}] Ejecución Exitosa', teamDomain: 'devops-usach-2020', tokenCredentialId: 'slacktoken'
			}
			failure{ 
			      slackSend color: 'danger', message: '[Cristian Martinez] [${env.JOB_NAME}] [${env.HERRAMIENTA}] Ejecución fallida en stage [${env.TAREA}]', teamDomain: 'devops-usach-2020', tokenCredentialId: 'slacktoken'
			}
			
		}
    }
}
