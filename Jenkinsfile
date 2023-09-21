pipeline {
    agent any
    tools {
        maven  'maven-latest' // Use the tool name defined in Jenkins configuration
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                echo "building image"
                withCredentials([usernamePassword(credentialsID: 'dockerhub-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh 'echo "Username: $USERNAME"'
                    sh 'echo "Password: $PASSWORD"'
                    sh 'docker build -t hassantariq14351/demo-app:aht-1 .'
                    sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                    sh 'docker push  hassantariq14351/demo-app:aht-1'
                }
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
