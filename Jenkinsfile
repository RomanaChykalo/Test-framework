pipeline {
  agent any
  stages {

    stage('Testing stage') {
      steps {
        sh 'mvn clean test'
      }
    }

    stage('Deployment stage') {
          steps {
            sh 'mvn deploy'
          }
        }
  }
}