    pipeline {
        agent any
        tools {
            maven  'maven-latest' // Use the tool name defined in Jenkins configuration
        }
        stages {
            stage("Unit testing Maven") {
                steps {
                    script {
                        sh 'mvn test'
                    }
                }
            }
            stage("Integration Test maven") {
                steps {
                    script {
                        sh 'mvn verify -DskipUnitTests'
                    }
                }
            }
            
            stage("Build Application") {
                steps {
                    script {
                        sh 'mvn clean package'
                    }
                }
            }
            stage("build image") {
                steps {
                    script {
                    echo "building image"
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t  hassantariq14351/demo-app:aht-2.0 .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push  hassantariq14351/demo-app:aht-2.0'
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
