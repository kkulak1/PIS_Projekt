pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Building') {
            steps {
                echo 'Hello World'
                sh "mvn clean compile"
            }
        }

        stage('Testing') {
            steps {
                echo 'Hello World'
                sh "mvn test"
            }
        }


    }
}
