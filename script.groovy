def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credential', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t hassantariq14351/demo-app:java-maven-app-143 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push hassantariq14351/demo-app:java-maven-app-143'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
