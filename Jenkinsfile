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
//         echo "${env.GITHUB_SHA}"
        githubNotify(
            status: 'SUCCESS',
            account: "kkulak1",
            credentialsId: "github",
            context: 'Jenkins',
            description: 'Build failed',
            repo: "PIS_projekt",
            sha: env.GIT_COMMIT
        )
    }
    failure {
//         echo "${env.GIT_COMMIT}"
          githubNotify(
            status: 'FAILURE',
            account: "kkulak1",
            credentialsId: "github",
            context: 'Jenkins',
            description: 'Build failed',
            repo: "PIS_projekt",
            sha: env.GIT_COMMIT

           )
      }
    }
  }
