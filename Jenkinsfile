pipeline {
  agent any

  tools {
      jdk 'jdk-17'
      maven "M3"
      git "Default"
  }

  stages {
    stage("Cleaning") {
        steps {
            powershell "mvn clean"
        }
    }

    stage('Building') {
        steps {
            powershell "mvn compile"
        }
    }
  }
  post {
    success  {
        echo "triumph"
    }
  }
}
//             post {
//                 success {
//                   script {
//                     def github = getGitHub()
//                     github.notifyCommitStatus(
//                       commitSha1: env.GIT_COMMIT,
//                       state: 'SUCCESS',
//                       context: 'Jenkins',
//                       description: 'Build passed')
//                   }
//                 }
//                 failure {
//                   script {
//                     def github = getGitHub()
//                     github.notifyCommitStatus(
//                       commitSha1: env.GIT_COMMIT,
//                       state: 'FAILURE',
//                       context: 'Jenkins',
//                       description: 'Build failed')
//                   }
//                 }
//              }
//   def getGitHub() {
//     def gitUrl = sh(
//       script: 'git config --get remote.origin.url',
//       returnStdout: true
//     ).trim()
//     def credsId = 'github-creds' // the ID of the GitHub credentials in Jenkins
//     return github(
//       url: gitUrl,
//       credentialsId: credsId
//     )
//   }
