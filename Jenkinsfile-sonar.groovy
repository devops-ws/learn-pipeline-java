// this demo runs in a k8s pod which has a docker container named 'java'
// also, maven is needed in this case.
pipeline {
  agent {
    label 'maven'
  }
  
  stages{
    stage('build'){
      steps{
        container('java'){
          sh 'mvn clean package'
        }
      }
    }

    stage('sonar scan') {
      steps {
        container('java'){
          sh '''
            mvn sonar:sonar \
              -Dsonar.projectKey=test \
              -Dsonar.host.url=${SONAR_HOST_URL} \
              -Dsonar.login=${SONAR_LOGIN}
          '''
        }
      }
    }
  }
}
