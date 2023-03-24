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
            success {
                echo "Successful cleaning"
            }
        }

        stage('Building') {
            powershell "mvn compile"
        }

        post {
            success {
                echo "Successful building"
            }
        }
    }
    post {
        success  {
            echo "Triumph"
        }
    }
}
