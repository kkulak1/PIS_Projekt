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
      githubNotify status: 'SUCCESS', context: 'Jenkins', description: 'Build successful'
    }
    failure {
      githubNotify status: 'FAILURE', context: 'Jenkins', description: 'Build failed'
    }
}
}
