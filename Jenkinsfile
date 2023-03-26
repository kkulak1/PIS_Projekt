pipeline {
  agent any

  tools {
      jdk 'jdk-17'
      maven "M3"
      git "Default"
  }

  environment {
    gitUrl = "${env.GITHUB_SERVER_URL}/${env.GITHUB_REPOSITORY}.git"
    commitSha = "${env.GITHUB_SHA}"
    githubToken = credentials('github-token')
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
      script {
        if (env.GITHUB_REPO_OWNER) {
          githubNotify(
            status: 'SUCCESS',
            context: 'Jenkins',
            description: 'Build successful',
            repo: gitUrl,
            credentialsId: "github",
            account: env.GITHUB_REPO_OWNER,
            sha: commitSha
          )
        } else {
          echo 'GITHUB_REPO_OWNER environment variable is not set, cannot notify GitHub'
        }
      }
    }
    failure {
      script {
        if (env.GITHUB_REPO_OWNER) {
          githubNotify(
            status: 'FAILURE',
            context: 'Jenkins',
            description: 'Build failed',
            repo: gitUrl,
            credentialsId: "github",
            account: env.GITHUB_REPO_OWNER,
            sha: commitSha
          )
        } else {
          echo 'GITHUB_REPO_OWNER environment variable is not set, cannot notify GitHub'
        }
      }
    }
  }
}
