pipeline {
  agent any

  tools {
      jdk 'jdk-17'
      maven "M3"
      git "Default"
  }

  environment {
    gitUrl = "https://github.com/kkulak1/PIS_projekt.git"
    commitSha = "${env.GITHUB_SHA}"
    GITHUB_REPO_OWNER = 'kkulak1'
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
          repo: gitUrl,
          credentialsId: "github",
          account: env.GITHUB_REPO_OWNER
         )
    }
    failure {
          echo "asdasdas"
      }
//         if (env.GITHUB_REPO_OWNER) {
//           githubNotify(
//             status: 'FAILURE',
//             context: 'Jenkins',
//             description: 'Build failed',
//             repo: gitUrl,
//             credentialsId: "github",
//             account: env.GITHUB_REPO_OWNER,
//             sha: commitSha
//           )
    }
  }
