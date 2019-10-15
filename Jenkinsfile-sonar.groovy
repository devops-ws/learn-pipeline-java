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
            echo ${SONAR_HOST_URL}
            mvn sonar:sonar \
              -Dsonar.projectKey=df \
              -Dsonar.host.url=${SONAR_HOST_URL} \
              -Dsonar.login=${SONAR_LOGIN}
          '''
        }
      }
    }
  }
}
