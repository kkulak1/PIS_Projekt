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
  }

  stages {
    stage("verifying") {
        steps {
            sh "mvn verify"
        }
    }
  }

  post {
    success  {
      script {
        def status = new GitHubStatus()
        status.notifyBuildStatus(
          status: "SUCCESS",
          message: "Build Successful",
          url: env.BUILD_URL,
          gitUrl: gitUrl,
          commitSha: commitSha,
          githubToken: githubToken
        )
      }
    }

    failure  {
      script {
        def status = new GitHubStatus()
        status.notifyBuildStatus(
          status: "FAILURE",
          message: "Build Failed",
          url: env.BUILD_URL,
          gitUrl: gitUrl,
          commitSha: commitSha,
          githubToken: githubToken
        )
      }
    }
  }
}
