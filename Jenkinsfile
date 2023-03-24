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
                powershell "mvn clean"
            }
        }

        stage('Building') {
            steps {
                powershell "mvn compile"
            }
        }
    }
}
