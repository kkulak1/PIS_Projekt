pipeline {
  agent any

  tools {
    jdk 'jdk-17'
    maven 'M3'
    git 'Default'
  }

  environment {
    gitUrl = "${env.GITHUB_SERVER_URL}/${env.GITHUB_REPOSITORY}.git"
    commitSha = "${env.GITHUB_SHA}"
    githubToken = credentials('github-token')
  }

  stages {
    stage('verify') {
      steps {
        sh 'mvn verify'
      }
    }
  }

  post {
    success {
      script {
        ghStatus = ghprbGitHubCommitStatus {
          context = 'Jenkins'
          description = 'Build successful'
          sha = commitSha
          state = 'SUCCESS'
          targetUrl = env.BUILD_URL
          oauthToken = githubToken
        }
        ghStatus.create()
      }
    }
    failure {
      script {
        ghStatus = ghprbGitHubCommitStatus {
          context = 'Jenkins'
          description = 'Build failed'
          sha = commitSha
          state = 'FAILURE'
          targetUrl = env.BUILD_URL
          oauthToken = githubToken
        }
        ghStatus.create()
      }
    }
  }
}
