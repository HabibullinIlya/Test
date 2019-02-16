pipeline {
    agent any
    
    
	
    stages {
        stage('Build') {
            steps {
                sh "chmod +x gradlew"
                sh "echo build"
                sh "./gradlew build"
            }
        }
		stage('build image'){
	    	steps{
	    		script{
	    			app = docker.build("habibullinilya/whereis")
	    		}
	        	/*sh "docker build -t habibullinilya/wherebackend ."
				sh "docker tag habibullinilya/wherebackend:v0.1 habibullinilya/whereis:v0.1"
				sh "docker tag habibullinilya/whereis:v0.1"*/
				
		
	   		}
		}
		stage('push image'){
			steps{
				

				script{
				docker.withRegistry('', 'dockerhub'){
		   		app.push("0.2")
		   		app.push("latest")	 
			}	
			}
			
			}
		}
		stage('deploy to k8s'){
			steps{
				sh "kubectl run whereis --image=docker.io/habibullinilya/whereis --port=8080"
				sh "kubectl get pods"

			}

		}     
	}
}

