pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Building') {
            steps {
                sh "echo 'Hello World'"
                sh "mvn clean"
                sh "mvn compile"
            }
        }

//         stage('Testing') {
//             steps {
//                 echo 'Hello World'
//                 sh "mvn test"
//             }
//         }


    }
}
