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
     always {
         allure report: 'allure_reports', results: [[path: 'allure-results']]
     }
}
}