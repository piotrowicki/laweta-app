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
    }
}