pipeline {
  agent {
    label 'java'
  } 
  
  options {
    disableConcurrentBuilds()
  }

  
  stages{
    stage('Build & Test'){
      steps{
        try {
          container('java'){
            sh 'mvn clean package test'
          }
        } catch(e) {
          sh 'mvn clean package test'
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
        echo 'sf'
      }
    }
  }
}
