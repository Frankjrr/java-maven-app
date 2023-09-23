    pipeline {
        agent any
        tools {
            maven  'maven-latest' // Use the tool name defined in Jenkins configuration
        }
        parameters {
                 choice(name: 'ENVIRONMENT', choices: ['dev', 'test', 'prod'], description: 'Select the environment')
        }
        stages {
            stage("build jar") {
                environment {
                    MY_VAR = '2.23'
                }
                steps {
                    script {
                        echo "building jar for  version = $MY_VAR"
                        sh 'mvn clean package'
                    }
                }
            }
            stage("build image") {
                input{
                    message "Do you want to proceed?"
                    ok "Yes"
                    parameters {
                        choice(name: 'VERSION', choices: ['1', '2', '3'], description: 'Select the version')
                }}
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
                        echo "deploying the image on $params.ENVIRONMENT"
                    }
                }
            }
        }
    }
