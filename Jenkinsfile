pipeline {
  agent any
  stages {

    stage('Testing stage') {
           steps {
                  def env_name=env_prod
                  echo 'Running ${env_name}.....'
                  sh 'mvn clean test -Denv=env_prod'
                  }
    }
    post {
            failure {
                mail to: romo4kachukalo@gmail.com, subject: 'The Pipeline failed :('
            }
        }

    stage('Deployment stage') {
          steps {
            sh 'mvn deploy'
          }
        }
  }
}