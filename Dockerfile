FROM openjdk:8-jre-alpine

EXPOSE 8080

# Copy app files from src directory
COPY ./target/java-maven-app-1.0-SNAPSHOT.jar /usr/app

# Create app directory & set default dir so that next commands executes in /usr/app dir, liked cd-ing into /usr/app to execute npm install
WORKDIR /usr/app

# Start the application
ENTRYPOINT [ "java","jar", "java-maven-app-1.0-SNAPSHOT.jar"]