pipeline {
  agent any
  stages {

    stage('Testing stage') {
           steps {
                  echo 'Running ${env_name}.....'
                  sh 'mvn clean test -Denv=env_prod'
                  }
    }
    stage('Deployment stage') {
          steps {
            sh 'mvn deploy'
          }
        }
  }
  post {
  failure {
      mail to: 'romo4kachukalo@gmail.com',
        subject: "Pipeline has failed: ${currentBuild.fullDisplayName}",
        body: "Error in ${env.BUILD_URL}"
    }
}