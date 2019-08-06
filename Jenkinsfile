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
          try {
            container('java'){
              sh 'mvn clean package test'
            }
          } catch(e) {
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
        echo 'sf'
      }
    }
  }
  
  post{
    always{
      junit 'target/surefire-reports/**/*.xml'
    }
  }
}
