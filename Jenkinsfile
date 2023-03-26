pipeline {
  agent any

  tools {
      jdk 'jdk-17'
      maven "M3"
      git "Default"
  }

  stages {
    stage('Build') {
      steps {
        sh "mvn verify"
      }
    }
  }
  post {
    success {
        githubNotify(
            status: 'FAILURE',
            account: "kkulak1",
            credentialsId: "github",
            context: 'Jenkins',
            description: 'Build failed',
            repo: "Default"
         )
    }
    failure {
          githubNotify(
            status: 'FAILURE',
            account: "kkulak1",
            credentialsId: "github",
            context: 'Jenkins',
            description: 'Build failed',
            repo: "Default"
           )
      }
    }
  }
