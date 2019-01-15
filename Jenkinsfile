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
	         docker build -t habibullinilya/wherebackend .
	         docker run -p 8085:8080 habibullinilya/wherebackend
	    }
	}

    }
}
