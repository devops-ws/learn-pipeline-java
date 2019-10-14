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
        sh '''
          echo ${sonar.host.url}
          mvn sonar:sonar \
            -Dsonar.projectKey=df \
            -Dsonar.host.url=${sonar.host.url} \
            -Dsonar.login=${sonar.login}
        '''
      }
    }
  }
}
