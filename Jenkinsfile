pipeline {
    agent any
    stages {
        stage("init") {
            steps {
                script {
                   sh 'npm --version'
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                   
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying the image"
                   
                }
            }
        }
    }   
}
