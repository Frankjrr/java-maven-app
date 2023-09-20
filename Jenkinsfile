pipeline {
    agent any
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
            input(message: 'Do you want to proceed?',
            ok: 'Yes',
            parameters: [booleanParam(defaultValue: true, description: 'Proceed?')])
            steps {
                script {
                    echo "deploying the image"

                }
            }
        }
    }
}
