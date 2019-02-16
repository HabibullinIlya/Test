pipeline {
    agent any

    enviroment {
        registry = "habibullunilya/whereis"
	registryCredintal = 'dockerhub'

    }
	
    stages {

	stage('clone repository'){
            checkout scm
	}

        stage('Build') {
            steps {
                sh "chmod +x gradlew"
                sh "echo build"
                sh "./gradlew build"
            }
        }
	stage('build image'){
	    steps{
	        /*sh "docker build -t habibullinilya/wherebackend ."
		sh "docker tag habibullinilya/wherebackend:v0.1 habibullinilya/whereis:v0.1"
		sh "docker tag habibullinilya/whereis:v0.1"*/
		app = docker.build("habibullinilya/whereis")
		
	    }
	}
	stage('push image'){
                docker.withRegistry('https://registry.hub.docker.com', 'dockerhub'){
		     app.push("{env.BUILD_NUMBER}")
		     app.push("latest")	 
		}


        }

    }
}
