pipeline {
    agent any
    environment {
        IMAGE_NAME = 'laweta-app-image'
    }
    stages {
        stage('Preparation') {
            steps {
                git branch: 'master', url: 'https://github.com/piotrowicki/laweta-app.git'
            }
        }
        stage('Build application') {
            tools {
                maven 'Maven 3.6.3'
                jdk 'openjdk-11'
            }
            steps {
                sh 'mvn package'
            }
        }
        stage('Build image') {
            steps {
                sh 'docker build -f src/main/docker/Dockerfile.jvm -t ${IMAGE_NAME} .'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker service update --force laweta_app'
            }
        }
    }
}
