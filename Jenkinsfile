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
	stage('make image and run container '){
	    steps{
	        sh "docker build -t habibullinilya/wherebackend ."
	        sh "docker run -p 8085:8080 habibullinilya/wherebackend"
	    }
	}

    }
}
