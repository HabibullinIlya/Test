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
        stage('build image') {
            steps {
                script {
                    app = docker.build("habibullinilya/whereis")
                }
                /*sh "docker build -t habibullinilya/wherebackend ."
                sh "docker tag habibullinilya/wherebackend:v0.1 habibullinilya/whereis:v0.1"
                sh "docker tag habibullinilya/whereis:v0.1"*/
            }
        }
        stage('push image') {
            steps {
                script {
                    docker.withRegistry('', 'dockerhub') {
                        app.push("0.2")
                        app.push("latest")
                    }
                }
            }
        }
        stage('deploy to k8s') {
            steps {
                script {
                    def projectName = "whereis"
                    def isExist = sh(script:"kubectl get deployments | grep whereis | wc -l", returnStdout: true)
                    echo "$isExist"
                    if (isExist == 1) {
                        echo "get deployements ${temp}"
                        sh "kubectl run whereis --image=docker.io/habibullinilya/whereis --port=8080"
                        sh "kubectl get pods"
                        sh "kubectl expose deployments/whereis --type=NodePort --port 8080"
                        sh "kubectl describe services/whereis"
                    } else {
                        echo "else"
                        sh "kubectl set image deployments/${projectName} ${projectName}=docker.io/habibullinilya/whereis"
                    }
                }


            }

        }
    }
}


