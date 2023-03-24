pipeline {
    agent any

    tools {
        jdk 'jdk-17'
        maven "M3"
        git "Default"
    }

    stages {
        stage("Cleaning") {
            steps {
                bat "echo Hello"
                bat "mvn clean"
            }
        }

        stage('Building') {
            steps {
                bat "echo Hello"
            }
        }
    }
}
