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
          status: 'SUCCESS',
          context: 'Jenkins',
          description: 'Build successful',
          repo: "https://github.com/kkulak1/PIS_projekt.git",
          credentialsId: "github",
          account: "kkulak1"
         )
    }
    failure {
          githubNotify(
            status: 'FAILURE',
            context: 'Jenkins',
            description: 'Build failed',
            repo: "kkulak1/PIS_projekt",
            credentialsId: "github",
            account: "kkulak1"
           )
      }
    }
  }
