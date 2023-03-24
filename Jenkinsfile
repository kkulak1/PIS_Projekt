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
                sh "ls"
                sh "mvn clean"
            }
        }

        stage('Building') {
            steps {
                sh "mvn compile"
            }
        }
    }
}
