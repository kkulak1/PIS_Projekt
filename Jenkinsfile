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
