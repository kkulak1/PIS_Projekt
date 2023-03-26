pipeline {
  agent any

  tools {
      jdk 'jdk-17'
      maven "M3"
      git "Default"
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
        def gitUrl = "${env.GITHUB_SERVER_URL}/${env.GITHUB_REPOSITORY}.git"
        def commitSha = env.GITHUB_SHA
        def gitHub = github()
        gitHub.setCommitStatus(
          context: "Jenkins",
          state: "SUCCESS",
          targetUrl: "${env.BUILD_URL}",
          description: "Build Successful",
          sha1: commitSha,
          repoOwner: env.GITHUB_REPOSITORY_OWNER,
          repository: env.GITHUB_REPOSITORY,
          oauthToken: "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"
        )
      }
    }

    failure  {
      script {
        def gitUrl = "${env.GITHUB_SERVER_URL}/${env.GITHUB_REPOSITORY}.git"
        def commitSha = env.GITHUB_SHA
        def gitHub = github()
        gitHub.setCommitStatus(
          context: "Jenkins",
          state: "FAILURE",
          targetUrl: "${env.BUILD_URL}",
          description: "Build Successful",
          sha1: commitSha,
          repoOwner: env.GITHUB_REPOSITORY_OWNER,
          repository: env.GITHUB_REPOSITORY,
          oauthToken: "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"
      }
    }
  }
}
