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
    stage('Deployment stage') {
          steps {
            sh 'mvn deploy'
          }
        }
  }
  post {
              failure {
                  mailUser('<romo4kachukalo@gmail.com>',"The Pipeline failed")
              }
          }
}