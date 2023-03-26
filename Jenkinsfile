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
            account: "kkulak1",
            credentialsId: "github",
            context: 'Jenkins',
            description: 'Build failed',
            repo: "PIS_projekt",
            sha: env.GITHUB_SHA
        )
    }
    failure {
          githubNotify(
            status: 'SUCCESS',
            account: "kkulak1",
            credentialsId: "github",
            context: 'Jenkins',
            description: 'Build failed',
            repo: "PIS_projekt",
            sha: env.GITHUB_SHA
           )
      }
    }
  }
