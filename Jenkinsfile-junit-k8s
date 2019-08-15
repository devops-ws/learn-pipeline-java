pipeline {
  agent {
    label 'maven'
  } 
  
  options {
    disableConcurrentBuilds()
  }

  
  stages{
    stage('Build & Test'){
      steps{
        script{
          container('java'){
            sh 'mvn clean package test'
          }
        }
      }
    }
    
    stage('Only for demo'){
      when {
        allOf {
          branch 'master'
        }
      }
      steps{
        echo 'only for demo'
      }
    }
  }
  
  post{
    always{
      junit 'target/surefire-reports/**/*.xml'
    }
  }
}
