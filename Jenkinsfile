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
        post {
            echo "Successful cleaning"
        }

        stage('Building') {
            steps {
                powershell "mvn compile"
            }
        }

        post {
            echo "Successful building"
        }
//         stage('Building') {
//             steps {
//                 powershell "mvn compile"
//             }
//         }

    }
    post {
        echo "Triumph"
    }
}
