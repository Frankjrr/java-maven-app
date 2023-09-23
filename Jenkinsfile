pipeline {
    agent any
     tools {
            maven  'maven-latest' // Use the tool name defined in Jenkins configuration
        }
    stages {
        stage("init") {
            steps {
                script {
                   sh 'mvn --version'
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
